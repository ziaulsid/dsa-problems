package recursion;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        //Find the 1st character

        for(int i=0; i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, word, 0, i, j, row, col)) return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int index, int crow, int ccol, int row, int col){

        if(index == word.length()) return true;

        if(crow < 0 || ccol < 0 || ccol >= col || crow >= row) return false;

        if(board[crow][ccol] != word.charAt(index)) return false;

        board[crow][ccol] = '$';

        boolean result = false;

        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};

        for (int d = 0; d < 4; ++d){
            result = dfs(board, word, index+1, crow+rowOffsets[d], ccol+colOffsets[d], row, col);
            if(result){
                break;
            }
        }

        board[crow][ccol] = word.charAt(index);
        return result;

    }
}
