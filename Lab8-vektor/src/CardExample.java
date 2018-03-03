public class CardExample {
	public static void main(String[] args) {
		CardDeck deck = new CardDeck();
//		while (deck.moreCards()) {
//			Card d = deck.getCard();
//			System.out.println(d);
//		}
		deck.shuffle();
		while (deck.moreCards()) {
			Card c = deck.getCard();
			System.out.println(c);
		}
	}
}
