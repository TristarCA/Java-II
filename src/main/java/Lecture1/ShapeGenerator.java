package Lecture1;
import java.util.Random;

class ShapeGenerator {
    Random random = new Random();
    int choice = random.nextInt(2);

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public Shape Creation() {
        ShapeGenerator myObj = new ShapeGenerator() {};
        if (myObj.getChoice() == 0) {
            return new Circle();
        }
        else {
            return new Rectangle();
        }
    }
}

