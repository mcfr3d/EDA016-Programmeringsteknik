import java.util.Random;

public class CardDeck {
	private Card[] cards;
	private int current;
	private static Random rand = new Random();
	
	/** Skapar en kortlek. */
	public CardDeck() {
		cards = new Card[52];
		for (int suit = Card.SPADES; suit <= Card.CLUBS; suit++) {
			for (int i = 1; i <= 13; i++) {
				cards[current] = new Card(suit, i);
				current++;
			}
		}
		current = 0;
	}
	
	/** Blandar kortleken. */
	public void shuffle() {
		for (int i = 51; i > 0; i--) {
			int nbr = rand.nextInt(i + 1);
			Card temp = cards[i];
			Card temp2 = cards[nbr];
			cards[i] = temp2;
			cards[nbr] = temp;
			current = 0;
		}
	}
	
	/** Tar reda på om det finns fler kort i kortleken. */
	public boolean moreCards() {
		if (current < cards.length) {
			return true;
		} else {
			return false;
		}
	}
	
	/** Drar det översta kortet i leken. */
	public Card getCard() {
		Card topcard;
		if(moreCards()){
			topcard = cards[current];
			current++;
			return topcard;
		}
		else return null;
	}
}
