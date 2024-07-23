package Project;

import java.util.ArrayList;
import java.util.Collections;
import java.io.PrintStream;

/**
 * The CardDeck class represents a standard deck of playing cards.
 * It includes methods for creating a deck, shuffling the deck, drawing cards,
 * and checking the number of cards left in the deck.
 */
public class CardDeck {
    static PrintStream stream = new PrintStream(System.out);
    private ArrayList<PlayingCard> playingCards;

    /**
     * Constructs a new CardDeck and initializes the fullDeck ArrayList.
     * The deck is created automatically upon instantiation.
     */
    public CardDeck() {
        // Initialize the fullDeck ArrayList in the constructor
        playingCards = new ArrayList<>();
        createDeck();
    }

    /**
     * Creates a standard deck of playing cards with all suits and values.
     * Populates the fullDeck ArrayList with each created PlayingCard.
     */
    public void createDeck() {
        /**
         *   For each PlayingCard.Suit(Spade, Diamond, Heart, Club) in PlayingCard.Suit.values()
         *   the .values() function is used on enums to creat an array of the values in the enum
         */
        for (PlayingCard.Suit suit : PlayingCard.Suit.values()) {
            for (int i = 2; i <= PlayingCard.ACE; i++) {
                PlayingCard newCard = new PlayingCard(i, suit);
                playingCards.add(newCard);
            }
        }
    }

    /**
     * For each card remaining in the deck an Ascii version of the card is displayed to the user
     */
    public void getFullDeck() {
        for (PlayingCard card : playingCards) {
            PlayingCard.printAsciiCard(card, stream);
            stream.println();
        }
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
            stream.println("Deck empty, opening new deck.....");
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
        if (playingCards.isEmpty()) {
            return 0;
        }
        return 1;
    }
}
