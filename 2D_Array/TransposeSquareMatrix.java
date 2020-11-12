package TwoDimensionalMatrix;

/*PROBLEM DESCRIPTION:
        A Square Matrix is a matrix with equal number of rows and columns
        Given a square matrix A, return the transpose of A.
        The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.

        Example 1:

        Input: [[1,2,3],[4,5,6],[7,8,9]]
        Output: [[1,4,7],[2,5,8],[3,6,9]]*/

public class TransposeSquareMatrix {

    public int[][] transpose(int[][] A) {

        if (A.length == 0) return A;

        int row = A.length;
        int col = A[0].length;

        for (int i = 0; i < row; i++) {

            for (int j = i; j < col; j++) {

                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
        return A;
    }
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        TransposeSquareMatrix transposeSquareMatrix = new TransposeSquareMatrix();
        transposeSquareMatrix.transpose(matrix);
    }
}
