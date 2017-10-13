/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 * @author liujing
 *
 */
public class _26_RemoveDuplicates {

	public int removeDuplicates(int[] nums){
		if(nums == null) return 0;
		
		int index = 0;
		for(int i = 1; i < nums.length; i++){
			if(nums[i] != nums[index]){
				nums[++index] = nums[i];
			}
		}
		return index+1;
	}
	
	public static void main(String[] args) {
		_26_RemoveDuplicates test = new _26_RemoveDuplicates();
		int[] nums = {1,1,2,2,3,3};
		System.out.println(test.removeDuplicates(nums));
	}

}
