package at.ac.fhcampuswien;

import java.util.Scanner;

/**
 * Player properties color and name (not yet relevant for JavaFX implementation)
 */
public class Player {
    Scanner scan = new Scanner(System.in);
    private String color;
    private String name;

    public Player(String name,String color) {
        this.color = color;
        this.name = name;
    }

    /**
     * getter for player color
     * @return player color
     */
    public String getColor() { return color; }

    /**
     * Getter for player name
     * @return player name
     */
    public String getName() { return name; }
}
