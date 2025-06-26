package Arrays_1;

import java.util.Arrays;

public class SortColors {

    /***
     *
     *  Problem Statement :
     *      Given an array nums with n objects colored red, white, or blue, sort them in-place
     *      so that objects of the same color are adjacent, with the colors in the order red, white,
     *      and blue.
     *
     * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
     *
     * You must solve this problem without using the library's sort function.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,0,2,1,1,0]
     * Output: [0,0,1,1,2,2]
     * Example 2:
     *
     * Input: nums = [2,0,1]
     * Output: [0,1,2]
     *
     *
     * Constraints:
     *
     * n == nums.length
     * 1 <= n <= 300
     * nums[i] is either 0, 1, or 2.
     *
     *
     * Follow up: Could you come up with a one-pass algorithm using only constant extra space?
     *
     */

    public static void sortColors(int[] nums) {
        int fl0=0;
        int fl2=nums.length-1;
        int fl1=0;
        for(int i=0;i<=fl2;i++)
        {
            if(nums[i]==0)
            {
                if(nums[fl0]!=0)
                {
                    nums[i]=nums[fl0];
                    nums[fl0]=0;
                }
                if(fl0!=i)
                    i--;
                fl0+=1;
            }
            else if(nums[i]==2)
            {
                if(nums[fl2]!=2)
                {
                    nums[i]=nums[fl2];
                    nums[fl2]=2;
                }
                fl2-=1;
                i--;
            }

        }
    }

    public static void main(String[] args) {
        int nums[]={2,0,2,1,1,0};
        sortColors(nums);
        Arrays.stream(nums).forEach(System.out::print);
    }
}
