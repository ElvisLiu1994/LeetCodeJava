import java.util.Arrays;

/**
 * 
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.
 * @author liujing
 *
 */
public class _66_PlusOne {
	
    public int[] plusOne(int[] digits) {
    	
    	int n = digits.length;
    	for(int i = n-1; i >= 0; i--){
    		if(digits[i] < 9){
    			digits[i]++;
    			return digits;
    		}
    		
    		digits[i] = 0;
    	
    	}
    	
    	int[] newNum = new int[n+1];
    	newNum[0] = 1;
    	
    	return newNum;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}