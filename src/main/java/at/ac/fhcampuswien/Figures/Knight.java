package at.ac.fhcampuswien.Figures;

/**
 * This class is a subclass of the Figure superclass and implements and uses its methods.
 */

import at.ac.fhcampuswien.Board;

import java.util.ArrayList;
import java.util.Arrays;

public class Knight extends Figure {

    /**
     * Constructor for the Figure "Knight" implementing the constructor of the superclass.
     * @param position
     * @param color
     * @param board
     */
    public Knight(int[] position, String color, Board board) {

        super(position, color, board);
    }

    /**
     * The method getPossibleMoves gets the position of the Figure Knight and checks the valid moves by using the isValidMove method.
     * @return Returns ArrayList containing all possible valid moves.
     */
    @Override
    public ArrayList<int[]> getPossibleMoves(){
        int x = this.getPosition()[0], y = this.getPosition()[1];
        ArrayList<int[]> knightMoves = new ArrayList<int[]>();
        if (this.board.isValidMove(new int[] {x+1,y-2}, this.getColor())){
            knightMoves.add(new int[]{x+1,y-2}); }
        if (this.board.isValidMove(new int[] {x+2,y-1}, this.getColor())){
            knightMoves.add(new int[]{x+2,y-1}); }
        if (this.board.isValidMove(new int[] {x+2,y+1}, this.getColor())){
            knightMoves.add(new int[]{x+2,y+1}); }
        if (this.board.isValidMove(new int[] {x+1,y+2}, this.getColor())){
            knightMoves.add(new int[]{x+1,y+2}); }
        if (this.board.isValidMove(new int[] {x-1,y+2}, this.getColor())){
            knightMoves.add(new int[]{x-1,y+2}); }
        if (this.board.isValidMove(new int[] {x-2,y+1}, this.getColor())){
            knightMoves.add(new int[]{x-2,y+1}); }
        if (this.board.isValidMove(new int[] {x-2,y-1}, this.getColor())){
            knightMoves.add(new int[]{x-2,y-1}); }
        if (this.board.isValidMove(new int[] {x-1,y-2}, this.getColor())){
            knightMoves.add(new int[]{x-1,y-2}); }
        return knightMoves;
        }


    /**
     * ToString Method to tag Chess Pieces on the Board in the Console.
     * @return Letter for type of figure plus color of the figure.
     */
    @Override
    public String toString() {
        return "[k" + this.getColor().substring(0,1)+ "]";
    }
}
