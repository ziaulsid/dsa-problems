package TwoDimensionalMatrix;

/*PROBLEM DESCRIPTION:

        You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
        You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

        Example 1:
        Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
        Output: [[7,4,1],[8,5,2],[9,6,3]]*/

public class RotateImage {

    public void rotate(int[][] A) {

        if(A.length == 0) return;

        int row = A.length;
        int col = A[0].length;

        /*1. Find the Transpose of the given matrix*/
        for (int i = 0; i < row; i++) {

            for (int j = i; j < col; j++) {

                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
        /*2. Reverse the rows - Clock Wise Rotation*/

        for (int i = 0; i < row; i++){

            for(int j = 0; j < col/2; j++){

                int temp = A[i][j];
                A[i][j] = A[i][col-1-j];
                A[i][col-1-j] = temp;
            }
        }

        /*3. Reverse the columns - Anti Clock Wise Rotation*/
        for (int i = 0; i < col; i++){

            for(int j = 0; j < row/2; j++){

                int temp = A[j][i];
                A[j][i]= A[row-1-j][j];
                A[row-1-j][j] = temp;
            }
        }
    }
}
