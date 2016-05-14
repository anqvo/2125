/*
 * An Vo
 * CSCI 2125-001
 * 05 September 2015
 * Assignment 1 "StartUp.java"
 */

/*
 * This class works as a starting point for the program.
 * This class acts as a sandbox to make use of the Infix to Postfix conversions.
 * These actions are performed in the main() method below.
 */
public class StartUp {
	public static void main(String[] args) {
	
		System.out.println("Infix: a * b + c / d \nPostfix: " + InfixToPostfix.convert("a * b + c / d"));
		
		System.out.println("\nInfix: a * ( b + c ) / d \nPostfix: " + InfixToPostfix.convert("a * ( b + c ) / d"));
		
		System.out.println("\nInfix: a * ( b + c / d ) \n Postfix: " + InfixToPostfix.convert("a * ( b + c / d )"));
		
		System.out.println("\nInfix: a + b * c + d \nPostfix: " + InfixToPostfix.convert("a + b * c + d"));
		
		System.out.println("\nInfix: ( a  + b ) * ( c + d ) \nPostfix: " + InfixToPostfix.convert("( a + b ) * ( c + d )"));
		
		System.out.println("\nInfix: a * b + c * d \nPostfix: " + InfixToPostfix.convert("a * b + c * d"));
		
		System.out.println("\nInfix: a + b + c + d \nPostfix: " + InfixToPostfix.convert("a + b + c + d"));
		
	}	//end main method
	
}	// end StartUp class
