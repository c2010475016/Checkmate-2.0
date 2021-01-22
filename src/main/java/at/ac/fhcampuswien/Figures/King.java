package at.ac.fhcampuswien.Figures;

/**
 * This class is a subclass of the Figure superclass and implements and uses its methods.
 */

import at.ac.fhcampuswien.Board;
import java.util.ArrayList;

public class King extends Figure{


    /**
     * decides if a Roucharde is still possible
     */
    private boolean possibleRoucharde = true;

    /**
     * Constructor for the Figure "King" implementing the constructor of the superclass.
     * @param position Position Array
     * @param color Color of the King
     * @param board on the Board
     */
    public King(int[] position, String color, Board board) {
        super(position, color,board);
    }


    @Override
    /**
     * decides if a Roucharde is still possible
     * @return boolean if a Roucharde is still possible
     */
    public boolean getPossibleRoucharde() {
        return possibleRoucharde;
    }

    @Override
    /**
     * sets if a Roucharde is still possible
     * @param possibleRoucharde decides if a Roucharde is still possible
     */
    public void setPossibleRoucharde(boolean possibleRoucharde) {
        this.possibleRoucharde = possibleRoucharde;
    }

    /**
     * The method getPossibleMoves gets the position of the Figure King and checks the valid moves by using the isValidMove method.
     * @return Returns ArrayList containing all possible valid moves.
     */
    @Override
    public ArrayList<int[]> getPossibleMoves(){
        int x = this.getPosition()[0], y = this.getPosition()[1];
        ArrayList<int[]> kingMoves = new ArrayList<int[]>();
        if (this.board.isValidMove(new int[] {x,y-1}, this.getColor())){
            kingMoves.add(new int[]{x,y-1}); }
        if (this.board.isValidMove(new int[] {x+1,y-1}, this.getColor())) {
            kingMoves.add(new int[]{x + 1, y - 1}); }
        if (this.board.isValidMove(new int[]{x+1,y}, this.getColor())){
        kingMoves.add(new int[]{x+1,y}); }
        if (this.board.isValidMove(new int[]{x+1,y+1}, this.getColor())){
        kingMoves.add(new int[]{x+1,y+1}); }
        if (this.board.isValidMove(new int[]{x,y+1}, this.getColor())){
        kingMoves.add(new int[]{x,y+1}); }
        if (this.board.isValidMove(new int[]{x-1,y+1}, this.getColor())){
        kingMoves.add(new int[]{x-1,y+1}); }
        if (this.board.isValidMove(new int[]{x-1,y}, this.getColor())){
        kingMoves.add(new int[]{x-1,y}); }
        if (this.board.isValidMove(new int[]{x-1,y-1}, this.getColor())){
        kingMoves.add(new int[]{x-1,y-1}); }

        /**
         * Rocharde
         */
        boolean rochardeVar =this.getColor().equals("white");

        if (this.board.isValidMove(new int[]{x, y + (2)}, this.getColor()) &&
                ((rochardeVar && x == 0) || (!rochardeVar && x == 7)) && y == 4 &&
                this.board.chessBoard[x][y + (1)] == null &&
                this.board.chessBoard[x][y + (2)] == null &&
                this.board.chessBoard[x][y + (3)] != null &&
                ((this.board.chessBoard[x][y + (3)].getClass().getSimpleName().equals("Rook"))) &&
                possibleRoucharde) {
            kingMoves.add(new int[]{x, y + (2)});
        }
        if (this.board.isValidMove(new int[]{x, y - (2)}, this.getColor()) &&
                ((rochardeVar && x == 0) || (!rochardeVar && x == 7)) &&  y == 4 &&
                this.board.chessBoard[x][y - (1)] == null &&
                this.board.chessBoard[x][y - (2)] == null &&
                this.board.chessBoard[x][y - (3)] == null &&
                this.board.chessBoard[x][y - (4)] != null &&
                ((this.board.chessBoard[x][y - (4)]).getClass().getSimpleName().equals("Rook")) &&
                possibleRoucharde) {
            kingMoves.add(new int[]{x, y - (2)});
        }
        return kingMoves;
    }

    /**
     * ToString Method to tag Chess Pieces on the Board in the Console.
     * @return Letter for type of figure plus color of the figure.
     */
    @Override
    public String toString() {
        return "[K" + this.getColor().substring(0,1)+ "]";
    }
}