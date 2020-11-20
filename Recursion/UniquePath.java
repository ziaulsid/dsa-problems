package recursion;

class UniquePaths {
	
    public int uniquePaths(int m, int n) {
        
        if (m == 1 || n == 1) return 1;
        
        return uniquePaths(m, n-1) + uniquePaths(n, m-1);
        
    }
}
