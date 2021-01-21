package at.ac.fhcampuswien;

import at.ac.fhcampuswien.Figures.Figure;
import at.ac.fhcampuswien.Figures.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    public Figure[][] chessBoard = new Figure[8][8];
    private ArrayList<Figure> whiteGraveyard = new ArrayList<Figure>();
    private ArrayList<Figure> blackGraveyard = new ArrayList<Figure>();


    /**
     * Setter for the white graveyard.
     * @param figure adds Figure to the graveyard.
     */
    public void setWhiteGraveyard(Figure figure) {
        this.whiteGraveyard.add(figure);
    }

    /**
     * Setter for the black graveyard.
     * @param figure adds Figure to the graveyard.
     */
    public void setBlackGraveyard(Figure figure) {
        this.blackGraveyard.add(figure);
    }

    public Board(){
        //resetBoard();
    }

    /**
     * Resets the board and places all chess pieces on their respective starting position.
     */
    public void resetBoard(){
        for (int i = 0; i< chessBoard.length; i++) {
            if (i == 1) {
                for (int x = 0; x < chessBoard[i].length; x++) {
                    chessBoard[i][x] = new Pawn(new int[]{i, x}, "white", this);
                }
            }else if(i == 6) {
                for (int x = 0; x < chessBoard[i].length; x++) {
                    chessBoard[i][x] = new Pawn(new int[]{i, x}, "black", this);
                }
            }else if(i == 0){
                chessBoard[i][0] = new Rook(new int[]{i, 0}, "white", this);
                chessBoard[i][1] = new Knight(new int[]{i, 1}, "white", this);
                chessBoard[i][2] = new Bishop(new int[]{i, 2}, "white", this);
                chessBoard[i][3] = new Queen(new int[]{i, 3}, "white", this);
                chessBoard[i][4] = new King(new int[]{i, 4}, "white", this);
                chessBoard[i][5] = new Bishop(new int[]{i, 5}, "white", this);
                chessBoard[i][6] = new Knight(new int[]{i, 6}, "white", this);
                chessBoard[i][7] = new Rook(new int[]{i, 7}, "white", this);
            }else if(i == 7){
                chessBoard[i][0] = new Rook(new int[]{i, 0}, "black", this);
                chessBoard[i][1] = new Knight(new int[]{i, 1}, "black", this);
                chessBoard[i][2] = new Bishop(new int[]{i, 2}, "black", this);
                chessBoard[i][3] = new Queen(new int[]{i, 3}, "black", this);
                chessBoard[i][4] = new King(new int[]{i, 4}, "black", this);
                chessBoard[i][5] = new Bishop(new int[]{i, 5}, "black", this);
                chessBoard[i][6] = new Knight(new int[]{i, 6}, "black", this);
                chessBoard[i][7] = new Rook(new int[]{i, 7}, "black", this);
            }else {
                for (int x = 0; x < chessBoard[i].length; x++) {
                    chessBoard[i][0] = null;
                }
            }
        }

    }

    /**
     * Method to move chess pieces using the command window.
     * @param oldpos the old position
     * @param newpos the new position
     * @return Calls move method of Class Figure.
     */
    public boolean moveFigure(int[]oldpos,int[]newpos) {
        return this.chessBoard[oldpos[0]][oldpos[1]].move(newpos);
    }

    /**
     * Method to check if a move is valid (Out of bounds, same color)
     * @param move move to be checked
     * @param color The color of the figure
     * @return move is possible/impossible
     */
    public boolean isValidMove(int[]move, String color){
        if (move[0] < 0 || move[0] > 7 || move[1] < 0 || move[1] > 7)
            return false;
        else if (this.chessBoard[move[0]][move[1]] == null)
            return true;
        else if (this.chessBoard[move[0]][move[1]].getColor().equals(color))
            return false;
        return true;
    }

    /**
     * Gets current position of the King.
     * @param color color of the requested King
     * @return Position
     */
    public int[] getKing(String color) {
        for(Figure[] line: chessBoard){
            for(Figure figure:line){
                if(figure != null && figure.getColor().equals(color) && figure.getClass().getSimpleName().equals("King")) {
                    return figure.getPosition();
                }
            }
        }
        return new int[]{-1,-1};
    }


    /**
     * Prints Board in command line.
     * @return String to print.
     */
    @Override
    public String toString() {
        String result = "";
        result += "-----------------------------------------------------------\n";
        for(Figure[] figure:this.chessBoard){

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

    /**
     * Method to assess if the King is in Check.
     * @param color color of the requested King
     * @return King is in check/not in check
     */
    public boolean isCheck(String color){
        int[] king = getKing(color);
        for(Figure[] line: chessBoard){
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

    /**
     * Method to assess if there is a Checkmate.
     * @param color color of the King
     * @return Checkmate/not Checkmate
     */
    public boolean isCheckmate(String color){
        for(Figure[] figures:this.chessBoard){
            for (Figure figure:figures) {
                if (figure != null && figure.getColor().equals(color)){
                    if (figure.getPossibleMoves().size() != 0){
                        for (int[] move:figure.getPossibleMoves()){
                            int[] oldPos = figure.getPosition();
                            int[] position = move;
                            Figure captured = this.chessBoard[position[0]][position[1]];

                            this.chessBoard[position[0]][position[1]] = this.chessBoard[oldPos[0]][oldPos[1]];
                            this.chessBoard[position[0]][position[1]].setPosition(new int[]{position[0],position[1]});
                            this.chessBoard[oldPos[0]][oldPos[1]] = null;
                            if (!isCheck(color)){
                                this.chessBoard[oldPos[0]][oldPos[1]] = this.chessBoard[position[0]][position[1]];
                                this.chessBoard[oldPos[0]][oldPos[1]].setPosition(new int[]{oldPos[0],oldPos[1]});
                                this.chessBoard[position[0]][position[1]] = captured;
                                return false;
                            }

                            this.chessBoard[oldPos[0]][oldPos[1]] = this.chessBoard[position[0]][position[1]];
                            this.chessBoard[oldPos[0]][oldPos[1]].setPosition(new int[]{oldPos[0],oldPos[1]});
                            this.chessBoard[position[0]][position[1]] = captured;
                        }
                    }
                }
            }
        }
        return true;
    }
}
