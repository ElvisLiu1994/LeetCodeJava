package algorithm.assignment;

import java.util.Arrays;

/**
 * Given a sequence of n real numbers a1,...,an, 
 * determine a subsequence (not necessarily contiguous) of maximum length 
 * in which the values in the subsequence form a strictly increasing sequence.
 * @author liujing
 *
 */
public class _300_LongestIncreasingSubseq {
	
	//O(n^2)
	//不一定最终的结果在DP[n]，可以在DP数组的任意位置
	public int lengthOfLIS1(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        int[] DP = new int[n];
        int longest = 0;
        //initial
        for(int i = 0; i < n; i++) DP[i] = 1;
        //DP
        for(int i = 0; i < n; i++){
        	for(int j = 0; j <i; j++){
        		if(nums[i] > nums[j] && DP[j]+1>DP[i])
        			DP[i] = DP[j]+1;
        	}
        	longest = DP[i] > longest ? DP[i] : longest;
        }
        return longest;
    }
	
	//O(nlogn)
	public int lengthOfLIS2(int[] nums){
		if(nums == null || nums.length == 0) return 0;
		
		int[] DP = new int[nums.length];
		int len = 0;
		
		for(int x : nums){
			int i = Arrays.binarySearch(DP, 0, len, x);
			if(i < 0) i = -(i+1);
			DP[i] = x;
			if(i == len) len++;
		}
		return len;
	}

	public static void main(String[] args) {
		_300_LongestIncreasingSubseq test = new _300_LongestIncreasingSubseq();
		int[] nums = new int[]{3,1};
		System.out.println(Arrays.binarySearch(nums, 0,1,1));
		System.out.println(test.lengthOfLIS2(nums));
	}

}
