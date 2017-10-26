
/**
 * Linked List class that will contain the operations of the Linked List, the methods include:
 * size, addNumber, addLinked, toString, add. multiply, and reverse.
 * @author Rafael Ninalaya
 * @param Node The node that points to the last 3 digits of the number
 * @param count An integer that keeps track of the length of the Linked List 
 */
public class LargeNumbers {
	 
	//one head Node and an Int count
	 private Node last;
	 private int count;
	 
	 //constructor
	 public LargeNumbers(){ last = null;}
	 
	 /**
		 * Size method
		 * returns the size of the Linked List
		 * @param none
		 * 
		 */
	 public int size(){
		 return count;
	 }

	 /**
		 * addNumber method
		 * Add a number of three digits to the list, starting from the back of the number
		 * and ending in the beginning of the number, increments the counter
		 * @param none
		 * 
		 */
	 public void addNumber(int x){
		Node n = new Node(x, null);
		n.setElement(x);
		n.setNext(last);
		last = n;
		count++;
	 }
	 
	 /**
		 * AddLinked method
		 * Take numbers in a String Array and add them into the LargeNumbers List, transforming the strings into
		 * integers in the process
		 * @param set Index of the array of the string
		 * @param str Array String from the text file
		 * @param ln LargeNumbers Linked list
		 * 
		 */
	 public void addLinked(String[] str, LargeNumbers ln) {
			
		int set;
		for (int i = 0; i < str.length; i++){
			set = Integer.parseInt(str[i]);//conversion to int
			ln.addNumber(set);
		}
	}
	 
	 /**
		 * toString method
		 * Return a String with the correct format of the number.
		 * @param reStr The String in correct format
		 * @param current The node that points to the Linked List
		 * 
		 */ 
	public String toString(){
		String retStr = new String();
		Node current = last;
		retStr +=  current.getElement() ;
		current = current.getNext();
		
		while (current != null){
		
		 //If the number is  more or equal than 100, the format is just a comma and the number 
		 if( current.getElement() >= 100){ 
			retStr += "," + current.getElement() ;
			}
		 //if the number is less than 10 the format is a comma, 00 and the number
		 else if (current.getElement() < 10){
			retStr += "," + "00" + current.getElement();
			}
		 //if th number is more or equal than 10 and less than 100, the format is comma, 0 and the number
		 else if (current.getElement() < 100 && current.getElement() >= 10 ){
			retStr += "," + "0" + current.getElement() ;
		 }
		 
		 //move the pointer to the next node
		 if (current != null)
			current = current.getNext();
		 }
		 return retStr;
	 }
	 
	/**
	 * add method
	 * Take two large Numbers and add them together, resulting in another large number
	 * @param N1,N2 The large numbers that we are going to add
	 * @param result The result of adding two large numbers 
	 * @param ln1,ln2 Nodes pointing to those large numbers
	 * @param sum The sum of digits of three
	 * @param carry The carry of adding two numbers and exceeding the format(0 or 1)
	 * 
	 */
	 public LargeNumbers add(LargeNumbers n1, LargeNumbers n2) {
			LargeNumbers result = new LargeNumbers();
			Node ln1 = n1.last;
			Node ln2 = n2.last;
			int sum = 0, carry = 0;
			
			//while the nodes pointing to the large numbers is not zero
			while( ln1 != null || ln2 != null){
				//if ln1 is null, we add zero to the sum of the three digits of the  
				//second number plus the carry
				if(ln1 == null){
					sum = 0 + ln2.getElement() + carry;
				}
				//if ln1 is null, we add zero to the sum of the three digits of the  
				//first number plus the carry
				else if(ln2 == null){
					sum = ln1.getElement() + 0 + carry;
				}
				//otherwise we add the three digits of the first number plus the second number
				//plus the carry
				else{
					sum = ln1.getElement() + ln2.getElement() + carry;
				}
				
				//if the sum is more than 1000, the carry is 1
				//otherwise it remains zero
				if(sum/1000 == 1)
					carry = 1;
				else
					carry =0;
				
				//add the number to the LargeNumbers list
				result.addNumber(sum%1000);
				
				//if ln1 or ln2 is not null, point to the next node
				//otherwise do nothing
				if(ln1 != null){
				ln1 = ln1.getNext();
				
				}
				if(ln2 != null){
				ln2 = ln2.getNext();
				}
				
			}
			return result;
		}
	 
	 /**
		 * multiply method
		 * Take two linked list and multiply them together, and putting that result into another linked list
		 * @param n1,n2 LargeNumbers list that we are gonna multiply 
		 * @param big,small Nodes that will determinate what number is bigger
		 * @param mul The multiplication of two numbers of three digits
		 * @param carry if the mul exceed 999, the reminder will be added to the next mul
		 * @param n Keeps track of the iterations
		 * @param bigger checks what number is bigger
		 */ 
	 public LargeNumbers multiply(LargeNumbers n1, LargeNumbers n2)  {
		LargeNumbers result = new LargeNumbers();
		Node big = null;
		Node small = null;
		int mul = 0,carry = 0;
		int n = 0;
		boolean bigger = false;
		
		//if n1 is bigger than n2, n1 goes to the node big and n2 to small
		//otherwise n2 goes to big, and n1 to small
		if (n1.count >= n2.count){
			big = n1.last;
			small = n2.last;
			bigger = true;
		}
		else{
			big = n2.last;
			small = n1.last;
		}
		
		//While small is not null
		while( small != null){
			//create a LargeNumber list to store the partial mul
			LargeNumbers partial = new LargeNumbers();
			
			//checks the iteration and determines how many 000 we add to the partial mul
			if(n!=0){
				int a = n;
				while(a > 0){
				partial.addNumber(0);
				a--;
				}
			}
			
			//while big is not null
			while( big != null){
				
				//store the multiplication to the variable 
				mul = small.getElement()*big.getElement() + carry;
				
				//if the number exceeds 999, stores the mod1000 to partial Linked List
				//and sets the carry to the coefficient of the division over 1000
				//otherwise just store the mul and sets the carry to 0
				if(mul >= 1000){
					partial.addNumber(mul%1000);
					carry = mul/1000;
				 }
				else{
					partial.addNumber(mul);
					carry = 0; 
				}
				big = big.getNext();
			}
			
			//if the carry is not zero in the last iteration
			//add the carry to the front of the list
			if (carry != 0 ){
				partial.addNumber(carry);
				carry = 0;
			}
			
			//if it is the first iteration of the small number
			//set the result to the partial multiplication linked list
			if (n == 0){
				result = partial;
				small = small.getNext();
			}
			//otherwise reverse the linked list
			//and use the method add to add the result linked list and the partial 
			//linked list with the shift amount
			else{
				result.reverse();
				partial.reverse();
				result = result.add(result, partial);
				small = small.getNext();
			}
			
			//if n1 is bigger than n2, set big to the node of n1
			if (bigger){
				big = n1.last;
			}
			//otherwise set big to n2
			else{
				big = n2.last;
			}
			//increment the counter of iterations
			n++;
		}
		return result;
		}
	 
	 /**
		 * reverse method
		 * Reverse the LargeNumber list.
		 * @param prev,next Node next and previous of the current node
		 * @param current Current node pointing to the list
		 * 
		 */ 
	 public void reverse() {
	        Node prev = null;
	        Node current = last;
	        Node next = null;
	        
	        //reversing iteration
	        while (current != null) {
	            next = current.getNext();
	            current.setNext(prev);
	            prev = current;
	            current = next;
	        }
	        //reversed LinkedList
	        last = prev;
	    }
}
	