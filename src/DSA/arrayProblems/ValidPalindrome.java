package DSA.arrayProblems;


/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
and removing all non-alphanumeric characters, it reads the same forward and backward.
Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
        System.out.println(isPalindrome(""));
        System.out.println(isPalindrome("race a car"));
        System.out.println();
        
        System.out.println(isPalindromeNoExtraMemory(s));
        System.out.println(isPalindromeNoExtraMemory(""));
        System.out.println(isPalindromeNoExtraMemory("race a car"));
    }
    
    // Solution with extra memory for creating new string without spaces & non-alphanumeric characters
    public static boolean isPalindrome(String s) {
        String newS = "";
        
        // new string with spaces & non-alphanumeric removed
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c) || Character.isDigit(c)) {
                newS += Character.toLowerCase(c);
            }
        }
        
        // Compare until left & right pointer do not cross or meet.
        // (This way we do not need to check whether s.length is even or odd)
        // (Nor need to reverse the string than compare from beginning to end)
        int left = 0;
        int right = newS.length() - 1;
        while (left < right) {
            if (newS.charAt(left++) != newS.charAt(right--)) {
                return false;
            }
        }
        
        return true;
    }
    
    // Solution without extra memory
    // Increment & Decrement left & right pointer until it's alphanumeric, then compare
    public static boolean isPalindromeNoExtraMemory(String s) {
        // Compare until left & right pointer do not cross or meet.
        // (This way we do not need to check whether s.length is even or odd)
        // (Nor need to reverse the string than compare from beginning to end)
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            // Increment left pointer until it's alphanumeric, while making sure index is not out of boundary
            while (left < right && !(Character.isLetter(s.charAt(left)) || Character.isDigit(s.charAt(left))) ) {
                left++;
            }
            // Decrement right pointer until it's alphanumeric, while making sure index is not out of boundary
            while (left < right && !(Character.isLetter(s.charAt(right)) || Character.isDigit(s.charAt(right))) ) {
                right--;
            }
            
            // If still left < right, compare
            if (left < right && Character.toLowerCase(s.charAt(left++)) != Character.toLowerCase(s.charAt(right--))) {
                return false;
            }
        }
        
        return true;
    }
    
}
