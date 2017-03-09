import java.util.ArrayList;
import java.util.List;

public class _46_Permutations {
	
	public List<List<Integer>> permute(int[] nums){
		
		if(nums == null || nums.length == 0) return null;
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		solve(nums,new ArrayList<Integer>(), res);
		return res;
		
	}
	
	public void solve(int[] nums, List<Integer> used, List<List<Integer>> res){
		if(used.size() == nums.length){
			res.add(new ArrayList<Integer>(used));
			return;
		}
		for(int i = 0; i < nums.length; i++){
			if(!used.contains(nums[i])){
				used.add(nums[i]);
				solve(nums,used,res);
				used.remove(used.size()-1);
			}
		}
			
	}

	public static void main(String[] args) {
		_46_Permutations test = new _46_Permutations();
		int[] nums = {1,2,3};
		List<List<Integer>> res = test.permute(nums);
		for(List<Integer> l : res){
			System.out.println(l);
		}
	}

}
