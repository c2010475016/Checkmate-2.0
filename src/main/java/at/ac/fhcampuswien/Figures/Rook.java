package at.ac.fhcampuswien.Figures;

/**
 * This class is a subclass of the Figure superclass and implements and uses its methods.
 */

import at.ac.fhcampuswien.Board;

import java.util.ArrayList;

public class Rook extends Figure {

    /**
     * Constructor for the Figure "Rook" implementing the constructor of the superclass.
     * @param position
     * @param color
     * @param board
     */
    public Rook(int[] position, String color, Board board) {
        super(position, color,board);
    }


    /**
     * The method getPossibleMoves gets the position of the Figure Rook and checks the valid moves by using the isValidMove method.
     * @return Returns ArrayList containing all possible valid moves.
     */
    @Override
    public ArrayList<int[]> getPossibleMoves() {
        int x = this.getPosition()[0], y = this.getPosition()[1];
        ArrayList<int[]> rookMoves = new ArrayList<int[]>();
        for (int a = 1;a>-2;a-=2) {
                for (int i = 1; true; i++) {
                    if (this.board.isValidMove(new int[]{x + (i * a), y}, this.getColor())) {
                        if (this.board.Schachbrett[x + (i * a)][y] == null) {
                            rookMoves.add(new int[]{x + (i * a), y});
                        } else {
                            rookMoves.add(new int[]{x + (i * a), y});
                            break;
                        }
                    } else {
                        break;
                    }
                }
                for (int i = 1; true; i++){
                    if (this.board.isValidMove(new int[]{x, y + (i*a)}, this.getColor())) {
                        if (this.board.Schachbrett[x][y+(i*a)] == null) {
                            rookMoves.add(new int[]{x, y + (i*a)});
                        } else {
                            rookMoves.add(new int[]{x, y + (i*a)});
                            break;
                        }
                    }else {
                        break;
                    }
                }
        }
        return rookMoves;
    }

    /**
     * ToString Method to tag Chess Pieces on the Board in the Console.
     * @return Letter for type of figure plus color of the figure.
     */
    @Override
    public String toString() {
        return "[R" + this.getColor().substring(0,1) + "]";
    }
}