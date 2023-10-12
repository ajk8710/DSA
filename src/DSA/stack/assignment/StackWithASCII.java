package DSA.stack.assignment;

/*
Grace has a string S and a stack A.
She pushes each character of string S whose ASCII value is divisible by 3 on the stack.

1) Given a string S as input print the contents of the stack by popping each character from the stack.
Sample Input:
abcfgh    - - denotes the string S
Output Format:
Print the contents of the stack by popping each character from the stack as per the conditions.
Sample Output:
fc

Explanation:
The ASCII values of a,b,c,f,g,h are 97,98,99,102,103,104 respectively out of which 99 and 102 are divisible by 3.
Therefore, first c then f is pushed on the stack. The contents are c,f.
Printing the stack by popping each element from the stack we get fc.
*/

public class StackWithASCII {
    public static void main(String[] args) {
        System.out.println(solution("abcfgh"));
    }
    
    public static String solution(String st) {
        ArrayStack stack = new ArrayStack(st.length());
        String rv = "";
        
        for (char ch : st.toCharArray()) {
            if (IsDivisibleByThree(ch)) {
                stack.push(ch);
            }
        }
        
        while (stack.len() != 0) {
            rv += stack.pop();
        }
        
        return rv;
    }
    
    public static boolean IsDivisibleByThree(char ch) {
        if (ch % 3 == 0) {
            return true;
        }
        return false;
    }
}
