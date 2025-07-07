package Arrays_1;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    /***
     *
     *
     *      Problem Statement :
     *          Given an array of integers nums and an integer target,
     *          return indices of the two numbers such that they add up to target.
     *
     * You may assume that each input would have exactly one solution, and you may
     * not use the same element twice.
     *
     * You can return the answer in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     * Example 2:
     *
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     * Example 3:
     *
     * Input: nums = [3,3], target = 6
     * Output: [0,1]
     *
     *
     * Constraints:
     *
     * 2 <= nums.length <= 104
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     */


    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        int indexes[]=new int [2];
        for(int i=0;i<nums.length;i++)
        {
            freq.put(nums[i],freq.containsKey(nums[i])?freq.get(nums[i])+1:1);
        }

        for(int i=0;i<nums.length;i++)
        {
            freq.put(nums[i],freq.get(nums[i])-1);
            if(freq.containsKey(target-nums[i]) && freq.get(target-nums[i])>0)
            {
                indexes[0]=i;
                break;
            }
        }
        for(int i=indexes[0]+1;i<nums.length;i++)
        {
            if(nums[i]==target-nums[indexes[0]])
            {
                indexes[1]=i;
                break;
            }
        }
        return indexes;
    }

    public static void main(String[] args) {
        int nums[] = {2,7,11,15};
        int target =9;
        int indexes[] = twoSum(nums,target);
        Arrays.stream(indexes).forEach(System.out::println);
    }

}
