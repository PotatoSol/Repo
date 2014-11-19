package poker;

public class Deck {

	public Card[] cards = new Card[52];

	public Deck() {
		int suit = 0;
		int value = 1;
		int counter = 0;
		while(suit < 4){
			while(value < 14){
				cards[counter] = new Card(value, suit);
				value++;
				counter++;
			}
			value = 1;
			suit++;
		}
		//throw new RuntimeException("Not yet implemented.");
	}

	public Deck(Deck other) {
		cards = new Card[other.getNumCards()];
		int counter = 0;
		while(counter < other.getNumCards()){
			cards[counter] = other.getCardAt(counter);
			counter++;
		}
		//throw new RuntimeException("Not yet implemented.");
	}

	public Card getCardAt(int position) { //not sure if this is correct because if asking for the top card you need to be sure you put in 0 not 1...
		Card cardAt = this.cards[position];
		return cardAt;
		//throw new RuntimeException("Not yet implemented.");
	}

	public int getNumCards() {
		return cards.length;
		
		//throw new RuntimeException("Not yet implemented.");
	}

	/* hint: odd and even */
	
	public void shuffle() {
		int size = getNumCards();
		int counter = 0;
		int half = size/2;
		Card[] firstHalf = new Card[half];
		Card[] secondHalf = new Card[size/2];
		if (size % 2 == 1){
			half++;
		}
		while(counter < half){
			firstHalf[counter] = cards[counter];
			counter++;
		}
		int tempCounter = 0;
		while(tempCounter < size/2){
			secondHalf[tempCounter] = cards[counter];
			tempCounter++;
			counter++;
		}
		int firstCounter = 0;
		int secondCounter = 0;
		int newCounter = 0;
		while (newCounter + 1 < size){
			if(newCounter % 2 == 0){
				cards[newCounter] = firstHalf[firstCounter];
				newCounter++;
				firstCounter++;
			}
			if(newCounter % 2 == 1){
				cards[newCounter] = secondHalf[secondCounter];
				newCounter++;
				secondCounter++;
				
			}
		}
	}	

	public void cut(int position) {
		Card[] topHalf = new Card[position];
		Card[] bottomHalf = new Card[cards.length-position];
		int counter = 0;
		int tempCounter = 0;
		while(counter < position){
			topHalf[tempCounter] = cards[counter];
			tempCounter++;
			counter++;
		}
		tempCounter = 0;
		while(counter < cards.length){
			bottomHalf[tempCounter] = cards[counter];
			tempCounter++;
			counter++;
		}
		Card[] cutDeck = new Card[cards.length];
		counter = 0;
		tempCounter = 0;
		while(counter < cards.length-position){
			cutDeck[counter] = bottomHalf[tempCounter];
			tempCounter++;
			counter++;
		}
		tempCounter = 0;
		while(counter < cards.length){
			cutDeck[counter] = topHalf[tempCounter];
			tempCounter++;
			counter++;
		}
		cards = cutDeck;
		//throw new RuntimeException("Not yet implemented.");
	}

	public Card[] deal(int numCards) {
		int length = cards.length;
		Card[] smaller = new Card[numCards];
		Card[] newDeck = new Card[length - numCards];
		int counter = 0;
		int bCounter = 0;
		while(counter < numCards){
			smaller[bCounter] = cards[counter];
			counter++;
			bCounter++;
		}

		bCounter = 0;
		while(counter +1< length){
			newDeck[bCounter] = cards[counter];
			counter++;
			bCounter++;
		}

		cards = newDeck;
		return smaller;
		//throw new RuntimeException("Not yet implemented.");
	}
 
}
