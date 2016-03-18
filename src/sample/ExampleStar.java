package sample;

import java.util.ArrayList;

/**
 * Created by wumengyang on 30/01/2016.
 */
public class ExampleStar {
    private String color;
    private String name;
    private int radius;
    private int orbitRadius;
    private double lengthOfYear;
    private ArrayList<ExampleStar> moons;
    public String getColor() {
        return color;
    }

    ExampleStar(String name, int radius, double lengthOfYear, int orbitRadius, String color) {
        this.moons = new ArrayList<ExampleStar>();
        this.name = name;
        this.color = color;

        this.radius = radius;
        this.lengthOfYear = lengthOfYear;
        this.orbitRadius = orbitRadius;

    }

    public String getName() {
        return name;
    }

    public int getRadius() {
        return radius;
    }

    public double getLengthOfYear() {
        return lengthOfYear;
    }

    public void addMoon(ExampleStar moon) {
        moons.add(moon);
    }

    public int getOrbitRadius() {
        return orbitRadius;
    }

    public ArrayList<ExampleStar> getMoons() {
        return moons;
    }
}
