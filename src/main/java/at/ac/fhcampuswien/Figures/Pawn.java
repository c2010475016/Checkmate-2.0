package at.ac.fhcampuswien.Figures;

/**
 * This class is a subclass of the Figure superclass and implements and uses its methods.
 */

import at.ac.fhcampuswien.Board;
import java.util.ArrayList;

public class Pawn extends Figure{

    /**
     * Constructor for the Figure "Pawn" implementing the constructor of the superclass.
     * @param position position Array
     * @param color color of the Pawn
     * @param board on the board
     */
    public Pawn(int[] position, String color, Board board) {
        super(position, color,board);
    }

    /**
     * The method getPossibleMoves gets the position of the Figure Pawn and checks the valid moves by using the isValidMove method.
     * @return Returns ArrayList containing all possible valid moves.
     */
    public ArrayList<int[]> getPossibleMoves(){
        int x = this.getPosition()[0], y = this.getPosition()[1];
        ArrayList<int[]> pawnMoves = new ArrayList<int[]>();
        if(getColor().equals("white")) {
            if (this.board.isValidMove(new int[] {x+1,y}, this.getColor()) && this.board.chessBoard[x+1][y] == null){
                pawnMoves.add(new int[]{x+1,y}); }
            if (x == 1 && this.board.isValidMove(new int[] {x+2,y}, this.getColor()) && this.board.chessBoard[x+1][y] == null && this.board.chessBoard[x+2][y] == null){
                pawnMoves.add(new int[]{x+2,y}); }
            if (this.board.isValidMove(new int[] {x+1,y-1}, this.getColor()) && this.board.chessBoard[x+1][y-1] != null){
                pawnMoves.add(new int[]{x+1,y-1}); }
            if (this.board.isValidMove(new int[] {x+1,y+1}, this.getColor()) && this.board.chessBoard[x+1][y+1] != null){
                pawnMoves.add(new int[]{x+1,y+1}); }
        } else {
            if (this.board.isValidMove(new int[] {x-1,y}, this.getColor()) && this.board.chessBoard[x-1][y] == null){
                pawnMoves.add(new int[]{x-1,y}); }
            if (x == 6 && this.board.isValidMove(new int[] {x-2,y}, this.getColor()) && this.board.chessBoard[x-1][y] == null && this.board.chessBoard[x-2][y] == null){
                pawnMoves.add(new int[]{x-2,y}); }
                if (this.board.isValidMove(new int[]{x-1,y-1}, this.getColor()) && this.board.chessBoard[x-1][y-1] != null) {
                    pawnMoves.add(new int[]{x-1, y-1}); }
            if (this.board.isValidMove(new int[] {x-1,y+1}, this.getColor()) && this.board.chessBoard[x-1][y+1] != null){
                pawnMoves.add(new int[]{x-1,y+1}); }
        }
        return pawnMoves;
    }


    /**
     * ToString Method to tag Chess Pieces on the Board in the Console.
     * @return Letter for type of figure plus color of the figure.
     */
    @Override
    public String toString() {
        return "[P" + this.getColor().substring(0,1)+ "]";
    }
}