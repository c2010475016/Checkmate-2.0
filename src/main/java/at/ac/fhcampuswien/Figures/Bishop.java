package at.ac.fhcampuswien.Figures;

/**
 * This class is a subclass of the Figure superclass and implements and uses its methods.
 */

import at.ac.fhcampuswien.Board;
import java.util.ArrayList;


public class Bishop extends Figure{

    /**
     * Constructor for the Figure "Bishop" implementing the constructor of the superclass.
     * @param position position Array
     * @param color Color of the Bishop
     * @param board on the board
     */
    public Bishop(int[] position, String color, Board board) {
        super(position, color, board);
    }

    /**
     * The method getPossibleMoves gets the position of the Figure Bishop and checks the valid moves by using the isValidMove method.
     * @return Returns ArrayList containing all possible valid moves.
     */
    public ArrayList<int[]> getPossibleMoves(){
        int x = this.getPosition()[0], y = this.getPosition()[1];
        ArrayList<int[]> bishopMoves = new ArrayList<int[]>();
        for (int a = 1;a>-2;a-=2) {
            for (int b = 1; b > -2; b -= 2) {
                for (int i = 1; true; i++) {
                    if (this.board.isValidMove(new int[]{x + (i*a), y + (i*b)}, this.getColor())) {
                        if (this.board.chessBoard[x+(i*a)][y+(i*b)] == null) {
                            bishopMoves.add(new int[]{x + (i*a), y + (i*b)});
                        } else {
                            bishopMoves.add(new int[]{x + (i*a), y + (i*b)});
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return bishopMoves;
    }

    /**
     * ToString Method to tag Chess Pieces on the Board in the Console.
     * @return Letter for type of figure plus color of the figure.
     */
    @Override
    public String toString() {
        return "[B" + this.getColor().substring(0,1)+ "]";
    }

}