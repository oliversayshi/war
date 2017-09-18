/**Oliver Shi
 * 9-17-17
 */

import java.util.*;

public class Player {

	Hand hand = new Hand(52);
	
	public Player() {
		// TODO Auto-generated constructor stub
	}
	
	public Card showTopCard() {
		return hand.dequeue();
	}
	
	public void addCard(Card card) {
		hand.enqueue(card);
	}
	
	

}
