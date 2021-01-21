package at.ac.fhcampuswien.JavaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;

public class StartScreen extends Application {
    /**
     * This creates the Startcreen/Main Menu window including the Start button and Player information.
     * @param primaryStage The main Stage.
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        StackPane pane = new StackPane();
        primaryStage.setTitle("Checkmate - Main Menu");
        Button startButton = new Button();
        startButton.setText("Start the Game!");
        pane.getChildren().add(startButton);
        startButton.setMinWidth(200);
        startButton.setMinHeight(50);
        startButton.setOnAction(event -> {
            Chessboard_FX game = new Chessboard_FX();
            primaryStage.close();
            Stage startStage = new Stage();
            try {
                game.gameStart(Chessboard_FX.gameStart(startStage));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Infotext on the Startscreen
        final double FONT_SIZE_SMALL = 14.0;
        final double FONT_SIZE_LARGE = 18.0;

        Label playerInfo1 = new Label("Player 1: White");
        pane.getChildren().add(playerInfo1);
        playerInfo1.setTranslateY(-100);
        playerInfo1.setFont(new Font(FONT_SIZE_LARGE));

        Label playerInfo2 = new Label("Player 2: Black");
        pane.getChildren().add(playerInfo2);
        playerInfo2.setTranslateY(-80);
        playerInfo2.setFont(new Font(FONT_SIZE_LARGE));

        Label beginner = new Label("White begins!");
        pane.getChildren().add(beginner);
        beginner.setTranslateY(-60);
        beginner.setFont(new Font(FONT_SIZE_LARGE));

        Label gameInfo = new Label("Press 'q' to quit the Game!");
        pane.getChildren().add(gameInfo);
        gameInfo.setTranslateY(-40);
        gameInfo.setFont(new Font(FONT_SIZE_SMALL));

        /*
        String bgImageresource = new File("./").getAbsolutePath();
        BackgroundImage background;
        background = new BackgroundImage(new Image(bgImageresource + "/src/main/java/at/ac/fhcampuswien/resources/Board.png", 600, 600, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        pane.setBackground(new Background(background));

         */

        primaryStage.setScene(new Scene(pane, 600, 600));
        primaryStage.show();
    }
}
