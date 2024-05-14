package Assignment1.review_soln.review_soln;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[5];

        int num = 0;
        for (Shape shape : shapes) {
            shape = ShapeGenerator.generateShape();
            shapes[num] = shape;
            num++;
            System.out.println(shape.getDescription());
        }
    }
}