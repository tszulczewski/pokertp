package cards;

import java.util.Arrays;

public class PokerCheck {
	private PokerPlayer player;
	private static PokerCards[] cardsInGame;
	private int cardsFigures[];
	
	PokerCheck(PokerPlayer playerFromGame ) {
		
	}
	
	public PokerCards[] getCards() {
		return cardsInGame;
	}
	public void setCards(PokerCards[] cardsFromGame) {
		cardsInGame = new PokerCards[5];
		for(int i = 0; i < 5; i++) 
			cardsInGame[i] = cardsFromGame[i];
	}
	
	public PokerPlayer getPlayer() {
		return player;
	}
	public void setPlayer(PokerPlayer newPlayer) {
		player = newPlayer;
	}
	
	public void sortingCards(PokerDeck deck) {
		this.cardsFigures = new int[7];
		// Getting players cards figure
		cardsFigures[0] = deck.getCardFigure(this.player.getCard(0));
		cardsFigures[1] = deck.getCardFigure(this.player.getCard(1));
		// Getting cards figure from game
		int k = 0;
		for(int i = 2; i < 7; i++) {
			cardsFigures[i] = cardsInGame[k].getCardFigure();
					k++;
		}		
		Arrays.sort(cardsFigures); // sorting cards
		
	}
	

}
