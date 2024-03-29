/**
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 * @author liujing
 *
 */
public class _52_NQueensII {
	int count = 0;//count不能当作参数进行传递，因为是基本类型，是进行值传递，所以最终return时的count值都会是初始值
	public int totalNQueens(int n){
		
		boolean[] fcol = new boolean[n];
		boolean[] f45 = new boolean[2*n-1];
		boolean[] f135 = new boolean[2*n-1];
		backtracking(n,0,fcol,f45,f135);
		return count;
	}
	
	public void backtracking(int n, int row, boolean[] fcol, boolean[] f45, boolean[] f135){
		if(row == n){
			count++;
			return;
		}
		for(int col = 0; col < n; col++){
			if(fcol[col] || f45[col+row] || f135[n-1+col-row]) continue;
			fcol[col] = f45[col+row] = f135[n-1+col-row] = true;
			backtracking(n,row+1,fcol,f45,f135);
			fcol[col] = f45[col+row] = f135[n-1+col-row] = false;
		}
	}

	public static void main(String[] args) {
		_52_NQueensII test = new _52_NQueensII();
		System.out.println(test.totalNQueens(4));
	}

}
