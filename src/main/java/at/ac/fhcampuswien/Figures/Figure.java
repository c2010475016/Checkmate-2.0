package at.ac.fhcampuswien.Figures;

/**
 * "Figure" Superclass.
 */

import at.ac.fhcampuswien.Board;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Figure implements Cloneable {
    private int[] position = new int[2];
    private String color;
    public Board board;

    /**
     * Constructor for the Object "Figure".
     * @param position position of the Figure
     * @param color color of the Figure
     * @param board on the board
     */
    public Figure(int[] position, String color, Board board) {
        this.position = position;
        this.color = color;
        this.board = board;
    }

    /**
     * Getter for current position.
     * @return Current position in the position Array.
     */
    public int[] getPosition() {
        return position;
    }

    /**
     * Setter for new position to be written in the position Array.
     * @param position Position Array.
     */
    public void setPosition(int[] position) {
        this.position = position;
    }


    /**
     * Getter for the color of the requested Figure.
     * @return Color.
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter for the color.
     * @param color set color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * decides if a Roucharde is still possible
     * @return boolean if a Roucharde is still possible
     */
    public boolean getPossibleRoucharde() {
        return true;
    }

    /**
     * sets if a Roucharde is still possible
     * @param possibleRoucharde decides if a Roucharde is still possible
     */
    public void setPossibleRoucharde(boolean possibleRoucharde) {
    }



    /**
     * Method to move the Figures, utilizes getPossibleMoves method
     * @param position 2D coordinate position Array. [0]=x, [1] = y.
     * @return move made
     */
    public boolean move(int[]position){
        int[] oldPos = this.position;
        ArrayList<int[]> moves = getPossibleMoves();
        for (int[] move: moves) {
            System.out.println(Arrays.toString(move));
        }
        for (int[] move: moves){
            if (move[0] == position[0] && move[1] == position[1]){
                System.out.println(this.position[0] + " " + this.position[1]+ " " +position[0]+ " " +position[1]);

                /**
                 * Chess piece down
                 */
                if (this.board.chessBoard[position[0]][position[1]] != null) {
                    System.out.println("Gegnerische Figur geschlagen!");
                    if(this.board.chessBoard[position[0]][position[1]].color.equals("white")){
                        this.board.setWhiteGraveyard(this.board.chessBoard[position[0]][position[1]]);
                    }else {
                        this.board.setBlackGraveyard(this.board.chessBoard[position[0]][position[1]]);
                    }
                }
                this.board.chessBoard[position[0]][position[1]] = this.board.chessBoard[this.position[0]][this.position[1]];
                this.board.chessBoard[position[0]][position[1]].setPosition(new int[]{position[0],position[1]});
                this.board.chessBoard[oldPos[0]][oldPos[1]] = null;

                /**
                 * You have to move out of Check
                 */
                if(board.isCheck(this.color)){
                    this.board.chessBoard[oldPos[0]][oldPos[1]] = this.board.chessBoard[position[0]][position[1]];
                    this.board.chessBoard[oldPos[0]][oldPos[1]].setPosition(new int[]{oldPos[0],oldPos[1]});
                    this.board.chessBoard[position[0]][position[1]] = null;
                    return false;
                }else {

                    /**
                     * Rocharde
                     */
                    if (this.board.chessBoard[position[0]][position[1]].getClass().getSimpleName().equals("King") &&
                            oldPos[1] + 2 == this.position[1]) {
                        this.board.chessBoard[oldPos[0]][oldPos[1] + 1] = this.board.chessBoard[oldPos[0]][oldPos[1] + 3];
                        this.board.chessBoard[oldPos[0]][oldPos[1] + 1].setPosition(new int[]{oldPos[0], oldPos[1] + 1});
                        this.board.chessBoard[oldPos[0]][oldPos[1] + 3] = null;
                        this.board.chessBoard[position[0]][position[1]].setPossibleRoucharde(false);
                    }
                    if (this.board.chessBoard[position[0]][position[1]].getClass().getSimpleName().equals("King") &&
                            oldPos[1] - 2 == this.position[1]) {
                        this.board.chessBoard[oldPos[0]][oldPos[1] - 1] = this.board.chessBoard[oldPos[0]][oldPos[1] - 4];
                        this.board.chessBoard[oldPos[0]][oldPos[1] - 1].setPosition(new int[]{oldPos[0], oldPos[1] - 1});
                        this.board.chessBoard[oldPos[0]][oldPos[1] - 4] = null;
                        this.board.chessBoard[position[0]][position[1]].setPossibleRoucharde(false);
                    }

                    /**
                     * after King moves once the Roucharde isnt possible anymore
                     */
                    if (this.board.chessBoard[position[0]][position[1]].getClass().getSimpleName().equals("King")){
                        this.board.chessBoard[position[0]][position[1]].setPossibleRoucharde(false);
                    }


                    /**
                     * Pawn/Queen exchange
                     */
                    if (this.getClass().getSimpleName().equals("Pawn")) {
                        if (this.getColor().equals("white") && this.position[0] == 7) {
                            this.board.chessBoard[position[0]][position[1]] = new Queen(new int[]{position[0], position[1]}, "white", this.board);
                        }
                        if (this.getColor().equals("black") && this.position[0] == 0) {
                            this.board.chessBoard[position[0]][position[1]] = new Queen(new int[]{position[0], position[1]}, "black", this.board);
                        }
                    }

                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Declaration of an abstract method to be implemented by all Figures.
     */
    public abstract ArrayList<int[]> getPossibleMoves();
}
