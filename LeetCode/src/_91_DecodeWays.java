/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways 
 * to decode it.

 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 * @author liujing
 *
 */
public class _91_DecodeWays {
	
	/**
	 * 考虑递归，对于当前字符串s，我们可以只decode一个字符，或者decode两个字符（如果合法的话），
	 * 然后将剩下的进行递归求解，对每一步之间的数目相乘得到最终结果。
	 */
	public static int numDecodings(String s) {
		// 由于s为空时，需要返回1，该逻辑不能直接用于下面的递归函数，所以单独列出来，再使用下面的递归函数
		if(s.length() == 0) return 0;
		
		// 进行递归求解
		return recurse(s);
			
	}
	
	public static int recurse(String s) {
		//下面三个判断语句为递归出口函数
		
		//当传递进来的s子串为空时，说明上一次切在字符串尾部: 23/
		if(s.length() == 0) return 1;
		//当传递进来的s子串以0开头时，字符串不合法，返回0: 2/3/0; 23/0
		if(s.charAt(0) == '0') return 0; 
		//当字符串长度为1时，说明上一次切完后只剩1个字符了：2/3
		if(s.length() == 1) return 1;
		
		return recurse(s.substring(1)) +
				((Integer.valueOf(s.substring(0, 2)) > 26) ? 0 : recurse(s.substring(2)));
		
	}
	
	/**
	 * 由于递归算法在处理比较长的数据时超时了，所以改用DP算法实现
	 */
	public static int numDecodings1(String s) {
		int len = s.length();
		if(len == 0) return 0;
		
		int[] dp = new int[len+1];
		dp[0] = 1; 
		dp[1] = (s.charAt(0) == '0') ? 0 : 1;
		
		for(int i = 2; i <= len; i++) {
			int first = Integer.valueOf(s.substring(i-1, i));
			int second = Integer.valueOf(s.substring(i-2, i));
			if(first >= 1 && first <= 9)
				dp[i] += dp[i-1];
			if(second >= 10 && second <=26)
				dp[i] += dp[i-2];
		}
		
		return dp[len];
	}

	public static void main(String[] args) {
		System.out.println(numDecodings1("9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253"));
		System.out.println(numDecodings1("23"));
	}

}
