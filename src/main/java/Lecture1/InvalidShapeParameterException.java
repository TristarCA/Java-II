package Lecture1;

public class InvalidShapeParameterException extends Exception {
    private static final String MSG = "Shape parameter is not valid!";

    public InvalidShapeParameterException() {
        super(MSG);
    }

    public String errorMessage() {
        return MSG;
    }
}
