/***************************************************************************
 * A Linked List class with a private static inner Node class.
 *
 *****************************************************************************/

import java.util.*;

public class MySingleLinkedList<E>
{ 
   private Node<E> head;

  /**
   *  Constructs an empty list
   */
   public MySingleLinkedList()
   {
      head = null;
   }
   
  /**
   *  Returns true if the list is empty
   *  @return true/false - empty/not empty
   */
   public boolean isEmpty()
   {
      return head == null;
   }
   
  /**
   *  Inserts a new node at the beginning of this list.
   *  @param item - element to add
   *
   */
   public void addFirst(E item)
   {
      head = new Node<E>(item, head);
   }
   
  /**
  *  Returns the first element in the list.
  *  @return the head of the list
  *  @exception NoSuchElementException if an empty list
  */
   public E getFirst()
   {
      if(head == null) throw new NoSuchElementException();

      return head.data;
   }
   
  /**
   *  Removes the first element in the list.
   *  @return head of the list
   *
   */
   public E removeFirst()
   {
      E tmp = getFirst();
      head = head.next;
      return tmp;
   }
   
  /**
   *  Inserts a new node to the end of this list.
   *  @param item - the element to add at the end of list
   */
   public void addLast(E item)
   {
      if( head == null)
         addFirst(item);
      else
      {
         Node<E> tmp = head;
         while(tmp.next != null) tmp = tmp.next;

         tmp.next = new Node<E>(item, null);
      }
   }
   
   /**
    *  Removes all nodes from the list.
    *
    */
    public void clear()
    {
       head = null;
    }
    
    /**
     *  Inserts a new node after the first appearance of the node containing the key
     *  @param key - the data of existing node included in the list 
     *  @param toInsert - the data of the new node to be inserted 
     */
     public void insertAfter(E key, E toInsert)
     {
        Node<E> tmp = head;

        while(tmp != null && !tmp.data.equals(key)) 
      	  tmp = tmp.next;

        if(tmp != null)
           tmp.next = new Node<E>(toInsert, tmp.next);
     }
    

/*
 *  ================================   The following functions need to be filled ===================================================
 *  
 */   
     
 /**
   *  Returns the last element in the list.
   *  @return  last element in the list
 * @throws Exception 
   *  @throws  NoSuchElementException if the list is empty
   */
     public E getLast()
     {
/**
 * This if statement checks whether the head node is null. If it is, the method throws
 *  a NoSuchElementException, indicating that the list is empty and there is no last element. 
 */
    	 if(head == null) 
    		 throw new NoSuchElementException();
/**
 *  If the head node is not null, initialize a temporary node temp to head, 
 *  representing the first node in the list. The while loop then iterates through the 
 *  linked list, continuing as long as temp.next is not null (i.meaning there are still nodes 
 *  to check). Inside the loop, temp is updated to point to the next node in the list.
 */
    	 MySingleLinkedList.Node<E> temp = head;
    	 
    	 while(temp.next != null) {
    		 temp = temp.next;
    	 }
/**
 * When the loop exits, temp is pointing to the last node in the list.
 * The data field of this element is returned as required by the method
 */	   
    	 return temp.data;  //remove this line after your implementation
     }

 /**
   *  Returns true if this list contains the specified element.
   *  @param item - element to be checked
   *  @return True - if contained; otherwise False 
   */
     public boolean contains(E item)
     {
/**
 * Just like the previous method, I initialize a temporary node temp to head, 
 * representing the first node in the list. The while loop then iterates through 
 * the linked list, continuing as long as temp.next is not null and the data field 
 * of the temp node is not equal to the item that is being searched for. If temp.next is 
 * null, the loop exits and the method returns false. If the loop finds a node whose 
 * data field is equal to the item, the method returns true. If the loop exits without 
 * finding such a node, the method returns false.
 */
    	 MySingleLinkedList.Node<E> temp = head;
		
    	 while(temp.next != null && temp.data != item) {
    		 temp = temp.next;
    	 }
	   	
    	 if(temp.data == item)
    		 return true;
    	 else
    		 return false;
     }
   
