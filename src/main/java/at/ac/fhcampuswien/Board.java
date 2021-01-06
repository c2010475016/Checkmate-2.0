package at.ac.fhcampuswien;

import at.ac.fhcampuswien.Figures.Figure;
import at.ac.fhcampuswien.Figures.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    public Figure[][] Schachbrett = new Figure[8][8];
    private ArrayList<Figure> whiteGraveyard = new ArrayList<Figure>();
    private ArrayList<Figure> blackGraveyard = new ArrayList<Figure>();

    public ArrayList<Figure> getWhiteGraveyard() {
        return whiteGraveyard;
    }

    public ArrayList<Figure> getBlackGraveyard() {
        return blackGraveyard;
    }

    public void setWhiteGraveyard(Figure figure) {
        this.whiteGraveyard.add(figure);
    }

    public void setBlackGraveyard(Figure figure) {
        this.blackGraveyard.add(figure);
    }

    public Board(){
        //resetBoard();
    }


    public void resetBoard(){
        for (int i = 0;i<Schachbrett.length;i++) {
            if (i == 1) {
                for (int x = 0; x < Schachbrett[i].length; x++) {
                    Schachbrett[i][x] = new Pawn(new int[]{i, x}, "white", this);
                }
            }else if(i == 6) {
                for (int x = 0; x < Schachbrett[i].length; x++) {
                    Schachbrett[i][x] = new Pawn(new int[]{i, x}, "black", this);
                }
            }else if(i == 0){
                Schachbrett[i][0] = new Rook(new int[]{i, 0}, "white", this);
                Schachbrett[i][1] = new Knight(new int[]{i, 1}, "white", this);
                Schachbrett[i][2] = new Bishop(new int[]{i, 2}, "white", this);
                Schachbrett[i][3] = new Queen(new int[]{i, 3}, "white", this);
                Schachbrett[i][4] = new King(new int[]{i, 4}, "white", this);
                Schachbrett[i][5] = new Bishop(new int[]{i, 5}, "white", this);
                Schachbrett[i][6] = new Knight(new int[]{i, 6}, "white", this);
                Schachbrett[i][7] = new Rook(new int[]{i, 7}, "white", this);
            }else if(i == 7){
                Schachbrett[i][0] = new Rook(new int[]{i, 0}, "black", this);
                Schachbrett[i][1] = new Knight(new int[]{i, 1}, "black", this);
                Schachbrett[i][2] = new Bishop(new int[]{i, 2}, "black", this);
                Schachbrett[i][3] = new Queen(new int[]{i, 3}, "black", this);
                Schachbrett[i][4] = new King(new int[]{i, 4}, "black", this);
                Schachbrett[i][5] = new Bishop(new int[]{i, 5}, "black", this);
                Schachbrett[i][6] = new Knight(new int[]{i, 6}, "black", this);
                Schachbrett[i][7] = new Rook(new int[]{i, 7}, "black", this);
            }else {
                for (int x = 0; x < Schachbrett[i].length; x++) {
                    Schachbrett[i][0] = null;
                }
            }
        }

    }


    public boolean moveFigure(int[]oldpos,int[]newpos) {
        return this.Schachbrett[oldpos[0]][oldpos[1]].move(newpos);
    }

    public boolean isValidMove(int[]move, String color){
        if (move[0] < 0 || move[0] > 7 || move[1] < 0 || move[1] > 7)
            return false;
        else if (this.Schachbrett[move[0]][move[1]] == null)
            return true;
        else if (this.Schachbrett[move[0]][move[1]].getColor().equals(color))
            return false;
        return true;
    }

    public int[] getKing(String color) {
        for(Figure[] line:Schachbrett){
            for(Figure figure:line){
                if(figure != null && figure.getColor().equals(color) && figure.getClass().getSimpleName().equals("King")) {
                    return figure.getPosition();
                }
            }
        }
        return new int[]{-1,-1};
    }



    @Override
    public String toString() {
        String result = "";
        result += "-----------------------------------------------------------\n";
        for(Figure[] figure:this.Schachbrett){

            for (int i = 0;i<=figure.length-1;i++){
                result += " | ";
                if(figure[i] == null){
                    result += "    ";
                } else {
                    result+=figure[i].toString();
                }
            }
            result += " |\n-----------------------------------------------------------\n";
        }
        return result;
    }

    public boolean isCheck(String color){
        int[] king = getKing(color);
        for(Figure[] line:Schachbrett){
            for(Figure figure:line){
                if(figure != null && !figure.getColor().equals(color) && figure.getPossibleMoves() != null) {
                    for(int[] move:figure.getPossibleMoves()){
                        if (move[0] == king[0] && move[1] == king[1]){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean isCheckmate(String color){
        for(Figure[] figures:this.Schachbrett){
            for (Figure figure:figures) {
                if (figure != null && figure.getColor().equals(color)){
                    if (figure.getPossibleMoves().size() != 0){
                        for (int[] move:figure.getPossibleMoves()){
                            int[] oldPos = figure.getPosition();
                            int[] position = move;
                            Figure geschlagen = this.Schachbrett[position[0]][position[1]];

                            this.Schachbrett[position[0]][position[1]] = this.Schachbrett[oldPos[0]][oldPos[1]];
                            this.Schachbrett[position[0]][position[1]].setPosition(new int[]{position[0],position[1]});
                            this.Schachbrett[oldPos[0]][oldPos[1]] = null;
                            if (!isCheck(color)){
                                this.Schachbrett[oldPos[0]][oldPos[1]] = this.Schachbrett[position[0]][position[1]];
                                this.Schachbrett[oldPos[0]][oldPos[1]].setPosition(new int[]{oldPos[0],oldPos[1]});
                                this.Schachbrett[position[0]][position[1]] = geschlagen;
                                return false;
                            }

                            this.Schachbrett[oldPos[0]][oldPos[1]] = this.Schachbrett[position[0]][position[1]];
                            this.Schachbrett[oldPos[0]][oldPos[1]].setPosition(new int[]{oldPos[0],oldPos[1]});
                            this.Schachbrett[position[0]][position[1]] = geschlagen;
                        }
                    }
                }
            }
        }
        return true;
    }






    public static void main(String[] args) {
        Board board = new Board();
        board.resetBoard();
        System.out.println(Arrays.toString(board.getKing("black")));

    }

}
