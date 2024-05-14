package Lecture1;
import java.util.ArrayList;

public class Main {
    ArrayList<Shape> shapes = new ArrayList<>();
    int i = 5;
    ShapeGenerator shapeGen = new ShapeGenerator();

    public void FillList() {
        while (i >= 0) {
            shapes.add(shapeGen.Creation());
            i--;
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.FillList();
        for (Shape shape : main.shapes) {
            System.out.println(shape.getDescription());
        }
    }
}

