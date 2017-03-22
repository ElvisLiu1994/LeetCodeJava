/**
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
 * @author liujing
 *
 */
public class _55_JumpGame {
	
	public boolean canJump(int[] nums){
		
		int max = 0, i = 0;
		for(; i < nums.length && i <= max; i++)
			max = Math.max(max, nums[i]+i);
		return i==nums.length;
	}

	public static void main(String[] args) {
		
	}

}
