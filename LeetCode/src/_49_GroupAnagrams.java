import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _49_GroupAnagrams {
	
	public List<List<String>> groupAnagrams(String[] strs){
		if(strs == null || strs.length == 0) return null;
		
		Map<String, List<String>> map = new HashMap<String,List<String>>();
		for(String s : strs){
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String strkey = String.valueOf(ca);
			if(!map.containsKey(strkey))
				map.put(strkey, new ArrayList<String>());
			map.get(strkey).add(s);
		}
		
		return new ArrayList<List<String>>(map.values());
	}

	public static void main(String[] args) {
		_49_GroupAnagrams test = new _49_GroupAnagrams();
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> res = test.groupAnagrams(strs);
		for(List<String> l : res)
			System.out.println(l);
	}

}
