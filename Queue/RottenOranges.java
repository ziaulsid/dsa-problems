import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges {

    public int orangesRotting(int[][] grid) {

        int minTime = 0;

        Queue<Pair<Integer,Integer>> queue = new ArrayDeque();
        boolean freshOrangesPresent = false;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.add(new Pair(i,j));
                }else if(grid[i][j] == 1){
                    freshOrangesPresent = true;
                }
            }
        }
        if(!freshOrangesPresent) return -1;
        if(queue.size() == 0) return -1;

        while(queue.size() != 0){
            int size = queue.size();

            boolean level = false;
            for (int k = 0; k < size; k++) {
                int row_arr[] = {-1, 1, 0, 0};
                int col_arr[] = {0, 0, -1, 1};

                Pair<Integer,Integer> pair = queue.poll();
                for(int i=0;i<4;i++){
                    int nextRow = pair.getKey() + row_arr[i];
                    int nextCol = pair.getValue() + col_arr[i];

                    if(isValid(nextRow, nextCol, grid.length, grid[0].length) && grid[nextRow][nextCol] == 1){
                        queue.add(new Pair(nextRow,nextCol));
                        grid[nextRow][nextCol] = 2;
                        level = true;
                    }
                }
            }
            if(level) minTime++;
        }

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return minTime;

    }

    private boolean isValid(int nextRow, int nextCol, int row, int column) {

        return nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < column;
    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};

        RottenOranges oranges = new RottenOranges();
        System.out.println(oranges.orangesRotting(grid));
    }
}
