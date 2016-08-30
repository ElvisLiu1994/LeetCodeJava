import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author liujing
 *
 */
public class _17_LettersCombinations {
	private static final char[][] map;
	static {
		map = new char[][] { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' },
				{ 'j', 'k', 'l' }, { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' },
				{ 'w', 'x', 'y', 'z' } };
	}

	public static List<String> letterCombinations(String digits) {
		if (digits == null || digits.length() == 0) {
			return Arrays.asList();
		}
		List<String> res = new ArrayList<String>();
		res.add("");
		char[] c = digits.toCharArray();
		for (int i = 0; i < c.length; i++) {
			res = combine(map[c[i] - '0'], res);
		}
		return res;
	}

	public static List<String> combine(char[] m, List<String> l){
		List<String> res = new ArrayList<String>();
		for(int i = 0; i < m.length; i++){
			for(String x : l){
				res.add(x+m[i]);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		
		System.out.println(letterCombinations("23"));
	}

}
