package Assignment1.Excercise4;

public class Main {
    public static void main(String[] args) {
        ShapeGenerator generator = new ShapeGenerator();
        Shape[] shapes = new Shape[5];


        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = generator.generateShape();
        }

        for (Shape shape : shapes) {
            System.out.println(shape.getDescription());
        }

    }
}