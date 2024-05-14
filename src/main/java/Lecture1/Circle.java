package Lecture1;
import java.util.Random;

class Circle extends Shape{
    //Random random = new Random();
    private double radius = testRadius(getRadius());

    public double getRadius() {
        return -3.0;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double testRadius(double radius) {
        try {
            if (radius > 0) {
                return radius;
            }
            else {
                throw new InvalidShapeParameterException();
            }
        } catch (InvalidShapeParameterException e) {
            e.errorMessage();
        }
        return 0.0;
    }

    @Override
    public Double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getDescription() {
        return String.format("This is a Circle with a radius of %.2f and an area of %.2f \n", radius, area());
    }
}
