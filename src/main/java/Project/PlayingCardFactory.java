package Project;

import java.util.Random;

/**
 * The PlayingCardFactory class provides methods for generating playing cards.
 * It includes methods to generate a random card and generate a card from a specific suit.
 */
public class PlayingCardFactory {
    /**
     * Generates a random playing card with a random rank and suit.
     */
    public static void generateRandomCard() {
        Random random = new Random();
        int cardNum = random.nextInt(13) + 2; // Generates a random value between 2 and Ace
        PlayingCard.Suit[] suits = PlayingCard.Suit.values();
        PlayingCard.Suit randomSuit = suits[random.nextInt(suits.length)]; // Randomly selects a suit

        PlayingCard newCard = new PlayingCard(cardNum, randomSuit);
        System.out.printf("%s \n", newCard); // Print the generated card
    }

    /**
     * Generates a playing card with a random rank and a specified suit.
     *
     * @param suit The suit of the generated card.
     */
    public static void generateFromSuit(PlayingCard.Suit suit) {
        Random random = new Random();
        int cardNum = random.nextInt(13) + 2; // Generates a random value between 2 and Ace

        PlayingCard newCard = new PlayingCard(cardNum, suit);
        System.out.printf("%s \n", newCard); // Print the generated card
    }
}