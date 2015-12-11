package cards;

/**
 * 
 * @author 209058 
 *
 */
public class PokerCards {
	private int cardColor;
	private int cardFigure;
	private int cardOrder; // order in deck	
	
	PokerCards(int color, int figure, int order) {
		this.cardColor = color;
		this.cardFigure = figure;
		this.cardOrder = order;
	}
	PokerCards(int color, int figure) {
		this.cardColor = color;
		this.cardFigure = figure;
	}

	public void setCardColor(int newCardColor) {
		this.cardColor = newCardColor;
	}
	public int getCardColor() {
		return cardColor;
	}
	
	public void setCardFigure(int newCardFigure) {
		this.cardFigure = newCardFigure;
	}
	public int getCardFigure() {
		return cardFigure;
	}
	
	public void setCardOrder(int newCardOrder) {
		this.cardOrder = newCardOrder;
	}
	public int getCardOrder() {
		return cardOrder;
	}
	

}
