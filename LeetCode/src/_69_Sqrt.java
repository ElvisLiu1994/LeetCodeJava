
public class _69_Sqrt {
	
	//二分法
	public int mySqrt(int x){
		int left = 1, right = x;
		while(left <= right){
			int mid = left + (right - left) / 2;
			if(mid == x / mid){
				return mid;
			} else if(mid < x / mid){
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return right;
	}
	
	//牛顿法
	public int mySqrt1(int x){
	    long r = x;
	    while (r*r > x)
	        r = (r + x/r) / 2;
	    return (int) r;
	}

	public static void main(String[] args) {
		_69_Sqrt test = new _69_Sqrt();
		System.out.println(test.mySqrt(2147395600));
		System.out.println(289398*289398);
		System.out.println(Math.sqrt(2147395600));
		System.out.println(46340*46340);
	}

}
