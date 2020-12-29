package at.ac.fhcampuswien.JavaFX_test;;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

public class DragEventHandler implements EventHandler<MouseEvent> {
    private Node group;
    private double mouseX;
    private double mouseY;
    private double startfigX;
    private double startfigY;


    public DragEventHandler(Node group) {
        this.group = group;
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

           //System.out.println("Event: " + event.getX() + " " +event.getY() + " | " + mouseX + " " + mouseY);
           //System.out.println("Scene: " + event.getSceneX() + " " +event.getSceneY() + " | " + mouseX + " " + mouseY);
        }
        if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
            // Help with dragging:
            // https://stackoverflow.com/questions/32680689/javafx-mouseevent-location-accuracy-degrades-over-time-results-in-node-movement
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
            int newMouseX = (int) event.getSceneX() / 10;
            int newMouseY = (int) event.getSceneY() / 10;
            newMouseX *= 10;
            newMouseY *= 10;
            while (newMouseX % 50 != 0) {
                newMouseX -= 10;
            }
            while (newMouseY % 50 != 0) {
                newMouseY -= 10;
            }
            if (group.getId().equals("1")) {
                group.setLayoutX(startfigX);
                group.setLayoutY(startfigY);
            } else {
                group.setLayoutX(newMouseX + 25);
                group.setLayoutY(newMouseY + 25);
            }
            int newX = (newMouseX-100)/50;
            int newY = (newMouseY-100)/50;
            group.setId(newY + "" + newX);
            System.out.println(group.getId());
        }
    }
}
