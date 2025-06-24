package Arrays;

import java.util.Arrays;

public class SetMatrixZeroes {

    /***
     *
     *      Problem Statement :
     *      Given an m x n integer matrix matrix, if an element is 0, set its entire row and column
     *      to 0's.
     *
     * You must do it in place.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
     * Output: [[1,0,1],[0,0,0],[1,0,1]]
     * Example 2:
     *
     *
     * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
     * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
     *
     *
     * Constraints:
     *
     * m == matrix.length
     * n == matrix[0].length
     * 1 <= m, n <= 200
     * -231 <= matrix[i][j] <= 231 - 1
     */

    public static void setZeroes(int[][] matrix) {
        int fl[] = new int[401];
        int ind = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 400 && matrix[i][j] >= 0)
                    fl[matrix[i][j]] = 1;
            }
        }
        for (int i = 0; i < 401; i++)
            if (fl[i] == 0) {
                ind = i;
                break;
            }
        int col = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (j == 0) {
                        matrix[i][0] = ind;
                        col = ind;
                    } else {
                        matrix[i][0] = ind;
                        matrix[0][j] = ind;
                    }
                }
            }
        }

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[i].length - 1; j > 0; j--) {
                if (matrix[i][0] == ind || matrix[0][j] == ind)
                    matrix[i][j] = 0;
            }
        }
        for (int i = 0; i < matrix.length; i++)
            if (matrix[i][0] == ind || col == ind)
                matrix[i][0] = 0;
    }


    public static void main(String[] args) {
        int matrix[][] = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
        Arrays.stream(matrix).forEach(a->{
            Arrays.stream(a).forEach(System.out::print);
            System.out.println();
        });
    }
}
