package Strings_1;

import java.util.HashMap;

public class ValidAnagram {

    /***
     *
     *
     *      Problem Statement :
     *          Given two strings s and t, return true if t is an anagram of s, and false otherwise.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "anagram", t = "nagaram"
     *
     * Output: true
     *
     * Example 2:
     *
     * Input: s = "rat", t = "car"
     *
     * Output: false
     *
     *
     *
     * Constraints:
     *
     * 1 <= s.length, t.length <= 5 * 104
     * s and t consist of lowercase English letters.
     */


    public static boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> freq = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            freq.put(s.charAt(i),freq.containsKey(s.charAt(i))?freq.get(s.charAt(i))+1:1);
        }
        for(int i=0;i<t.length();i++)
        {
            if(!freq.containsKey(t.charAt(i)))
                return false;
            freq.put(t.charAt(i),freq.get(t.charAt(i))-1);
        }
        for(int value : freq.values())
        {
            if(value!=0)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "anagram", t = "nagaram" ;
        System.out.println(isAnagram(s,t));
    }


}
