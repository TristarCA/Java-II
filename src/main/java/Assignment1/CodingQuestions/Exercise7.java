package Assignment1.CodingQuestions;

public class Exercise7 {
    public static void someMethod2() throws Exception {
        System.err.println("Exception initially thrown from someMethod2");
        throw new Exception("Exception thrown from someMethod2");
    }

    public static void someMethod() throws Exception {
        try {
            someMethod2();
        } catch (Exception e) {
            System.err.println("Exception caught and re-thrown by someMethod");
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            someMethod();
        } catch (Exception e) {
            System.err.println("Exception finally caught in main method and Stack printed");
            e.printStackTrace();
        }
    }
}
