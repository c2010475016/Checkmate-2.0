package at.ac.fhcampuswien.Figures;

import at.ac.fhcampuswien.Board;
import java.util.ArrayList;


public class Bishop extends Figure{

    public Bishop(int[] position, String color, Board board) {
        super(position, color, board);
    }


    public ArrayList<int[]> getPossibleMoves(){
        int x = this.getPosition()[0], y = this.getPosition()[1];
        ArrayList<int[]> bishopMoves = new ArrayList<int[]>();
        for (int a = 1;a>-2;a-=2) {
            for (int b = 1; b > -2; b -= 2) {
                for (int i = 1; true; i++) {
                    if (this.board.isValidMove(new int[]{x + (i*a), y + (i*b)}, this.getColor())) {
                        if (this.board.Schachbrett[x+(i*a)][y+(i*b)] == null) {
                            bishopMoves.add(new int[]{x + (i*a), y + (i *b)});
                        } else {
                            bishopMoves.add(new int[]{x + (i*a), y + (i*b)});
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return bishopMoves;
    }

    @Override
    public String toString() {
        return "[B" + this.getColor().substring(0,1)+ "]";
    }

}