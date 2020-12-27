package at.ac.fhcampuswien.Figures;

import at.ac.fhcampuswien.Board;

import java.util.ArrayList;

public class Pawn extends Figure{

    public Pawn(int[] position, String color, Board board) {
        super(position, color,board);
    }

    @Override
    public String toString() {
        return "[P" + this.getColor().substring(0,1)+ "]";
    }

    public ArrayList<int[]> getPossibleMoves(){
        int x = this.getPosition()[0], y = this.getPosition()[1];
        ArrayList<int[]> pawnMoves = new ArrayList<int[]>();
        if(getColor().equals("white")) {
            if (this.board.isValidMove(new int[] {x+1,y}, this.getColor()) && this.board.Schachbrett[x+1][y] == null){
                pawnMoves.add(new int[]{x+1,y}); }
            if (x == 1 && this.board.isValidMove(new int[] {x+2,y}, this.getColor()) && this.board.Schachbrett[x+1][y] == null && this.board.Schachbrett[x+2][y] == null){
                pawnMoves.add(new int[]{x+2,y}); }
            if (this.board.isValidMove(new int[] {x+1,y-1}, this.getColor()) && this.board.Schachbrett[x+1][y-1] != null){
                pawnMoves.add(new int[]{x+1,y-1}); }
            if (this.board.isValidMove(new int[] {x+1,y+1}, this.getColor()) && this.board.Schachbrett[x+1][y+1] != null){
                pawnMoves.add(new int[]{x+1,y+1}); }
        } else {
            if (this.board.isValidMove(new int[] {x-1,y}, this.getColor()) && this.board.Schachbrett[x-1][y] == null){
                pawnMoves.add(new int[]{x-1,y}); }
            if (x == 6 && this.board.isValidMove(new int[] {x-2,y}, this.getColor()) && this.board.Schachbrett[x-1][y] == null && this.board.Schachbrett[x-2][y] == null){
                pawnMoves.add(new int[]{x-2,y}); }
                if (this.board.isValidMove(new int[]{x-1,y-1}, this.getColor()) && this.board.Schachbrett[x-1][y-1] != null) {
                    pawnMoves.add(new int[]{x-1, y-1}); }
            if (this.board.isValidMove(new int[] {x-1,y+1}, this.getColor()) && this.board.Schachbrett[x-1][y+1] != null){
                pawnMoves.add(new int[]{x-1,y+1}); }
        }
        return pawnMoves;
    }
}