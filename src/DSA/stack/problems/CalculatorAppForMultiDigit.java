package DSA.stack.problems;

// Gets string of math expression.
// Converts expression from infix to post fix.
// Calculate using converted post fix string.

// This version works with multi-digit numbers compared to my previous CalculatorApp
// that only works for single digit numbers, by having a separator (a space) between postfix entries. EX: 2 55 7 * + 3 -
//
// This is achieved by: When converting infix to postfix,
// append a space to postfix whenever operator is encountered & whenever operator from stack is appended to postfix.
// (Logic: there's always an operator between two numbers, so a number after a number is a single number - no space needed,
// but when operator is encountered, separate a number by a space, & when operator is appended to postfix, also append space before it.)
//
// When doing calculation on postfix: Maintain a flag "was last char a number". 
// When number is encountered, check if last char was number, if so, pop it & multiply by 10, then add this num, then push.
// Ignore any space characters.
public class CalculatorAppForMultiDigit {
    
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
        
        calculate("2+55*7-3");
        calculate("(2+55*7-3)");
        calculate("(12+55*77-321)");
        calculate("((11+22)-33*(42/52))+62");
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
    
    // This returns calculated value using converted postfix string.
    //
    // Iterate postfix from left to right.
    // (There will always be at least two numbers to apply operator, until the end. The remaining last one number is the result.)
    // If number, push to temp stack.
    // If operator, pop top two from stack, apply operator, push the result to stack.
    // After iteration, there will be one remaining top of stack, which is the result.
    public static double evaluatePostfix(String postfix) {
        
        ArrayStackForDouble stack = new ArrayStackForDouble(postfix.length());  // initialize stack
        char[] chars = postfix.toCharArray();  // convert string to char array to iterate over
        
        boolean wasNumber = false;  // was last char a number
        
        for (char c : chars) {
            if (Character.isDigit(c)) {  // if operand, push to stack
                if (wasNumber) {  // if last char was number, pop & multiply by 10, then add this num, then push
                    stack.push(stack.pop() * 10 + Double.valueOf(String.valueOf(c)));
                }
                else {
                    stack.push(Double.valueOf(String.valueOf(c)));
                    wasNumber= true;
                }
            }
            else if (c == ' ') {
                // ignore spaces
                wasNumber = false;
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
                wasNumber = false;
            }
        }
        
        return Double.valueOf(stack.pop());  // return the top
    }
    
    // This converts expression from infix to postfix. (EX: 2 + 5 * 7 to 2 5 7 * +)
    // 
    // Concept is to have a higher precedence operator be at right after its two numbers, then lower precedence operator followed.
    // This is achieved by having a stack, where top of stack is always highest precedence, otherwise pop the top:
    // Push when operator is seen. When next operator (me) is seen, pop and append to postfix until the top is lower precedence than me.
    // (If top is same or higher precedence than me, go append to postfix before me)
    //
    // As a program:
    // String postfix = ""; (the resulting postfix)
    // Stack tempStack; (to contain open brackets and operators)
    // Convert infix string to char array, then iterate from left to right.
    // If number, append to postfix.
    // If open bracket, push to temp stack.
    // If closed bracket, pop and append to postfix until open bracket is popped. (Whatever within bracket is highest precedence)
    // If operator, pop and append until the top of stack is operator with lower precedence. Then push to stack.
    // After iteration, pop the rest from temp stack and append to postfix. (Thus, higher precedence appends to postfix first)
    public static String infixToPostfix(String infix) {
        
        String postfix = "";  // initialize return string
        ArrayStack stack = new ArrayStack(infix.length());  // initialize stack
        char[] chars = infix.toCharArray();  // convert string to char array to iterate over
        
        for (char c : chars) {
            if (Character.isDigit(c)) {  // if number, append to postfix string
                postfix += c;
            }
            else if (isBracket(c)) {  // if bracket
                if (isOpenBracket(c)) {  // if open bracket, push to stack
                    stack.push(c);
                }
                else {  // if closed bracket, pop the stack and append to postfix string until open bracket is popped
                    while (!isOpenBracket(stack.peek())) {  // there must be an open bracket if valid expression
                        postfix += " " + stack.pop();
                    }
                    stack.pop();  // discard brackets
                }
            }
            else {  // if operator, pop the stack and append to postfix string until the top of stack is operator with lower precedence
                while (stack.len() > 0 && !Character.isDigit(stack.peek()) && !isBracket(stack.peek()) && getPrecedance(stack.peek()) >= getPrecedance(c)) {
                    postfix += " " + stack.pop();
                }
                postfix += " ";
                stack.push(c);  // push to stack
            }
        }
        
        while (stack.len() != 0) {  // Pop the rest and append to postfix.
            postfix += " " + stack.pop();
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
    
    // Returns true if a digit or a dot
    // Temporary work: May want to work on decimal calculation later.
    // Not working for now, because the program tries to multiply 10 on a dot when calculating postfix.
    // If it's a dot, I need a logic to discard a dot and handle following number characters as decimals.
    public static boolean isDigitOrDot(char c) {
        if (Character.isDigit(c) || c == '.') {
            return true;
        }
        return false;
    }
    
}
