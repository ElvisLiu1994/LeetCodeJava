import java.util.Arrays;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * @author liujing
 *
 */
public class _45_JumpGameII {
	//DP solution, 数据量大的情况下出现了超时
	public int jump(int[] nums){
		if(nums == null || nums.length == 0) return 0;
		
		int len = nums.length;
		int[] dp = new int[len];
		//initial
		dp[0] = 0;
		for(int i = 1; i < len; i++){
			dp[i] = i;
		}
		
		for(int i = 1; i < len; i++){
			for(int j = 0; j < i; j++){
				//遍历该位置前面的所有
				if(nums[j] + j >= i && dp[j]+1 < dp[i]){
					dp[i] = dp[j]+1;
				}
			}
		}
		return dp[len-1];
	}
	//bfs
	public int jump1(int[] nums){
		if(nums.length < 2) return 0;
		int level = 0, currentMax = 0, nextMax = 0, i = 0;
		
		while(currentMax >= i){
			level++;
			for(;i<=currentMax;i++){
				nextMax = Math.max(nextMax, nums[i]+i);
				if(nextMax >= nums.length-1) return level;
			}
			currentMax = nextMax;
		}
		return 0;
	}
	//greedy
	public int jump2(int[] nums){
		int step_count = 0;
		int last_jump_max = 0;
		int current_jump_max = 0;
		for(int i=0; i<nums.length-1; i++) {
		    current_jump_max = Math.max(current_jump_max, i+nums[i]);
		    if( i == last_jump_max ) {
		        step_count++;
		        last_jump_max = current_jump_max;
		    } 
		}
		return step_count;
	}
	

	public static void main(String[] args) {
		_45_JumpGameII test = new _45_JumpGameII();
		int[] nums = {1,2,3};
		System.out.println(test.jump1(nums));
	}

}
