package Strings_1;

import java.util.Stack;

public class ReverseVowelsOfaString {

    /***
     *
     *
     *      Problem Statement :
     *      Given a string s, reverse only all the vowels in the string and return it.
     *
     * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases,
     * more than once.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "IceCreAm"
     *
     * Output: "AceCreIm"
     *
     * Explanation:
     *
     * The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".
     *
     * Example 2:
     *
     * Input: s = "leetcode"
     *
     * Output: "leotcede"
     *
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 3 * 105
     * s consist of printable ASCII characters.
     *
     */



    public static String reverseVowels(String s) {
        Stack<Character> vowels = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u' || s.charAt(i)=='A' || s.charAt(i)=='E' || s.charAt(i)=='I' || s.charAt(i)=='O' || s.charAt(i)=='U')
                vowels.push(s.charAt(i));
        }
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u' || s.charAt(i)=='A' || s.charAt(i)=='E' || s.charAt(i)=='I' || s.charAt(i)=='O' || s.charAt(i)=='U')
                s=s.substring(0,i)+vowels.pop()+s.substring(i+1,s.length());
        }
        return s;
    }

    public static void main(String[] args) {
        String str1 = "IceCreAm";
        System.out.println(reverseVowels(str1));
    }


}
