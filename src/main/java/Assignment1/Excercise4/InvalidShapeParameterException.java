package Assignment1.Excercise4;

public class InvalidShapeParameterException extends Exception {
    private static final String MSG = "Shape parameter is not vaild!";

    public InvalidShapeParameterException() {
        super(MSG);
    }
}
