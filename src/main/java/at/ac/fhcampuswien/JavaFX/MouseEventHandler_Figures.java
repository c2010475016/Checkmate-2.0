package at.ac.fhcampuswien.JavaFX;;

import at.ac.fhcampuswien.Board;
import at.ac.fhcampuswien.Figures.Figure;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class MouseEventHandler_Figures implements EventHandler<MouseEvent> {
    private static String nextMove = "white";
    private Board board;
    private Node group;
    private double mouseX;
    private double mouseY;
    private double startfigX;
    private double startfigY;
    private Boolean blackcheck = false,whitecheck  = false;
    private double newMouseXa;
    private double newMouseYa;
    private ImageView[][] grid;
    private String resources = new File("./").getAbsolutePath();
    private Image whQ = null;
    private Image blQ = null;
    private static int whiteGraveyardXPosition = 100;
    private static int blackGraveyardXPosition = 100;
    private Label gameOver;

    // Implement sounds played
    String uriString = new File(resources + "/src/main/java/at/ac/fhcampuswien/resources/chess_move.wav").toURI().toString();
    MediaPlayer playSound = new MediaPlayer(new Media(uriString));


    /**
     * Constructor for JavaFX Figures.
     * @param group
     * @param board
     * @param grid Array of chess pieces
     */
    public MouseEventHandler_Figures(Node group, Board board,ImageView[][] grid, Label label) {
        this.grid = grid;
        this.group = group;
        this.board = board;
        this.gameOver = label;
        resources = resources.substring(0,resources.length()-2);
        try {
            whQ = new Image(new FileInputStream(resources + "/src/main/java/at/ac/fhcampuswien/resources/queen_white.png"));
            blQ = new Image(new FileInputStream(resources + "/src/main/java/at/ac/fhcampuswien/resources/queen_black.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Invoked when a specific event of the type for which this handler is
     * registered happens.
     *
     * @param event the event which occurred
     */
    @Override
    public void handle(MouseEvent event) {
        if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
           mouseX = event.getSceneX();
           mouseY = event.getSceneY();
           startfigX = group.getLayoutX();
           startfigY = group.getLayoutY();
           System.out.println(group.getId());
        }
        if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
            int newMouseX = (int) event.getSceneX();
            int newMouseY = (int) event.getSceneY();
            double deltaX = newMouseX - mouseX;
            double deltaY = newMouseY - mouseY;
            group.setLayoutX(group.getLayoutX() + deltaX);
            group.setLayoutY(group.getLayoutY() + deltaY);
            mouseX = newMouseX;
            mouseY = newMouseY;
        }
        if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
            // Centering the figure on the new field
            newMouseXa = (int) event.getSceneX() / 10;
            newMouseYa = (int) event.getSceneY() / 10;
            newMouseXa *= 10;
            newMouseYa *= 10;
            while (newMouseXa % 50 != 0) {
                newMouseXa -= 10;
            }
            while (newMouseYa % 50 != 0) {
                newMouseYa -= 10;
            }
            group.setLayoutX(newMouseXa);
            group.setLayoutY(newMouseYa);

            // translating the JavaFX position to the array position
            int newX = (int)(newMouseXa-100)/50;
            int newY = (int)(newMouseYa-100)/50;
            int oldx = Integer.parseInt(group.getId().substring(0,1));
            int oldy = Integer.parseInt(group.getId().substring(1));
            System.out.println(oldx + "" + oldy);

            if (nextMove.equals(board.Schachbrett[oldx][oldy].getColor())){
                // Play Sound when piece is moved
                playSound.play();
                playSound.seek(playSound.getStartTime());

                if(!board.moveFigure(new int[]{oldx,oldy},new int[]{newY,newX})) {
                    System.out.println("invalid Move");
                    group.setLayoutX(startfigX);
                    group.setLayoutY(startfigY);
                }else {
                    System.out.println(board.toString());
                    if (nextMove.equals("white")) {
                        nextMove = "black";
                    } else {
                        nextMove = "white";
                    }
                    /**
                     * Graveyard
                     */
                    for(ImageView[] imageViewArray:grid) {
                        for(ImageView imageView:imageViewArray){
                            if (imageView!=null && imageView.getId().equals(newY + "" + newX)){
                                imageView.setId("beaten");
                                if(nextMove.equals("black")){
                                    imageView.setLayoutX(blackGraveyardXPosition);
                                    imageView.setLayoutY(500);
                                    imageView.setFitHeight(25);
                                    imageView.setFitWidth(25);
                                    blackGraveyardXPosition = blackGraveyardXPosition + 25;
                                } else {
                                    imageView.setLayoutX(whiteGraveyardXPosition);
                                    imageView.setLayoutY(75);
                                    imageView.setFitHeight(25);
                                    imageView.setFitWidth(25);
                                    whiteGraveyardXPosition = whiteGraveyardXPosition + 25;
                                }
                                imageView.removeEventHandler(MouseEvent.ANY, this::handle);
                            }
                        }
                    }
                    group.setId(newY + "" + newX);

                    int coloradder = 0;
                    if(nextMove.equals("white")){
                        coloradder+=7;
                    }
                    /**
                     * Rocharde
                     */
                    if(grid[coloradder][4].getId().equals(group.getId()) && oldy+2 == newX) {
                        grid[coloradder][7].setLayoutX(startfigX+50);
                        grid[coloradder][7].setLayoutY(startfigY);
                        grid[coloradder][7].setId(coloradder + "5");
                    }
                    if(grid[coloradder][4].getId().equals(group.getId()) && oldy-2 == newX) {
                        grid[coloradder][0].setLayoutX(startfigX-50);
                        grid[coloradder][0].setLayoutY(startfigY);
                        grid[coloradder][0].setId(coloradder + "3");
                    }

                    /**
                     * Pawn/Queen exchange
                     */
                    for (ImageView imageView:grid[1]){
                        if (imageView.getId().substring(0,1).equals("7")){
                            imageView.setImage(whQ);
                        }
                    }

                    for (ImageView imageView:grid[6]){
                        if (imageView.getId().substring(0,1).equals("0")){
                            imageView.setImage(blQ);
                        }
                    }




                }
            }else {
                System.out.println("not your Color");
                group.setLayoutX(startfigX);
                group.setLayoutY(startfigY);
            }

            /**
             * Game-Over Screen
             */
            if (board.isCheck(nextMove)){
                if (board.isCheckmate(nextMove)){
                    gameOver.setVisible(true);
                    gameOver.toFront();
                    System.out.println("Game over!");
                }
                System.out.println("Check on " + nextMove);
            }
            System.out.println("next to move: " + nextMove);
        }
    }
}
