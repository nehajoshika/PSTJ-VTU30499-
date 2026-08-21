class Solution {
    public int[][] transpose(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }
}

output:

Accepted
Runtime: 0 ms
Case 1
Case 2
Input
matrix =
[[1,2,3],[4,5,6],[7,8,9]]
Output
[[1,4,7],[2,5,8],[3,6,9]]
Expected
[[1,4,7],[2,5,8],[3,6,9]]