
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


public class PostfixEvaluation {
    int evaluatePostfix(String expression)
{
	
	Stack<Integer> S =new Stack<>();

	for(int i = 0;i< expression.length();i++) {
            
            char c = expression.charAt(i);

		if(c == ' ' || c == ',') continue; 

		
		else if(isOperator(c)) {
			
			int operand2 = S.peek(); S.pop();
			int operand1 = S.peek(); S.pop();
			
			int result = performOperation(c, operand1, operand2);
			
			S.push(result);
		}
		else if(isNumericDigit(c)){
			
                        
                        S.push(expression.charAt(i)-'0');
		}
	}
	
	return S.peek();
}


boolean isNumericDigit(char C) 
{
	if(C >= '0' && C <= '9') return true;
	return false;
}


boolean isOperator(char C)
{
	if(C == '+' || C == '-' || C == '*' || C == '/')
		return true;

	return false;
}


int performOperation(char operation, int operand1, int operand2)
{
	if(operation == '+') return operand1 +operand2;
	else if(operation == '-') return operand1 - operand2;
	else if(operation == '*') return operand1 * operand2;
	else if(operation == '/')
        { if (operand2 == 0){
                  throw new UnsupportedOperationException("Cannot divide by zero");
                  
        }
            return operand1 / operand2;
        }
	else System.out.println("Unexpected Error \n");
	return -1; 
}

  public static void main(String[] args) {
        
        PostfixEvaluation p = new PostfixEvaluation();
        
        
        
        System.out.println("Postfix evaluation for the expression 48+65-*32-22+*/ is " + p.evaluatePostfix("48+65-*32-22+*/"));
    }

}
