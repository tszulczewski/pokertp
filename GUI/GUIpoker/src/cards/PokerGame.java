package cards;

public class PokerGame {
	private PokerDeck deck;
	private PokerPlayer[] player;
	private int cardsOut;
	private int numberOfPlayers;
	
	PokerGame(int numberOfPlayers) throws ToManyPlayersException {
		
		if(numberOfPlayers > 10 || numberOfPlayers < 2)
			throw new ToManyPlayersException();
		
		this.numberOfPlayers = numberOfPlayers;
		
		player = new PokerPlayer[numberOfPlayers];
		cardsOut = 0;
		deck = new PokerDeck();
		deck.shuffleDeck();
		
		this.handingOutCards();
		}
	
	public int getPlayerCard(int player, int card) {
		return this.player[player].getCard(card);
	}
	/*public void showCards(int player) {
		System.out.println( ValueOfCards.getCardColor(deck.getCardColor(this.player[player].getCard(0))) + " " 
	+ ValueOfCards.getCardFigure(deck.getCardFigure(this.player[player].getCard(0))) );

		System.out.println( ValueOfCards.getCardColor(deck.getCardColor(this.player[player].getCard(1))) + " " 
				+ ValueOfCards.getCardFigure(deck.getCardFigure(this.player[player].getCard(1))) );
	}
	*/
	
	public void handingOutCards () {
		
		for(int i = 0; i < this.numberOfPlayers; i++) {
			this.player[i] = new PokerPlayer(2);
			for(int k = 0; k < 2; k++) {
				this.player[i].setCard(k, this.deck.getCardOrder(this.cardsOut));
				this.cardsOut++;
			}
		}
	}
}
