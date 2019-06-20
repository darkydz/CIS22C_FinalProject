package finalProject;

/**
 * Class to  List.java
 */
import java.util.NoSuchElementException;
import java.lang.NullPointerException;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.IndexOutOfBoundsException;
import java.util.*;


public class List <T extends Comparable<T>> {
    private class Node {
        private T data;
        private Node next;
        private Node prev;
        
        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    
    private int length;
    private Node first;
    private Node last;
    private Node iterator;
    
    /****CONSTRUCTOR****/
    
    /**
     * Instantiates a new List with default values
     * @postcondition  set up a constructor with defaults value
     */
    public List() {
    	first = last = iterator = null;
    	length = 0 ;
 
    }
    
    /**
     * Instantiates a new List by copying another List
     * @param original the List to make a copy of
     * @postcondition a new List object, which is an identical
     * but separate copy of the List original
     */
    public List(List<T> original) {
        if (original == null) {
            return;
        }
        if (original.length == 0) {
            length = 0;
            first = null;
            last = null;
            iterator = null;
        } else {
            Node temp = original.first;
            while (temp != null) {
                addLast(temp.data);
                temp = temp.next;
            }
            iterator = null;
        }
    }
    
    /****ACCESSORS****/
    
   
 	 /**
     * Returns the value stored in the first node
     * @precondition 
     * @return the integer value stored at node first
     * @throws NoSuchElementException when the precondition is violated
     */
       public T getFirst() throws NoSuchElementException{
           if (length == 0) {
               throw new NoSuchElementException("getFirst: List is Empty. No data to access!");
          }
           return first.data;
       }   
    
    /**
      * Returns the value stored in the last node
      * @precondition 
      * @return the integer value stored at node last
      * @throws NoSuchElementException when the precondition is violated
      */
     public T getLast() throws NoSuchElementException{
         if (length == 0) {
             throw new NoSuchElementException("getlast: List is Empty. No data to access!");
         }
         return last.data;
       }
    
    /**
     * Returns the current length of the list
     * @return the length of the list from 0 to n
     */
    public int getLength() {
        return length;
    }
    private int getLength(Node T) {
    	if(T == null) {
    		return 0;
    	} else {
    		return 1 + getLength(T.next);
    	}
    }
    
    /**
     * Returns the data stored in the node referenced by the iterator
     * @precondition iterator != null
     * @return the data stored at iterator node 
     * @throws NoSuchElementException when the precondition is violated
     */
       public T getIterator() throws NoSuchElementException{
           if (length == 0) {
               throw new NoSuchElementException("getIterator: List is Empty. No data to access!");
          }
           return iterator.data;
       }   
    
    /**
     * Returns whether the list is currently empty
     * @return whether the list is empty
     */
    public boolean isEmpty() {
    	return length == 0;
    }
    
    /**
     * returns whether the iterator is off the end of the list, i.e. is NULL
     * @return whether the iterator is null
     */
    public boolean offEnd() {
    	return iterator == null;
    }
    
    /**
     * overrides the equals method for object to compares this list to another list to see if they contain the same data in the same order.
     * @return whether the two lists are equal
     */
       @Override public boolean equals(Object o) {
           if (o == this) {
        	   return true;
           } else if(!(o instanceof List)){
        	   return false;
           } else {
        	   List L = (List) o;
        	   if (this.length != L.length) {
        		   return false;
        	   } else {
        		   Node temp1 = this.first;
        		   Node temp2 = L.first;
        		   while (temp1 != null) {
        			   if (!temp1.data.equals(temp2.data)) {
        				   return false;
        			   }
        			   temp1 = temp1.next;
        			   temp2 = temp2.next;
        		   }
        		   return true;
        	   }
           }
             
          }   
 
    /****MUTATORS****/
    
    /**
     * Creates a new first element
     * @param data the data to insert at the 
     * front of the list
     * @postcondition value is added to beginning of list
     */
    public void addFirst(T data) {
    	if (first == null) {
            first = last = iterator = new Node(data);
        } else {
            Node N = new Node(data);
            N.next = first;
            first.prev = N;
            first = N;
        }
        length++;
    }
    
    /**
     * Creates a new last element
     * @param data the data to insert at the 
     * end of the list
     * @postcondition   value is added to end of list
     */
    public void addLast(T data) {
    	if (isEmpty()) {// edge case
    		first = last = iterator = new Node(data);
    	} else {//general case
    		Node N = new Node(data);
    		last.next = N;
    		N.prev = last;
    		last = N;
    	}
    	length++; 
  	 }
    
