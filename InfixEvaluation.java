/*
 * Anusha Peddigari
 * 001023769
 */
package Test;

import java.util.Stack;

/**
 *
 * @author Anusha
 */
public class InfixEvaluation {

    public int evaluate(String expression){
        
        Stack<Integer> numbers = new Stack<>();

        
        Stack<Character> operations = new Stack<>();
        
        
        for(int i=0; i<expression.length();i++) {
            char c = expression.charAt(i);
            
            if(Character.isDigit(c)){
                
                int num = 0;
                while (Character.isDigit(c)) {
                    num = num*10 + (c-'0');
                    i++;
                    if(i < expression.length())
                        c = expression.charAt(i);
                    else
                        break;
                }
                i--;
                
                numbers.push(num);
            }else if(c=='('){
                
                operations.push(c);
            }
            
            else if(c==')') {
                while(operations.peek()!='('){
                    int output = performOperation(numbers, operations);
                    
                    numbers.push(output);
                }
                operations.pop();
            }
            
            else if(isOperator(c)){
                
                while(!operations.isEmpty() && precedence(c)<=precedence(operations.peek())){
                    int output = performOperation(numbers, operations);
                    
                    numbers.push(output);
                }
                
                operations.push(c);
            }
        }

        while(!operations.isEmpty()){
            int output = performOperation(numbers, operations);
            
            numbers.push(output);
        }
        return numbers.pop();
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

    public int performOperation(Stack<Integer> numbers, Stack<Character> operations) {
        int a = numbers.pop();
        int b = numbers.pop();
        char operation = operations.pop();
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return b - a;
            case '*':
                return a * b;
            case '/':
                if (a == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return b / a;
        }
        return 0;
    }

    public boolean isOperator(char c){
        return (c=='+'||c=='-'||c=='/'||c=='*'||c=='^');
    }

    public static void main(String[] args) {
        
        InfixEvaluation i = new InfixEvaluation();
        
        System.out.println(i.evaluate("1*2/3+(4+5-(6*(7/8)))")); 
        
        System.out.println(i.evaluate("4 + 8 * 6 - 5 / 3 - 2 * 2 + 2")); 
        
        System.out.println(i.evaluate("(1 + 3 + ( ( 4 / 2 ) * ( 8 * 4 ) )) ")); 
        
        System.out.println(i.evaluate("(4+8)*( 6 - 5 ) / ( ( 3 - 2 ) * ( 2 + 2 ) )")); 
    }
}
