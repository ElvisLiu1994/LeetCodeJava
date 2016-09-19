
public class _28_StrStr {
	
	public int strStr(String haystack, String needle){
		for(int i = 0; ;i++){
			for(int j = 0; ; j++){
				if(j == needle.length()) return i;
				if(i + j == haystack.length()) return -1;
				if(needle.charAt(j) != haystack.charAt(i+j)) break; 
			}
		}
	}

	public static void main(String[] args) {
		_28_StrStr test = new _28_StrStr();
	}

}
