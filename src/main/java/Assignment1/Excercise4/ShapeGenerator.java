package Assignment1.Excercise4;

import java.util.Random;

public class ShapeGenerator {
    public Shape generateShape() {
        Random random = new Random();
        while (true) {
            int randomRadius = random.nextInt(21) - 10;
            int randomLength = random.nextInt(21) - 10;
            int randomWidth = random.nextInt(21) - 10;
            int choice = random.nextInt(2);

            try {
                if (choice == 0) {
                    return new Circle((double) randomRadius);
                } else {
                    return new Rectangle(randomLength, randomWidth);
                }
            } catch (InvalidShapeParameterException e) {
                if (randomRadius < 0) {
                    System.err.println("Caught exception: " + e.getMessage() + " (Circle radius: " + randomRadius + ")");
                }
                if (randomLength < 0) {
                    System.err.println("Caught exception: " + e.getMessage() + " (Rectangle length: " + randomLength + ")");
                }
                if (randomWidth < 0) {
                    System.err.println("Caught exception: " + e.getMessage() + " (Rectangle width: " + randomWidth + ")");
                }
            }
        }
    }
}
