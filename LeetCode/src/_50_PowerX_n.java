
public class _50_PowerX_n {
	//非递归解法
	public double myPow(double x, int n){
		if(n == 0) return 1;
		if(n < 0){//不能处理Integer.MIN_VALUE的情况
			x = 1/x;
			n = -n;
		}
		double result = 1;
		for(double f = x; n > 0; n = n >> 1){
			if(n % 2 == 1){
				result *= f;
			}
			f = f*f;
		}
		return result;
	}
	//下面这种做法是非常简单的，但是时间开销比较大，因为有些简单的特殊情况没有处理
	public double pow1(double x, int n ){//33ms
	    if(n==0) return 1;
	    double t = pow1(x,n/2);
	    if(n%2 != 0) return n<0 ? 1/x*t*t : x*t*t;
	    else return t*t;
	}
	
	public double pow2(double x, int n){//31ms
		if(n == 0)
			return 1.;
		if(x == 1)
			return 1.;
		if(x == -1)
			return n%2==0 ? 1. : -1.;
	    double t = pow1(x,n/2);
	    if(n%2 != 0) return n<0 ? 1/x*t*t : x*t*t;
	    else return t*t;
	}
	//下面的递归形式与上面有些不同
	public double pow3(double x, int n){//不能处理 n=Integer.MINVALUE时的情况，因为-n还是负数
		if(n == 0)
			return 1.;
		if(x == 1)
			return 1.;
		if(x == -1)
			return n%2==0 ? 1. : -1.;
		if(n < 0){
			x = 1/x;
			n = -n;
		}
		return (n%2==0) ? pow3(x*x, n/2) : x*pow3(x*x, n/2);
	}
	
	public double pow4(double x, int n){//35ms
		if(n == 0) return 1.;
		if(x == 1) return 1.;
		if(x == -1) return n%2==0 ? 1. : -1.;
		
		double result = 1.;
		if(n < 0){
			result = 1/x;
			x = 1/x;
			n = -(n+1);
		}
		for(double f = x; n > 0; n = n >> 1){
			if(n%2 == 1){
				result *= f;
			}
			f = f*f;
		}
		return result;
	}

	public static void main(String[] args) {
		_50_PowerX_n test = new _50_PowerX_n();
		System.out.println(-1 * Integer.MIN_VALUE);
		System.out.println(-3 %2);
		System.out.println(test.pow1(0.5, Integer.MIN_VALUE));
	}

}
