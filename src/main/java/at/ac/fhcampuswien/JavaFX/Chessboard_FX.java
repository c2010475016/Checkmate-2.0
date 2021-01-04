package at.ac.fhcampuswien.JavaFX;
import at.ac.fhcampuswien.Board;
import at.ac.fhcampuswien.Player;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;

public class Chessboard_FX extends Application {

    private static final int BOARD_SIZE = 600;
    @Override
    public void start(Stage primaryStage) throws Exception{


        Board board;
        Player player1;
        Player player2;
        player1 = new Player("Player 1","white");
        player2 = new Player("Player 2","black");
        System.out.println(player1.getName() + " plays color " + player1.getColor());
        System.out.println(player2.getName() + " plays color " + player2.getColor());
        System.out.println(player1.getName() + " has to move first");
        System.out.println("Game on!");
        board = new Board();
        board.resetBoard();
        System.out.println(board);



        Group root = new Group();

        Rectangle[][] rectangles = new Rectangle[8][8];

        int groesse_rect = 50;
        for (int i = 0;i<8;i++) {
            for (int x = 0;x<8;x++) {
                Rectangle r = new Rectangle(groesse_rect,groesse_rect);
                r.setLayoutX(100 + groesse_rect*x);
                r.setLayoutY(100 + groesse_rect*i);
                r.setStroke(Color.BLACK);
                r.setId("10");
                if ((x+(i%2))%2==0) {
                    r.setFill(Color.WHITE);
                }else {
                    r.setFill(Color.BLACK);
                }
                rectangles[i][x] = r;
                root.getChildren().addAll(r);
            }
        }


        ImageView[][] grid = new ImageView[8][8];
        Circle[][] circles = new Circle[8][8];
        String resources = new File("./").getAbsolutePath();
        resources = resources.substring(0,resources.length()-2);
        for (int i = 0;i<8;i++) {
            if(i==0||i==1||i==6||i==7) {
                for (int x = 0; x < 8; x++) {
                    if (i == 0) {
                        if (x == 0 || x == 7) {
                            Image whR = new Image(new FileInputStream(resources + "/src/main/java/at/ac/fhcampuswien/resources/rook_white.png"));
                            ImageView whiteRook = new ImageView(whR);
                            whiteRook.setLayoutX(100 + groesse_rect * x);
                            whiteRook.setLayoutY(100 + groesse_rect * i);   //wahrscheinlich gehts auch ohne!
                            whiteRook.setFitHeight(50);
                            whiteRook.setFitWidth(50);
                            whiteRook.setId(i + "" + x);
                            grid[i][x] = whiteRook;
                            whiteRook.addEventHandler(MouseEvent.ANY, new MouseEventHandler_Figures(whiteRook, board));
                            root.getChildren().addAll(whiteRook);
                        } else if (x == 1 || x == 6) {
                            Image whKn = new Image(new FileInputStream(resources + "/src/main/java/at/ac/fhcampuswien/resources/knight_white.png"));
                            ImageView whiteKnight = new ImageView(whKn);
                            whiteKnight.setLayoutX(100 + groesse_rect * x);
                            whiteKnight.setLayoutY(100 + groesse_rect * i);
                            whiteKnight.setFitHeight(50);
                            whiteKnight.setFitWidth(50);
                            whiteKnight.setId(i + "" + x);
                            grid[i][x] = whiteKnight;
                            whiteKnight.addEventHandler(MouseEvent.ANY, new MouseEventHandler_Figures(whiteKnight, board));
                            root.getChildren().addAll(whiteKnight);
                        } else if (x == 2 || x == 5) {
                            Image whB = new Image(new FileInputStream(resources + "/src/main/java/at/ac/fhcampuswien/resources/phallus_white.png"));
                            ImageView whiteBishop = new ImageView(whB);
                            whiteBishop.setLayoutX(100 + groesse_rect * x);
                            whiteBishop.setLayoutY(100 + groesse_rect * i);
                            whiteBishop.setFitHeight(50);
                            whiteBishop.setFitWidth(50);
                            whiteBishop.setId(i + "" + x);
                            grid[i][x] = whiteBishop;
                            whiteBishop.addEventHandler(MouseEvent.ANY, new MouseEventHandler_Figures(whiteBishop, board));
                            root.getChildren().addAll(whiteBishop);
                        } else if (x == 3){
                            Image whQ = new Image(new FileInputStream(resources + "/src/main/java/at/ac/fhcampuswien/resources/queen_white.png"));
                            ImageView whiteQueen = new ImageView(whQ);
                            whiteQueen.setLayoutX(100 + groesse_rect * x);
                            whiteQueen.setLayoutY(100 + groesse_rect * i);
                            whiteQueen.setFitHeight(50);
                            whiteQueen.setFitWidth(50);
                            whiteQueen.setId(i + "" + x);
                            grid[i][x] = whiteQueen;
                            whiteQueen.addEventHandler(MouseEvent.ANY, new MouseEventHandler_Figures(whiteQueen, board));
                            root.getChildren().addAll(whiteQueen);
                        } else {
                            Image whKi = new Image(new FileInputStream(resources + "/src/main/java/at/ac/fhcampuswien/resources/king_white.png"));
                            ImageView whiteKing = new ImageView(whKi);
                            whiteKing.setLayoutX(100 + groesse_rect * x);
                            whiteKing.setLayoutY(100 + groesse_rect * i);
                            whiteKing.setFitHeight(50);
                            whiteKing.setFitWidth(50);
                            whiteKing.setId(i + "" + x);
                            grid[i][x] = whiteKing;
                            whiteKing.addEventHandler(MouseEvent.ANY, new MouseEventHandler_Figures(whiteKing, board));
                            root.getChildren().addAll(whiteKing);
                        }
                    }
                    else if (i == 1){
                        Image whP = new Image(new FileInputStream(resources + "/src/main/java/at/ac/fhcampuswien/resources/pawn_white.png"));
                        ImageView whitePawn = new ImageView(whP);
                        whitePawn.setLayoutX(100 + groesse_rect * x);
                        whitePawn.setLayoutY(100 + groesse_rect * i);
                        whitePawn.setFitHeight(50);
                        whitePawn.setFitWidth(50);
                        whitePawn.setId(i + "" + x);
                        grid[i][x] = whitePawn;
                        whitePawn.addEventHandler(MouseEvent.ANY, new MouseEventHandler_Figures(whitePawn, board));
                        root.getChildren().addAll(whitePawn);
                    }
                    else if (i == 6){
                        Image blP = new Image(new FileInputStream(resources + "/src/main/java/at/ac/fhcampuswien/resources/pawn_black.png"));
                        ImageView blackPawn = new ImageView(blP);
                        blackPawn.setLayoutX(100 + groesse_rect * x);
                        blackPawn.setLayoutY(100 + groesse_rect * i);
                        blackPawn.setFitHeight(50);
                        blackPawn.setFitWidth(50);
                        blackPawn.setId(i + "" + x);
                        grid[i][x] = blackPawn;
                        blackPawn.addEventHandler(MouseEvent.ANY, new MouseEventHandler_Figures(blackPawn, board));
                        root.getChildren().addAll(blackPawn);
                    }
                    else{
                        if (x == 0 || x == 7) {
                            Image blR = new Image(new FileInputStream(resources + "/src/main/java/at/ac/fhcampuswien/resources/rook_black.png"));
                            ImageView blackRook = new ImageView(blR);
                            blackRook.setLayoutX(100 + groesse_rect * x);
                            blackRook.setLayoutY(100 + groesse_rect * i);
                            blackRook.setFitHeight(50);
                            blackRook.setFitWidth(50);
                            blackRook.setId(i + "" + x);
                            grid[i][x] = blackRook;
                            blackRook.addEventHandler(MouseEvent.ANY, new MouseEventHandler_Figures(blackRook, board));
                            root.getChildren().addAll(blackRook);
                        }else if (x == 1 || x == 6) {
                            Image blKn = new Image(new FileInputStream(resources + "/src/main/java/at/ac/fhcampuswien/resources/knight_black.png"));
                            ImageView blackKnight = new ImageView(blKn);
                            blackKnight.setLayoutX(100 + groesse_rect * x);
                            blackKnight.setLayoutY(100 + groesse_rect * i);
                            blackKnight.setFitHeight(50);
                            blackKnight.setFitWidth(50);
                            blackKnight.setId(i + "" + x);
                            grid[i][x] = blackKnight;
                            blackKnight.addEventHandler(MouseEvent.ANY, new MouseEventHandler_Figures(blackKnight, board));
                            root.getChildren().addAll(blackKnight);
                        } else if (x == 2 || x == 5) {
                            Image blB = new Image(new FileInputStream(resources + "/src/main/java/at/ac/fhcampuswien/resources/phallus_black.png"));
                            ImageView blackBishop = new ImageView(blB);
                            blackBishop.setLayoutX(100 + groesse_rect * x);
                            blackBishop.setLayoutY(100 + groesse_rect * i);
                            blackBishop.setFitHeight(50);
                            blackBishop.setFitWidth(50);
                            blackBishop.setId(i + "" + x);
                            grid[i][x] = blackBishop;
                            blackBishop.addEventHandler(MouseEvent.ANY, new MouseEventHandler_Figures(blackBishop, board));
                            root.getChildren().addAll(blackBishop);
                        } else if (x == 3){
                            Image blQ = new Image(new FileInputStream(resources + "/src/main/java/at/ac/fhcampuswien/resources/queen_black.png"));
                            ImageView blackQueen = new ImageView(blQ);
                            blackQueen.setLayoutX(100 + groesse_rect * x);
                            blackQueen.setLayoutY(100 + groesse_rect * i);
                            blackQueen.setFitHeight(50);
                            blackQueen.setFitWidth(50);
                            blackQueen.setId(i + "" + x);
                            grid[i][x] = blackQueen;
                            blackQueen.addEventHandler(MouseEvent.ANY, new MouseEventHandler_Figures(blackQueen, board));
                            root.getChildren().addAll(blackQueen);
                        } else {
                            Image blKi = new Image(new FileInputStream(resources + "/src/main/java/at/ac/fhcampuswien/resources/king_black.png"));
                            ImageView blackKing = new ImageView(blKi);
                            blackKing.setLayoutX(100 + groesse_rect * x);
                            blackKing.setLayoutY(100 + groesse_rect * i);
                            blackKing.setFitHeight(50);
                            blackKing.setFitWidth(50);
                            blackKing.setId(i + "" + x);
                            grid[i][x] = blackKing;
                            blackKing.addEventHandler(MouseEvent.ANY, new MouseEventHandler_Figures(blackKing, board));
                            root.getChildren().addAll(blackKing);
                        }
                    }


                    /*Image image2 = new Image(new FileInputStream(resources + "/src/main/java/at/ac/fhcampuswien/resources/rook_black.png"));
                    ImageView imageView2 = new ImageView(image2);

                    imageView2.setLayoutX(100 + groesse_rect * x);
                    imageView2.setLayoutY(100 + groesse_rect * i);

                    imageView2.setFitHeight(50);
                    imageView2.setFitWidth(50);
                    imageView2.setId(i + "" + x);

                    grid[i][x] = imageView2;
                    imageView2.addEventHandler(MouseEvent.ANY, new MouseEventHandler_Figures(imageView2,board));
                    root.getChildren().addAll(imageView2);*/

                    /*Circle r = new Circle(groesse_circ);
                    r.setLayoutX(100 + groesse_rect * x + 25);
                    r.setLayoutY(100 + groesse_rect * i + 25);
                    r.setStroke(Color.BLACK);
                    r.setId(i + "" + x);
                    r.setFill(Color.RED);
                    circles[i][x] = r;
                    r.addEventHandler(MouseEvent.ANY, new MouseEventHandler_Figures(r,board));
                    root.getChildren().addAll(r);*/
                }
            }
        }


        /*Image image2 = new Image(new FileInputStream(resources + "/src/main/java/at/ac/fhcampuswien/resources/rook_black.png"));
        ImageView imageView2 = new ImageView(image2);

        imageView2.setX(100);
        imageView2.setY(50);

        imageView2.setFitHeight(50);
        imageView2.setFitWidth(50);
        imageView2.setId("01");

        imageView2.addEventHandler(MouseEvent.ANY, new MouseEventHandler_Figures(imageView2,board));

        imageView2.setPreserveRatio(true);
        root.getChildren().addAll(imageView2);
         */



        Scene scene = new Scene(root, BOARD_SIZE, BOARD_SIZE);

        scene.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            if(e.getCode().equals(KeyCode.Q)){
                Platform.exit();
                System.exit(0);
            }
        });


        primaryStage.setTitle("Hello Chess");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
