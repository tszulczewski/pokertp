package cards;

import static org.junit.Assert.*;

import org.junit.Test;

public class PokerGameTest {

	@Test
	public void test() throws ToManyPlayersException {
		try {
		PokerGame game = new PokerGame(3);
		
		}catch(ToManyPlayersException e) {
			System.out.println("Cant create game!");
		}
		
	}
	/*@Test
	public void showCard() {
		try {
			PokerGame game = new PokerGame(4);
			game.showCards(0);
			game.showCards(1);
			game.showCards(2);
			game.showCards(3);
			}catch(ToManyPlayersException e) {
				System.out.println("Cant create game!");
			}
		
	}*/

}
