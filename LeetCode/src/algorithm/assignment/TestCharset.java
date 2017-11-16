package algorithm.assignment;

import java.nio.charset.Charset;
import java.util.Arrays;

public class TestCharset {

	public static void main(String[] args) throws Exception {
		String str = "I AM ÖÐ¹úÈË";
		System.out.println("str = " + str);
		System.out.println(Charset.defaultCharset());
		System.out.println("Default byte codes of str : " + Arrays.toString(str.getBytes()));  
        System.out.println("GBK codes of str : " + Arrays.toString(str.getBytes("GBK")));  
        System.out.println("UTF-8 codes of str : " + Arrays.toString(str.getBytes("UTF-8")));  
        System.out.println("UTF-16 codes of str : " + Arrays.toString(str.getBytes("UTF-16")));  
	}

}
