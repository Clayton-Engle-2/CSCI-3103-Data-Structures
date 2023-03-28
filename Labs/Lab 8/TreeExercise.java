package lab8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class TreeExercise {
		
	public static boolean isOp(String str)
	{
		if (str.equals("/") || str.equals("+") || str.equals("-") || str.equals("*"))
		{
			return true;
		}
		
		return false;
	}
	
	/*
	 * Construct Expression tree from postfixExpression
	 */
	public static Node<String> conExpTree(String str)
	{
		String[]  arr = str.split("\\s+");
		
		Stack<Node<String>> stk = new Stack<Node<String>>();
		
		for (String item: arr)
		{
			Node<String> newT = new Node<String>(item);
			if (!isOp(item))
			{
				stk.push(newT);
			}
			else
			{
				Node<String> right = stk.pop();
				Node<String> left = stk.pop();
				
				newT.left = left;
				newT.right = right;
				
				stk.push(newT);
			}
		}		
		return stk.pop();		
	}	
	
	/* * * * * * * * * * * * * * *****************************
	 * Please fill the code to complete the following functions
	 **********************************************************/
		
	/*
	 * Tree preOrder traversal
	 */ 
	/** @param root - root of the given tree
	 * @param str - a string representing inOrder tree traversal
	 * @return the str
	 *   
	 *  Example:                            *
	 *                                    /    \ 
	 *                                   +      -
	 *                                  / \    / \
	 *                                 x   y  +  c
	 *                                       / \
	 *                                      a   b       
	 *
	 * return: "* + x y / + a b c"
"
	 */
	public static String preOrderTraveral(Node<String> root)
	{	
		//Implementation similar to inOrderTraveral, which is described thoroughly 
		if(root == null) 
			return "";
		
		return (root.toString())+preOrderTraveral(root.left)+preOrderTraveral(root.right);
	}
	
	
	/*
	 * Tree postOrder traversal
	 */ 
	/** @param root - root of the given tree
	 * @param str - a string representing postOrder tree traversal
	 * @return the str
	 *   
	 *  Example:                            *
	 *                                    /    \ 
	 *                                   +      -
	 *                                  / \    / \
	 *                                 x   y  +  c
	 *                                       / \
	 *                                      a   b       
	 *
	 *  return: "x y + a b + c - *"
	 */
	public static String postOrderTraveral(Node<String> root)
	{
		////Implementation similar to inOrderTraveral, which is described thoroughly 
		if(root == null) 
			return "";
		
		return postOrderTraveral(root.left)+postOrderTraveral(root.right)+(root.toString());
		
	}
	
	
	
	/*
	 * Tree inOrder traversal
	 */ 
	/** @param root - root of the given tree
	 * @param str - a string representing inOrder tree traversal
	 * @return the str
	 *   
	 *  Example:                            *
	 *                                    /    \ 
	 *                                   +      -
	 *                                  / \    / \
	 *                                 x   y  +  c
	 *                                       / \
	 *                                      a   b       
	 *
	 *  return: "x + y * a + b - c"
	 */
	public static String inOrderTraveral(Node<String> root)
	{
		/*
		 * The inOrderTraversal method performs an in-order traversal of a binary tree and 
		 * returns a String representation of the traversal.
		 * 
		 * In an in-order traversal, we visit the nodes of the tree in the following order:
		 *  -  Visit the left subtree.
		 *  -  Visit the root node.
		 *  -  Visit the right subtree.
		 *  
		 *  The inOrderTraversal method implements this traversal using a recursive 
		 *  approach. If the root node is null, the method returns an empty string. 
		 *  Otherwise, the method concatenates the following three strings recursively:
		 *  -  The result of calling inOrderTraversal on the left subtree of the root node.
		 *  -  The String representation of the root node.
		 *  -  The result of calling inOrderTraversal on the right subtree of the root node.
		 *  
		 *  The String representation of the root node is obtained by calling toString() on the 
		 *  root node object.
		 *  The base case for the recursive function is when the root node is null. When this 
		 *  happens, the recursive calls to inOrderTraversal on the left and right subtrees 
		 *  return an empty string, and the root node's data is not included in the result.
		 */
		if(root == null) 
			return "";
		
		return inOrderTraveral(root.left)+(root.toString())+inOrderTraveral(root.right);
		
	}
	
	
	/*
	 *  Tree level traversal 
	 */
	/**
	 * @param root - the root of tree
	 * @return String - level traversal of tree
	 *   ==
	 *  Example:                            *
	 *                                    /    \ 
	 *                                   +      -
	 *                                  / \    / \
	 *                                 x   y  +  c
	 *                                       / \
	 *                                      a   b       
	 *
	 *  return: "* + - x y + c a b"
	 */
	public static String levelOrderTraveral(Node<String> root)
	{
		/* Here, we start by checking if the root is null and 
		 * returning an empty string if it is. 
		 */
		if (root == null) {
	        return "";
	    }
		
		/* Otherwise, we initialize a StringBuilder to store the 
		 * level traversal and a Queue to perform the traversal.
		 */
	    
	    StringBuilder sBuilder = new StringBuilder();
	    Queue<Node<String>> queue = new LinkedList<Node<String>>();
	    queue.offer(root);
	    
	    /* We add the root node to the queue and then loop through the queue 
	     * until it's empty. In each iteration, we remove the first node from 
	     * the queue, add its data to the StringBuilder, and then add its 
	     * left and right children (if they exist) to the queue.
	     */
	    while (!queue.isEmpty()) {
	        Node<String> curr = queue.poll();
	        sBuilder.append(curr.toString()).append(" ");
	        
	        if (curr.left != null) {
	            queue.offer(curr.left);
	        }
	        
	        if (curr.right != null) {
	            queue.offer(curr.right);
	        }
	    }
	    //Finally, we return the StringBuilder as a String, trimming any trailing spaces.
	    return sBuilder.toString().trim();
	}

}


