package algorithm.assignment;

import java.util.Arrays;
import java.util.Scanner;

public class tuzi1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int n = Integer.parseInt(scanner.nextLine());
		
		String[] numsStr = scanner.nextLine().split(" ");
		
		int[] nums = new int[n];
		for(int i = 0; i < n; i++)
			nums[i] = Integer.parseInt(numsStr[i]);
		
		scanner.close();
		
		Arrays.sort(nums);
		int count = 0;
		for(int i = 0; i < n; i++){
			for(int j = i+1; j < n; j++){
				for(int k = j+1; k < n; k++){
					for(int m = k+1; m < n; m++){
						int product = nums[i]*nums[j]*nums[k];
						if(product == nums[m])
							count++;
						else if(product < nums[m])
							break;
					}
				}
			}
		}
		System.out.println(Integer.MAX_VALUE * Integer.MAX_VALUE);
	}
	
	

}
