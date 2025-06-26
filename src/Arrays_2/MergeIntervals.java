package Arrays_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    /***
     *
     *          Problem Statement :
     *          Given an array of intervals where intervals[i] = [starti, endi],
     *          merge all overlapping intervals, and return an array of the non-overlapping
     *          intervals that cover all the intervals in the input.
     *
     *
     * Example 1:
     *
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
     * Example 2:
     *
     * Input: intervals = [[1,4],[4,5]]
     * Output: [[1,5]]
     * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
     *
     *
     * Constraints:
     *
     * 1 <= intervals.length <= 104
     * intervals[i].length == 2
     * 0 <= starti <= endi <= 104
     *
     *
     *
     */

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[][] mergeIntervals = new int[intervals.length][2];
        int[] curInterval = null;
        int cnt=0;
        for(int i=0;i<intervals.length;i++)
        {
            if(i==0 || curInterval[1]<intervals[i][0])
            {
                if(i!=0) {
                    mergeIntervals[cnt] = curInterval;
                    cnt++;
                }
                curInterval=new int[2];
                curInterval[0]=intervals[i][0];
                curInterval[1]=intervals[i][1];
            }
            else
            {
                curInterval[0]=Math.min(curInterval[0],intervals[i][0]);
                curInterval[1]=Math.max(curInterval[1],intervals[i][1]);
            }
        }
        mergeIntervals[cnt]=curInterval;
        int [][] mergedInterval = new int[cnt+1][2];
        for(int i=0;i<cnt+1;i++)
        {
            mergedInterval[i][0]=mergeIntervals[i][0];
            mergedInterval[i][1]=mergeIntervals[i][1];
        }
        return mergedInterval;
    }

    public static void main(String[] args) {
        int[][] intervals={{1,3},{2,6},{8,10},{15,18}};
        intervals = merge(intervals);
        Arrays.stream(intervals).forEach((a)-> {
            Arrays.stream(a).forEach(b->System.out.print(b+","));
        System.out.println();});

    }
}
