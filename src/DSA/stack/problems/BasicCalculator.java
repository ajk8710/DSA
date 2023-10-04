package DSA.stack.problems;

import java.util.ArrayDeque;

// Implement a basic calculator to evaluate a simple expression string.
// The expression string may contain open ( and closing parentheses ),
// the plus + or minus sign -, non-negative integers and empty spaces (no consecutive operators).
// Input: "1 + 1"
// Output: 2
// Input: " 2-1 + 2 "
// Output: 3
// Input: "(1+(4+5+2)-3)+(6+8)"
// Output: 23
public class BasicCalculator {
    
    public static void main(String args[]) {
        System.out.println(calculate("1 + 1"));
        System.out.println(calculate("(1 + 1)"));
        System.out.println(calculate(" 2-1 + 2 "));
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(calculate("-(1+(4+5+2)-3)+(6+8)"));
        System.out.println(calculate("-(123+(42+50))"));
        System.out.println(calculate("-(1+(4+5))"));
        
        //        -  ( 1 + (   4 + 5 )     )
        // sum:   0      1       4   9 10  -10
        // sign: -1  1   1       1 
        // num:   0    1 0     4 0 5 0
        // stack: 0 -1     1 1

    }
    
    // Read from left to right.
    // Initialize sum = 0, sign = 1.
    // If digit, finish reading number (prevInt * 10 + curInt).
    // If + or -, sum = previous sign * previous num. Reset sign (1 or -1).
    // If (, stack = [sumBefore(, signBefore(]. Reset sign = 1. Reset sum = 0.
    // If ), sum = previous sign * previous num. Then sum = popedSign * sum + popedSum. Reset num = 0.
    public static int calculate(String str) {
        int sum = 0;  // result of calculation
        int sign = 1;
        int num = 0;  // number read
        ArrayDeque<Integer> stack = new ArrayDeque<>();  // top of stack is + or - read before the number or (
        stack.push(sign);
        
        for (char c : str.toCharArray())
            if (Character.isDigit(c)) {       // If digit, finish reading the number
                num = num * 10 + (c - '0');   // ex: '9' - '0' = 9
            }
            else if (c == '+' || c == '-') {  // if sign, do calculation for number preceded
                sum += sign * num;            // sum = sign before number preceded * number preceded
                sign = (c == '+' ? 1 : -1);   // reset sign according to current char
                num = 0;                      // reset num
            }
            else if (c == '(') {
                stack.push(sum);
                stack.push(sign);
                sign = 1;
                sum = 0;
            }
            else if (c == ')') {
                sum += sign * num;
                sum *= stack.pop();
                sum += stack.pop();
                num = 0;
            }  // else (spaces) don't do anything   
            
        return sum + sign * num;  // do calculation with the last num
    }
}
