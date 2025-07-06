package Arrays_2;

public class CanPlaceFlowers {

    /***
     *
     *
     *      Problem Statement :
     *      You have a long flowerbed in which some of the plots are planted, and some are not.
     *      However, flowers cannot be planted in adjacent plots.
     *
     * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty,
     * and an integer n, return true if n new flowers can be planted in the flowerbed without violating
     * the no-adjacent-flowers rule and false otherwise.
     *
     *
     *
     * Example 1:
     *
     * Input: flowerbed = [1,0,0,0,1], n = 1
     * Output: true
     * Example 2:
     *
     * Input: flowerbed = [1,0,0,0,1], n = 2
     * Output: false
     *
     *
     * Constraints:
     *
     * 1 <= flowerbed.length <= 2 * 104
     * flowerbed[i] is 0 or 1.
     * There are no two adjacent flowers in flowerbed.
     * 0 <= n <= flowerbed.length
     *
     */


    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i=-2;
        int j=0,cnt=0;
        for(j=0;j<flowerbed.length+2;j++)
        {
            if((j<flowerbed.length && flowerbed[j]==1) || j==flowerbed.length+1)
            {
                int emptybeds = j-i-1-2;
                if(emptybeds>0)
                {
                    cnt+=((emptybeds)/2)+((emptybeds)%2);
                    System.out.println(cnt+"--"+i+"-"+j);
                }
                i=j;
            }
            if(cnt>=n)
                return true;
        }
        return false;
    }


    public static void main(String[] args) {
        int[] flowerbed={1,0,0,0,1};
        int n=2;
        System.out.println(canPlaceFlowers(flowerbed,n));
    }
}
