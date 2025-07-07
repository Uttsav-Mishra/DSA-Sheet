package Strings_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    /***
     *
     *
     *      Problem Statement :
     *          Given an array of strings strs, group the anagrams together.
     *          You can return the answer in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     *
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     *
     * Explanation:
     *
     * There is no string in strs that can be rearranged to form "bat".
     * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
     * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
     * Example 2:
     *
     * Input: strs = [""]
     *
     * Output: [[""]]
     *
     * Example 3:
     *
     * Input: strs = ["a"]
     *
     * Output: [["a"]]
     *
     *
     *
     * Constraints:
     *
     * 1 <= strs.length <= 104
     * 0 <= strs[i].length <= 100
     * strs[i] consists of lowercase English letters.
     */

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> groupedAnagram = new HashMap<>();
        for(int i=0;i<strs.length;i++)
        {
            String key = getKey(strs[i]);
            List<String> newAnagramGroup = new ArrayList<>();
            if(groupedAnagram.containsKey(key))
                newAnagramGroup=groupedAnagram.get(key);
            newAnagramGroup.add(strs[i]);
            groupedAnagram.put(key,newAnagramGroup);
        }
        List<List<String>> result = new ArrayList<>();
        for(List<String> eachAnagramGroup : groupedAnagram.values() )
            result.add(eachAnagramGroup);
        return result;
    }

    public static String getKey(String s)
    {
        int alpha[] = new int[26];
        for(int i=0;i<s.length();i++)
        {
            alpha[s.charAt(i)-'a']++;
        }
        String key = "";
        for(int i=0;i<26;i++)
        {
            key+="#"+alpha[i];
        }
        return key;
    }


    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> anagramGroups = groupAnagrams(strs);
        anagramGroups.stream().forEach(a->{
            a.stream().forEach(b->System.out.print(b+" "));
            System.out.println();
        });

    }
}
