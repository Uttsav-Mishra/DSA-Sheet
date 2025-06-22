package DynamicProgramming.KnapSack_0_1;

import java.util.Arrays;

public class KnapSack0_1 {

    /***
     *
     * Problem statement
     * A thief is robbing a store and can carry a maximal weight of W into his knapsack.
     * There are N items and the ith item weighs wi and is of value vi. Considering the constraints
     * of the maximum weight that a knapsack can carry, you have to find and return the maximum value
     * that a thief can generate by stealing items.
     *
     * Detailed explanation ( Input/output format, Notes, Images )
     * Constraints:
     * 1 <= T <= 10
     * 1 <= N <= 10^2
     * 1<= wi <= 50
     * 1 <= vi <= 10^2
     * 1 <= W <= 10^3
     *
     * Time Limit: 1 second
     * Sample Input:
     * 1
     * 4
     * 1 2 4 5
     * 5 4 8 6
     * 5
     * Sample Output:
     * 13
     *
     */

    static int knapsack(int[] weight, int[] value, int n, int maxWeight,int dp[][]) {
        if(maxWeight==0)
            return 0;
        if(n==0)
            return 0;
        if(dp[n][maxWeight]!=-1)
            return dp[n][maxWeight];
        if(maxWeight<weight[n-1])
            return dp[n][maxWeight] = knapsack(weight,value,n-1,maxWeight,dp);
        return dp[n][maxWeight] = Math.max(value[n-1]+knapsack(weight,value,n-1,maxWeight-weight[n-1],dp),knapsack(weight,value,n-1,maxWeight,dp));
    }
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

        int dp[][] = new int[n+1][maxWeight+1];
        for(int i=0;i<n+1;i++)
            Arrays.fill(dp[i],-1);
        return knapsack(weight,value,n,maxWeight,dp);
    }

    public static void main(String args[])
    {
        int[] weight = {1,2,4,5};
        int[] value  =  {5,4,8,6};
        int n = 4 ;
        int maxWeight = 5;
        System.out.println(knapsack(weight,value,n,maxWeight));
    }
}
