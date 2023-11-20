package DSA.arrayProblems;

import java.util.List;

/*
Given a list of unique words (of lower cases), find all pairs of distinct indices (i, j) in the given list,
so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome. 
Example 1: 
Input: ["abcd","dcba","lls","s","sssll"] 
Output: [[0,1],[1,0],[3,2],[2,4]] 
Explanation: The palindromes are ["abcddcba", ¡°dcbaabcd","slls","llssssll"] 
Example 2: 
Input: ["bat","tab","cat"] 
Output: [[0,1],[1,0]] 
Explanation: The palindromes are ["battab","tabbat"] 
 */
public class PalindromeAfterConcatenation {
    
    public static void main(String[] args) {

    }
    
    // brute force way would be, for i < words.len for j < words.len, if word lengths are equal & i != j, compare from left & right
    public static List<List<Integer>> palindromePairs(String[] words) {
        return null;
    }

}
