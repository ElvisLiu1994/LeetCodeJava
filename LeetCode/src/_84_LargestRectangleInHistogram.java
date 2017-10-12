/**
 * 
 *
 */
public class _84_LargestRectangleInHistogram {
	
	/**
	 * 利用DP算法，dp[i]表示前i+1个数所能形成的最大矩形，在每一步中，有一个矩形加入，这个矩形要么能够形成更大的
	 * 矩形，要么不会，所以依次向前遍历包含该矩形的最大面积，再与前面的dp值进行比较，判断是否会形成更大的面积，
	 * 时间复杂度为O(n^2)，本质上是暴力求解; 95/96个test通过，最后一个全为1的大数组超时
	 */
	public int largestRectangleArea(int[] heights) {
		
		if(heights == null || heights.length == 0) return 0;
		
		int[] dp = new int[heights.length];
		dp[0] = heights[0];
		
		for(int i = 1; i < heights.length; i++){
			int tmp = heights[i];
			int min = heights[i];
			for(int j = i-1; j >= 0; j--){
				if(heights[j] < min) min = heights[j];
				tmp = Math.max(tmp, min*(i - j + 1));
			}
			dp[i] = Math.max(dp[i-1], tmp);
		}
		
		return dp[heights.length-1];
	}
	
	/**
	 * 
	 */
//	public int largestRectangleArea1(int[] heights){
//		if(heights == null || heights.length == 0) return 0;
//		
//	}

	public static void main(String[] args) {
		_84_LargestRectangleInHistogram test = new _84_LargestRectangleInHistogram();
		System.out.println(test.largestRectangleArea(new int[]{0,9}));
	}

}
