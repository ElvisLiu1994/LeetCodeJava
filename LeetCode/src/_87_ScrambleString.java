/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 *
 */
public class _87_ScrambleString {
	/**
	 * 当字符串的长度为3时，可以通过不同的二叉树以及scramble获得所有6种排列方式，以此为基础进行推断
	 * 当字符串的长度为4时，在3的基础上，第4个字符可以通过scramble插入字符串的任意位置。
	 * 依此推断，只需要两个字符串所包含的字符是一样的，那么它们就是scrambled的。
	 * 难点在于两个字符串中有重复的字符时，重复字符的数量还要相等，所以不能简单地使用set来实现。
	 * 
	 * WRONG: abcd  bdac
	 */
	public static boolean isScramble1(String s1, String s2){
		if(s1.length() != s2.length()) return false;
		
		int len = s1.length();
		int[] hash = new int[256];
		
		for(char c: s1.toCharArray()) {
			hash[c]++;
		}
		
		for(char c : s2.toCharArray()) {
			hash[c]--;
		}
		
		for(int x : hash) {
			if(x != 0) return false;
		}
		
		return true;
	}
	
	public static boolean isScramble(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		
		
	}

	public static void main(String[] args) {
		System.out.println(isScramble("great", "rgtae"));
	}

}
