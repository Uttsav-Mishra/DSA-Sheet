package Arrays_2;

public class GreatestCommonDivisorofStrings {


    /***
     *
     *
     *      Problem Statement :
     *
     *      For two strings s and t, we say "t divides s" if and only if
     *      s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
     *
     * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
     *
     *
     *
     * Example 1:
     *
     * Input: str1 = "ABCABC", str2 = "ABC"
     * Output: "ABC"
     * Example 2:
     *
     * Input: str1 = "ABABAB", str2 = "ABAB"
     * Output: "AB"
     * Example 3:
     *
     * Input: str1 = "LEET", str2 = "CODE"
     * Output: ""
     *
     *
     * Constraints:
     *
     * 1 <= str1.length, str2.length <= 1000
     * str1 and str2 consist of English uppercase letters.
     *
     **/

    public static String gcdOfStrings(String str1, String str2) {
        if((str1+str2).equals(str2+str1))
            for(int i=str2.length();i>=0;i--)
            {
                if(str1.length()%(i+1)==0 && str2.length()%(i+1)==0)
                {
                    if((str2.substring(0,i+1).repeat(str1.length()/(i+1)).equals(str1))
                            &&(str2.substring(0,i+1).repeat(str2.length()/(i+1)).equals(str2)))
                        return str2.substring(0,i+1);
                }
            }

        return "";
    }

    public static void main(String[] args) {
        String str1 = "ABABAB", str2 = "ABAB";
        System.out.println(gcdOfStrings(str1,str2));
    }
}
