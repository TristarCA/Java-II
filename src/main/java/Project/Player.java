package Project;

import java.util.ArrayList;

/**
 * The Player class represents a player in the Blackjack game.
 * It manages the player's hand, cash, and score.
 */
public class Player {
    private double cash;
    private ArrayList<PlayingCard> hand;
    private int score;

    /**
     * Constructs a new Player with a specified amount of starting cash.
     *
     * @param cash The initial amount of cash the player has.
     */
    public Player(double cash) {
        this.cash = cash;
        this.hand = new ArrayList<>();
        this.score = 0;
    }

    /**
     * Gets the amount of cash the player has.
     *
     * @return The player's cash balance.
     */
    public double getMoney() {
        return cash;
    }

    /**
     * Adjusts the player's cash by a specified amount.
     *
     * @param amount The amount to adjust the player's cash by.
     */
    public void adjustCash(double amount) {
        this.cash += amount;
    }

    /**
     * Adds a card to the player's hand and updates the score.
     *
     * @param card The card to be added to the player's hand.
     */
    public void receiveCard(PlayingCard card) {
        this.hand.add(card);
        updateScore();
    }

    /**
     * Displays the player's current hand as an ASCII art representation.
     *
     * @return A string representing the player's hand in ASCII art format and their current score.
     */
    public String showHand() {
        StringBuilder handString = new StringBuilder();
        StringBuilder[] cardLines = new StringBuilder[9];

        // Initialize StringBuilder array
        for (int i = 0; i < cardLines.length; i++) {
            cardLines[i] = new StringBuilder();
        }

        // Build each line of the ASCII card representation
        for (PlayingCard card : hand) {
            String[] asciiCard = card.getAsciiCard().toString().split("\n");
            for (int lineIndex = 0; lineIndex < asciiCard.length; lineIndex++) {
                cardLines[lineIndex].append(asciiCard[lineIndex]).append("  ");
            }
        }

        // Combine all lines into the final handString
        for (StringBuilder line : cardLines) {
            handString.append(line.toString()).append("\n");
        }

        handString.append("Current Score: ").append(this.score).append("\n");
        return handString.toString();
    }

    /**
     * Updates the player's score based on the current hand.
     * Aces are counted as 11 unless that would cause the score to exceed 21, in which case they are counted as 1.
     */
    private void updateScore() {
        this.score = 0;
        int aces = 0;
        for (PlayingCard card : hand) {
            int value = card.getValue();
            if (value == PlayingCard.JACK || value == PlayingCard.QUEEN || value == PlayingCard.KING) {
                this.score += 10;
            } else if (value == PlayingCard.ACE) {
                aces++;
            } else {
                this.score += value;
            }
        }
        for (int i = 0; i < aces; i++) {
            if (this.score + 11 <= 21) {
                this.score += 11;
            } else {
                this.score += 1;
            }
        }
    }

    /**
     * Resets the player's hand and score.
     */
    public void reset() {
        this.hand.clear();
        this.score = 0;
    }

    /**
     * Gets the player's current hand of cards.
     *
     * @return The player's hand as an ArrayList of PlayingCard objects.
     */
    public ArrayList<PlayingCard> getHand() {
        return hand;
    }

    /**
     * Gets the player's current score.
     *
     * @return The player's current score.
     */
    public int getScore() {
        return score;
    }
}
