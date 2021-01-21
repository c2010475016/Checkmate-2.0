package at.ac.fhcampuswien.JavaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class StartScreen extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        HBox eins = new HBox();
        primaryStage.setTitle("Hello World");
        Button zwei = new Button();
        eins.getChildren().add(zwei);
        zwei.setMinWidth(400);
        zwei.setMinHeight(500);
        zwei.setOnAction(event -> {
            Chessboard_FX game = new Chessboard_FX();
            primaryStage.close();
            Stage peter = new Stage();
            try {
                game.gameStart(Chessboard_FX.gameStart(peter));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        primaryStage.setScene(new Scene(eins, 300, 275));
        primaryStage.show();
    }
}
