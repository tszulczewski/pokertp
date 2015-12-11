package cards;

import static org.junit.Assert.*;

import org.junit.Test;

public class PokerCheckTest {

	@Test
	public void test() {
		PokerPlayer player = new PokerPlayer(2);
		PokerDeck deck = new PokerDeck();
		
		player.setCard(0, 0);
		player.setCard(1, 1);
		
		PokerCards[] cards = new PokerCards[5];
		
		for(int i = 0; i < 5; i++){
			cards[i] = deck.getCard(i+7);
		}
		PokerCheck check = new PokerCheck(player);
		check.setCards(cards);
		
		check.sortingCards(deck);
		check.showSorted();
	
		
		if(check.isStraightFlush())
			System.out.println("Straight Flush");

	}


}
