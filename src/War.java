/**Oliver Shi
 * 9-17-17
 */

import java.util.*;

import com.sun.glass.ui.SystemClipboard;

import java.io.*;

enum Card{
	NONE(-1),
	ACE(14),
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8),
	NINE(9),
	TEN(10),
	JACK(11),
	QUEEN(12),
	KING(13);
	
	int value;
	
	Card(int value) {
		this.value = value;
	}
	
	int value(){
		return value;
	}
	
}

public class War {

	public War() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Scanner reader = new Scanner(new File("war.dat"));
		
		for (;;) {
			
			Player p1 = new Player();
			Player p2 = new Player();
			
			String hand1 = reader.nextLine();
			String hand2 = reader.nextLine();
		
			
			Scanner handReader = new Scanner(hand1);
			
			while (handReader.hasNext()) {
				p1.addCard(War.getCardFromString(handReader.next()));
			}
			
			handReader = new Scanner(hand2);
			while (handReader.hasNext()) {
				p2.addCard(War.getCardFromString(handReader.next()));
			}
			
			System.out.println(p1.hand);
			System.out.println(p2.hand);
			
			int turn = 0;
			
			while (p1.hand.isEmpty() != true && p2.hand.isEmpty() != true && turn <= 100000) {
				
				turn++;
				Card card1 = p1.showTopCard();
				Card card2 = p2.showTopCard();
				
				
				Hand pile = new Hand(52);
				
				pile.enqueue(card1);
				pile.enqueue(card2);
				
				boolean winnerFound = false;
				
				while (winnerFound != true) {
					
					int winner = compareCards(card1, card2);
					
					if (winner == 1) {
						winnerFound = true;
						while (pile.isEmpty() != true)
							p1.addCard(pile.dequeue());
					} else if (winner == 2) {
						winnerFound = true;
						while (pile.isEmpty() != true)
							p2.addCard(pile.dequeue());
					} else if (winner == 0) {
						card1 = p1.showTopCard();
						card2 = p2.showTopCard();
						
						pile.enqueue(card1);
						pile.enqueue(card2);
					}
					
				}
				
				
			}
			System.out.println(turn);
			if (p1.hand.isEmpty() == true) {
				System.out.println("Player 2 Wins!");
			} else if (p2.hand.isEmpty() == true) {
				System.out.println("Player 1 Wins!");
			} else {
				System.out.println("Tie game stopped at 100000 plays.");
			}
			
			
		}
		
	}
	
	public static Card getCardFromString(String s) {
		s.toLowerCase();
		Card card;
		//System.out.print(s.charAt(0));
		switch (s.charAt(0)) {
		case 'a':
		case 'A':
			card = Card.ACE;
			break;
		case '2':
			card = Card.TWO;
			break;
		case '3':
			card = Card.THREE;
			break;
		case '4':
			card = Card.FOUR;
			break;
		case '5':
			card = Card.FIVE;
			break;
		case '6':
			card = Card.SIX;
			break;
		case '7':
			card = Card.SEVEN;
			break;
		case '8':
			card = Card.EIGHT;
			break;
		case '9':
			card = Card.NINE;
			break;
		case 't':
		case 'T':
			card = Card.TEN;
			break;
		case 'j':
		case 'J':
			card = Card.JACK;
			break;
		case 'q':
		case 'Q':
			card = Card.QUEEN;
			break;
		case 'k':
		case 'K':
			card = Card.KING;
			break;
		default:
			card = Card.NONE;
			break;
		}
		
		return card;
	}
	
	public static int compareCards(Card playerOneCard, Card playerTwoCard) {
		
		int winner = 0;
		
		if(playerOneCard.value > playerTwoCard.value){
			winner = 1;
		}else if(playerOneCard.value < playerTwoCard.value){
			winner = 2;
		}
		
		return winner;
		
	}

}
