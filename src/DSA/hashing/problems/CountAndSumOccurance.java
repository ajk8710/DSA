package DSA.hashing.problems;

import java.util.HashMap;

/*
You are given a string S. you also have an empty list at hand.
A sum operation on the string is defined as follows:

1. Iterate over the characters of the string.
2. For each characters in the string, append a number to the list using the following algorithm:
a. If the current character in the string has occurred for the first time, append 0 to the list.
b. If the current characters in the string has occurred before,
   append the number of times the current character has occurred in the string until now - 1 to the list.
3. For example, if the string is ¡°aba¡±, then after the sum operation,
   the elements in the list would be [0, 0, 1]. The sum of this list is 1
4. For example, if the string is ¡°abaab¡±, then after the sum operation,
   the elements in the list would be 0, 0, 1, 2, 1]. ]. The sum of this list is 4.

Thus, given a string S, you need to figure out the sum of the elements of the list.
Example

Consider, for example, the string S = ¡°abcaab¡±.
Then, after the sum operation, the list will become [0, 0, 0, 1, 2, 1].
The sum of this list is 4. Hence, the answer is 4.
 */
public class CountAndSumOccurance {
    
    public static void main(String[] args) {
        System.out.println(countAndSumOccurance("aba"));
        System.out.println(countAndSumOccurance("abcaab"));
    }
    
    // Use hashmap: Record occurrences of each char.
    public static int countAndSumOccurance(String str) {
        HashMap<Character, Integer> char_count = new HashMap<>();  // map of character to count
        int[] arr = new int[str.length()];  // array - technically not needed to solve problem, if I'm just returning the sum of every index's value of array.
        int sum = 0;
        
        for (int i = 0; i < str.length(); i++) {  // go through each char
            char c = str.charAt(i);
            if (!char_count.containsKey(c)) {  // if map does not contain char, record 1
                arr[i] = 0;
                char_count.put(c, 1);
            }
            else {                             // if map contains char, increment count
                int count = char_count.get(c);
                sum += count;                  // add current value of array to sum
                arr[i] = count;
                char_count.put(c, count + 1);
            }
        }
        
        // System.out.println(Arrays.toString(arr));
        return sum;
    }
    
}
