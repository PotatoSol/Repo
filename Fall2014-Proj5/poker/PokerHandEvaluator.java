package poker;

public class PokerHandEvaluator {
	//YOUR IMPLEMENTATION HERE
	//Any helpers must be private.
	//broken: oddStraight, StraightFlush, 
	public static boolean hasPair(Card[] cards) {
		int referenceCard = 0;
		int compareCard = 1;
		boolean isPair = false;
		while(referenceCard + 1< cards.length){
			while(compareCard < cards.length){
				if(cards[referenceCard].getValue() == cards[compareCard].getValue()){
					isPair = true;
				}
				compareCard++;
			}
			referenceCard++;
			compareCard = referenceCard + 1;
		}
		return isPair; //could I put "return false" here and "return true" where it says "isPair = true" and eliminate a variable?
	}
	
	public static boolean hasRainbow(Card[] cards) {
		int checkCard = 1;
		boolean heart = false;
		boolean spade = false;
		boolean diamond = false;
		boolean club = false;
		while(checkCard < cards.length ){
			if (cards[checkCard].getSuit() == 0){
				spade = true;
			}
			if (cards[checkCard].getSuit() == 1){
				heart = true;
			}
			if (cards[checkCard].getSuit() == 2){
				club = true;
			}
			if (cards[checkCard].getSuit() == 3){
				diamond = true;
			}
			checkCard++;			
		}
		if (heart == true && spade == true && diamond == true && club == true){
			return true;
		}
		else return false;
		//throw new RuntimeException("NOT YET IMPLEMENTED");
	}
	
	public static boolean hasTwoPair(Card[] cards) { 
		int referenceCard = 0;
		int compareCard = 1;
		int isPair = 0;
		while(referenceCard + 1< cards.length){
			while(compareCard < cards.length){
				if(cards[referenceCard].getValue() == cards[compareCard].getValue()){
					isPair++;
				}
				compareCard++;
			}
			referenceCard++;
			compareCard = referenceCard + 1;
		}
		if (isPair > 1){
			return true; 
		}else return false;
	}
	
	public static boolean hasThreeOfAKind(Card[] cards) {
		int referenceCard = 0;
		int compareCard = 1;
		boolean isTwoPair = true;
		int isPair = 0;
		while (referenceCard + 1 < cards.length){
			while (compareCard < cards.length){
				if (cards[referenceCard].getValue() == cards[compareCard].getValue()){
					if(isTwoPair == false && isPair == 0){
						isTwoPair = true;
					} else if (isTwoPair == true && isPair == 0){
						isPair++;
					} else return false;
				}
			}
		}
		if (isPair == 1){
			return true;
		} else return false;
		
		
		//throw new RuntimeException("NOT YET IMPLEMENTED");
	}
	
	public static boolean hasOddStraight(Card [] cards) {
		int lowestValue;
		lowestValue = cards[0].getValue();
		int counter = 0;
		boolean checkTwo = false, checkThree = false, checkFour = false, checkFive = false;
		while(counter +1 < cards.length){ //determines the lowest card value
			if (cards[counter].getValue() > cards[counter+1].getValue()){
				lowestValue = cards[counter+1].getValue();
			}
			counter++;
		}
		int valueTwo = lowestValue + 2; //setting up checks to see if it is a valid oddStraight
		int valueThree = lowestValue + 4;
		int valueFour = lowestValue + 6;  //reminder to self to account for aces
		int valueFive = lowestValue + 8;  //Don't have to account for ace --- ace-high is 14 but since this is a oddStraight, ace can only be valid if it is 0
		if(lowestValue % 2 == 1){ //checks to see if the lowest value is odd
			return false;
		} 
		counter = 0;
		while(counter + 1< cards.length){
			if(cards[counter].getValue() == valueTwo){
				checkTwo = true;
			}
			if(cards[counter].getValue() == valueThree){
				checkThree = true;
			}
			if(cards[counter].getValue() == valueFour){
				checkFour = true;
			}
			if(cards[counter].getValue() == valueFive){
				checkFive = true;
			}
			counter++;
		}
		
		if (checkTwo == true && checkThree == true && checkFour == true && checkFive == true){
			return true;
		}else return false;
		
		//throw new RuntimeException("NOT YET IMPLEMENTED");
	}
	
