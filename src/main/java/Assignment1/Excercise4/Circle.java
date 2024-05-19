package Assignment1.Excercise4;

public class Circle extends Shape{
    private Double radius;

    public Circle(Double radius) throws InvalidShapeParameterException {
        setRadius(radius);
    }

    public Double getRadius(){
        return radius;
    }

    public void setRadius(Double radius) throws InvalidShapeParameterException {
        if (radius < 0) {
            throw new InvalidShapeParameterException();
        }
        this.radius = radius;
    }

    @Override
    public Double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String getDescription() {
        return String.format("Circle with radius %.1f has a area of %.2f", radius, area());
    }
}
