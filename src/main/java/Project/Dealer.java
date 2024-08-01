package Project;

import java.util.ArrayList;

public class Dealer {
    private ArrayList<PlayingCard> hand;
    private CardDeck deck;
    private int score;

    public Dealer() {
        this.deck = new CardDeck();
        this.deck.shuffleDeck();
        this.hand = new ArrayList<>();
        this.score = 0;
    }

    public PlayingCard dealCard() {
        return deck.drawCard();
    }

    public void receiveCard(PlayingCard card) {
        this.hand.add(card);
        updateScore();
    }

    public String showHand() {
        StringBuilder handString = new StringBuilder();

        for (int lineIndex = 0; lineIndex < 9; lineIndex++) {
            for (PlayingCard card : hand) {
                handString.append(getAsciiCardLine(card, lineIndex)).append("  ");
            }
            handString.append("\n");
        }

        handString.append("Dealer Score: ").append(this.score).append("\n");
        return handString.toString();
    }

    private String getAsciiCardLine(PlayingCard card, int lineIndex) {
        char symbol = getSuitSymbol(card.getSuit());
        String value = getCardValueString(card.getValue());

        switch (lineIndex) {
            case 0: return "┌──────────────┐";
            case 1: return value.equals("10") ? String.format("| %s          |", value + symbol) : String.format("| %s           |", value + symbol);
            case 2:
            case 3: return "|              |";
            case 4: return String.format("|      %s       |", symbol);
            case 5:
            case 6: return "|              |";
            case 7: return value.equals("10") ? String.format("|          %s |", value + symbol) : String.format("|           %s |", value + symbol);
            case 8: return "└──────────────┘";
            default: return "";
        }
    }

    private char getSuitSymbol(PlayingCard.Suit suit) {
        switch (suit) {
            case DIAMONDS: return '♦';
            case HEARTS:   return '♥';
            case CLUBS:    return '♣';
            case SPADE:    return '♠';
            default:       return ' ';
        }
    }

    private String getCardValueString(int value) {
        switch (value) {
            case PlayingCard.JACK:  return "J";
            case PlayingCard.QUEEN: return "Q";
            case PlayingCard.KING:  return "K";
            case PlayingCard.ACE:   return "A";
            default:                return String.valueOf(value);
        }
    }

    private void updateScore() {
        this.score = 0;
        int aces = 0;
        for (PlayingCard card : hand) {
            char cardChar = card.toString().charAt(0);
            if (cardChar == 'J' || cardChar == 'Q' || cardChar == 'K') {
                this.score += 10;
            } else if (cardChar == 'A') {
                aces++;
            } else {
                this.score += card.getValue();
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

    public void reset() {
        this.hand.clear();
        this.deck = new CardDeck();
        this.deck.shuffleDeck();
        this.score = 0;
    }

    public ArrayList<PlayingCard> getHand() {
        return hand;
    }

    public int getScore() {
        return score;
    }
}
