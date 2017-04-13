/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
 * @author liujing
 *
 */
public class _62_UniquePaths {
	
	public int uniquePaths(int m, int n){
		
		if(n <= 0 || m <= 0) return 0;
		
		if(n == 1 || m == 1) return 1;
		
		int[][] dp = new int[m][n];
		for(int i = 1; i < m; i++)//initial
			dp[i][0] = 1;
		for(int i = 1; i < n; i++)
			dp[0][i] = 1;
		
		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++){
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		
		return dp[m-1][n-1];
	}

	public static void main(String[] args) {
		_62_UniquePaths test = new _62_UniquePaths();
		System.out.println(test.uniquePaths(2, 2));
	}

}