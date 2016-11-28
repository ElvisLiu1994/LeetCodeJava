package algorithm.assignment;
/**
 * Given a string s, partition s such that every substring of the partition is 
 * a palindrome. Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s = “aab”, return 1 since the palindrome 
 * partitioning [“aa”, “b”] could be produced using 1 cut.
 * @author liujing
 *
 */
public class _132_PalindromePartition2 {
	
	//填表格时不一定挨着填，这里是通过对每一个i来找回文串，然后在回文串的位置填数据。
	public int minCut(String s){
		if(s == null || s.length() == 0) return 0;
		
		int n = s.length();
		char[] c = s.toCharArray();
		int[] DP = new int[n+1];
		//initial
		for(int i = 0; i <= n; i++) DP[i] = i-1;
		//DP
		for(int i = 0; i < n; i++){
			for(int a = i, b = i; a>=0 && b<n && c[a]==c[b]; a--,b++)
				DP[b+1] = Math.min(DP[b+1], DP[a]+1);
			for(int a = i, b = i+1; a>=0 && b<n && c[a]==c[b]; a--,b++)
				DP[b+1] = Math.min(DP[b+1], DP[a]+1);
		}
		return DP[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
