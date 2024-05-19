package Assignment1.CodingQuestions.Exercise5;

public class Main {
    public static void main(String[] args) {
        try {
            throw new ExceptionC("This is ExceptionC");
        } catch (ExceptionA e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        try {
            throw new ExceptionB("This is ExceptionB");
        } catch (ExceptionA e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
