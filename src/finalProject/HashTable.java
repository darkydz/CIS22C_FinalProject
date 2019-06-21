package finalProject;

/**
 * HashTable.java
 * @author 
 * @author
 * CIS 22C, Lab 7
 */
import java.util.ArrayList;
import finalProject.List;
import java.util.NoSuchElementException;

public class HashTable<T extends Comparable<T>> {
    
    private int numElements;
    private ArrayList<List<T>> Table;

    /**
     * Constructor for the HashTable.java
     * class. Initializes the Table to
     * be sized according to value passed
     * in as a parameter
     * Inserts size empty Lists into the
     * table. Sets numElements to 0
     * @param size the table size
     */
    public HashTable(int size) {
    	Table = new ArrayList<List<T>>(size);
    	for(int i = 0; i < size; i++) {
    		Table.add(i, new List<T>());
    	}
    	numElements = 0;  
    }
       
    /**Accessors*/
    
    /**
     * returns the hash value in the Table
     * for a given Object 
     * @param t the Object
     * @return the index in the Table
     */
    private int hash(T t) {
    	int code = t.hashCode();
    	return code%Table.size();
    }
    
    /**
     * counts the number of elements at this index
     * @param index the index in the Table
     * @precondition 0 <=  index < Table.length
     * @return the count of elements at this index
     * @throws IndexOutOfBoundsException
     */
    public int countBucket(int index) throws IndexOutOfBoundsException{
    	 if(index < 0 || index > Table.size()) {
    	    	throw new IndexOutOfBoundsException("countBucket(): cannot count");
    	    }
    	    else {
    	    	return Table.get(index).getLength(); 
    	    }
    }
    
    /**
     * returns total number of elements in the Table
     * @return total number of elements
     */
    public int getNumElements() {
        return numElements;
    }
    
    /**
     * searches for a specified element in the Table
     * @param t the element to search for
     * @return the index in the Table (0 to Table.length - 1)
     * or -1 if t is not in the Table
     */
    public int search(T t) {
    	int bucket = hash(t);
    	int m = Table.get(bucket).linearSearch(t);
    	if(m != -1) {
       		return bucket;
       	}
    	else {
    		return -1;
    	}
    }
    
    public ArrayList<T> getAllElements() {
		ArrayList<T> all = new ArrayList<T>();
    	for (List<T> list : Table) {
    		System.out.println(list.getLength());
//    		list.printReversed();
    		int i = 0;
    		while (i < list.getLength()) {
    			System.out.println("count " + i);
    			all.add(list.getIterator());
    			list.advanceIterator();
    			i++;
    		}
		}
    	return all;
	}
     
    /**Manipulation Procedures*/
    
    /**
     * inserts a new element in the Table
     * calls the hash method to determine placement
     * @param t the element to insert
     */
    public void insert(T t) {    
    	int bucket = hash(t);
    	Table.get(bucket).addLast(t);
    	numElements++;
    }  
     
     
    /**
     * removes the element t from the Table
     * calls the hash method on the key to
     * determine correct placement
     * has no effect if t is not in
     * the Table
     * @param t the key to remove
     * @precondition t must be in the table
     * @throws NoSuchElementException when
     * the element is not in the table
     */
    public void remove(T t) throws NoSuchElementException{
    	int bucket = hash(t);
    	if(Table.get(bucket).isEmpty()) {
    		return;
    	}
    	if(search(t) != -1) {
    		Table.get(bucket).placeIterator();
    		for(int i = 0; i < Table.get(bucket).getLength(); i++) {
    			if(Table.get(bucket).getIterator().equals(t)) {
    				Table.get(bucket).removeIterator();
    				numElements--;
    			}
    			else {
    				Table.get(bucket).advanceIterator();
    			}
    		}
    	}
    	else {
    		return;
    	}
    }

    /**Additional Methods*/

    /**
     * Prints all the keys at a specified
     * bucket in the Table. Each element displayed
     * on its own line, with a blank line 
     * separating each element
     * Above the elements, prints the message
     * "Printing bucket #<bucket>:"
     * Note that there is no <> in the output
     * @param bucket the index in the Table
     * @throws IndexOutOfBoundsException
     */
    public void printBucket(int bucket) {
    	System.out.println("Printing bucket #" + bucket + ":\n");
    	if(Table.get(bucket).isEmpty()) {
    		return;
    	}
    	else {
    		Table.get(bucket).placeIterator();
    		for(int i = 0; i < Table.get(bucket).getLength(); i++) {
    			System.out.println(Table.get(bucket).getIterator());
    			Table.get(bucket).advanceIterator();
    			System.out.println();
    		}
    	}
    	}
    
        
    /**
     * Prints the first element at each bucket
     * along with a count of the total elements
     * with the message "+ <count> -1 more 
     * at this bucket." Each bucket separated
     * with to blank lines. When the bucket is 
     * empty, prints the message "This bucket
     * is empty." followed by two blank lines
     */
    public void printTable(){
    	for(int i = 0; i < Table.size(); i++) {
    		System.out.println("Bucket: " + i);
    		if(Table.get(i).isEmpty()) {
    			System.out.println("This bucket is empty.\n\n");
    		}
    		else {
    			System.out.println(Table.get(i).getFirst() + "\n+ " +
    				 (Table.get(i).getLength() - 1) + " more at this bucket\n\n");
    		}
    	}
     } 
    
    public void printNonEmptyBuckets() {
    	for(int i = 0; i < Table.size(); i++) {
    		if(!Table.get(i).isEmpty()) {
    			System.out.println(Table.get(i).getFirst());
    		}
    	}
	}
}