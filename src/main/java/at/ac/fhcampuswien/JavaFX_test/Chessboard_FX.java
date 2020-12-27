package at.ac.fhcampuswien.JavaFX_test;
import at.ac.fhcampuswien.Figures.Figure;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
// import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Chessboard_FX extends Application {

    private static final int BOARD_SIZE = 600;
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Group robot = FXMLLoader.load(getClass().getResource("test.fxml"));

        /*
        Rectangle r = new Rectangle(100,100);
        r.setLayoutX(100);
        r.setLayoutY(100);
        r.setId("10");
        r.setFill(Color.RED);
        r.addEventHandler(MouseEvent.ANY, new DragEventHandler(r));
         */

        //robot.setLayoutX(400);
        //robot.setLayoutY(400);
        Group root = new Group();
        Button revive = new Button();

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
                //r.addEventHandler(MouseEvent.ANY, new DragEventHandler(r));
                root.getChildren().addAll(r);
            }
        }


        Circle[][] circles = new Circle[8][8];

        int groesse_circ = 20;
        for (int i = 0;i<8;i++) {
            if(i==0||i==1||i==6||i==7) {
                for (int x = 0; x < 8; x++) {
                    Circle r = new Circle(groesse_circ);
                    r.setLayoutX(100 + groesse_rect * x + 25);
                    r.setLayoutY(100 + groesse_rect * i + 25);
                    r.setStroke(Color.BLACK);
                    r.setId("0");
                    r.setFill(Color.RED);
                    circles[i][x] = r;
                    r.addEventHandler(MouseEvent.ANY, new DragEventHandler(r));
                    root.getChildren().addAll(r);
                }
            }
        }

        revive.setText("Revive");
        revive.setPrefSize(100,30);
        revive.setLayoutX(5);
        revive.setLayoutY(5);
        /*revive.setOnAction(e -> {
            Label label = (Label) robot.lookup("#label");
            if(robot.isVisible()){
                label.setText("!Dead yet!?");
            } else {
                robot.setVisible(true);
                label.setText("Be nice this time!");
            }
        })
         */


        root.getChildren().addAll(revive);
        Scene scene = new Scene(root, BOARD_SIZE, BOARD_SIZE);

        scene.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            if(e.getCode().equals(KeyCode.Q)){
                Platform.exit();
                System.exit(0);
            }
        });

        /*
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            if(e.getButton() == MouseButton.SECONDARY) {
                Bounds b = robot.getLayoutBounds();
                Timeline animation = new Timeline(
                        new KeyFrame(
                                Duration.millis(700),
                                new KeyValue(robot.layoutXProperty(), e.getX() - b.getWidth()/2),
                                new KeyValue(robot.layoutYProperty(), e.getY() - b.getHeight()/2))
                );
                animation.play();
            }
        });

        //root.getChildren().add(createRobot());
        robot.addEventHandler(MouseEvent.ANY, new DragEventHandler(robot));

         */
        primaryStage.setTitle("Hello Chess");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
