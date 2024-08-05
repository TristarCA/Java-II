package Project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The CardDeck class represents a standard deck of playing cards.
 * It includes methods for creating a deck, shuffling the deck, drawing cards,
 * and checking the number of cards left in the deck.
 */
public class CardDeck {
    private ArrayList<PlayingCard> playingCards;

    /**
     * Constructs a new CardDeck and initializes the playingCards ArrayList.
     * The deck is created automatically upon instantiation.
     */
    public CardDeck() {
        playingCards = new ArrayList<>();
        createDeck();
    }

    /**
     * Creates a standard deck of playing cards with all suits and values.
     * Populates the playingCards ArrayList with each created PlayingCard.
     */
    public void createDeck() {
        for (PlayingCard.Suit suit : PlayingCard.Suit.values()) {
            for (int i = 2; i <= PlayingCard.ACE; i++) {
                PlayingCard newCard = new PlayingCard(i, suit);
                playingCards.add(newCard);
            }
        }
    }

    /**
     * Generates and returns a string containing the ASCII art representation of the entire deck.
     *
     * @return A string representing the entire deck in ASCII art format.
     */
    public String getFullDeck() {
        StringBuilder deckString = new StringBuilder();
        for (PlayingCard card : playingCards) {
            deckString.append(card.getAsciiCard().toString()).append("\n\n");
        }
        return deckString.toString();
    }

    /**
     * Shuffles the deck of playing cards using the Collections.shuffle method.
     */
    public void shuffleDeck() {
        Collections.shuffle(playingCards);
    }

    /**
     * Draws a card from the deck. If the deck is empty, it repopulates the deck.
     *
     * @return The drawn PlayingCard.
     */
    public PlayingCard drawCard() {
        if (cardsLeft() == 0) {
            System.out.println("Deck empty, opening new deck.....");
            createDeck();
        }
        return playingCards.remove(0);
    }

    /**
     * Returns the number of cards left in the deck.
     *
     * @return The number of cards left in the deck.
     */
    public int cardsLeft() {
        return playingCards.size();
    }
}