    /**
    * removes the element at the front of the list
    * @precondition list is not empty
    * @postcondition remove first value from list
    * @throws NoSuchElementException when precondition is violated
    */
    public void removeFirst() throws NoSuchElementException{
  
    	   if (length == 0) {
    	        throw new NoSuchElementException("removeFirst(): Cannot remove from an empty List!");
    	    } else if (length == 1) {
    	        first = last = iterator = null;
         } else {
        	    if (iterator == first) {
        		 iterator = null;
              	 }
 	            first = first.next;
 	            first.prev = null;
 	            }
    	        length--;
    	       }
    
    /**
     * removes the element at the end of the list
     * @precondition list is not empty
     * @postcondition remove last value from list
     * @throws NoSuchElementException when precondition is violated
     */
    public void removeLast() throws NoSuchElementException{
    	 if (length == 0) {
             throw new NoSuchElementException("removeFirst(): Cannot remove from an empty List!");
    	 } else if (length == 1) {
    		 first = last = iterator = null;
        } else {
        	   if (iterator == last) {
       		     iterator = null;
             	 }
            Node temp = first;
            while (temp.next != last) {
                temp = temp.next;
            }
            last.prev.next = null;
            last = temp;
        }
        length--;
    }

    /**
     * moves the iterator to the start of the list
     * @precondition iterator = null
     * @throws NoSuchElementException when precondition is violated
     */
    public void placeIterator() throws NoSuchElementException {
    	if (iterator == null ) {// precondition 
            throw new NoSuchElementException("placeIterator(): Cannot place when there is empty list!");
    	}
    	else {
    		iterator = first;
    	}
    	
  	 }  
    
    /**
     * removes the node referenced by( pointed at ) by the iterator
     * @precondition iterator != null
     * @postcondition iterator = null;
     * @throws NullPointerException when precondition is violated
     */
    public void removeIterator() throws NullPointerException{
    	 if (iterator == null) {
             throw new NullPointerException("removeIterator(): Cannot remove when iterator is null!");
    	 } else if (iterator == first) {
    		 removeFirst();
        } else if (iterator == last) {
   		 removeLast();
        } else {
        	   iterator.prev.next = iterator.next;
        	   iterator.next.prev = iterator.prev;
               length--;
                }
    	 iterator = null;
    }
    
    
    /**
     * Inserts a new data after iterator
     * @param data the new data to insert
     * @precondition iterator != null
     * @postcondition  NullPointerException when precondition is violated
     */
    public void addIterator(T data) throws NullPointerException {
    	if (iterator == null) {// precondition 
            throw new NullPointerException("addIterator(): Cannot add when iterator is null!");
    	} else if (iterator == last) {//edge case
      		  addLast(data);
    	}else {//general case
    		Node N = new Node(data);
    		N.next = iterator.next;
    		N.prev = iterator;
    		iterator.next.prev = N;
    		iterator.next = N;
    		length++; 
    	}
    	
  	 }   
    	

       /**
        *  moves the iterator up by one node
        * @precondition iterator != null
        * @precondition length != 0
        * @throws NullPointerException when precondition is violated
        */
       public void advanceIterator() throws NullPointerException {
       	if (iterator == null) {// precondition 
               throw new NullPointerException("advanceIterator(): Cannot move up when iterator is null!");
       	}
       	else if (length == 0) {//precondition
       		throw new NullPointerException("advanceIterator(): Cannot move when up there is empty list!");
       	}else if (iterator == last) {//edge case
       		throw new NoSuchElementException("advanceIterator(): Cannot move when up iterator is the last!");
       	}
       		iterator = iterator.next;
       	
    	 }  
       
       
       
 
    /****ADDITIONAL OPERATIONS****/
    
    /**
     * List with each value on its own line
     * At the end of the List a new line
     * @return the List as a String for display
     */
    @Override public String toString() {
    	String result = "";
        Node temp = first;
        while(temp != null) {
            result +=temp.data + " ";
            temp= temp.next;
        }
        result += "\n";
        
        return result;
    }

    
    /**
     * prints the contents of the linked list to the screen
     *  in the format #. <element> followed by a newline
     *
     */
    public void printNumberedList(){
        Node temp = first;
        int index = 1;
        while(temp != null) {
        	System.out.println(index + ": " + temp.data);
        	temp = temp.next;
        	index++;
        }
    	
    }
    /**Additional Operations*/

    /**
     * Prints a linked list to the console
     * in reverse by calling the private 
     * recursive helper method printReverse
     */
    public void printReversed() {
    	printReversed(last);
    }
    
