package at.ac.fhcampuswien.JavaFX;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class RuleSet {

    public static void rules() {
        Stage rulesScreen = new Stage();
        StackPane rules = new StackPane();
        Scene secondScene = new Scene(rules, 600, 600);
        rulesScreen.setScene(secondScene);
        rulesScreen.show();
        Label ruleSet = new Label("Checkmate");
        ruleSet.setText("""
                King can move exactly one square horizontally, vertically, or diagonally. At most once in every game, each king is allowed to make a special move, known as castling.
                
                Queen can move any number of vacant squares diagonally, horizontally, or vertically.
                
                Rook can move any number of vacant squares vertically or horizontally. It also is moved while castling.
                
                Bishop can move any number of vacant squares in any diagonal direction.
                
                Knight can move one square along any rank or file and then at an angle. The knight's movement can also be viewed as an L laid out at any horizontal or vertical angle.
                
                Pawns can move forward one square, if that square is unoccupied. If it has not yet moved, the pawn has the option of moving two squares forward provided both squares in front of the pawn are unoccupied. A pawn cannot move backward. Pawns are the only pieces that capture differently from how they move. They can capture an enemy piece on either of the two spaces adjacent to the space in front of them (i.e., the two squares diagonally in front of them) but cannot move to these spaces if they are vacant. The pawn is also involved in the two special moves en passant and promotion."""
        );
        ruleSet.setTextFill(Color.web("#000000"));
        ruleSet.setTextAlignment(TextAlignment.JUSTIFY);
        ruleSet.setMaxWidth(500);
        ruleSet.setWrapText(true);
        rules.getChildren().add(ruleSet);
        ruleSet.setFont(new Font(14));
    }
}
