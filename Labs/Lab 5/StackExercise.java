
import java.util.LinkedList;
import java.util.Stack;

public class StackExercise {

		/*
		 * Given an expression string exp,
		 *  write a program to examine whether the pairs and 
		 *  the orders of parenthesis are correct in exp. 
		 *  For example, the program should print true for exp = [()[]]
		 *  and false for exp = [()[])
		 */
		/**
		 * 
		 * @param str 
		 * @return  true if balanced; false is unbalanced 
		 */
		public static boolean isBalancedParentheses(String str)
		{
			 Stack<Character> stack = new Stack<>();
			    for (int i = 0; i < str.length(); i++) {
			        char c = str.charAt(i);
			        if (c == '(' || c == '[' || c == '{') {  // If opening parenthesis, push it to the stack
			            stack.push(c);
			        } else if (c == ')' || c == ']' || c == '}') {  // If closing parenthesis, check if it matches the top of the stack
			            if (stack.isEmpty()) {  // Stack should not be empty for any closing parenthesis
			                return false;
			            }
			            char top = stack.pop();
			            if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
			                // If the closing parenthesis doesn't match the top of the stack, return false
			                return false;
			            }
			        }
			    }
			    return stack.isEmpty();  // If stack is empty, all parentheses have been matched and the expression is balanced
			}
		
			
		
		/*
		 * 
		 * Reverse the all the items in the linkedlist and return the return the head of the 
		 * reversed one, for example: A -> B -> C should be reversed as: C->B->A
		 */

		/**
		 * @param lst - the linkedlist to be reversed
		 * @return the linkedlist with all items reversed - 
		 */
		public static LinkedList<String> revLinkedList(LinkedList<String> lst)
		{
			 if (lst == null || lst.isEmpty()) {
			        return lst;
			    }

			    Stack<String> stack = new Stack<>();
			    for (String element : lst) {
			        stack.push(element);
			    }

			    LinkedList<String> reversed = new LinkedList<>();
			    while (!stack.isEmpty()) {
			        reversed.add(stack.pop());
			    }

			    return reversed;
			}	
		
		/*  This function evaluates "postfix" expressions (also called "Reverse Polish 
		 * Notation"), which are mathematical expressions but with the operators placed
		 * after operands instead of between.
		 * For example: 1 + 2 * 3 + 4  is written as 1 2 3 * + 4 + 
		 */
		/**
		 * 
		 * @param str
		 * @return the result of postfix expression
		 */
		
		public static int postfixEvaluate(String exp) {
			 Stack<Integer> stack = new Stack<>();

			    for (String token : exp.split("\\s")) {
			        if (token.matches("\\d+")) {  // If token is a number, push it to the stack
			            stack.push(Integer.parseInt(token));
			        } else if (token.matches("[+\\-*/]")) {  // If token is an operator, pop two operands and perform the operation
			            int operand2 = stack.pop();
			            int operand1 = stack.pop();
			            switch (token) {
			                case "+":
			                    stack.push(operand1 + operand2);
			                    break;
			                case "-":
			                    stack.push(operand1 - operand2);
			                    break;
			                case "*":
			                    stack.push(operand1 * operand2);
			                    break;
			                case "/":
			                    stack.push(operand1 / operand2);
			                    break;
			            }
			        }
			    }

			    return stack.pop();  // The final result will be left on top of the stack
			}





			
			
	}
