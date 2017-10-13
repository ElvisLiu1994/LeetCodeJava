package algorithm.assignment;

import java.util.Scanner;

public class Bzsw {
	
	public static int max = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int m = scanner.nextInt();;
		
		int[][] a = new int[n][m];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				a[i][j] = scanner.nextInt();
			}
		}
		scanner.close();
		
		solve(a, n, m, 0);
		System.out.println(max);
	}
	
	private static void solve(int[][] a, int n, int m, Integer curMax){
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(a[i][j] == 0){
					a[i][j] = 3; //设置一个守卫
					if(isValid(a,n, m,i,j)){
						curMax++;
						if(curMax > max){
							max++;
						}
						solve(a, n, m, curMax);
						curMax--;
					}
					a[i][j] = 0;
				}
			}
		}
		
	}
	
	private static boolean isValid(int[][] a, int n, int m, int i, int j ){
		
		boolean canShoot = false;
		for(int c = 0; c < m; c++){
			if(a[i][c] == 2){
				canShoot = false;
			}else if(a[i][c] == 3){
				if(canShoot)
					return false;
				else
					canShoot = true;
			}
		}
		canShoot = false;
		for(int c = 0; c < n; c++){
			if(a[c][j] == 2){
				canShoot = false;
			}else if(a[c][j] == 3){
				if(canShoot) 
					return false;
				else
					canShoot = true;
			}
		}
		
		return true;
	}

}
