package Project;


public class GameMessage {
    private static final long serialVersionUID = 1L;
    public static final int WAITING = 0;
    public static final int IN_GAME = 1;
    public static final int BETTING = 2;
    public static final int PLAYER_TURN = 3;
    public static final int GAME_OVER = 4;

    private int state;
    private Dealer dealer;
    private Player player;
    private double bet;
    private String message;

    public GameMessage(int state, Dealer dealer, Player player, double bet) {
        this.state = state;
        this.dealer = dealer;
        this.player = player;
        this.bet = bet;
        this.message = "";
    }

    public int getState() {
        return state;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public Player getPlayer() {
        return player;
    }

    public double getBet() {
        return bet;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
