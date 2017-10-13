package algorithm.assignment;
/**
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
 * If there are multiple solutions, return any subset is fine.
 * Example 1:
 * nums: [1,2,3]
 * Result: [1,2] (of course, [1,3] will also be ok)
 * Example 2:
 * nums: [1,2,4,8]
 * Result: [1,2,4,8]
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _368_LargestDivisibleSubset {
	
	/* 1.先将数组进行排序，我们在确定DP[i]与DP[j]的关系时，只需要做一次求模运算
	 * 2.
	 */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums == null) return null;
        Arrays.sort(nums);
        int n = nums.length;
        int[] DP = new int[n];
        int[] sel = new int[n];
        int largest = 0;
        int idx = -1;
        //initial
        for(int i = 0; i < n; i++)
        	DP[i] = 1;
        for(int i = 0; i < n; i++)
        	sel[i] = -1;
        //DP
        for(int i = 0; i < n; i++){
        	for(int j = 0; j < i; j++){
        		if(nums[i] % nums[j] == 0 && DP[j]+1 > DP[i]){
        			DP[i] = DP[j]+1;
        			sel[i] = j;
        		}
        	}
        	if(DP[i] > largest){
        		largest = DP[i];
        		idx = i;
        	}
        }
        
        List<Integer> res = new ArrayList<Integer>();
        //Backtracking
        while(idx != -1){
        	res.add(nums[idx]);
        	idx = sel[idx];
        }
        return res;
    }

	public static void main(String[] args) {
		_368_LargestDivisibleSubset test = new _368_LargestDivisibleSubset();
		System.out.println(test.largestDivisibleSubset(new int[]{3,4,16,8}));
	}

}
