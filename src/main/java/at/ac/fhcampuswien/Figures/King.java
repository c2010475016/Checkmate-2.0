package at.ac.fhcampuswien.Figures;

/**
 * This class is a subclass of the Figure superclass and implements and uses its methods.
 */

import at.ac.fhcampuswien.Board;

import java.util.ArrayList;
import java.util.Arrays;

public class King extends Figure{

    /**
     * Constructor for the Figure "King" implementing the constructor of the superclass.
     * @param position
     * @param color
     * @param board
     */
    public King(int[] position, String color, Board board) {
        super(position, color,board);
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

        //rocharde
        boolean rochardevar =this.getColor().equals("white");

        if (this.board.isValidMove(new int[]{x, y + (2)}, this.getColor()) &&
                ((rochardevar && x == 0) || (!rochardevar && x == 7)) && y == 4 &&
                this.board.Schachbrett[x][y + (1)] == null &&
                this.board.Schachbrett[x][y + (2)] == null &&
                this.board.Schachbrett[x][y + (3)] != null &&
                ((this.board.Schachbrett[x][y + (3)].getClass().getSimpleName().equals("Rook")))) {
            kingMoves.add(new int[]{x, y + (2)});
        }
        if (this.board.isValidMove(new int[]{x, y - (2)}, this.getColor()) &&
                ((rochardevar && x == 0) || (!rochardevar && x == 7)) &&  y == 4 &&
                this.board.Schachbrett[x][y - (1)] == null &&
                this.board.Schachbrett[x][y - (2)] == null &&
                this.board.Schachbrett[x][y - (3)] == null &&
                this.board.Schachbrett[x][y - (4)] != null &&
                ((this.board.Schachbrett[x][y - (4)]).getClass().getSimpleName().equals("Rook"))) {
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