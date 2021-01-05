package at.ac.fhcampuswien.Figures;

import at.ac.fhcampuswien.Board;

import java.util.ArrayList;
import java.util.Arrays;

public class King extends Figure{

    public King(int[] position, String color, Board board) {
        super(position, color,board);
    }


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
                ((rochardevar && x == 0) || (!rochardevar && x == 7)) &&
                this.board.Schachbrett[x][y + (1)] == null &&
                this.board.Schachbrett[x][y + (2)] == null &&
                this.board.Schachbrett[x][y + (3)] != null &&
                ((this.board.Schachbrett[x][y + (3)].getClass().getSimpleName().equals("Rook")))) {
            kingMoves.add(new int[]{x, y + (2)});
        }
        if (this.board.isValidMove(new int[]{x, y - (2)}, this.getColor()) &&
                ((rochardevar && x == 0) || (!rochardevar && x == 7)) &&
                this.board.Schachbrett[x][y - (1)] == null &&
                this.board.Schachbrett[x][y - (2)] == null &&
                this.board.Schachbrett[x][y - (3)] == null &&
                this.board.Schachbrett[x][y - (4)] != null &&
                ((this.board.Schachbrett[x][y - (4)]).getClass().getSimpleName().equals("Rook"))) {
            kingMoves.add(new int[]{x, y - (4)});
        }










        return kingMoves;
    }


    @Override
    public String toString() {
        return "[K" + this.getColor().substring(0,1)+ "]";
    }
}