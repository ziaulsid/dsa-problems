public class SubsetSum {

    public static void main(String[] args) {
        int[] A = { 68, 35, 1, 70, 25, 79, 59, 63, 65, 6, 46};
        solve(A, 282);
    }

    public static int solve(int[] A, int B) {

        int[][] matrix = new int[A.length+1][B+1];

        for(int i=0; i<A.length+1; i++){
            matrix[i][0] = 1;
        }

        for(int i=1; i<A.length+1; i++){
            for(int j=1; j<B+1; j++){

                if(A[i-1] <= j){
                    matrix[i][j] = matrix[i-1][j-A[i-1]] | matrix[i-1][j];
                }else{
                    matrix[i][j] = matrix[i-1][j];
                }

            }
        }

        return matrix[A.length][B];
    }
}
