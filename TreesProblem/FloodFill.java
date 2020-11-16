package recursion;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int row = image.length;
        int column = image[0].length;

        if(image[sr][sc] != newColor){

            floodFillUtil(image, sr, sc, image[sr][sc], newColor, row, column);
        }
        return image;
    }

    public void floodFillUtil(int[][] image, int sr, int sc, int currColor, int newColor, int row, int column){

        if(sr < 0 || sr > row-1 || sc < 0 || sc > column-1) return;

        System.out.println("Inside for row: " + sr);
        if(currColor == image[sr][sc]){

            image[sr][sc] = newColor;
            floodFillUtil(image, sr-1, sc,  currColor, newColor, row, column);
            floodFillUtil(image, sr+1, sc,  currColor,newColor, row, column);
            floodFillUtil(image, sr, sc-1,  currColor, newColor, row, column);
            floodFillUtil(image, sr, sc+1,  currColor,newColor, row, column);
        }

    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        FloodFill f = new FloodFill();
        f.floodFill(matrix, 1,1,2);
    }
}
