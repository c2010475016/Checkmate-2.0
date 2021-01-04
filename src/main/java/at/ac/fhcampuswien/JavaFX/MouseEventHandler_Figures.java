package at.ac.fhcampuswien.JavaFX;;

import at.ac.fhcampuswien.Board;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

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


    public MouseEventHandler_Figures(Node group, Board board) {
        this.group = group;
        this.board = board;
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
            double newMouseX = event.getSceneX();
            double newMouseY = event.getSceneY();
            double deltaX = newMouseX - mouseX;
            double deltaY = newMouseY - mouseY;
            group.setLayoutX(group.getLayoutX() + deltaX);
            group.setLayoutY(group.getLayoutY() + deltaY);
            mouseX = newMouseX;
            mouseY = newMouseY;
        }
        if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {

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


            int newX = (int)(newMouseXa-100)/50;
            int newY = (int)(newMouseYa-100)/50;
            int oldx = Integer.parseInt(group.getId().substring(0,1));
            int oldy = Integer.parseInt(group.getId().substring(1));

            if (nextMove.equals(board.Schachbrett[oldx][oldy].getColor())){

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
                    group.setId(newY + "" + newX);

                }
            }else {
                System.out.println("not your Color");
                group.setLayoutX(startfigX);
                group.setLayoutY(startfigY);
            }

            if (board.isCheck(nextMove)){
                if (board.isCheckmate(nextMove)){

                }
                System.out.println("Check on " + nextMove);
            }
            System.out.println("next to move: " + nextMove);


        }
    }
}
