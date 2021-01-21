package at.ac.fhcampuswien;

/**
 * Player properties color and name (not yet relevant for JavaFX implementation)
 */
public class Player {
    private String color;
    private String name;

    public Player(String name,String color) {
        this.color = color;
        this.name = name;
    }

    /**
     * Getter for player color
     * @return player color
     */
    public String getColor() { return color; }

    /**
     * Getter for player name
     * @return player name
     */
    public String getName() { return name; }
}
