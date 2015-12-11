package cards;

import java.util.Arrays;

public class PokerCheck {
	private PokerPlayer player;
	private static PokerCards[] cardsInGame;
	private int cardsFigures[];
	private int cardsColors[];
	private int highestCardSlot;
	private int firstHighestCard;
	private HandRanking rank;
	
	PokerCheck(PokerPlayer playerFromGame ) {
		this.player = playerFromGame;
	}
	
	public PokerCards[] getCards() {
		return cardsInGame;
	}
	
	public static boolean isNextInRow(int first, int next) {
		return (next == first+1);
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
		this.cardsColors = new int[7];
		// Getting players cards figure and color
		cardsFigures[0] = deck.getCardFigure(this.player.getCard(0));
		cardsColors[0] = deck.getCardColor(this.player.getCard(0));
		cardsFigures[1] = deck.getCardFigure(this.player.getCard(1));
		cardsColors[1] = deck.getCardColor(this.player.getCard(1));
		// Getting cards figure from game
		int k = 0;
		for(int i = 2; i < 7; i++) {
			cardsFigures[i] = cardsInGame[k].getCardFigure();
			cardsColors[i] = cardsInGame[k].getCardColor();
					k++;
		}		
		// Arrays.sort(cardsFigures); // sorting cards
	        for (int i = 0; i < 7; i++) {
	            for (int j = 0; j < 7 - 1; j++) {
	                if (cardsFigures[j] > cardsFigures[j + 1]) {
	                    int tempF,tempC;
	                    tempF = cardsFigures[j + 1];
	                    tempC = cardsColors[j + 1];
	                    cardsFigures[j + 1] = cardsFigures[j];
	                    cardsFigures[j] = tempF;
	                    cardsColors[j + 1] = cardsColors[j];
	                    cardsColors[j] = tempC;
	                }
	            }
	        }
	}
	public void showSorted() {
		for(int i =0; i < 7; i++) {
		System.out.println("f: " + this.cardsFigures[i]);
		System.out.println("c: " + this.cardsColors[i]);
		}
	}
	public void checkHandRanking() {
		if(this.isStraightFlush()) {
			for(int i = 0; i < 5; i++) {
				rank.setCardFigure(cardsFigures[highestCardSlot-i],
						i);
				rank.setCardColor(cardsColors[highestCardSlot-i],
						i);
				rank.setHandRanking(8);
			}
		}	
		else if(this.isFourOfaKind()) {
			for(int i = 0; i < 4; i++) {
				rank.setCardFigure(cardsFigures[highestCardSlot+i],
						i);
				rank.setCardColor(cardsColors[highestCardSlot+i],
						i);
				rank.setHandRanking(7);
			}
			rank.setCardFigure(cardsFigures[firstHighestCard], 5);
			rank.setCardColor(cardsFigures[firstHighestCard], 5);
		}	
		
	}
	public boolean isStraightFlush() {
		int k = 0;
		int straight = 0;
		boolean isStraight = false;
		if(cardsFigures[0] == 9) // for Jack there is no chance to straight Flush
			return false;
		
		while(k < 3){
			for(int i = k; i < k+4; i++){
				if(cardsColors[i] == cardsColors[i+1]
						&& isNextInRow(cardsFigures[i], cardsFigures[i+1]) )
					straight++;
				System.out.println(straight);
			}
			if(straight == 4) {
				this.highestCardSlot  = k+4; // set highest card 
				isStraight = true;
				straight = 0;
			}
			else
				straight = 0;
			k++;
		}
		return isStraight;
	}
	
	public boolean isFourOfaKind() {
		int four = 0;
		boolean isFour = false;
		
		for(int i = 0; i < 4; i++) {
			if( four == 3) {
				isFour = true;
				highestCardSlot = i-1;
			}
			four = 0;
			for(int k = 1; k < 7; k++) {
				if(cardsFigures[i] == cardsFigures[k])
					four++;
			}
		}
		return isFour;
	}
	
	public boolean isFullHouse() {
		boolean isThree = false;
		boolean isTwo = false;
		int three = 0, 
				//two = 0, 
				highThree = -1, howManyThree = 0;
		
		for(int i = 0; i < 6; i++) {
			if(three == 2) {
				isThree = true;
				howManyThree++;
				if(cardsFigures[i] > highThree) {
					highThree = cardsFigures[i];			
				}
				if(howManyThree == 2)
					isTwo = true;
			}
			else if(three == 1)
				isTwo = true;
			
			three = 0;
			//two = 0;
			for(int k = i+1 ; k < i+3; k++) {
				if(cardsFigures[i] == cardsFigures[k]) {
					three++;
					//two++;
				}
			}
			
		}
		return (isThree && isTwo);
	}

	public boolean isFlush() {
		int tempColor[] = new int[7];
		int k = 0;
		boolean isColor = false;
		tempColor = cardsColors;
		Arrays.sort(tempColor);
		
		int color = 0;
		while(k < 3) {
			for(int i = 1; i < 5; i++) {
				if(tempColor[k] == tempColor[i])
					color++;
			}
			if(color == 4)
				isColor = true;
			k++;
		}		
		return isColor;
	}
	
	public boolean isStraight() {
		if(cardsFigures[0] == 9) // for Jack there is no chance to straight Flush
			return false;
		int k = 0;
		int straight = 0;
		boolean isStraight = false;
				
		while(k < 3) {
			for(int i =k; i < k +4; i++) {
				if(isNextInRow(cardsFigures[i], cardsFigures[i+1]) )
					straight++;
				System.out.println(straight);
				
				if(straight == 4) {
					this.highestCardSlot  = k+4; // set highest card 
					isStraight = true;
					straight = 0;
				}
				else
					straight = 0;
				k++;
			}
		}
		return isStraight;
	}
	
	public boolean isThreeOfaKind() {
		boolean isThree = false;
		int three = 0;
		// TODO higher three
		for(int i = 0; i < 5; i++) {
			three =0;
			for(int k = i+1; k < i+3; k++ ) {
				if(cardsFigures[i] == cardsFigures[k])
					three++;
			}
			if(three == 2)
				isThree = true;
		}
		return isThree;
	}

	public boolean isTwoPair() {
		int two = 0;
		boolean isTwo = false;
		int higher = -1;
		for(int i = 0; i < 7; i++)
			if(cardsFigures[i] == cardsFigures[i+1]) {
				two++;
				if(cardsFigures[i] > higher)
					higher = cardsFigures[i];
			}
		if(two >= 2) {
			isTwo = true;
			this.firstHighestCard = higher;
		}
		return isTwo;
	}

	public boolean isOnePair() {
		boolean isOne = false;
		for(int i = 0; i < 7; i++) {
			if(cardsFigures[i] == cardsFigures[i+1])
				isOne = true;
		}
		return isOne;
	}
	
	public void setHighCard() {
		this.firstHighestCard = cardsFigures[6];
	}
}
