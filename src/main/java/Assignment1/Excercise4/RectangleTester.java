package Assignment1.Excercise4;

public class RectangleTester {
    public static void main(String[] args) {
        try {
            Rectangle validRectangle = new Rectangle(3.0, 4.0);
            System.out.println("Valid Rectangle: " + validRectangle.getDescription());
        } catch (InvalidShapeParameterException e) {
            System.err.println("Exception for valid rectangle: " + e.getMessage());
        }

        try {
            Rectangle invalidLengthRectangle = new Rectangle(-3.0, 4.0);
            System.err.println("Invalid Rectangle (length): " + invalidLengthRectangle.getDescription());
        } catch (InvalidShapeParameterException e) {
            System.err.println("Exception for invalid rectangle (length): " + e.getMessage());
        }

        try {
            Rectangle invalidWidthRectangle = new Rectangle(3.0, -4.0);
        } catch (InvalidShapeParameterException e) {
            System.err.println("Exception for invalid rectangle (width): " + e.getMessage());
        }

        try {
            Rectangle rectangle = new Rectangle(5.0, 6.0);
            System.out.println("Rectangle before setting invalid length: " + rectangle.getDescription());
            rectangle.setLength(-5.0);
        } catch (InvalidShapeParameterException e) {
            System.err.println("Exception for setting invalid length: " + e.getMessage());
        }

        try {
            Rectangle rectangle = new Rectangle(5.0, 6.0);
            System.out.println("Rectangle before setting invalid width: " + rectangle.getDescription());
            rectangle.setWidth(-6.0);
        } catch (InvalidShapeParameterException e) {
            System.err.println("Exception for setting invalid width: " + e.getMessage());
        }
    }
}
