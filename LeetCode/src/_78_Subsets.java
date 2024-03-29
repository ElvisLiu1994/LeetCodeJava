import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 *
 */
public class _78_Subsets {
	
    public List<List<Integer>> subsets(int[] nums) {
    	
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
        
//    	Arrays.sort(nums);
    	
    	solve(nums, res, new ArrayList<Integer>(), 0);
    	
    	return res;
    }
    
    private void solve(int[] nums, List<List<Integer>> res, List<Integer> cur, int start){
    	//每一次递归都有一个新的subset产生
    	res.add(new ArrayList<Integer>(cur));
    	
    	for(int i = start; i < nums.length; i++){
    		cur.add(nums[i]);
    		solve(nums, res, cur, i+1);
    		cur.remove(cur.size()-1);
    	}
    }

	public static void main(String[] args) {
		_78_Subsets test = new _78_Subsets();
		List<List<Integer>> res = test.subsets(new int[]{1,2,3});
		for(List<Integer> l : res)
			System.out.println(l);
	}

}
