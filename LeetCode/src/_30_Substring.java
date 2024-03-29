import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 
 * @author liujing
 *
 */
public class _30_Substring {
	/**
	 * 如果先将所有的words中字符串的排列求出来再进行匹配，则时间开销太大，这里使用两个
	 * hashmap来对匹配成功的字符串进行计数，从而减少了求排列所需要的时间。
	 * @param s
	 * @param words
	 * @return
	 */
	public List<Integer> findSubstring(String s, String[] words){
		List<Integer> res = new ArrayList<Integer>();
		if(words.length == 0 || s.length() < words.length*words[0].length())
			return res;
		
		int N = s.length(), M = words.length, K = words[0].length();
		Map<String, Integer> map = new HashMap<String, Integer>(), curMap = new HashMap<String, Integer>();
		for(String str : words){
			if(map.containsKey(str)) map.put(str, map.get(str)+1);
			else map.put(str, 1);
		}
		
		String str = null, tmp = null;
		for(int i = 0; i < K; i++){
			int count = 0;
			for(int l = i, r = i; r + K <= N; r+=K){
				str = s.substring(r, r+K);
				if(map.containsKey(str)) {
					if(curMap.containsKey(str)) curMap.put(str, curMap.get(str)+1);
					else curMap.put(str, 1);
					
					if(curMap.get(str) <= map.get(str)) count++;
					
					while(curMap.get(str) > map.get(str)){
						tmp = s.substring(l,l+K);
						curMap.put(tmp, curMap.get(tmp)-1);
						l += K;
						if(curMap.get(tmp) < map.get(tmp)) count--;
					}
					if(count == M){
						res.add(l);
						tmp = s.substring(l,l+K);
						curMap.put(tmp, curMap.get(tmp)-1);
						l+=K;
						count--;
					}
					
				}else{
					curMap.clear();
					l = r+K;
					count = 0;
				}
			}
			curMap.clear();
		}
		
		return res;
	}

	public static void main(String[] args) {
		_30_Substring test = new _30_Substring();
		System.out.println(test.findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));
	}

}
