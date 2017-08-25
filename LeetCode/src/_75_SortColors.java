/**
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
 *
 */
public class _75_SortColors {
	//two pass way
	public void sortColors(int[] nums){
		
		int[] counts = new int[]{0,0,0};
		for(int i = 0; i < nums.length; i++) counts[nums[i]]++;
		
		int p = 0;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < counts[i]; j++){
				nums[p++] = i; 
			}
		}
	}
	
	//one pass way: three points; rewrite
	public void sortColors1(int[] nums){
		int p0 = 0, p1 = 0, p2 = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == 0){
				nums[p2++] = 2; nums[p1++] = 1; nums[p0++] = 0;
			}else if(nums[i] == 1){
				nums[p2++] = 2; nums[p1++] = 1;
			}else{
				nums[p2++] = 2;
			}
		}
	}
	
	//one pass way: two points; swap
	public void sortColors2(int[] nums){
		int p0 = 0, p2 = nums.length-1;
		for(int i = 0; i <= p2; i++){
			if(nums[i] == 0){
				int tmp = nums[i];
				nums[i] = nums[p0];
				nums[p0] = tmp;
				p0++;
			}else if(nums[i] == 2){
				int tmp = nums[i];
				nums[i] = nums[p2];
				nums[p2] = tmp;
				p2--;
				i--;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
