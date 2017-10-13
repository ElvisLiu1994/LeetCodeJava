package algorithm.assignment;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

public class SignificantInversionPair {
	
	public long SortAndCount(int[] L, int s, int e){
		if(s >= e-1) return 0;
		
		int mid = (s+e) >> 1;
		long left = SortAndCount(L,s,mid);
		long right = SortAndCount(L,mid,e);
		long merge = MergeAndCount(L,s,mid,e);
		return left+right+merge;
	}
	
	public int MergeAndCount(int[] L, int s, int mid, int e){
		int[] temp = new int[e-s];
		int i = s, j = mid, k = 0, count = 0;
		while(i < mid && j < e){
			if(L[i] > L[j]){
				temp[k++] = L[j++];
				count += (mid-i);
			}else{
				temp[k++] = L[i++];
			}
		}
		while(i < mid) temp[k++] = L[i++];
		while(j < e) temp[k++] = L[j++];
		
		for(int c = 0; c < temp.length; c++){
			L[s+c] = temp[c];
		}
		
		return count;
	}

	public static void main(String[] args) throws Exception{
		SignificantInversionPair test = new SignificantInversionPair();
		int[] L = new int[100000];
		BufferedReader br = new BufferedReader(new FileReader("Q8.txt"));//Q8.txt must in LeetCode这个工程目录下面，与src同一级
		String s;
		int i = 0;
		while((s = br.readLine())!= null){
			L[i++] = Integer.valueOf(s);
		}
		br.close();
		System.out.println(test.SortAndCount(L, 0, L.length));
	}

}
