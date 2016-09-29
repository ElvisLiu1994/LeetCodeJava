
public class _4_MedianofTwoSortedArrays {
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2){
		
		if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
		
		if(nums2.length == 0) return 0;
		
		int m = nums1.length, n = nums2.length;
		int imin = 0, imax = m, half_len = (m+n+1)/2;
		int max_of_left, min_of_right;
		while(imin <= imax){
			int i = (imin + imax) / 2;
			int j = half_len - i;
			
			if(j > 0 && i < m && nums2[j-1] > nums1[i])
				imin = i + 1; // i is too small, must increase it
			else if(i > 0 && j < n && nums1[i-1] > nums2[j])
				imax = i - 1; // i is too big, must decrease it
			else{
				if(i == 0) max_of_left = nums2[j-1];
				else if(j == 0) max_of_left = nums1[i-1];
				else max_of_left = Math.max(nums1[i-1], nums2[j-1]);
				
				if((m + n) % 2 == 1)
					return max_of_left;
				
				if(i == m) min_of_right = nums2[j];
				else if(j == n) min_of_right = nums1[i];
				else min_of_right = Math.min(nums1[i], nums2[j]);
				
				return (min_of_right + max_of_left) / 2.0;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		_4_MedianofTwoSortedArrays test = new _4_MedianofTwoSortedArrays();
		int[] n1 = new int[]{1,3};
		int[] n2 = new int[]{2};
		System.out.println(test.findMedianSortedArrays(n1, n2));
	}

}
