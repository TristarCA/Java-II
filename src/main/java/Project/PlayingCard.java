package Project;

import java.io.Serializable;
import java.io.PrintStream;

/**
 * The PlayingCard class represents a standard playing card.
 * It includes methods to get the card's value and suit, and to print the card in ASCII art.
 */
public class PlayingCard implements Serializable {

    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    public static final int ACE = 14;
    private final int value;  // Represents the numeric value of the card (2-14).
    private final Suit suit; // Represents the suit of the card.

    /**
     * Constructs a PlayingCard with a specified value and suit.
     * If the specified value is invalid, the default value is set to 2.
     *
     * @param value The numeric value of the card (2-14).
     * @param suit  The suit of the card.
     */
    public PlayingCard(int value, Suit suit) {
        if (value < 2 || value > ACE) {
            System.out.println("Invalid card value. Setting default value to 2.");
            this.value = 2;
        } else {
            this.value = value;
        }
        this.suit = suit;
    }

    /**
     * Gets the numeric value of the card.
     *
     * @return The numeric value of the card.
     */
    public int getValue() {
        return value;
    }

    /**
     * Gets the suit of the card.
     *
     * @return The suit of the card.
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Returns a string representation of the card in the format "VALUE(SUIT)".
     *
     * @return A string representation of the card.
     */
    @Override
    public String toString() {
        String card = "";
        if (value == JACK) {
            card += "J";
        } else if (value == QUEEN) {
            card += "Q";
        } else if (value == KING) {
            card += "K";
        } else if (value == ACE) {
            card += "A";
        } else {
            card += String.valueOf(value);
        }

        Suit suitSymbol = suit;
        if (suitSymbol == Suit.DIAMONDS) {
            card += (char) '♦';
        } else if (suitSymbol == Suit.SPADE) {
            card += (char) '♠';
        } else if (suitSymbol == Suit.CLUBS) {
            card += (char) '♣';
        } else {
            card += (char) '♥';
        }
        return card;
    }

    /**
     * Prints an ASCII art representation of the card to the specified PrintStream.
     *
     * @param playingCard The PlayingCard to print.
     * @param printStream The PrintStream to which the ASCII art will be printed.
     */
    public static void printAsciiCard(PlayingCard playingCard, PrintStream printStream) {
        StringBuilder str = new StringBuilder();
        char symbol;
        String val;
        Suit suitSymbol = playingCard.getSuit();

        if (suitSymbol == Suit.DIAMONDS) {
            symbol = '\u2666';
        } else if (suitSymbol == Suit.SPADE) {
            symbol = '\u2660';
        } else if (suitSymbol == Suit.CLUBS) {
            symbol = '\u2663';
        } else {
            symbol = '\u2665';
        }

        if (playingCard.getValue() == JACK) {
            val = "J";
        } else if (playingCard.getValue() == QUEEN) {
            val = "Q";
        } else if (playingCard.getValue() == KING) {
            val = "K";
        } else if (playingCard.getValue() == ACE) {
            val = "A";
        } else {
            val = String.valueOf(playingCard.getValue());
        }

        str.append("┌──────────────┐\n");
        if (val.equals("10")) {
            str.append(String.format("| %s", symbol + val)).append("          |\n");
        } else {
            str.append(String.format("| %s           |\n", symbol + val));
        }
        str.append("|              |\n");
        str.append("|              |\n");
        str.append(String.format("|      %s       |\n", symbol));
        str.append("|              |\n");
        str.append("|              |\n");
        if (val.equals("10")) {
            str.append(String.format("|          %s", symbol + val)).append(" |\n");
        } else {
            str.append(String.format("|           %s |\n", symbol + val));
        }str.append("└──────────────┘");
        printStream.printf("%s", str);
    }

    /**
     * The Suit enum represents the possible suits of a playing card.
     */
    public enum Suit {DIAMONDS, HEARTS, CLUBS, SPADE};
}
