package Project;

import java.util.ArrayList;

/**
 * The Dealer class represents the dealer in the Blackjack game.
 * It manages the dealer's hand, deck of cards, and score.
 */
public class Dealer {
    private ArrayList<PlayingCard> hand;
    private CardDeck deck;
    private int score;

    /**
     * Constructs a new Dealer with a shuffled deck and an empty hand.
     */
    public Dealer() {
        this.deck = new CardDeck();
        this.deck.shuffleDeck();
        this.hand = new ArrayList<>();
        this.score = 0;
    }

    /**
     * Deals a card from the deck.
     *
     * @return The drawn PlayingCard.
     */
    public PlayingCard dealCard() {
        return deck.drawCard();
    }

    /**
     * Adds a card to the dealer's hand and updates the score.
     *
     * @param card The card to be added to the dealer's hand.
     */
    public void receiveCard(PlayingCard card) {
        this.hand.add(card);
        updateScore();
    }

    /**
     * Displays the dealer's current hand as an ASCII art representation.
     *
     * @return A string representing the dealer's hand in ASCII art format and their current score.
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

        handString.append("Score: ").append(this.score).append("\n");
        return handString.toString();
    }

    /**
     * Updates the dealer's score based on the current hand.
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
     * Resets the dealer's hand and score, and shuffles the deck.
     */
    public void reset() {
        this.hand.clear();
        this.deck = new CardDeck();
        this.deck.shuffleDeck();
        this.score = 0;
    }

    /**
     * Gets the dealer's current hand of cards.
     *
     * @return The dealer's hand as an ArrayList of PlayingCard objects.
     */
    public ArrayList<PlayingCard> getHand() {
        return hand;
    }

    /**
     * Gets the dealer's current score.
     *
     * @return The dealer's current score.
     */
    public int getScore() {
        return score;
    }
}
