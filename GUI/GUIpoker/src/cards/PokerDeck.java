package cards;

import java.util.Random;

public class PokerDeck {
	private PokerCards[] singleCard;
	

	PokerDeck() {
		singleCard = new PokerCards[52];
		int cardNumber = 0;
		
		for(int iColor = 0; iColor < 4; iColor++) {
			for(int iFigure = 0; iFigure < 13; iFigure++) {
				singleCard[cardNumber] = new PokerCards(iColor, iFigure, cardNumber);
				cardNumber++;
			}
		}
	}
	public PokerCards getCard(int index) {
		return singleCard[index];
	}
	public int getCardColor(int index) {
		return singleCard[index].getCardColor();
	}
	public int getCardFigure(int index) {
		return singleCard[index].getCardFigure();
	}
	public int getCardOrder(int index) {
		return singleCard[index].getCardOrder();
	}
	public void setCardOrder(int index, int newCardOrder) {
		singleCard[index].setCardOrder(newCardOrder); 
	}
	
	public  void shuffleDeck() {
		int temp;
		Random generator = new Random();
		int rand;
		
		for(int i = 0; i < 52; i++) {
			rand = generator.nextInt(52);
			temp = this.getCardOrder(i);
			this.setCardOrder(i, this.getCardOrder(rand));
			this.setCardOrder(rand, temp);
		}
	}

}
