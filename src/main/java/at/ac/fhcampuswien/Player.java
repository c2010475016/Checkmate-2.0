package at.ac.fhcampuswien;

import java.util.Scanner;

public class Player {
    Scanner scan = new Scanner(System.in);
    private String color;
    private String name;

    public Player(String name,String color) {
        this.color = color;
        this.name = name;
    }

    public String getColor() { return color; }
    public String getName() { return name; }
}
