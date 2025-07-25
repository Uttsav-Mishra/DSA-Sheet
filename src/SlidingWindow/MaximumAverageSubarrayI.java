package SlidingWindow;

public class MaximumAverageSubarrayI {


    /***
     *
     *
     *      Problem Statement :
     *      You are given an integer array nums consisting of n elements, and an integer k.
     *
     * Find a contiguous subarray whose length is equal to k that has the maximum average
     * value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,12,-5,-6,50,3], k = 4
     * Output: 12.75000
     * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
     * Example 2:
     *
     * Input: nums = [5], k = 1
     * Output: 5.00000
     *
     *
     * Constraints:
     *
     * n == nums.length
     * 1 <= k <= n <= 105
     * -104 <= nums[i] <= 104
     */



    public static double findMaxAverage(int[] nums, int k) {
        int sum=0,i=0,max=Integer.MIN_VALUE;
        for(int j=0;j<nums.length;j++)
        {

            sum+=nums[j];

            if(j-i+1==k)
            {
                max=Math.max(max,sum);
                sum-=nums[i];
                i++;
            }
        }
        System.out.println(max);
        return (double)max/(double)k;
    }

    public static void main(String[] args) {
        int[] nums={1,12,-5,-6,50,3};
        int k=4;

        System.out.println(findMaxAverage(nums,k));
    }
}
