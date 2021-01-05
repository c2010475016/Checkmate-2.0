package at.ac.fhcampuswien.Figures;

import at.ac.fhcampuswien.Board;

import java.util.ArrayList;

public class Rook extends Figure {

    public Rook(int[] position, String color, Board board) {
        super(position, color,board);
    }


    @Override
    public ArrayList<int[]> getPossibleMoves() {
        int x = this.getPosition()[0], y = this.getPosition()[1];
        ArrayList<int[]> rookMoves = new ArrayList<int[]>();
        for (int a = 1;a>-2;a-=2) {
                for (int i = 1; true; i++) {
                    if (this.board.isValidMove(new int[]{x + (i * a), y}, this.getColor())) {
                        if (this.board.Schachbrett[x + (i * a)][y] == null) {
                            rookMoves.add(new int[]{x + (i * a), y});
                        } else {
                            rookMoves.add(new int[]{x + (i * a), y});
                            break;
                        }
                    } else {
                        break;
                    }
                }
                for (int i = 1; true; i++){
                    if (this.board.isValidMove(new int[]{x, y + (i*a)}, this.getColor())) {
                        if (this.board.Schachbrett[x][y+(i*a)] == null) {
                            rookMoves.add(new int[]{x, y + (i*a)});
                        } else {
                            rookMoves.add(new int[]{x, y + (i*a)});
                            break;
                        }
                    }else {
                        break;
                    }
                }
        }
        return rookMoves;
    }


    @Override
    public String toString() {
        return "[R" + this.getColor().substring(0,1) + "]";
    }
}