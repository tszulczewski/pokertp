package cards;


public abstract class ValueOfCards {
	private static String[] cardColors = {"Heart","Diamond", "Club", "Spade"};
	private static String[] cardFigures = {"2","3", "4", "5", "6", "7", "8", "9",
			"10", "Jack", "Queen", "King", "Ace"};

	public static String getCardColor(int index) {
		return cardColors[index];
	}
	
	public static String getCardFigure(int index) {
		return cardFigures[index];
	}

}