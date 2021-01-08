package at.ac.fhcampuswien.Figures;

/**
 * This class is a subclass of the Figure superclass and implements and uses its methods.
 */

import at.ac.fhcampuswien.Board;

import java.util.ArrayList;

public class Queen extends Figure {

    /**
     * Constructor for the Figure "Queen" implementing the constructor of the superclass.
     * @param position position Array
     * @param color color of the Queen
     * @param board on the board
     */
    public Queen (int[] position, String color, Board board) {
        super(position, color,board);
    }

    /**
     * ToString Method to tag Chess Pieces on the Board in the Console.
     * @return Letter for type of figure plus color of the figure.
     */
    @Override
    public String toString() {
        return "[Q" + this.getColor().substring(0,1)+ "]";
    }

    /**
     * The method getPossibleMoves gets the position of the Figure Queen and checks the valid moves by using the isValidMove method.
     * @return Returns ArrayList containing all possible valid moves.
     */
    public ArrayList<int[]> getPossibleMoves(){
        int x = this.getPosition()[0], y = this.getPosition()[1];
        ArrayList<int[]> queenMoves = new ArrayList<int[]>();
        for (int a = 1;a>-2;a-=2) {
            for (int b = 1; b > -2; b -= 2) {
                for (int i = 1; true; i++) {
                    if (this.board.isValidMove(new int[]{x + (i*a), y + (i*b)}, this.getColor())) {
                        if (this.board.Schachbrett[x + (i*a)][y + (i*b)] == null) {
                            queenMoves.add(new int[]{x + (i*a), y + (i*b)});
                        } else {
                            queenMoves.add(new int[]{x + (i*a), y + (i*b)});
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        for (int a = 1;a>-2;a-=2) {
            for (int i = 1; true; i++) {
                if (this.board.isValidMove(new int[]{x + (i * a), y}, this.getColor())) {
                    if (this.board.Schachbrett[x + (i * a)][y] == null) {
                        queenMoves.add(new int[]{x + (i * a), y});
                    } else {
                        queenMoves.add(new int[]{x + (i * a), y});
                        break;
                    }
                } else {
                    break;
                }
            }
            for (int i = 1; true; i++){
                if (this.board.isValidMove(new int[]{x, y + (i*a)}, this.getColor())) {
                    if (this.board.Schachbrett[x][y+(i*a)] == null) {
                        queenMoves.add(new int[]{x, y + (i*a)});
                    } else {
                        queenMoves.add(new int[]{x, y + (i*a)});
                        break;
                    }
                }else {
                    break;
                }
            }
        }
        return queenMoves;
    }
}

