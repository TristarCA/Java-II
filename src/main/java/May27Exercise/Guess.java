package May27Exercise;

public class Guess {
    private int number;

    public Guess() {this(0);}

    public Guess(int number) {
        this.number = number;
    }

    public int getNumber() {return number;}

    public void setNumber(final int number) {
        this.number = number;
    }
}
