import java.util.ArrayList;
import java.util.List;

/**
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 *
 */
public class _93_RestoreIPAddress {
	
	public static List<String> restoreIpAddresses(String s){
		
		List<String> res = new ArrayList<String>();
		
		if(s.length() < 4 || s.length() > 12) return res;
		
		solve(res, new StringBuilder(s), 0, 0);
		
		return res;
	}
	
	public static void solve(List<String> res, StringBuilder sb, int dotNum, int start){
		if(dotNum == 3) {
			int tmp = Integer.valueOf(sb.substring(start, sb.length()));
			if(tmp >= 0 && tmp <= 255)
				res.add(sb.toString());
			return;
		}
		// 最多三位，并且加点后面还需要有数字，所以需要start+i<sb.length()
		for(int i = 1; i <= 3 && start+i < sb.length(); i++){
			
			// 当'.'往后放超过1位时，该区间不能以'0'开头，后面可以直接不用循环了，所以用break
			// 避免出现"0.1.00.10"这种情况
			if(i > 1 && sb.charAt(start) == '0') break;
			
			// 上面的情况不能过滤"0.1.0.010"这种情况，因为当dotNum==2时，只加入一个'0'，后面的是否合法而没有判断
			// 所以这里需要判断这种情况， 同时当"1.0.1023"时，为了能够输出"1.0.10.23"和"1.0.102.3"，这里只需要过滤i==1时的情况，所以用continue
			// 不能用break，否则结果将会不正确，正确结果被过滤掉
			if(dotNum == 2 && start+i < sb.length()-1 && sb.substring(start+i).startsWith("0")) continue;
			
			int tmp = Integer.valueOf(sb.substring(start, start+i));
			if((tmp >= 0 && tmp <= 255)){
				solve(res, sb.insert(start+i, '.'), dotNum+1, start+i+1);
				sb.deleteCharAt(start+i);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(restoreIpAddresses("25525511135"));
		System.out.println(restoreIpAddresses("010010"));
		System.out.println(restoreIpAddresses("101023"));
	}

}
