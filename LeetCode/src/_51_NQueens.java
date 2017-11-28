import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 * @author liujing
 *
 */
public class _51_NQueens {
	
	public List<List<String>> solveNQueens(int n){
		if(n <= 0) return new ArrayList<List<String>>();
		
		List<List<String>> res = new ArrayList<List<String>>();
		List<String> cur = new ArrayList<String>(n);
		StringBuilder sb = new StringBuilder(n);
		for(int i = 0; i < n; i++)
			sb.append('.');
		String str = sb.toString();
		for(int i = 0; i < n; i++) // 
			cur.add(str);
//		solve(n,res, cur, 0);
		solve2(n,res,cur,0,new boolean[n],new boolean[2*n-1],new boolean[2*n-1]);
		return res;
	}
	//由于每一层肯定只能有一个queen，所以当递归到queens层时，不需要使用两层循环去遍历
	private void solve(int n, List<List<String>> res, List<String> current, int queens){
		if(queens == n){
			res.add(new ArrayList<String>(current));
			return;
		}
		for(int col = 0; col < n; col++){
			if(isValid(current,queens,col)){
				setChar(current,queens,col,'Q');
				solve(n,res,current,queens+1);
				setChar(current,queens,col,'.');
			}
		}
	}
	
	private void setChar(List<String> cur, int i, int j, char c){
		StringBuilder sb = new StringBuilder(cur.get(i));
		sb.setCharAt(j, c);
		cur.set(i, sb.toString());
	}
	
	private boolean isValid(List<String> cur, int x, int y){
		int n = cur.size();
		//检查同一行是否有queen
		for(int i = 0; i < n; i++)
			if(cur.get(i).charAt(y)=='Q')
				return false;
		//检查左上方
		for(int i = x-1, j=y-1; i>=0 && j>=0; --i,--j)
			if(cur.get(i).charAt(j) == 'Q')
				return false;
		//检查右上方
		for(int i = x-1, j=y+1; i>=0 && j<n; --i,++j)
			if(cur.get(i).charAt(j) == 'Q')
				return false;
		return true;
	}
	/**
	 * The number of columns is n, the number of 45° diagonals is 2 * n - 1, 
	 * the number of 135° diagonals is also 2 * n - 1. When reach [row, col], 
	 * the column No. is col, the 45° diagonal No. is row + col and t
	 * he 135° diagonal No. is n - 1 + col - row. We can use three arrays to 
	 * indicate if the column or the diagonal had a queen before, if not, 
	 * we can put a queen in this position and continue.
	 */
	private void solve2(int n, List<List<String>> res, List<String> current, int row,boolean[] flag_col, boolean[] flag_45, boolean[] flag_135){
		if(row == n){
			res.add(new ArrayList<String>(current));
			return;
		}
		for(int col = 0; col < n; col++){
			if(!flag_col[col] && !flag_45[col+row] && !flag_135[n-1+col-row]){
				flag_col[col] = flag_45[row + col] = flag_135[n - 1 + col - row] = true;
				setChar(current,row,col,'Q');
				solve2(n,res,current,row+1,flag_col,flag_45,flag_135);
				setChar(current,row,col,'.');
				flag_col[col] = flag_45[row + col] = flag_135[n - 1 + col - row] = false;
			}
		}
	}

	public static void main(String[] args) {
		_51_NQueens test = new _51_NQueens();
		List<List<String>> res = test.solveNQueens(4);
		for(List<String> l : res){
			for(String s : l){
				System.out.println(s);
			}
			System.out.println("---------");
		}
	}

}
