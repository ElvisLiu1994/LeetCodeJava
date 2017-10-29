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
		for(int i = 1; i <= 3 && start+i < sb.length(); i++){
			int tmp = Integer.valueOf(sb.substring(start, start+i));
			if((tmp > 0 && tmp <= 255) || (Integer. && i == 1)){
				solve(res, sb.insert(start+i, '.'), dotNum+1, start+i+1);
				sb.deleteCharAt(start+i);
			}
		}
	}

	public static void main(String[] args) {
//		System.out.println(restoreIpAddresses("25525511135"));
		System.out.println(restoreIpAddresses("010010"));
	}

}
