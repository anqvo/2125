/*
 * An Vo
 * CSCI 2125-001
 * 05 September 2015
 * Assignment 1 Part 3 "InfixToPostfix.java"
 */

/*
 * InfixToPostfix will simply take a String infix notation and output the postfix expression.
 */
public class InfixToPostfix {
	
	/*
	 * Take an infix notation String input.
	 *
	 * Tokens are all characters that are grouped into symbols:
	 * 	tokens may be identifiers, keywords, separators, operators, literals, comments.
	 * @param String infix notation to convert to postfix
	 * @return converted String postfix notation
	 */
	public static String convert(String infix) {
		String[] tokens = infix.split("\\s+");	// split method acquired from String API

		MyStack<String> operators = new MyStack<String>();

		StringBuilder pfixBuilder = new StringBuilder();	// StringBuilder used to OUTPUT postfix notation

		for(String token : tokens) {	// iterate through for-each token
			int precedence = getPrecedence(token);	// precedence will be used in Step 3, precedence = -1 if(token != operator)
																//	 precedence will dictate which two DIFFERENT (tokens) operations will carry out first
			int associativity = getAssociativity(token);	// associativity = -1 if(token != operator)
																		// associativity will dictate which two SIMILAR (tokens) operations will carry out first
			if(token.equals("(")) {
				operators.push(token);	// Step 4 according to F. Eishita: "if(token is O.P) stack.push(O.P)"
			}
			else if(token.equals(")")) {
				String nextToken = operators.pop();	// ...and if(token is C.P) stack.pop(all operators) until O.P appears
				while(!nextToken.equals("(")) {
					pfixBuilder.append(nextToken);
					pfixBuilder.append(' ');
					nextToken = operators.pop();
				}
			}
			// the following comments are a combination of Step 2 and Step 3 according to F. Eishita: "if operator and check precedence"
			else if(precedence >= 0 && associativity >= 0) {	// 0 = operator == precedence(token) && associativity(token)
																				// pop all higher prioritized operators and StringBuilder
																				// append to OUTPUT postfix notation
				while(!operators.isEmpty() && !operators.peek().equals("(") && ((associativity == 0 && precedence <= getPrecedence(operators.peek())) || (associativity == 1 && precedence < getPrecedence(operators.peek())))) {
					pfixBuilder.append(operators.pop());
					pfixBuilder.append(' ');
				}
				operators.push(token);	// token is pushed onto the stack
			}
			else { 	// the token is merely an operand, StringBuilder append this token to the OUTPUT
				pfixBuilder.append(token);
				pfixBuilder.append(' ');
			}
		}

		while(!operators.isEmpty()) {
			pfixBuilder.append(operators.pop()); // pop the remaining operators(tokens) and StringBuilder append to OUTPUT
			pfixBuilder.append(' ');
		}
		return pfixBuilder.toString();	// return the String representation of the OUTPUT postfix notation
	}

	/*
	 *	Retrieve the precedence of an operator of type String.
	 *	Higher precedence = lower priority, vice versa.
	 *
	 *	@param String operator of whom's precedence is tested
	 *	@return the precedence/priority of the tested operator
	 */
	private static int getPrecedence(String operator) {
		int pVal = -1;
		if(operator.equals("^")) {
			pVal = 2;
			return pVal;
		}
		else if(operator.equals("*") || operator.equals("/")) {
			pVal = 1;
			return pVal;
		}
		else if(operator.equals("+") || operator.equals("-")) {
			pVal = 0;
			return pVal;
		}
		else {
			return pVal;
		}
	}	// end getPrecedence method
	
	/*
	 *	Retrieve the associativity of an operator of type String.
	 *	Associativity for the operator follows accordingly:
	 *	0 == left, 1 == right, -1 == unknown
	 *
	 *	@param String operator of whom's associativity is tested
	 *	@return the associativity of the tested operator
	 */
	private static int getAssociativity(String operator) {
		int aVal = -1;
		if(operator.equals("^")) {
			aVal = 1;
			return aVal;
		}
		else if(operator.equals("*") || operator.equals("/") || operator.equals("+") || operator.equals("-")) {
			aVal = 0;
			return aVal;
		}
		else {
			return aVal;
		}
	}	// end getAssociativity method

}	// end InfixToPostfix class
