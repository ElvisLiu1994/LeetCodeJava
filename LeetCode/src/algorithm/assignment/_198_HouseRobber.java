package algorithm.assignment;
/**
 * A robber is planning to rob houses along a street. Each house has a certain amount 
 * of money stashed, the only constraint stopping you from robbing each of them is 
 * that adjacent houses have security system connected and it will automatically contact 
 * the police if two adjacent houses were broken into on the same night.
 *	   Given a list of non-negative integers representing the amount of money 
 *	   of each house, determine the maximum amount of money you can rob tonight 
 *     without alerting the police.
 * @author liujing
 *
 */
public class _198_HouseRobber {
	
	public int rob(int[] nums){
		if(nums == null || nums.length == 0) return 0;
		
		int n = nums.length;
		int[] DP = new int[n];
		//initial
		DP[0] = nums[0];
		if(n > 1) DP[1] = Math.max(nums[0], nums[1]);
		//DP
		for(int i = 2; i < n; i++){
			DP[i] = Math.max(DP[i-1], DP[i-2]+nums[i]);
		}
		return DP[n-1];
	}
	
	public static void main(String[] args) {

	}

}
