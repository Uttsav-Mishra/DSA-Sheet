package Strings_1;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ValidPalindrome {

    /***
     *
     *
     *      Problem Statement :
     *      A phrase is a palindrome if, after converting all uppercase letters
     *      into lowercase letters and removing all non-alphanumeric characters,
     *      it reads the same forward and backward. Alphanumeric characters include
     *      letters and numbers.
     *
     * Given a string s, return true if it is a palindrome, or false otherwise.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "A man, a plan, a canal: Panama"
     * Output: true
     *
     * Explanation: "amanaplanacanalpanama" is a palindrome.
     * Example 2:
     *
     * Input: s = "race a car"
     * Output: false
     * Explanation: "raceacar" is not a palindrome.
     * Example 3:
     *
     * Input: s = " "
     * Output: true
     * Explanation: s is an empty string "" after removing non-alphanumeric characters.
     * Since an empty string reads the same forward and backward, it is a palindrome.
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 2 * 105
     * s consists only of printable ASCII characters.
     *
     */

    public static boolean isPalindrome(String s) {
        String palindrome = "";
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                palindrome+=c ;
            }
        }
        palindrome = palindrome.toLowerCase();
        return checkPalindrome(palindrome);
    }
    public static boolean checkPalindrome(String palindrome)
    {
        int i=0;
        int j=palindrome.length()-1;
        while(i<j)
        {
            if(palindrome.charAt(i)!=palindrome.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String args[])
    {
        int nums[] ={1,2,3,1,3,1};
        int k=2;
        String checkPalindromeStatement = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(checkPalindromeStatement));
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(freq.containsKey(nums[i]))
                freq.put(nums[i],freq.get(nums[i])+1);
            else
                freq.put(nums[i],1);
        }

        for(Map.Entry<Integer,Integer>sortFreq : freq.entrySet().stream().sorted((a, b)->a.getValue()-b.getValue()).collect(Collectors.toCollection());

    }
}