    /**
     * Recursively prints a linked list to the console
     * in reverse order from last to first (no loops)
     * Each element separated by a space
     * Should print a new line after all
     * elements have been displayed
     */    
    private void printReversed(Node node) {
    	if(node == null) {
    		System.out.print("\n");
    	} else {
    	System.out.print(node.data + " ");
    		printReversed(node.prev);
    	}
    }
    /**
     * Returns the index of the iterator
     * from 1 to n. Note that there is 
     * no index 0. Does not use recursion.
     * @precondition
     * @return the index of the iterator
     * @throws NullPointerException when
     * the precondition is violated
     */
	public int getIndex() throws NullPointerException {
		if (offEnd()) {
			throw new NullPointerException("getIndex(): iterator is null. Cannot " + "get the index of null pointer");
		} else {
		int index = 1;
		Node temp = first;
		while (temp != iterator) {
				temp = temp.next;
				index++;
			}
		return index;
		}
	}
	/**
     * Places the iterator at first
     * and then iteratively advances 
     * it to the specified index
     * no recursion
     * @param index the index where
     * the iterator should be placed
     * @precondition 1 <= index <= length
     * @throws IndexOutOfBoundsException
     * when precondition is violated
     */
    public void advanceToIndex(int index) throws IndexOutOfBoundsException{
    	if (index > length || index < 1) {
			throw new IndexOutOfBoundsException("advanceToIndex(): Index is out of bound. Cannot advance index");
		}

		placeIterator();
		int k = index;
		for (int i = 1; i < k; i++) {
			advanceIterator();
		}
    }
    
    /**
     *  moves the iterator down by one node
     * @precondition iterator != null
     * @precondition length != 0
     * @throws NullPointerException when precondition is violated
     */
    public void reverseIterator() throws NullPointerException {
    	if (offEnd()) {// precondition 
            throw new NullPointerException("reverseIterator(): Cannot moves down when iterator is null");
    	}
    	else if (length == 0) {//precondition
    		throw new NullPointerException("reverseIterator(): Cannot moves down when there is empty list");
    	}else if (iterator == first) {//edge case
    		throw new NoSuchElementException("reverseIterator(): Cannot moves down when iterator is the first!");
    	}
    		iterator = iterator.prev;
    	
 	 }  
    
    
    /**Accessory Methods*/      

    /**
     * Determines whether a List is sorted
     * by calling its recursive helper method
     * isSorted
     * Note: An empty List can be
     * considered to be (trivially) sorted
     * @return whether this List is sorted
     */
    public boolean isSorted() {
        return isSorted (first);
    }
    
    /**
     * Determines whether a List is 
     * sorted in ascending order recursively
     * @return whether this List is sorted
     */
    private boolean isSorted(Node node) {
        if (isEmpty()) {
     	    return true;
        } else if ( node == null || node.next == null) {
        	return true;	
        } else return  ((node.data).compareTo((node.next).data)<0) && isSorted(node.next);
    }
    
    /**
     * Uses the iterative linear search
     * algorithm to locate a specific
     * element in the list
     * @param element the value to search for
     * @return the location of value in the
     * List or -1 to indicate not found
     * Note that if the List is empty we will
     * consider the element to be not found
     * @postcondition: position of the iterator remains
     * unchanged!
     */
    public int linearSearch(T element) {
 	   if (isEmpty()) {
 		   return -1;
 	   } else {
 		  int iteratorIndex = getIndex();
 			for(int i = 1;i <= length; i++) {
 				advanceToIndex(i);
 				if(getIterator().compareTo(element) == 0) {
 					advanceToIndex(iteratorIndex);
 					return i;
 				}
 			}
 			advanceToIndex(iteratorIndex);
 		    return -1;
 	   }
    }
 	   
    /**
     * Returns the index from 1 to length
     * where value is located in the List
     * by calling the private helper method
     * binarySearch
     * @param value the value to search for
     * @return the index where value is 
     * stored from 1 to length, or -1 to
     * indicate not found
     * @precondition isSorted()
     * @postcondition the position of the
     * iterator must remain unchanged! 
     * @throws IllegalStateException when the
     * precondition is violated.
     */
    public int binarySearch(T value) throws IllegalStateException {
 	   if (!isSorted()) {
 		   throw new IllegalStateException ("binarySearch: cannot access when the list is not sorted yet!");
 	   } else {
 		   return binarySearch(1,length,value);
 	   }
 	   
    }
    
 
    private int binarySearch(int low, int high, T value) {
 	   if (high < low) {
 		   return -1;
 	   } else{
   		int iteratorIndex = getIndex();
   		int mid = low + (high - low) / 2;
   		advanceToIndex(mid);
   		if(getIterator().compareTo(value) == 0){
   			advanceToIndex(iteratorIndex);
   			return mid;
   		}else if(getIterator().compareTo(value) > 0){
   			advanceToIndex(iteratorIndex);
   			return binarySearch(low,mid - 1,value);
   		}else{
   			advanceToIndex(iteratorIndex);
   			return binarySearch(mid + 1,high,value);
			}
   	}
   }
}

