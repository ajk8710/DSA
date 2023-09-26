package DSA.stack.problems;

// Gets string of math expression.
// Converts expression from infix to post fix.
// Calculate using converted post fix string.
public class CalculatorApp {
    
    public static void main(String[] args) {
        /*
        System.out.println("in--fix: 2+5*7-3");
        System.out.println("postfix: " + infixToPostfix("2+5*7-3"));  // 257*+3-
        System.out.println("in--fix: (2+5*7-3)");
        System.out.println("postfix: " + infixToPostfix("(2+5*7-3)"));  // 257*+3-
        
        System.out.println("in--fix: (1-2)-3+4*5+6");
        System.out.println("postfix: " + infixToPostfix("(1-2)-3+4*5+6"));  // 12-3-45*+6+
        System.out.println("in--fix: (1+2*(3-4))/5");
        System.out.println("postfix: " + infixToPostfix("(1+2*(3-4))/5"));  // 1234-*+5/
        System.out.println("in--fix: ((1+2)-3*(4/5))+6");
        System.out.println("postfix: " + infixToPostfix("((1+2)-3*(4/5))+6"));  // 12+345/*-6+
        
        System.out.println(evaluatePostfix("257*+3-"));
        System.out.println();
        */
        
        calculate("2+5*7-3");
        calculate("(2+5*7-3)");
        calculate("(1-2)-3+4*5+6");
        calculate("(1+2*(3-4))/5");
        calculate("((1+2)-3*(4/5))+6");
    }
    
    // Calculates math expression using infixToPostfix and evaluatePostfix methods.
    public static double calculate(String exp) {
        System.out.println("in--fix: " + exp);
        String postfix = infixToPostfix(exp);
        System.out.println("postfix: " + postfix);
        double result = evaluatePostfix(postfix);
        System.out.println("result: " + result);
        return result;
    }
    
    // Returns calculated value using converted postfix string.
    // Iterate postfix from left to right.
    // If operand, push to temp stack.
    // If operator, pop top two from stack, apply operator, push the result to stack.
    // After iteration, there will be one remaining top of stack, which is the result.
    public static double evaluatePostfix(String postfix) {
        
        ArrayStackForDouble stack = new ArrayStackForDouble(postfix.length());  // initialize stack
        char[] chars = postfix.toCharArray();  // convert string to char array to iterate over
        
        for (char c : chars) {
            if (Character.isDigit(c)) {  // if operand, push to stack
                stack.push(Double.valueOf(String.valueOf(c)));
            }
            else {  // if operator, pop top two from stack, apply operator, push the result to stack
                double j = stack.pop();
                double i = stack.pop();
                
                if (c == '+') {
                    stack.push(i + j);
                }
                else if (c == '-') {
                    stack.push(i - j);
                }
                else if (c == '*') {
                    stack.push(i * j);
                }
                else if (c == '/') {
                    stack.push(i / j);
                }
                else {  // c == '^'
                    stack.push(Math.pow(i, j));
                }
            }
        }
        
        return Double.valueOf(stack.pop());  // return the top
    }
    
    // Converts expression from infix to postfix.
    // Iterate infix from left to right.
    // If operand, append to postfix.
    // If open bracket, push to temp stack.
    // If closed bracket, pop and append to postfix until open bracket is popped.
    // If operator, pop and append until the top of stack is operator with lower precedence. Then push to stack.
    // After iteration, pop the rest from temp stack and append to postfix.
    public static String infixToPostfix(String infix) {
        
        String postfix = "";  // initialize return string
        ArrayStack stack = new ArrayStack(infix.length());  // initialize stack
        char[] chars = infix.toCharArray();  // convert string to char array to iterate over
        
        for (char c : chars) {
            if (Character.isDigit(c)) {  // if operand, append to postfix string
                postfix += c;
            }
            else if (isBracket(c)) {  // if bracket
                if (isOpenBracket(c)) {  // if open bracket, push to stack
                    stack.push(c);
                }
                else {  // if closed bracket, pop the stack and append to postfix string until open bracket is popped
                    while (!isOpenBracket(stack.peek())) {  // there must be an open bracket if valid expression
                        postfix += stack.pop();
                    }
                    stack.pop();  // discard brackets
                }
            }
            else {  // if operator, pop the stack and append to postfix string until the top of stack is operator with lower precedence
                while (stack.len() > 0 && !Character.isDigit(stack.peek()) && !isBracket(stack.peek()) && getPrecedance(stack.peek()) >= getPrecedance(c)) {
                    postfix += stack.pop();
                }
                stack.push(c);  // push to stack
            }
        }
        
        while (stack.len() != 0) {  // Pop the rest and append to postfix.
            postfix += stack.pop();
        }
        
        return postfix;
    }
    
    // Returns precedence of math operator, higher number means higher precedence
    public static int getPrecedance(char c) {
        if (c == '^') {
            return 2;
        }
        else if (c == '*' || c == '/') {
            return 1;
        }
        else {  // '+' or '-'
            return 0;
        }
    }
    
    // Returns true if bracket
    public static boolean isBracket(char c) {
        if (c == '(' || c == ')' || c == '[' || c == ']' || c == '{' || c == '}') {
            return true;
        }
        return false;
    }
    
    // Returns true if open bracket
    public static boolean isOpenBracket(char c) {
        if (c == '(' || c == '[' || c == '{') {
            return true;
        }
        return false;
    }
    
}