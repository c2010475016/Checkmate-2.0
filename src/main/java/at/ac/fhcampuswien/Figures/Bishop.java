package at.ac.fhcampuswien.Figures;

import at.ac.fhcampuswien.Board;

import java.util.ArrayList;
import java.util.Arrays;

public class Bishop extends Figure{

    public Bishop(int[] position, String color, Board board) {
        super(position, color, board);
    }

    //von Tobi - sollte so passen
    public ArrayList<int[]> getPossibleMoves(){
        int x = this.getPosition()[0], y = this.getPosition()[1];
        ArrayList<int[]> bishopmoves = new ArrayList<int[]>();
        for (int a = 1;a>-2;a-=2) {
            for (int b = 1; b > -2; b -= 2) {
                for (int i = 1; true; i++) {
                    if (this.board.isValidMove(new int[]{x + (1 * i*a), y + (1 * i*b)}, this.getColor())) {
                        if (this.board.Schachbrett[x+(i*a)][y+(i*b)] == null) {
                            bishopmoves.add(new int[]{x + (1 * i * a), y + (1 * i * b)});
                        } else {
                            bishopmoves.add(new int[]{x + (1 * i * a), y + (1 * i * b)});
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return bishopmoves;
    }

    @Override
    public String toString() {
        return "[B" + this.getColor().substring(0,1)+ "]";
    }

    public static void main(String[] args) {
        Board board = new Board();
        Bishop bishop = new Bishop(new int[]{3,4},"black",board);
        board.Schachbrett[3][4] = bishop;
        board.Schachbrett[1][2] = bishop;
        ArrayList<int[]> test = bishop.getPossibleMoves();
        for (int[] whatever: test) {
            System.out.println(Arrays.toString(whatever));
        }
    }
}

