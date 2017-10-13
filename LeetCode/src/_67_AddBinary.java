/**
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 
 * @author liujing
 *
 */
public class _67_AddBinary {
	
	public String addBinary(String a, String b){
		
		if(a == null || b == null){
			return null;
		}
		
		char[] na = a.toCharArray(), nb = b.toCharArray();
		int n = a.length()-1, m = b.length()-1;
		
		int c = 0;
		StringBuilder sb = new StringBuilder();
		while(n >= 0 || m >=0){
			 int sum = c;
			 if(n >= 0) sum += na[n--]-'0';
			 if(m >= 0) sum += nb[m--]-'0';
			 sb.append(sum % 2);
			 c = sum / 2;
		}
		if(c != 0) sb.append(c);
		return sb.reverse().toString();
		
	}

	public static void main(String[] args) {
		_67_AddBinary test = new _67_AddBinary();
		System.out.println(test.addBinary("11", "1"));
	}

}