 /**
   *  Returns the data at the specified position in the list.
   *  @param  the position index
   *  @return  the data contained at the given position index
   *  @throws  IndexOutOfBoundsException if pos is larger than the size of list
   *
   */
     public E get(int pos)
     {
/**
 * The first if-statement checks if pos is negative. If pos is negative, the method throws 
 * an IndexOutOfBoundsException, as there is no element in the list at a negative position.
 */
    	 if (pos < 0) 
    		 throw new IndexOutOfBoundsException();
 /**
* If pos is non-negative, the method initializes two variables: index and current. index 
* is set to 0, representing the position of the first element in the list. current is set 
* to head, representing the first element in the list.
*/	       
    	 int index = 0;
    	 Node<E> current = head;
 /**
  * The method then enters a while loop that iterates through the linked list. The loop continues 
  * as long as current is not null and the value of index is less than pos. Inside the loop, the 
  * current node is set to the next node in the list, and index is incremented by 1.
  */
    	 while (current != null && index < pos) {
    		 current = current.next;
    		 index++;
    	 }
/**
 * When the loop exits, current is either pointing to the node at position pos, or it is null, 
 * meaning there is no element in the list at position pos. If current is null, the method 
 * throws an IndexOutOfBoundsException, as there is no element in the list at position pos.
 * If current is not null, the method returns the data field of current, which is the 
 * element at position pos.
 */
    	 if (current == null) 
    		 throw new IndexOutOfBoundsException();
	       
    	 return current.data;
     }
	  
   /**
   *  Inserts a new node before the first appearance of the node containing the key.
   *  @param key  the data of existing node included in the list 
   *  @param toInsert  the data of the new node to be inserted 
   */
   public void insertBefore(E key, E toInsert) 
   {
/**
 * The first if statement checks if the head is null, meaning the list is empty. In this case I  throw 
 * a NoSuchElementException, as there is no node in the list with the value key to insert before.
 */
	      if (head == null) {
	         throw new NoSuchElementException();
	      }
/**
 * If head contains the value key, then the toInsert node is added to the beginning of the list 
 * using the addFirst method. After adding toInsert, the method immediately returns.
 */
	      if (head.data.equals(key)) {
	         addFirst(toInsert);
	         return;
	      }
/**
 * If head does not contain the value key, the method creates two Node objects: prev and current. 
 * prev is initialized to null, and current is initialized to the head of the list.
 */
	      Node<E> prev = null;
	      Node<E> current = head;
/**
 * The while loop iterates through the linked list. The loop continues as 
 * long as current is not null and the data field of the current node is not equal to the key value. 
 * Inside the loop, the prev node is set to current, and current is set to the next node in the list.
 */
	      while (current != null && !current.data.equals(key)) {
	         prev = current;
	         current = current.next;
	      }
/**
 * When the loop exits, current is either pointing to a node with the value of key, or it is null, meaning 
 * there is no such node in the list. If current is null, the method throws a NoSuchElementException, as 
 * there is no node in the list with the value of key.
 * 
 * If current is not null, the method creates a new node called newNode, which has its data field set to 
 * toInsert and its next field set to current.
 */
	      if (current == null) {
	         throw new NoSuchElementException();
	      }
/**
 * Finally, the method sets the next field of prev to point to newNode, effectively 
 * inserting newNode into the list before the node with the value of key.
 */
	      Node<E> newNode = new Node<E>(toInsert, current);
	      prev.next = newNode;
	   }
   
   
   
   /***************************   Extra Credit Exercises *****************************************/ 
   
   /***** This is for  Extra Credit (5 points) *********************  
 /**
   *  Removes the first occurrence of the specified element in this list.
   *  @param key - the element to be removed
   *
   */
   public void remove(E key) 
   {
/**
 * First, lets initialize two node objects temp and prev to the head of the linked list. 
 * The node temp is used to traverse the linked list and find the node that contains the key to be 
 * removed, while prev keeps track of the previous node.
 */
	   MySingleLinkedList.Node<E> temp = head;
	   MySingleLinkedList.Node<E> prev = head;
/**
 * The while loop checks if temp has not reached the end of the linked list 
 * and whether the data in the current node is not equal to the key that needs to be removed. If both 
 * conditions are true, the method updates prev to point to temp and then moves temp to the next node.
 */
	   while(temp.next != null && temp.data != key) {
		   prev = temp;
		   temp = temp.next;	   		
	   }
/**
 * Once the loop exits, temp will either be pointing to the node that contains the key to be removed, 
 * or it will be pointing to the end of the linked list. In the former case, the method updates the 
 * next field of prev to point to the node that comes after temp, effectively removing temp from the linked 
 * list. 
 * If temp is pointing to the end of the linked list and no node containing the key is found, the 
 * method throws an IndexOutOfBoundsException.
 */
	   if(temp.data == key) {
		   prev.next = temp.next;
	   }
	   else
		   throw new IndexOutOfBoundsException();    
   }
 
   /***** This is for  Extra Credit (5 points) *********************  
 /**
   *  Reverses the list: A->B->C to C->B->A
   *  @return the new head
   */
   
