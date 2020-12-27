package at.ac.fhcampuswien.Figures;

import at.ac.fhcampuswien.Board;

import java.util.ArrayList;
import java.util.Arrays;

public class Knight extends Figure {

    public Knight(int[] position, String color, Board board) {

        super(position, color, board);
    }

    //NEW
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

    @Override
    public String toString() {
        return "[k" + this.getColor().substring(0,1)+ "]";
    }


    public static void main(String[] args) {
        Knight knight = new Knight(new int[]{1,1}, "black", new Board());
        ArrayList<int[]> test = knight.getPossibleMoves();
        for (int[] whatever: test) {
            System.out.println(Arrays.toString(whatever));
        }
    }

}
