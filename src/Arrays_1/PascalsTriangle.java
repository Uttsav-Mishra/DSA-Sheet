package Arrays_1;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    /***
     *
     *      Problem Statement :
     *      Given an integer numRows, return the first numRows of Pascal's triangle.
     *
     * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
     *
     *
     *
     *
     * Example 1:
     *
     * Input: numRows = 5
     * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
     * Example 2:
     *
     * Input: numRows = 1
     * Output: [[1]]
     *
     *
     * Constraints:
     *
     * 1 <= numRows <= 30
     *
     *
     *
     */

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for(int i=0;i<numRows;i++)
        {
            List<Integer> rows = new ArrayList<>();
            rows.add(1);
            for(int j=1;j<i;j++)
                rows.add(pascalTriangle.get(i-1).get(j-1)+pascalTriangle.get(i-1).get(j));
            if(i>0)
                rows.add(1);
            pascalTriangle.add(rows);
        }
        return pascalTriangle;
    }

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> pascalsTriangle = generate(numRows);
        pascalsTriangle.stream().forEach(a-> {
            a.stream().forEach(System.out::print);
            System.out.println();
        });
    }
}
