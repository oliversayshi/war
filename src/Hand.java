/**Oliver Shi
 * Adv. CSCI 3A
 * 9/11/17
 *Program Description:
 */
public class Hand {

	Card[] arr;
	int first = 0;
	int last = 0;
	int size = 0;
	
	public Hand(int length) {
		arr = new Card[length];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0 ? true: false;
	}
	
	public boolean isFull() {
		return size == arr.length ? true : false;
	}
	
	public void enqueue(Card x) {
		
		arr[last++] = x;
		size++;
		
		if (last == arr.length)
			last = 0;
		
	}

	public Card dequeue() {
		
		if (isEmpty())
			return Card.NONE;
		
		Card value = arr[first++];
		size--;
		
		if (first == arr.length) 
			first = 0;
		return value;
	}
	
	public Card peek() {
		return arr[first];
	}
	
	public void clear() {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Card.NONE;
		}
		first = 0;
		last = 0;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		String printout = "";
		
		for (int i = first; i != last ; i++) {
			if (i == arr.length) {
				i = 0;
			}
			
			printout += arr[i].value + "";
			
		}
		return printout;
		
	}
	
	
	
}
