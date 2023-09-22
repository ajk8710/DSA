package DSA.stack.problems;

public class ValidExpression {
    
    public static void main(String args[]) {
        
        System.out.println("a: " + isValidExpression("a"));
        System.out.println("a: " + isValidExpression("1"));
        System.out.println();
        
        System.out.println("+: " + isValidExpression("+"));
        System.out.println("-: " + isValidExpression("-"));
        System.out.println("*: " + isValidExpression("*"));
        System.out.println("/: " + isValidExpression("/"));
        System.out.println("[: " + isValidExpression("["));
        System.out.println("}: " + isValidExpression("}"));
        System.out.println("()(: " + isValidExpression("()("));
        System.out.println();
        
        System.out.println("(): " + isValidExpression("()"));
        System.out.println("[]: " + isValidExpression("[]"));
        System.out.println("{}: " + isValidExpression("{}"));
        System.out.println("[]{}: " + isValidExpression("[]{}"));
        System.out.println("([]{}): " + isValidExpression("([]{})"));
        System.out.println();
        
        System.out.println(")a: " + isValidExpression(")a"));
        System.out.println("a]b: " + isValidExpression("a]b"));
        System.out.println("a}: " + isValidExpression("a}"));
        System.out.println("(a]b: " + isValidExpression("(a]b"));
        System.out.println("a[b)c: " + isValidExpression("a[b)c"));
        System.out.println("a{b ]: " + isValidExpression("a{b ]"));
        System.out.println();
        
        System.out.println("a[b ]: " + isValidExpression("a[b ]"));
        System.out.println("a{b}: " + isValidExpression("a{b}"));
        System.out.println(" ( a{b}c ): " + isValidExpression(" ( a{b}c )"));
        System.out.println("({[[(a{b}c)]]}): " + isValidExpression("{{({[[(a{b}c)]]})}}"));
        System.out.println();
        
        System.out.println("+a{b}+: " + isValidExpression("+a{b}+"));
        System.out.println("a++: " + isValidExpression("a++"));
        System.out.println("a * (b: " + isValidExpression("a * (b"));
        System.out.println("a * b): " + isValidExpression("a * b)"));
        System.out.println();
        
        
        System.out.println("(a+a): " + isValidExpression("(a+a)"));
        System.out.println("a*b: " + isValidExpression("a*b"));
        System.out.println("a + b * c / 2: " + isValidExpression("a + b * c / 2"));
        System.out.println("a + b * c // 2: " + isValidExpression("a + b * c // 2"));
        System.out.println();
        
        // irregulars
        System.out.println("-a: " + isValidExpression("-a"));
        System.out.println("-a*b: " + isValidExpression("-a*b"));
        System.out.println("*a: " + isValidExpression("*a"));
        System.out.println("a*: " + isValidExpression("a*"));
        System.out.println("+a{b}: " + isValidExpression("+a{b}"));
        System.out.println("+a/{b}: " + isValidExpression("+a/{b}"));
        
    }
    
    // Checks for valid expression
    // Input restriction:
    // Integer from 0 to 9
    // Letter from a to z (should be one character, not like xx or xyz)
    // Binary operator: + - * /
    public static boolean isValidExpression(String exp) {
        
        if (exp.length() == 0) {
            return false;
        }
        
        char cha = exp.charAt(0);
        if (exp.length() == 1 && (Character.isAlphabetic(cha) || Character.isDigit(cha))) {
            return true;
        }
        
        ArrayStack operands = new ArrayStack(exp.length());
        ArrayStack operators = new ArrayStack(exp.length());
        ArrayStack openBrackets = new ArrayStack(exp.length());
        
        for (int i = 0; i < exp.length(); i++) {
            char curChar = exp.charAt(i);
            
            if (curChar == '(' || curChar == '[' || curChar == '{') {  // if opening bracket, push
                openBrackets.push(curChar);
            }
            else if (curChar == '+' || curChar == '-' || curChar == '*' || curChar == '/') {  // if operator, push
                operators.push(curChar);
            }
            else if (Character.isAlphabetic(curChar) || Character.isDigit(curChar)) {  // if operand, push
                operands.push(curChar);
                if (i == exp.length() - 1) {  // if last char is operand
                    if (operators.len() == 0) {
                        return false;
                    }
                    if (operators.len() >= operands.len()) {
                        return false;
                    }
                    else {
                        return (openBrackets.len() == 0 ? true : false);  // return true if there is no left over in openBrackets
                    }
                }
            }
            else if (curChar == ')' || curChar == ']' || curChar == '}') {  // if closing bracket, check for matching opening bracket
                if (openBrackets.len() == 0) {
                    return false;
                }
                char bracket = openBrackets.pop();
                if (bracket == '(' && curChar != ')') {
                    return false;
                }
                else if (bracket == '[' && curChar != ']') {
                    return false;
                }
                else if (bracket == '{' && curChar != '}') {
                    return false;
                }
                if (operators.len() != 0) {  // after checking bracket validity
                    operators.pop();         // pop operator
                    if (operands.len() < 2) {  // there must be two operands per operator (not considering unary operator here)
                        return false;
                    }
                    operands.pop();
                    operands.pop();
                }
            }
        }
        
        // return true if there is no left over in openBrackets nor operands stack
        return (openBrackets.len() == 0 ? true : false) && (operators.len() == 0 ? true : false);
    }
    
}
