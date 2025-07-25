package Arrays_2;

import java.util.Arrays;

public class RotateImage {


    /***
     *
     *      Problem Statement :
     *
     *      You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees
     *      (clockwise).
     *
     * You have to rotate the image in-place, which means you have to modify the input 2D matrix
     * directly. DO NOT allocate another 2D matrix and do the rotation.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * Output: [[7,4,1],[8,5,2],[9,6,3]]
     * Example 2:
     *
     *
     * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
     * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
     *
     *
     * Constraints:
     *
     * n == matrix.length == matrix[i].length
     * 1 <= n <= 20
     * -1000 <= matrix[i][j] <= 1000
     *
     *
     */

    public static void rotate(int[][] matrix) {
        rotateBy90(matrix,0,0,matrix.length);
    }
    public static void rotateBy90(int matrix[][],int i,int j,int n)
    {
        if(n<=1)
            return;
        for(int k=0;k<n-1;k++)
        {
            int a=matrix[i][j+k];
            matrix[i][j+k]=matrix[i+n-1-k][j];
            matrix[i+n-1-k][j]=matrix[i+n-1][j+n-1-k];
            matrix[i+n-1][j+n-1-k]=matrix[i+k][j+n-1];
            matrix[i+k][j+n-1]=a;
        }
        rotateBy90(matrix,i+1,j+1,n-2);
        return;
    }

    public static void main(String[] args) {
        int[][] matrix={{}};
        rotate(matrix);
        Arrays.stream(matrix).forEach(a->{
            Arrays.stream(a).forEach(System.out::print);
            System.out.println();
        });
    }
}
