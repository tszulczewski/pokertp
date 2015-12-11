package cards;

public class HandRanking {
	private int handRanking;
	private PokerCards[] cards;
	
	HandRanking() {
		cards = new PokerCards[5];
	}
	
	public void setCardColor(int color, int cardNumber) {
		this.cards[cardNumber].setCardColor(color);
	}
	public void setCardFigure(int figure, int cardNumber) {
		this.cards[cardNumber].setCardFigure(figure);
	}
	public void setHandRanking(int ranking) {
		this.handRanking = ranking;
	}
	public int getHandRanking() {
		return handRanking;
	}
}