	public static boolean hasEvenStraight(Card [] cards) {	
		int lowestValue;
		lowestValue = cards[0].getValue();
		int counter = 0;
		boolean checkTwo = false, checkThree = false, checkFour = false, checkFive = false;
		while(counter +1 < cards.length){ //determines the lowest card value
			if (cards[counter].getValue() > cards[counter+1].getValue() && cards[counter].getValue() != 1){
				lowestValue = cards[counter+1].getValue();
			}
			counter++;
		}
		int valueTwo = lowestValue + 2; //setting up checks to see if it is a valid evenStraight
		int valueThree = lowestValue + 4;
		int valueFour = lowestValue + 6; 
		int valueFive = lowestValue + 8; 
		if(lowestValue % 2 == 0){ //checks to see if the lowest value is even
			return false;
		} 
		counter = 0;
		while(counter +1 < cards.length){
			if(cards[counter].getValue() == valueTwo){
				checkTwo = true;
			}
			if(cards[counter].getValue() == valueThree){
				checkThree = true;
			}
			if(cards[counter].getValue() == valueFour){
				checkFour = true;
			}
			if(cards[counter].getValue() == valueFive){
				checkFive = true;
			}
			if(cards[counter].getValue() == 1 && lowestValue == 6){ //so that if ace is high it works
				checkFive = true;
			}
			counter++;
		}
		
		if (checkTwo == true && checkThree == true && checkFour == true && checkFive == true){
			return true;
		}else return false;
		//throw new RuntimeException("NOT YET IMPLEMENTED");
	}
	
	public static boolean hasFlush(Card[] cards) {
		int suit = cards[0].getSuit();
		if (cards[1].getSuit() == suit && suit == cards[2].getSuit() && suit == cards[3].getSuit() && suit == cards[4].getSuit()){
			return true;
		} else return false;
		
		//throw new RuntimeException("NOT YET IMPLEMENTED");
	}
	
	public static boolean hasFullHouse(Card[] cards) {
		if (hasTwoPair(cards) == true && hasThreeOfAKind(cards) == true){
			return true;
		} else return false;
		//throw new RuntimeException("NOT YET IMPLEMENTED");
	}
	
	public static boolean hasFourOfAKind(Card[] cards) {
		int errors = 0; //because all but one are going to be equal if they're are 4 of a kind, this int checks to see if there is exactly 1 that isn't similar
		int counter = 0;
		while (errors < 2 || counter + 1 < cards.length){
			if(cards[counter].getValue() != cards[counter+1].getValue()){
				errors++;
				counter++; //if the non-similar card is in the middle of the array, it'll be tested against other cards twice unless counter is incremented again
			}
			counter++;
		}
		if (errors == 1){ //there should be exactly 1 card that is dissimilar to the others
			return true; 
		}else return false;
		//throw new RuntimeException("NOT YET IMPLEMENTED");
	}
	
	public static boolean hasStraightRainbow(Card[] cards) {
		if (hasOddStraight(cards) == true && hasRainbow(cards)){
			return true;
		} else if (hasEvenStraight(cards) == true && hasRainbow(cards)){
			return true;
		} else return false;
		//throw new RuntimeException("NOT YET IMPLEMENTED");
	}
	
	public static boolean hasStraightFlush(Card[] cards) {
		if (hasOddStraight(cards) == true && hasFlush(cards)){
			return true;
		} else if (hasEvenStraight(cards) == true && hasFlush(cards)){
			return true;
		} else return false;
		//throw new RuntimeException("NOT YET IMPLEMENTED");
	}
}

