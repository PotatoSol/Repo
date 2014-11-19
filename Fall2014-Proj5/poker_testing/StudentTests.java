package poker_testing;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Card;
import poker.PokerHandEvaluator;


//Don't forget to import additional classes as needed...


public class StudentTests {

	/*
	@Test
	public void testExampleTest_SinglePairTest() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(1,1);
		testHand[1] = new Card(2,1);
		testHand[2] = new Card(3,1);
		testHand[3] = new Card(4,1);
		testHand[4] = new Card(5,1);
		assertFalse(PokerHandEvaluator.hasPair(testHand));
	}
	*/
	@Test
	public void testExampleTest_SinglePairTest() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(1,1);
		testHand[1] = new Card(2,1);
		testHand[2] = new Card(3,1);
		testHand[3] = new Card(4,1);
		testHand[4] = new Card(1,2);
		assertTrue(PokerHandEvaluator.hasPair(testHand)); 
	}
	@Test
	public void testExampleTest_TwoPairTest() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(1,1);
		testHand[1] = new Card(2,1);
		testHand[2] = new Card(2,2);
		testHand[3] = new Card(4,1);
		testHand[4] = new Card(1,2);
		assertTrue(PokerHandEvaluator.hasTwoPair(testHand)); 
	}
	@Test
	public void testExampleTest_ThreePairTest() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(1,1);
		testHand[1] = new Card(1,3);
		testHand[2] = new Card(3,1);
		testHand[3] = new Card(4,1);
		testHand[4] = new Card(1,2);
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(testHand)); 
	}
	@Test
	public void testExampleTest_RainbowTest() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(1,1);
		testHand[1] = new Card(2,2);
		testHand[2] = new Card(3,3);
		testHand[3] = new Card(4,0);
		testHand[4] = new Card(1,2);
		assertTrue(PokerHandEvaluator.hasRainbow(testHand)); 
	}
	@Test
	public void testExampleTest_OddStraightTest() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(1,1);
		testHand[1] = new Card(3,1);
		testHand[2] = new Card(5,1);
		testHand[3] = new Card(7,1);
		testHand[4] = new Card(9,2);
		assertTrue(PokerHandEvaluator.hasOddStraight(testHand)); 
	}
	@Test
	public void testExampleTest_EvenStraightTest() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(2,1);
		testHand[1] = new Card(4,1);
		testHand[2] = new Card(6,1);
		testHand[3] = new Card(8,1);
		testHand[4] = new Card(10,2);
		assertTrue(PokerHandEvaluator.hasEvenStraight(testHand)); 
	}
	@Test
	public void testExampleTest_FlushTest() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(1,1);
		testHand[1] = new Card(2,1);
		testHand[2] = new Card(3,1);
		testHand[3] = new Card(4,1);
		testHand[4] = new Card(1,2);
		assertTrue(PokerHandEvaluator.hasFlush(testHand)); 
	}
	@Test
	public void testExampleTest_FullHouseTest() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(1,1);
		testHand[1] = new Card(1,2);
		testHand[2] = new Card(3,0);
		testHand[3] = new Card(3,1);
		testHand[4] = new Card(3,2);
		assertTrue(PokerHandEvaluator.hasFullHouse(testHand)); 
	}
	@Test
	public void testExampleTest_FourOfAKindTest() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(1,1);
		testHand[1] = new Card(1,2);
		testHand[2] = new Card(1,3);
		testHand[3] = new Card(1,0);
		testHand[4] = new Card(2,2);
		assertTrue(PokerHandEvaluator.hasFourOfAKind(testHand)); 
	}
	@Test
	public void testExampleTest_StraightRainbowTest() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(1,1);
		testHand[1] = new Card(2,2);
		testHand[2] = new Card(3,3);
		testHand[3] = new Card(4,0);
		testHand[4] = new Card(5,2);
		assertTrue(PokerHandEvaluator.hasStraightRainbow(testHand)); 
	}
	@Test
	public void testExampleTest_SingleFlushTest() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(1,1);
		testHand[1] = new Card(2,1);
		testHand[2] = new Card(3,1);
		testHand[3] = new Card(4,1);
		testHand[4] = new Card(5,1);
		assertTrue(PokerHandEvaluator.hasStraightFlush(testHand)); 
	}
	
}
