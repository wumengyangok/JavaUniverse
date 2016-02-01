package sample;

/**
 * Created by wumengyang on 30/01/2016.
 */
public class ExampleStar {
    private String name;
    private int mass;
    private int radius;
    private int positionX;
    private int positionY;
    private int age;
    private double lengthOfDay;
    private double lengthOfYear;
    private double gravity;
    ExampleStar(
            String name, int mass, int radius, int positionX, int positionY,
            int age, double lengthOfDay, double lengthOfYear, double gravity
    ) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
        this.positionX = positionX;
        this.positionY = positionY;
        this.age = age;
        this.lengthOfDay = lengthOfDay;
        this.lengthOfYear = lengthOfYear;
        this.gravity = gravity;
    }
    public String getName() {
        return name;
    }
    public int getMass() {
        return mass;
    }
    public int getRadius() {
        return radius;
    }
    public int getPositionX() {
        return positionX;
    }
    public int getPositionY() {
        return positionY;
    }
    public int getAge() {
        return age;
    }
    public double getLengthOfDay() {
        return lengthOfDay;
    }
    public double getLengthOfYear() {
        return lengthOfYear;
    }
    public double getGravity() {
        return gravity;
    }
}