   public Node<E> reverse() 
   {
/**
 * The if statement ensures that the list contains at least two elements. If the list has less than
 * two elements the method will return the head of the list, as the reverse order of one element is
 * the element itself
 */
	   if(head.next != null) {
/**
 * This method effectively reverses the list using three temporary Node objects (pointers), prev, curr, 
 * and next, to traverse the list and reverse the object references (also pointers) to each element. 
 * The process starts with prev and next being initialized to null, and curr holding a reference, 
 * or pointing to the first element in the list (head).
 * 
 * In the diagram below, arrows pointing down show which nodes share a direct reference, and sideways 
 * arrows show which node is referenced in a node`s "next" variable.
 * Here, curr has a "down" arrow to A, so curr = A. A has a sideways arrow to B, so A.next = B
   +---+--+        +---+--+          +---+--+ 
   | prev |        | curr |          |  next|    
   +---+--+        +---+--+          +---+--+   
      |                |                          
      |                v                          
      v           +---+---+          +---+---+ 
     null         |   A   |------->  |   B   |------->
                  +---+---+          +---+---+  
 */
		   Node<E> prev = null;
		   Node<E> curr = head;
		   Node<E> next = null;
	        
/**
 * The while loop continues until curr is null, meaning it has traversed to the end of the list. 
 * Within the loop, 
 *   - the next pointer is set to the next node in the list 
 *   - the curr node's next pointer is set to the prev node, reversing that link of the list 
 *   - then the prev node is set to the curr node  
 *   - the curr node is set to the next node, incrementing the pointers one element further into the list
 *   This process effectively reverses the direction of the linked list.
 *   
 *   Step 1:
 * +---+--+       +---+--+          +---+--+ 
   | prev |        | curr |          |  next|    
   +---+--+        +---+--+          +---+--+   
      |                |                 |         
      |                v                 v         
      v            +---+---+          +---+---+          +---+---+
     null          |   A   |------->  |   B   |------->  |   C   |
                   +---+---+          +---+---+          +---+---+
  * 
  * Step 2:  
   +---+--+        +---+--+          +---+--+ 
   | prev |        | curr |          |  next|    
   +---+--+        +---+--+          +---+--+   
      |                |                 |         
      |                v                 v         
      v            +---+---+         +---+---+          +---+---+ 
     null  <-------|   A   |          |   B   |------->  |   C   |
                   +---+---+          +---+---+          +---+---+
 *
 * * 
  * Step 3:  
            +---+--+   +---+--+        +---+--+ 
            | prev | = | curr |        |  next|    
            +---+--+   +---+--+        +---+--+   
      |            |       |              |         
                   v       v              v         
                   +---+---+          +---+---+          +---+---+ 
     null  <-------|   A   |          |   B   |------->  |   C   |
                   +---+---+          +---+---+          +---+---+
*
*  *   
 *   Step 1:
   +---+--+       +---+--+          +---+--+ 
   | prev |        | curr |          |  next|    
   +---+--+        +---+--+          +---+--+   
      |                |                 |         
      |                v                 v         
      v            +---+---+          +---+---+          +---+---+
     null          |   A   |------->  |   B   |------->  |   C   |
                   +---+---+          +---+---+          +---+---+ *   
 *   Step 1:
   +---+--+       +---+--+          +---+--+ 
   | prev |        | curr |          |  next|    
   +---+--+        +---+--+          +---+--+   
      |                |                 |         
      |                v                 v         
      v            +---+---+          +---+---+          +---+---+
     null          |   A   |------->  |   B   |------->  |   C   |
                   +---+---+          +---+---+          +---+---+ *   
 *   Step 1:
   +---+--+       +---+--+          +---+--+ 
   | prev |        | curr |          |  next|    
   +---+--+        +---+--+          +---+--+   
      |                |                 |         
      v                v                 v         
    +---+---+      +---+---+          +---+---+          +---+---+
<---|   A   |      |   B   |------->  |   C   |------->  |   D   |
    +---+---+      +---+---+          +---+---+          +---+---+
*/
		   while (curr != null) {
			   next = curr.next;
			   curr.next = prev;
			   prev = curr;
			   curr = next;
		   }
	        
 //Once the loop is completed, the head pointer is set to prev, which is now the first element in the reversed list. 
		   head = prev;
	   }
	   return head;	   
   }
   
   /*
    *  ================================   The end of functions need to be filled ===================================================
    *    
    */ 
   
   /*******************************************************
 *
 *  The Node class
 *
 ********************************************************/
   private static class Node<E>
   {
      private E data;
      private Node<E> next;

      public Node(E data, Node<E> next)
      {
         this.data = data;
         this.next = next;
      }
   }
   
  
}
