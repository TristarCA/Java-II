package Assignment1.Excercise4;

public class CircleTester {
    public static void main(String[] args) {
        try {
            Circle validCircle = new Circle(1.0);
            System.out.println("Valid Circle: " + validCircle.getDescription());
        } catch (InvalidShapeParameterException e) {
            System.err.println("Exception for valid circle: " + e.getMessage());
        }

        try {
            Circle invalidCircle = new Circle(-1.0);
            System.err.println("Invalid Circle: " + invalidCircle.getDescription());
        } catch (InvalidShapeParameterException e) {
            System.err.println("Exception for invalid circle: " + e.getMessage());
        }

        try {
            Circle circle = new Circle(2.0);
            System.out.println("Circle before setting invalid radius: " + circle.getDescription());
            circle.setRadius(-2.0);
            System.err.println("Circle after setting invalid radius: " + circle.getDescription());
        } catch (InvalidShapeParameterException e) {
            System.err.println("Exception for setting invalid radius: " + e.getMessage());
        }
    }
}
