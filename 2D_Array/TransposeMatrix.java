package TwoDimensionalMatrix;

/*PROBLEM DESCRIPTION:
        Given a matrix A, return the transpose of A.
        The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.

        Example 1:

        Input: [[1,2,3],[4,5,6],[7,8,9]]
        Output: [[1,4,7],[2,5,8],[3,6,9]]

        Example 2:

        Input: [[1,2,3],[4,5,6]]
        Output: [[1,4],[2,5],[3,6]]*/
public class TransposeMatrix {

    public int[][] transpose(int[][] A) {


        if(A.length == 0) return A;

        int row = A.length;
        int col = A[0].length;

        int[][] result = new int[col][row];

        for(int i=0; i<row; i++){

            for(int j=0; j<col; j++){
                result[j][i] = A[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        TransposeMatrix transposeMatrix = new TransposeMatrix();
        transposeMatrix.transpose(matrix);
    }

}
