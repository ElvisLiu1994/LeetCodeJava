import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _18_4Sum {
	//常规解法，数据规模太大时会超时，没有通过
	public List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> l ;
        for(int i = 0; i < nums.length; i++){
        	int t1 = target - nums[i];
        	for(int j = 0; j < nums.length; j++){ //3sum
        		if(j == i)
        			continue;
        		int t2 = t1 - nums[j];
        		for(int k = 0; k < nums.length; k++){
        			if(k == i || k == j)
        				continue;
        			int t3 = t2 - nums[k];
        			for(int p = 0; p < nums.length; p++){
        				if(p == i || p == j || p == k)
        					continue;
        				if(nums[p] == t3){
        					l = Arrays.asList(nums[i],nums[j],nums[k],nums[p]);
        					Collections.sort(l);
        					if(!res.contains(l)) //contains使用equals判断，而equals只需要内部元素相等，则两个list相等
        						res.add(l);
        				}
        			}
        		}
        	}
        }
        return res;
    }
	
	public List<List<Integer>> fourSum2(int[] nums, int target){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null || nums.length < 4){
			return res;
		}
		
		Arrays.sort(nums);
		
		int len = nums.length;
		int max = nums[len-1];
		if(4*nums[0] > target || 4 * max < target){
			return res;
		}
		
		for(int i = 0; i < nums.length - 3; i++){
			int z = nums[i];
			if(i > 0 && z==nums[i-1]) //avoid duplicate
				continue;
			if(z + 3*max < target) //z is too small
				continue;
			if(4 * z > target) //z is too big
				break;
			if(4 * z == target){
				if(i + 3 < len && nums[i+3] == z ){
					res.add(Arrays.asList(z,z,z,z));
				}
				break;
			}
			
			threeSum(nums, target-z, i+1, len-1, res, z);
		}
		return res;
	}
	
	public void threeSum(int[] nums, int target, int low, int high, List<List<Integer>> res, int z1){
		if(low + 1 >= high)
			return;
		
		int max = nums[high];
		if(3*nums[low] > target || 3*max < target){
			return;
		}
		
		int z;
		for(int i = low; i < high - 1; i++){
			z = nums[i];
			if(i > low && z == nums[i-1]) //avoid duplicate
				continue;
			if(z + 2*max < target) //z is too small
				continue;
			if(3*z > target) // z is too big
				break;
			if(3*z == target){
				if(i+1 < high && nums[i+2] == z){
					res.add(Arrays.asList(z1,z,z,z));
				}
				break;
			}
			
			towSum(nums, target-z, i+1, high, res, z1, z);
		}
	}
	
	public void towSum(int[] nums, int target, int low, int high, List<List<Integer>> res, int z1, int z2){
		if(low >= high)
			return;
		
		if(2*nums[low] > target || 2*nums[high] < target)
			return;
		
		int i = low, j = high, sum, x;
		while(i < j){
			sum = nums[i] + nums[j];
			if(sum == target){
				res.add(Arrays.asList(z1,z2,nums[i],nums[j]));
				
				x = nums[i];
				while(++i < j && x==nums[i]) ; // avoid duplicate
				x = nums[j];
				while(i < --j && x==nums[j]) ; // avoid duplicate
			}
			if(sum < target)
				i++;
			if(sum > target)
				j--;
		}
		return;
	}

	public static void main(String[] args) {
//		List<Integer> a = Arrays.asList(1,2,3);
//		List<Integer> b = Arrays.asList(1,2,3);
//		Set<List<Integer>> s = new HashSet<List<Integer>>();
//		s.add(a);
//		s.add(b);
//		System.out.println(s);
		
		int[] S = {0,1,5,0,1,5,5,-4};
		int target = 11;
		_18_4Sum test = new _18_4Sum();
		System.out.println(test.fourSum2(S, target));
	}

}
