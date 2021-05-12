
/*
 * Anusha Peddigari
 * 001023769
 */
package Test;
/**
 *
 * @author 16175
 */

import java.util.Stack;
public class InfixToPostfix {
    
    String infixToPostfix(String expression)
{
	
	Stack<Character> S =new Stack<>();
	String postfix = ""; // Initialize postfix as empty string.
        
	for(int i = 0;i< expression.length();i++) {
            Character c= expression.charAt(i); 
		if(expression.charAt(i) == ' ' || expression.charAt(i) == ',') continue; 

		
		else if(isOperator(expression.charAt(i))) 
		{
			while(!S.empty() &&  precedence(c)<=precedence(S.peek()))
			{
				postfix+= S.peek();
				S.pop();
			}
			S.push(expression.charAt(i));
		}
		
		else if(isOperand(expression.charAt(i)))
		{
			postfix +=expression.charAt(i);
		}

		else if (expression.charAt(i) == '(') 
		{
			S.push(expression.charAt(i));
		}

		else if(expression.charAt(i) == ')') 
		{
			while(!S.empty() && S.peek() !=  '(') {
				postfix += S.peek();
				S.pop();
			}
			S.pop();
		}
	}

	while(!S.empty()) {
		postfix += S.peek();
		S.pop();
	}

	return postfix;
}

    
   static int precedence(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

boolean isOperand(char C) 
{
	if(C >= '0' && C <= '9') return true;
	if(C >= 'a' && C <= 'z') return true;
	if(C >= 'A' && C <= 'Z') return true;
	return false;
}


boolean isOperator(char C)
{
	if(C == '+' || C == '-' || C == '*' || C == '/' || C== '$')
		return true;

	return false;
}


    boolean isRightAssociative(char op)
{
	if(op == '$') return true;
	return false;
}


int getOperatorWeight(char op)
{
	int weight = -1; 
	switch(op)
	{
	case '+':
	case '-':
		weight = 1;
	case '*':
	case '/':
		weight = 2;
	case '$':
		weight = 3;
	}
	return weight;
}


    boolean hasHigherPrecedence(char op1, char op2)
{
	int op1Weight = getOperatorWeight(op1);
	int op2Weight = getOperatorWeight(op2);

	return op1Weight > op2Weight ?  true: false;
}
    
    public static void main(String[] args) {
        InfixToPostfix i=new InfixToPostfix();
		String exp = "(4 + 8) * (6 - 5)/((3 - 2) * (2 + 2))"; 
        System.out.println("Postfix conversion of the infix expression (4 + 8) * (6 - 5)/((3 - 2) * (2 + 2)) is " + i.infixToPostfix(exp)); 

	}

}
