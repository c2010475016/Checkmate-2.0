package at.ac.fhcampuswien.JavaFX_test;
import at.ac.fhcampuswien.Board;
import at.ac.fhcampuswien.Figures.Figure;
import at.ac.fhcampuswien.Player;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
// import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class Chessboard_FX extends Application {

    private static final int BOARD_SIZE = 600;
    @Override
    public void start(Stage primaryStage) throws Exception{


        Board board;
        Player player1;
        Player player2;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Player 1 Name: ");
        player1 = new Player("Player 1","white");
        System.out.print("Player 2 Name: ");
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


        Circle[][] circles = new Circle[8][8];

        int groesse_circ = 20;
        for (int i = 0;i<8;i++) {
            if(i==0||i==1||i==6||i==7) {
                for (int x = 0; x < 8; x++) {
                    Circle r = new Circle(groesse_circ);
                    r.setLayoutX(100 + groesse_rect * x + 25);
                    r.setLayoutY(100 + groesse_rect * i + 25);
                    r.setStroke(Color.BLACK);
                    r.setId(i + "" + x);
                    r.setFill(Color.RED);
                    circles[i][x] = r;
                    r.addEventHandler(MouseEvent.ANY, new DragEventHandler(r,board));
                    root.getChildren().addAll(r);
                }
            }
        }

        String resources = new File("./").getAbsolutePath();
        resources = resources.substring(0,resources.length()-2);
        Image image = new Image(new FileInputStream(resources + "/src/main/java/at/ac/fhcampuswien/resources/king.jpg"));
        ImageView imageView = new ImageView(image);

        imageView.setX(100);
        imageView.setY(100);

        imageView.setFitHeight(40);
        imageView.setFitWidth(40);
        imageView.setId("00");

        imageView.addEventHandler(MouseEvent.ANY, new DragEventHandler(imageView,board));

        imageView.setPreserveRatio(true);
        root.getChildren().addAll(imageView);



        /*
        Button revive = new Button();
        revive.setText("Revive");
        revive.setPrefSize(100,30);
        revive.setLayoutX(5);
        revive.setLayoutY(5);
        revive.setOnAction(e -> {
            Label label = (Label) robot.lookup("#label");
            if(robot.isVisible()){
                label.setText("!Dead yet!?");
            } else {
                robot.setVisible(true);
                label.setText("Be nice this time!");
            }
        })
        root.getChildren().addAll(revive);
         */

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
