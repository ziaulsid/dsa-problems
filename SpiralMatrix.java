package TwoDimensionalMatrix;

import java.util.ArrayList;
import java.util.List;

/*PROBLEM DESCRIPTION:

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

        Example 1:

        Input:
        [
        [ 1, 2, 3 ],
        [ 4, 5, 6 ],
        [ 7, 8, 9 ]
        ]
        Output: [1,2,3,6,9,8,7,4,5]
        Example 2:

        Input:
        [
        [1, 2, 3, 4],
        [5, 6, 7, 8],
        [9,10,11,12]
        ]
        Output: [1,2,3,4,8,12,11,10,9,5,6,7]*/

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> spiralOrderList = new ArrayList<>();
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = matrix.length-1;
        int colEnd = matrix[0].length-1;
        while (rowStart <= rowEnd && colStart <= colEnd){

            //First Row
            for(int c=colStart; c<=colEnd; c++){

                spiralOrderList.add(matrix[rowStart][c]);
            }
            rowStart++;

            //Last Column
            for(int r=rowStart; r<=rowEnd; r++){

                spiralOrderList.add(matrix[r][colEnd]);
            }
            colEnd--;

            //Last Row
            if(rowStart <= rowEnd){
                for(int r=colEnd; r>=colStart; r--){

                    spiralOrderList.add(matrix[rowEnd][r]);
                }
                rowEnd--;
            }

            //First Column
            if(colStart <= colEnd){

                for(int r=rowEnd; r>=rowStart; r--){

                    spiralOrderList.add(matrix[r][colStart]);
                }
                colStart++;
            }

        }
        return spiralOrderList;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };

        SpiralMatrix spiralMatrix = new SpiralMatrix();
        spiralMatrix.spiralOrder(matrix);
    }
}
