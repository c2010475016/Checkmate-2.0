package at.ac.fhcampuswien.Figures;

import at.ac.fhcampuswien.Board;

import java.util.ArrayList;

public class Queen extends Figure {

    public Queen (int[] position, String color, Board board) {
        super(position, color,board);
    }

    @Override
    public String toString() {
        return "[Q" + this.getColor().substring(0,1)+ "]";
    }

    public ArrayList<int[]> getPossibleMoves(){
        int x = this.getPosition()[0], y = this.getPosition()[1];
        ArrayList<int[]> queenMoves = new ArrayList<int[]>();
        for (int a = 1;a>-2;a-=2) {
            for (int b = 1; b > -2; b -= 2) {
                for (int i = 1; true; i++) {
                    if (this.board.isValidMove(new int[]{x + (1 * i*a), y + (1 * i*b)}, this.getColor())) {
                        if (this.board.Schachbrett[x+(i*a)][y+(i*b)] == null) {
                            queenMoves.add(new int[]{x + (1 * i * a), y + (1 * i * b)});
                        } else {
                            queenMoves.add(new int[]{x + (1 * i * a), y + (1 * i * b)});
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        for (int a = 1;a>-2;a-=2) {
            for (int i = 1; true; i++) {
                if (this.board.isValidMove(new int[]{x + (i * a), y}, this.getColor())) {
                    if (this.board.Schachbrett[x + (i * a)][y] == null) {
                        queenMoves.add(new int[]{x + (i * a), y});
                    } else {
                        queenMoves.add(new int[]{x + (i * a), y});
                        break;
                    }
                } else {
                    break;
                }
            }
            for (int i = 1; true; i++){
                if (this.board.isValidMove(new int[]{x, y + (i*a)}, this.getColor())) {
                    if (this.board.Schachbrett[x][y+(i*a)] == null) {
                        queenMoves.add(new int[]{x, y + (i*a)});
                    } else {
                        queenMoves.add(new int[]{x, y + (i*a)});
                        break;
                    }
                }else {
                    break;
                }
            }
        }
        return queenMoves;
    }
}

