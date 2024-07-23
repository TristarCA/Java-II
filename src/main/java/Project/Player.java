package Project;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private double cash;
    private ArrayList<PlayingCard> hand;
    private int score;

    public Player(double cash) {
        this.cash = cash;
        this.hand = new ArrayList<>();
        this.score = 0;
    }

    public double getMoney() {
        return cash;
    }

    public void adjustCash(double amount) {
        this.cash += amount;
    }

    public void receiveCard(PlayingCard card) {
        this.hand.add(card);
        updateScore();
    }

    public void showHand() {
        ArrayList<String> lines = new ArrayList<>(9);

        for (int i = 0; i < 9; i++) {
            lines.add("");
        }

        for (PlayingCard card : hand) {
            List<String> cardLines = getAsciiCardLines(card);
            for (int i = 0; i < 9; i++) {
                lines.set(i, lines.get(i) + cardLines.get(i) + "  ");
            }
        }


        for (String line : lines) {
            System.out.println(line);
        }
        System.out.println("Current Score: " + this.score);
    }

    private List<String> getAsciiCardLines(PlayingCard card) {
        List<String> lines = new ArrayList<>();
        char symbol = getSuitSymbol(card.getSuit());
        String value = getCardValueString(card.getValue());

        // Format the card art
        lines.add("┌──────────────┐");
        if (value.equals("10")) {
            lines.add(String.format("| %s          |", value + symbol));
        } else {
            lines.add(String.format("| %s           |", value + symbol));
        }
        lines.add("|              |");
        lines.add("|              |");
        lines.add(String.format("|      %s       |", symbol));
        lines.add("|              |");
        lines.add("|              |");
        if (value.equals("10")) {
            lines.add(String.format("|          %s |", value + symbol));
        } else {
            lines.add(String.format("|           %s |", value + symbol));
        }
        lines.add("└──────────────┘");
        return lines;
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



    public int getScore() {
        return this.score;
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
        this.score = 0;
    }
}
