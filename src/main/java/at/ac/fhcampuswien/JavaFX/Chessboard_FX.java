package at.ac.fhcampuswien.JavaFX;

/**
 * Class to define board and Chess Piece appearances in JavaFX.
 */

import at.ac.fhcampuswien.Board;
import at.ac.fhcampuswien.Player;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;

public class Chessboard_FX {

    private static final int BOARD_SIZE = 600;

    public static Stage gameStart(Stage primaryStage) throws Exception{

        /**
         * Setup for new Game
         */
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

        /**
         * Game-Over screen
         */
        Label gameOver = new Label("Game over!");
        gameOver.setVisible(false);
        gameOver.setText("Game over!");
        gameOver.setFont(Font.font(50));
        gameOver.setTextFill(Color.web("#ffffff"));
        gameOver.setLayoutX(170);
        gameOver.setLayoutY(250);
        gameOver.setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 0, 1), new CornerRadii(5.0), new Insets(-5.0))));
        root.getChildren().addAll(gameOver);

        /**
         * Labels to indicate which players turn it currently is.
         */
        Label blackMove = new Label("Next move: Black!");
        blackMove.setVisible(false);
        blackMove.setFont(Font.font(20));
        blackMove.setLayoutX(215);
        blackMove.setLayoutY(525);
        blackMove.setTextAlignment(TextAlignment.LEFT);
        root.getChildren().addAll(blackMove);

        Label whiteMove = new Label("Next move: White!");
        whiteMove.setVisible(true);
        whiteMove.setFont(Font.font(20));
        whiteMove.setLayoutX(215);
        whiteMove.setLayoutY(525);
        whiteMove.setTextAlignment(TextAlignment.LEFT);
        root.getChildren().addAll(whiteMove);

        /**
         * Creates classic Chess Board pattern consisting of black and white squares.
         */
        Rectangle[][] rectangles = new Rectangle[8][8];

        int size_rect = 50;
        for (int i = 0;i<8;i++) {
            for (int x = 0;x<8;x++) {
                Rectangle r = new Rectangle(size_rect,size_rect);
                r.setLayoutX(100 + size_rect*x);
                r.setLayoutY(100 + size_rect*i);
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

        /**
         * Places the chess pieces on the board (Drawn by the infamous Joseph Hangstein)
         */
        ImageView[][] grid = new ImageView[8][8];
        String resources = new File("./").getAbsolutePath();
        resources = resources.substring(0,resources.length()-2);
        for (int i = 0;i<8;i++) {
            if(i==0||i==1||i==6||i==7) {
                for (int x = 0; x < 8; x++) {
                    if (i == 0) {
                        if (x == 0 || x == 7) {
                            Image whR = new Image(new FileInputStream(resources + "/src/main/java/at/ac/fhcampuswien/resources/rook_white.png"));
                            ImageView whiteRook = new ImageView(whR);
                            whiteRook.setLayoutX(100 + size_rect * x);
                            whiteRook.setLayoutY(100);
                            whiteRook.setFitHeight(50);
                            whiteRook.setFitWidth(50);
                            whiteRook.setId(i + "" + x);
                            grid[i][x] = whiteRook;
                            whiteRook.addEventHandler(MouseEvent.ANY, new MouseEventHandler_Figures(whiteRook, board, grid, gameOver, whiteMove, blackMove));
                            root.getChildren().addAll(whiteRook);
                        } else if (x == 1 || x == 6) {
                            Image whKn = new Image(new FileInputStream(resources + "/src/main/java/at/ac/fhcampuswien/resources/knight_white.png"));
                            ImageView whiteKnight = new ImageView(whKn);
                            whiteKnight.setLayoutX(100 + size_rect * x);
                            whiteKnight.setLayoutY(100);
                            whiteKnight.setFitHeight(50);
                            whiteKnight.setFitWidth(50);
                            whiteKnight.setId(i + "" + x);
                            grid[i][x] = whiteKnight;
                            whiteKnight.addEventHandler(MouseEvent.ANY, new MouseEventHandler_Figures(whiteKnight, board, grid, gameOver, whiteMove, blackMove));
                            root.getChildren().addAll(whiteKnight);
                        } else if (x == 2 || x == 5) {
                            Image whB = new Image(new FileInputStream(resources + "/src/main/java/at/ac/fhcampuswien/resources/phallus_white.png"));
                            ImageView whiteBishop = new ImageView(whB);
                            whiteBishop.setLayoutX(100 + size_rect * x);
                            whiteBishop.setLayoutY(100);
                            whiteBishop.setFitHeight(50);
                            whiteBishop.setFitWidth(50);
                            whiteBishop.setId(i + "" + x);
                            grid[i][x] = whiteBishop;
                            whiteBishop.addEventHandler(MouseEvent.ANY, new MouseEventHandler_Figures(whiteBishop, board, grid, gameOver, whiteMove, blackMove));
                            root.getChildren().addAll(whiteBishop);
                        } else if (x == 3){
                            Image whQ = new Image(new FileInputStream(resources + "/src/main/java/at/ac/fhcampuswien/resources/queen_white.png"));
                            ImageView whiteQueen = new ImageView(whQ);
                            whiteQueen.setLayoutX(100 + size_rect * x);
                            whiteQueen.setLayoutY(100);
                            whiteQueen.setFitHeight(50);
                            whiteQueen.setFitWidth(50);
                            whiteQueen.setId(i + "" + x);
                            grid[i][x] = whiteQueen;
                            whiteQueen.addEventHandler(MouseEvent.ANY, new MouseEventHandler_Figures(whiteQueen, board, grid, gameOver, whiteMove, blackMove));
                            root.getChildren().addAll(whiteQueen);
                        } else {
                            Image whKi = new Image(new FileInputStream(resources + "/src/main/java/at/ac/fhcampuswien/resources/king_white.png"));
                            ImageView whiteKing = new ImageView(whKi);
                            whiteKing.setLayoutX(100 + size_rect * x);
                            whiteKing.setLayoutY(100);
                            whiteKing.setFitHeight(50);
                            whiteKing.setFitWidth(50);
                            whiteKing.setId(i + "" + x);
                            grid[i][x] = whiteKing;
                            whiteKing.addEventHandler(MouseEvent.ANY, new MouseEventHandler_Figures(whiteKing, board, grid, gameOver, whiteMove, blackMove));
                            root.getChildren().addAll(whiteKing);
                        }
                    }
                    else if (i == 1){
                        Image whP = new Image(new FileInputStream(resources + "/src/main/java/at/ac/fhcampuswien/resources/pawn_white.png"));
                        ImageView whitePawn = new ImageView(whP);
                        whitePawn.setLayoutX(100 + size_rect * x);
                        whitePawn.setLayoutY(100 + size_rect * i);
                        whitePawn.setFitHeight(50);
                        whitePawn.setFitWidth(50);
                        whitePawn.setId(i + "" + x);
                        grid[i][x] = whitePawn;
                        whitePawn.addEventHandler(MouseEvent.ANY, new MouseEventHandler_Figures(whitePawn, board, grid, gameOver, whiteMove, blackMove));
                        root.getChildren().addAll(whitePawn);
                    }
                    else if (i == 6){
                        Image blP = new Image(new FileInputStream(resources + "/src/main/java/at/ac/fhcampuswien/resources/pawn_black.png"));
                        ImageView blackPawn = new ImageView(blP);
                        blackPawn.setLayoutX(100 + size_rect * x);
                        blackPawn.setLayoutY(100 + size_rect * i);
                        blackPawn.setFitHeight(50);
                        blackPawn.setFitWidth(50);
                        blackPawn.setId(i + "" + x);
                        grid[i][x] = blackPawn;
                        blackPawn.addEventHandler(MouseEvent.ANY, new MouseEventHandler_Figures(blackPawn, board, grid, gameOver, whiteMove, blackMove));
                        root.getChildren().addAll(blackPawn);
                    }
                    else{
                        if (x == 0 || x == 7) {
                            Image blR = new Image(new FileInputStream(resources + "/src/main/java/at/ac/fhcampuswien/resources/rook_black.png"));
                            ImageView blackRook = new ImageView(blR);
                            blackRook.setLayoutX(100 + size_rect * x);
                            blackRook.setLayoutY(100 + size_rect * i);
                            blackRook.setFitHeight(50);
                            blackRook.setFitWidth(50);
                            blackRook.setId(i + "" + x);
                            grid[i][x] = blackRook;
                            blackRook.addEventHandler(MouseEvent.ANY, new MouseEventHandler_Figures(blackRook, board, grid, gameOver, whiteMove, blackMove));
                            root.getChildren().addAll(blackRook);
                        }else if (x == 1 || x == 6) {
                            Image blKn = new Image(new FileInputStream(resources + "/src/main/java/at/ac/fhcampuswien/resources/knight_black.png"));
                            ImageView blackKnight = new ImageView(blKn);
                            blackKnight.setLayoutX(100 + size_rect * x);
                            blackKnight.setLayoutY(100 + size_rect * i);
                            blackKnight.setFitHeight(50);
                            blackKnight.setFitWidth(50);
                            blackKnight.setId(i + "" + x);
                            grid[i][x] = blackKnight;
                            blackKnight.addEventHandler(MouseEvent.ANY, new MouseEventHandler_Figures(blackKnight, board, grid, gameOver, whiteMove, blackMove));
                            root.getChildren().addAll(blackKnight);
                        } else if (x == 2 || x == 5) {
                            Image blB = new Image(new FileInputStream(resources + "/src/main/java/at/ac/fhcampuswien/resources/phallus_black.png"));
                            ImageView blackBishop = new ImageView(blB);
                            blackBishop.setLayoutX(100 + size_rect * x);
                            blackBishop.setLayoutY(100 + size_rect * i);
                            blackBishop.setFitHeight(50);
                            blackBishop.setFitWidth(50);
                            blackBishop.setId(i + "" + x);
                            grid[i][x] = blackBishop;
                            blackBishop.addEventHandler(MouseEvent.ANY, new MouseEventHandler_Figures(blackBishop, board, grid, gameOver, whiteMove, blackMove));
                            root.getChildren().addAll(blackBishop);
                        } else if (x == 3){
                            Image blQ = new Image(new FileInputStream(resources + "/src/main/java/at/ac/fhcampuswien/resources/queen_black.png"));
                            ImageView blackQueen = new ImageView(blQ);
                            blackQueen.setLayoutX(100 + size_rect * x);
                            blackQueen.setLayoutY(100 + size_rect * i);
                            blackQueen.setFitHeight(50);
                            blackQueen.setFitWidth(50);
                            blackQueen.setId(i + "" + x);
                            grid[i][x] = blackQueen;
                            blackQueen.addEventHandler(MouseEvent.ANY, new MouseEventHandler_Figures(blackQueen, board, grid, gameOver, whiteMove, blackMove));
                            root.getChildren().addAll(blackQueen);
                        } else {
                            Image blKi = new Image(new FileInputStream(resources + "/src/main/java/at/ac/fhcampuswien/resources/king_black.png"));
                            ImageView blackKing = new ImageView(blKi);
                            blackKing.setLayoutX(100 + size_rect * x);
                            blackKing.setLayoutY(100 + size_rect * i);
                            blackKing.setFitHeight(50);
                            blackKing.setFitWidth(50);
                            blackKing.setId(i + "" + x);
                            grid[i][x] = blackKing;
                            blackKing.addEventHandler(MouseEvent.ANY, new MouseEventHandler_Figures(blackKing, board, grid, gameOver, whiteMove, blackMove));
                            root.getChildren().addAll(blackKing);
                        }
                    }
                }
            }
        }


        Scene scene = new Scene(root, BOARD_SIZE, BOARD_SIZE, Color.LIGHTGRAY);

        /**
         * Press "q" to quit the game. Recognizes "q" keystroke and exits.
         */
        scene.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            if(e.getCode().equals(KeyCode.Q)){
                Platform.exit();
                System.exit(0);
            }
        });

        /**
         * Reset button in Game window. Press that button to restart the game.
         */
        Button resetButton = new Button();
        resetButton.setText("Restart Game");
        root.getChildren().add(resetButton);
        resetButton.setTranslateX(4);
        resetButton.setTranslateY(300);
        resetButton.setMinWidth(90);
        resetButton.setOnAction(event -> {
            MouseEventHandler_Figures.nextMove = "white";
            primaryStage.close();
            board.resetBoard();

            try {
                gameStart(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
            primaryStage.show();
        });

        /**
         * Button to open the Rules
         */
        Button rulesButton = new Button();
        rulesButton.setText("Rules");
        root.getChildren().add(rulesButton);
        rulesButton.setMinWidth(90);
        rulesButton.setTranslateX(4);
        rulesButton.setTranslateY(330);
        rulesButton.setOnAction(event -> {
            try {
                RuleSet.rules();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        /**
         * Game window initialisation
         */
        primaryStage.setResizable(false);
        primaryStage.setTitle("Checkmate");
        primaryStage.setScene(scene);
        primaryStage.show();
        return primaryStage;
    }
}
