package DSA.arrayProblems;

import java.util.Arrays;

/*
Given an array nums of n integers where n > 1,
return an array output such that output[i] is equal to the product of all the elements of nums except nums[i]. 
Example:
Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer. 
Note: Please solve it without division and in O(n).
Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.) 
 */
public class ProductAllOthers {
    
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4};
        int[] products = productOfAllOthersExceptMe(nums);
        for (int i : products) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        products = productOfAllOthersExceptMeLessNotes(nums);
        System.out.println(Arrays.toString(products));
    }
    
    // Construct "left products before me": leftProduct = 1. My left product is leftProduct. Update leftProduct by multiplying me.
    // Construct "answer" by multiplying left product (answer[i]) & rightProduct. Update rightProduct by multiplying me.
    public static int[] productOfAllOthersExceptMeLessNotes(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = leftProduct;  // my leftProduct is leftProduct
            leftProduct *= nums[i];  // update left product by multiplying me
        }
        
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= rightProduct;  // answer is left product * right product
            rightProduct *= nums[i];  // update right product by multiplying me
        }
        
        return answer;
    }

    // Below contains a lot of notes while studying the problem.
    
    // Concept: product except me = product of my left * product of my right
    //                          Input nums: [1, 2, 3, 4]
    // Left product so far * One before me: [1, 1, 2, 6]
    // Right product so far * One after me: [24,12,4, 1]
    //         Multiply left & right of me: [24,12,8, 6]
    
    // Programmatically: 
    // Using only one extra array for calculations and to return.
    // Construct "left products before me" first: [1, ans_preIdx * num_preIdx, ...]
    // Or, Construct "left products before me" by: Starting leftProduct = 1. answer_meIdx = leftProduct. Update leftProduct by multiplying me.
    // Construct "answer" by multiplying left product (answer[i]) * rightProductSoFar. Update rightProductSoFar by multiplying me.
    public static int[] productOfAllOthersExceptMe(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        
//        answer[0] = 1;
//        for (int i = 1; i < n; i++) {  // starting from index 1.
//            answer[i] = answer[i - 1] * nums[i - 1];  // product so far before me-1 * me-1
//        }
        
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {  // starting from index 0.
            answer[i] = leftProduct;  // my leftProduct is leftProduct
            leftProduct *= nums[i];  // update left product by multiplying me
        }
        
        // answer with for loop starting from n - 2;
        //                         Input nums:  [1, 2, 3, 4]
        // Left product so far * One before me: [1, 1, 2, 6]
        // Sum of left product & right product: [24,12,8, 6]
//        int rightProduct = 1;
//        for (int i = n - 2; i >= 0; i--) {
//            rightProduct = rightProduct * nums[i + 1];
//            answer[i] *= rightProduct;
//        }
        
        // answer with for loop starting from n - 1;
        //                         Input nums:  [1, 2, 3, 4]
        // Left product so far * One before me: [1, 1, 2, 6]
        // Sum of left product & right product: [24,12,8, 6]
        int rightProduct = 1;  // Here, we need to save rightProduct as variable, because we can't use answer-array itself as rightProduct.
                               // answer-array is being used as leftProduct * rightProduct.
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= rightProduct;  // answer is left product * right product
            rightProduct *= nums[i];  // update right product by multiplying me
        }
        
        return answer;
    }
    
}
