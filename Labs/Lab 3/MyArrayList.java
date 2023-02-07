
import java.util.Arrays;
import java.util.AbstractList;

/**
 * This class implements some of the methods of the Java
 *  ArrayList class.
 * 
 *  
 */
public class MyArrayList<E>  extends AbstractList<E>
{
    // Data Fields
    /** The default initial capacity */
    private static final int INITIAL_CAPACITY = 10;
    /** The underlying data array */				
    private E[] theData;
    /** The current size */
    private int size = 0;
    /** The current capacity */
    private int capacity = 0;

    /**
     * Construct an empty ArrayList with the default
     * initial capacity
     */
    public MyArrayList() {
        capacity = INITIAL_CAPACITY;
        theData = (E[]) new Object[capacity];
    }

    
    /**
     * Add an entry to the end of the list
     * @param anEntry - The anEntry to be inserted
     * @return true/false - if the entry is inserted successfully at the end
     */
    public boolean add(E anEntry) {
        if (size == capacity) {
            reallocate();
        }
        theData[size] = anEntry;
        size++;
        return true;
    }

    /**
     * Get a value in the array based on its index.
     * @param index - The index of the item desired
     * @return The contents of the array at that index
     * @throws ArrayIndexOutOfBoundsException - if the index
     *         is negative or if it is greater than or equal to the
     *         current size
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return theData[index];
    }

    /**
     * Set the value in the array based on its index.
     * @param index - The index of the item desired
     * @param newValue - The new value to store at this position
     * @return The old value at this position
     * @throws ArrayIndexOutOfBoundsException - if the index
     *         is negative or if it is greater than or equal to the
     *         current size
     * @throws NullPointerException - if newValue is null       
     */
    public E set(int index, E newValue) {
        if (index < 0 || index >= capacity) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        
        if(newValue == null)
        	throw new NullPointerException();
        
        E oldValue = theData[index];
        theData[index] = newValue;
        return oldValue;
    }
    
    /**
     * Get the current size of the array
     * @return The current size of the array
     */
    public int size() {
        return size;
    }
    
    /**
     * Returns the index of the first occurence of the specified element
     * in this list, or -1 if this list does not contain the element
     * @param item The object to search for
     * @returns The index of the first occurence of the specified item
     *          or -1 if this list does not contain the element
     */
    public int indexOf(Object item) {
        for (int i = 0; i < size; i++) {
            if (theData[i] == null && item == null) {
                return i;
            }
            if (theData[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }   


    /**
     * Allocate a new array to hold the directory
     * 
     */
    private void reallocate() {
        capacity = 2 * capacity;
        theData = Arrays.copyOf(theData, capacity);
    }
    
    
    /*
     *  ================================   The following functions need to be filled ===================================================
     *    
     */
   

   /**
     * Add an entry to the data inserting it at the specified index.
     * @param index - The index of the time that the new
     *        value it to be inserted           
     * @param newValue - The value to be inserted
     * @throws ArrayIndexOUtOfBoundsException if index is
     *         less than zero or greater than size
     *         
     */
    public void add(int index, E newValue) {    		
    	// if index exists outside the boundaries of array
    	if (index < 0 || index > size) {
    		throw new ArrayIndexOutOfBoundsException();
    	}
        
    	// if new value is null, pointer will reference something that does not exist  	
    	if(newValue == null) {
    		throw new NullPointerException();
    	}
    	
    	// shift all elements after the insertion over
    	for(int i = size - 1; i >= index; i--) {
    		set(i + 1, theData[i]);
    	}
    	
    	// The index specified for insertion will now have the same value as the index+ 1 value
    	// so, set the index equal to the value to be inserted
    	set(index, newValue);
    	// increment size by 1
    	size++;
    	
    }    /**
     * Remove an entry based on its index
     * @param index - The index of the entry to be removed
     * @return The Item removed
     * @throws ArrayIndexOutOfBoundsException - if the index
     *         is negative or if it is greater than or equal to the
     *         current size
     */
    public E remove(int index) {
    	// create new generic variable to store the element to be removed and returned
    	E ret = theData[index];
    	
    	// loop moves pointer through array setting the value of each index to that of the one immediately to the right
    	// basically shifts all elements after removal down 1 index to fill gap
    	for(int i = index; i < size; i++) {
        	theData[i] = theData[i + 1];
        }
    	
    	// decrease size by 1
    	size--;
    	//return the element removed from the array
        return ret;  
    }

    
    /**
     * Count the total number of elements equals to elem
     * @param theValue - the compared element
     * @return the total number of replicas or -1 if not found in the list    
     */
    public int countApperance(E theValue)
    {
    	// counter will keep track of how many times the target value occurs in array
    	int count = 0;
    	
    	//loop through array, if value matches target, increment the count variable  	
    	for(int i = 0; i < size; i++) {
    		if(theData[i] == theValue)
    			count += 1;
    	}
    	// return count, the number of times an element occurs in the array;
    	return count;	
    }
    
    /**
     * Remove all the duplicated elements equals to theValue
     * @param theValue - the duplicated element to be removed     * 
     */
    public void removeDuplicate(E theValue)
    {    	
    	// count will be used to mark if an element is a repeat
    	int count = 0;
    	
    	// loop through array. if element is a repeat, increment counter
    	for(int i = 0; i < size; i++) {
    		if(theData[i] == theValue) {
    			count += 1;
    		
    			// if there are two of the same element, remove the value at the current index
    			// set counter back to 1, and proceed 
    			if(count == 2) {
    				remove(i);
    				count = 1;
    			}
    		}
    	}
    	
    }
       
    
 }
