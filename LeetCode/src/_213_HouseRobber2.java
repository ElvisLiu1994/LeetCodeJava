
/**
 * After robbing those houses on that street, the thief has found himself a 
 * new place for his thievery so that he will not get too much attention. 
 * This time, all houses at this place are arranged in a circle. 
 * That means the first house is the neighbor of the last one. 
 * Meanwhile, the security system for these houses remain the same as for 
 * those in the previous street.

 * Given a list of non-negative integers representing the amount of 
 * money of each house, determine the maximum amount of money you can rob 
 * tonight without alerting the police.
 * @author liujing
 *
 */
public class _213_HouseRobber2 {
	
	//要么取1不取n，要么取n不取1，仅需要考虑这两种情况
	public int rob(int[] nums){
		if(nums == null || nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];
		return Math.max(rob(nums,0,nums.length-2), rob(nums,1,nums.length-1));
	}
	
	private int rob(int[] nums, int l, int h){
		int[] DP = new int[h-l+1];
		DP[0] = nums[l];
		DP[1] = Math.max(nums[l], nums[l+1]);
		for(int i = l+2; i <= h; i++){
			DP[i-l] = Math.max(DP[i-l-2]+nums[i], DP[i-l-1]);
		}
		return DP[h-l];
	}

	public static void main(String[] args) {

	}

}
