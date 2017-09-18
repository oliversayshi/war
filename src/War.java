/**Oliver Shi
 * 9-17-17
 */

import java.util.*;

import com.sun.glass.ui.SystemClipboard;

import java.io.*;

enum Card{
	NONE(-1),
	ACE(12),
	TWO(0),
	THREE(1),
	FOUR(2),
	FIVE(3),
	SIX(4),
	SEVEN(5),
	EIGHT(6),
	NINE(7),
	TEN(8),
	JACK(9),
	QUEEN(10),
	KING(11);
	
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
			System.out.println(hand1);
			while (handReader.hasNext()) {
				
				p1.addCard(War.getCardFromString(handReader.next()));
				System.out.println(p1.showTopCard());
			}
			
			handReader = new Scanner(hand2);
			while (handReader.hasNext()) {
				p2.addCard(War.getCardFromString(handReader.next()));
			}
			
			int turn = 0;
			
			while (p1.hand.isEmpty() != true && p2.hand.isEmpty() != true && turn <= 100000) {
				turn++;
				
				Card card1 = p1.showTopCard();
				Card card2 = p2.showTopCard();
				
				//System.out.println(card1.value);
			//	System.out.println(card2.value);
				
				
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
			card = Card.ACE;
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
		
		if(playerOneCard.value > playerTwoCard.value)
			winner = 1;
		else if(playerOneCard.value < playerOneCard.value)
			winner = 2;
		
		return winner;
		
	}

}
