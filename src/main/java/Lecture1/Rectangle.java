package Lecture1;
import java.util.Random;

class Rectangle extends Shape {
    Random random = new Random();
    private double length = random.nextDouble() + 1;
    private double width = random.nextDouble() + 1;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = this.length = random.nextDouble();
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = this.width = random.nextDouble();
    }

    @Override
    public Double area() {
        return length * width;
    }

    @Override
    public String getDescription() {
        return String.format("This is a Rectangle with a Length of %.2f and width of %.2f, as well the area is %.2f \n", getLength(), getWidth(), area());
    }
}
