package poker;
import javax.swing.JButton;

public class PokerGame {
	public final static int NUM_PLAYERS = 6;
	public final static int CARDS_PER_PLAYER = 2;

	private Player[] players;
	private Card[] tableCards;
	private Deck deck;

	private int state;
	public final static int PRE_DEAL = 0;
	public final static int PRE_FLOP = 1;
	public final static int FLOP = 2;
	public final static int TURN = 3;
	public final static int RIVER = 4;

	public PokerGame() {
		initializeGame();
		new PokerGUI(this);
	}

	private void initializeGame() {
		deck = new Deck();
		players = new Player[NUM_PLAYERS];
		for (int i = 0; i < NUM_PLAYERS; i++) {
			players[i] = new Player();
		}
		tableCards = new Card[0];
		state = PRE_DEAL;
	}
	
	/* returns a shallow copy of the deck */
	public Deck getDeck() {
		return new Deck(deck);
	}

	/* returns a DEEP COPY of the Players */
	public Player[] getPlayers() {
		Player[] p = new Player[players.length];
		for (int i = 0; i < p.length; i++) {
			p[i] = new Player(players[i]);
		}
		return p;
	}

	/* returns shallow copy of table cards */
	public Card[] getTableCards() {
		Card[] c = new Card[tableCards.length];
		for (int i = 0; i < c.length; i++) {
			c[i] = tableCards[i];
		}
		return c;
	}
	
	public void doShuffle1() {
		deck.shuffle();
	}
	
	public void doCutDeck(int position) {
		deck.cut(position);
	}
	
	public void proceedToNextStep(JButton buttonToUpdate) {
		switch(state) {
		case PRE_DEAL:
			dealPlayerCards();
			state = PRE_FLOP;
			buttonToUpdate.setText("Flop");
			break;
		case PRE_FLOP:
			dealFlop();
			state = FLOP;
			buttonToUpdate.setText("Turn");
			break;
		case FLOP:
			dealTurn();
			state = TURN;
			buttonToUpdate.setText("River");
			break;
		case TURN:
			dealRiver();
			state = RIVER;
			buttonToUpdate.setText("Restart");
			break;
		case RIVER:
			initializeGame();
			buttonToUpdate.setText("Deal");
			state = PRE_DEAL;
			break;
		default:
			throw new RuntimeException("Unknown state.");
		}
	}

	public void dealPlayerCards() {
		for (int i = 0; i < NUM_PLAYERS; i++) {
			players[i].setHand(deck.deal(CARDS_PER_PLAYER));
		}
	}

	public void dealFlop() {
		tableCards = deck.deal(3);
	}

	public void dealTurn() {
		Card[] turn = deck.deal(1);
		Card[] newTableCards = new Card[4];
		for (int i = 0; i < 3; i++) {
			newTableCards[i] = tableCards[i];
		}
		newTableCards[3] = turn[0];
		tableCards = newTableCards;
	}

	public void dealRiver() {
		Card[] river = deck.deal(1);
		Card[] newTableCards = new Card[5];
		for (int i = 0; i < 4; i++) {
			newTableCards[i] = tableCards[i];
		}
		newTableCards[4] = river[0];
		tableCards = newTableCards;
	}
}
