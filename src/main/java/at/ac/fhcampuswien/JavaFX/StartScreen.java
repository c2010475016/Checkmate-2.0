package at.ac.fhcampuswien.JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.File;



public class StartScreen extends Application {
    /**
     * This creates the Startcreen/Main Menu window including the Start button and Player information.
     * @param primaryStage The main Stage.
     * @throws Exception
     */

    private final String resources = new File("./").getAbsolutePath();
    String uriString = new File(resources + "/src/main/java/at/ac/fhcampuswien/resources/sword_unsheath.mp3").toURI().toString();
    MediaPlayer playSound = new MediaPlayer(new Media(uriString));

    @Override
    public void start(Stage primaryStage) throws Exception{
        StackPane pane = new StackPane();
        primaryStage.setTitle("Checkmate - Main Menu");
        Button startButton = new Button();
        startButton.setText("Start the Game!");
        pane.getChildren().add(startButton);
        startButton.setMinWidth(200);
        startButton.setMinHeight(50);
        Font font = new Font(30);
        startButton.setFont(font);
        startButton.setOnAction(event -> {
            playSound.play();
            playSound.seek(playSound.getStartTime());
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
        final double FONT_SIZE_TINY = 10.0;
        final double FONT_SIZE_SMALL = 14.0;
        final double FONT_SIZE_LARGE = 18.0;

        Label title = new Label("Checkmate");
        title.setTextFill(Color.web("#ffffff"));
        pane.getChildren().add(title);
        title.setTranslateY(-250);
        title.setFont(new Font("Algerian", 60));

        Label version = new Label("Version 1.0");
        version.setTextFill(Color.web("#ffffff"));
        pane.getChildren().add(version);
        version.setTranslateX(270);
        version.setTranslateY(290);
        version.setFont(new Font(FONT_SIZE_TINY));

        Label playerInfo1 = new Label("Player 1: White");
        playerInfo1.setTextFill(Color.web("#ffffff"));
        pane.getChildren().add(playerInfo1);
        playerInfo1.setTranslateY(-100);
        playerInfo1.setFont(new Font(FONT_SIZE_LARGE));

        Label playerInfo2 = new Label("Player 2: Black");
        playerInfo2.setTextFill(Color.web("#ffffff"));
        pane.getChildren().add(playerInfo2);
        playerInfo2.setTranslateY(-80);
        playerInfo2.setFont(new Font(FONT_SIZE_LARGE));

        Label beginner = new Label("White begins!");
        beginner.setTextFill(Color.web("#ffffff"));
        pane.getChildren().add(beginner);
        beginner.setTranslateY(-60);
        beginner.setFont(new Font(FONT_SIZE_LARGE));

        Label gameInfo = new Label("You can always press 'Q' to quit the game!");
        gameInfo.setTextFill(Color.web("#ffffff"));
        pane.getChildren().add(gameInfo);
        gameInfo.setTranslateY(290);
        gameInfo.setFont(new Font(16));



        String resources = new File("./").getAbsolutePath();
        String uriString = new File(resources + "/src/main/java/at/ac/fhcampuswien/resources/ChessSet.jpg").toURI().toString();
        Image image = new Image(uriString);
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage background = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        primaryStage.setScene(new Scene(pane, 600, 600));
        pane.setBackground(new Background(background));
        primaryStage.show();
    }
}
