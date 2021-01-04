package Graph;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int count = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){

                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(grid,i,j,row,col,visited);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int crow, int ccol, int row, int col, boolean[][] visited){

        if(crow < 0 || crow >= row || ccol < 0 || ccol >= col || grid[crow][ccol] == '0' || visited[crow][ccol]) return;

        int row_arr[] = {-1, 1, 0, 0};
        int col_arr[] = {0, 0, -1, 1};

        visited[crow][ccol] = true;
        for(int i=0;i<4;i++){
            dfs(grid, crow+row_arr[i], ccol+col_arr[i],row,col,visited);
        }
    }
}
