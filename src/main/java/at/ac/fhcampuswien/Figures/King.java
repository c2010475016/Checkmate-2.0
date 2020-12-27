package at.ac.fhcampuswien.Figures;

import at.ac.fhcampuswien.Board;

import java.util.ArrayList;
import java.util.Arrays;

public class King extends Figure{

    public King(int[] position, String color, Board board) {
        super(position, color,board);
    }


    //NEW
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
        return kingMoves;
    }

    @Override
    public String toString() {
        return "[K" + this.getColor().substring(0,1)+ "]";
    }

    public static void main(String[] args) {
        King king = new King(new int[]{1,1}, "black", new Board());
        ArrayList<int[]> test = king.getPossibleMoves();
        for (int[] whatever: test) {
            System.out.println(Arrays.toString(whatever));
        }
    }
}
