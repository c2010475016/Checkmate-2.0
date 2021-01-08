package at.ac.fhcampuswien;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


/*
    *
    *
    *
    * Class is just for testing purposes.
    *
    *
    *
 */


/**
 * PLayer name input, start of the Game
 */
public class Game {
    Board board;
    Player player1;
    Player player2;
    Scanner scanner = new Scanner(System.in);
    public Game() {
        System.out.print("Player 1 Name: ");
        player1 = new Player(scanner.next(),"white");
        System.out.print("Player 2 Name: ");
        player2 = new Player(scanner.next(),"black");
        System.out.println(player1.getName() + " plays color " + player1.getColor());
        System.out.println(player2.getName() + " plays color " + player2.getColor());
        System.out.println(player1.getName() + " has to move first");
        System.out.println("Game on!");
        board = new Board();
        board.resetBoard();
        System.out.println(board);
    }

    /**
     * Alternates betwenn players at turn, checks if you move the right Figure, utilizes getPossibleMoves method.
     */
    public void gameprocess(){
        int winner = 0;
        Scanner gamescanner = new Scanner(System.in);
        Boolean blackcheck = false,whitecheck  = false;
        int fromx,fromy,tox,toy;

        while(true){

            if (board.isCheck("white")){
                if (board.isCheckmate("white")){
                    winner = 2;
                    break;
                }
                System.out.println("Check on white");
            }
            while (true) {
                System.out.println("Player " + player1.getName() + " move from: ");
                fromx = gamescanner.nextInt();
                fromy = gamescanner.nextInt();
                if (board.Schachbrett[fromx][fromy] == null) {
                    System.out.println("There is no figure");
                }else if(board.Schachbrett[fromx][fromy].getPossibleMoves().isEmpty()){
                    System.out.println("You cant move that figure");
                } else if (board.Schachbrett[fromx][fromy].getColor().equals("white")){
                    ArrayList<int[]> moves = board.Schachbrett[fromx][fromy].getPossibleMoves();;
                    for (int[] whatever: moves) {
                        System.out.println(Arrays.toString(whatever));
                    }
                    System.out.println("Player " + player1.getName() + " move to: ");
                    tox = gamescanner.nextInt();
                    toy = gamescanner.nextInt();
                    board.moveFigure(new int[]{fromx, fromy}, new int[]{tox, toy});
                    break;
                } else {
                    System.out.println("Thats not your figure!");
                }
            }

            System.out.println(board);

            if (board.isCheck("black")){
                if (board.isCheckmate("black")){
                    winner = 1;
                    break;
                }
                System.out.println("Check on black");
            }

            while (true) {
                System.out.println("Player " + player2.getName() + " move from: ");
                fromx = gamescanner.nextInt();
                fromy = gamescanner.nextInt();
                if (board.Schachbrett[fromx][fromy] == null){
                    System.out.println("There is no figure");
                } else if(board.Schachbrett[fromx][fromy].getPossibleMoves().isEmpty()){
                    System.out.println("You cant move that figure");
                } else if (board.Schachbrett[fromx][fromy].getColor().equals("black")){
                    ArrayList<int[]> moves = board.Schachbrett[fromx][fromy].getPossibleMoves();;
                    for (int[] whatever: moves) {
                        System.out.println(Arrays.toString(whatever));
                    }
                    System.out.println("Player " + player2.getName() + " move to: ");
                    tox = gamescanner.nextInt();
                    toy = gamescanner.nextInt();
                    board.moveFigure(new int[]{fromx, fromy}, new int[]{tox, toy});
                    break;
                } else {
                    System.out.println("Thats not your figure!");
                }
            }
            System.out.println(board);
        }

        System.out.println("Checkmate! Game over.");
        if (winner==1){
            System.out.println("Player " + player1.getName() + " won!");
        }else {
            System.out.println("Player " + player2.getName() + " won!");
        }

    }




    public static void main(String[] args) {
        Game game = new Game();
        game.gameprocess();
    }
}
