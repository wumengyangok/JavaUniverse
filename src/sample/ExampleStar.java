package sample;

import java.util.ArrayList;

/**
 * Created by wumengyang on 30/01/2016.
 */
public class ExampleStar {
    private String name;
    private int radius;
    private int orbitRadius;
    private double lengthOfYear;
    private ArrayList<ExampleStar> moons;

    ExampleStar(String name, int radius, int age, double lengthOfYear, int orbitRadius) {
        this.moons = new ArrayList<ExampleStar>();
        this.name = name;
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
