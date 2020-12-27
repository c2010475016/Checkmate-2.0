package at.ac.fhcampuswien.JavaFX_test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.awt.*;

public class RobotController {
    @FXML
    private Group robot;
    @FXML
    private Label label;
    @FXML
    protected void hitRobot(MouseEvent event) {
        
        if(event.getEventType() == MouseEvent.MOUSE_CLICKED){
            if(label.getText().equals("") || label.getText().equals("Be nice this time!")|| label.getText().equals("!Dead yet!?")){
                label.setText("Ouch!");
            }
            else if(label.getText().equals("Ouch!")){
                label.setText("Please no!");
            } else {
                robot.setVisible(false);
            }
        }
    }
}
