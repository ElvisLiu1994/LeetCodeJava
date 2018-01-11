/**
Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
 *
 */
public class _115_DistinctSubsequences {
    /*
     * 首先想到的是动态规划的方法,根据s的长度为i的前缀中t的个数，来求长度为i+1的前缀中t的个数
     */
    public static int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        // 边界情况
        if(m < n || m == 0) return 0;
        if(m == n && s.equals(t)) return 1;
        
        int[][] dp = new int[m+1][n+1]; //虽然dp是一个局部变量，但是由于使用了new关键字，所以是在堆上分配了内存空间，然后进行了初始化为默认值。
        for(int i = 0; i <= m; i++)
            dp[i][0] = 1; // 所有的串都包含1个空串
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) { // 这里也可以用(j<=i && j<=n)结果是一样的
                if(s.charAt(i-1) != t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                }
            }
        }
        
        return dp[m][n];
    }

    public static void main(String[] args) {
        int res = numDistinct("ccc", "c");
        System.out.println(res);
        
        with("Hello").say();
    }
    
    public static test with(String s) {
        
        return new test() {
            public void say() {
                //! s = "world"; Local variable s defined in an enclosing scope must be final or effectively final
                System.out.println(s);
            }
        };
    }

}

class test{
    int x = 0;
    
    public void say() {
        
    }
}