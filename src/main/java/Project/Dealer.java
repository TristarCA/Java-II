package Project;
// TODO: Add functionality for calculating dealers score


import java.util.ArrayList;

import static Project.CardDeck.stream;

public class Dealer {
    private ArrayList<PlayingCard> hand;
    private CardDeck deck;

    public Dealer() {
        hand = new ArrayList<>();
        deck = new CardDeck();
        deck.shuffleDeck();
        hand.add(deck.drawCard());
        hand.add(deck.drawCard());
    }

    public ArrayList<PlayingCard> dealCards() {
        ArrayList<PlayingCard> playerHand = new ArrayList<>();
        playerHand.add(deck.drawCard());
        playerHand.add(deck.drawCard());
        return playerHand;
    }

    public ArrayList<PlayingCard> getHand() {
        for (PlayingCard card : hand) {
            PlayingCard.printAsciiCard(card, stream);
            stream.println();
        }
        return null;
    }

    public PlayingCard getTopCard() {
        return(deck.drawCard());
    }

    public int getScore() {
        return 100;
    }
}
