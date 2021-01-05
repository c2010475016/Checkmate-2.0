package at.ac.fhcampuswien.Figures;

import at.ac.fhcampuswien.Board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Figure {
    private int[] position = new int[2];
    private String color;
    public Board board;

    public Figure(int[] position, String color, Board board) {
        this.position = position;
        this.color = color;
        this.board = board;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }



    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //fehlt: falls nach dem move noch immer Schah besteht -> invalid move
    public boolean move(int[]position){
        int[] oldPos = this.position;
        ArrayList<int[]> moves = getPossibleMoves();
        for (int[] move: moves) {
            System.out.println(Arrays.toString(move));
        }
        for (int[] move: moves){
            if (move[0] == position[0] && move[1] == position[1]){
                System.out.println(this.position[0] + " " + this.position[1]+ " " +position[0]+ " " +position[1]);

                /* noch in der Testphase
                Figure[][] test_schachbrett = this.board.Schachbrett;
                test_schachbrett[position[0]][position[1]] = test_schachbrett[this.position[0]][this.position[1]];
                test_schachbrett[position[0]][position[1]].setPosition(new int[]{position[0],position[1]});
                test_schachbrett[oldPos[0]][oldPos[1]] = null;
                Board testboard = new Board();
                testboard.Schachbrett = test_schachbrett;
                if (testboard.isCheck(this.color)){
                    invalidMove(true);
                    return;
                } */

                if (this.board.Schachbrett[position[0]][position[1]] != null) {
                    System.out.println("gegnerischen Figur geschlagen!");
                    if(this.board.Schachbrett[position[0]][position[1]].color.equals("white")){
                        this.board.setWhiteGraveyard(this.board.Schachbrett[position[0]][position[1]]);
                    }else {
                        this.board.setBlackGraveyard(this.board.Schachbrett[position[0]][position[1]]);
                    }
                }
                this.board.Schachbrett[position[0]][position[1]] = this.board.Schachbrett[this.position[0]][this.position[1]];
                this.board.Schachbrett[position[0]][position[1]].setPosition(new int[]{position[0],position[1]});
                this.board.Schachbrett[oldPos[0]][oldPos[1]] = null;

                //rocharde
                if (this.board.Schachbrett[position[0]][position[1]].getClass().getSimpleName().equals("King") &&
                oldPos[1]+2 == this.position[1]){
                    this.board.Schachbrett[oldPos[0]][oldPos[1]+1] = this.board.Schachbrett[oldPos[0]][oldPos[1]+3];
                    this.board.Schachbrett[oldPos[0]][oldPos[1]+1].setPosition(new int[]{oldPos[0],oldPos[1]+1});
                    this.board.Schachbrett[oldPos[0]][oldPos[1]+3] = null;

                }
                if (this.board.Schachbrett[position[0]][position[1]].getClass().getSimpleName().equals("King") &&
                        oldPos[1]-2 == this.position[1]){
                    this.board.Schachbrett[oldPos[0]][oldPos[1]+1] = this.board.Schachbrett[oldPos[0]][oldPos[1]+4];
                    this.board.Schachbrett[oldPos[0]][oldPos[1]+1].setPosition(new int[]{oldPos[0],oldPos[1]+1});
                    this.board.Schachbrett[oldPos[0]][oldPos[1]+4] = null;

                }

                return true;
            }
        }
        return false;
    }


    public ArrayList<int[]> getPossibleMoves(){
        return null;
    }

    public static void main(String[] args) {
        Board board = new Board();
        King king1 = new King(new int[] {3,3},"black",board);
        board.Schachbrett[3][3] = king1;
        board.Schachbrett[3][2] = king1;
        board.Schachbrett[2][2] = king1;
        board.moveFigure(king1.getPosition(), new int[]{2,2});
        //King king = new King(new int[] {3,3},"black",board);
        //king.move(new int[]{2,2});
    }
}
