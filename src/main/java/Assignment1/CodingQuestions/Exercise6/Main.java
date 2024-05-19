package Assignment1.CodingQuestions.Exercise6;

public class Main {
    public static void main(String[] args) {
        try {
            SomeClass obj = new SomeClass();
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
