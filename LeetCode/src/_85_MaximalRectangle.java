import java.util.Arrays;

/**
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle 
containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 6.
 *
 */
public class _85_MaximalRectangle {
	
	/**
	 * 可以考虑利用前一题，条形图的最大矩形，遍历每一行时的最大矩形面积，最终得到最大面积。
	 */
	public static int maximalRectangle(char[][] matrix) {
		
		if(matrix == null || matrix.length == 0)	return 0;
		
		int rows = matrix.length;
		int cols = matrix[0].length;

		int[] heights = new int[cols];
		int max = 0;
		//累加每一行的和
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				//为0的列直接要将高度设置为0
				heights[j] = (matrix[i][j] == '0' ? 0 : heights[j]+1);
			}
			max = Math.max(max, largestRectangelInHistogram(heights));
		}
		return max;
	}
	
	public static int largestRectangelInHistogram(int[] heights){
		
		if(heights == null || heights.length == 0) return 0;
		
		int max = 0;
		int top = 0;
		int[] stack = new int[heights.length+1];
		
		for(int i = 0; i <= heights.length; i++){
			
			int curHeight = (i == heights.length ? 0 : heights[i]);
			
			if(top == 0 || curHeight >= heights[stack[top-1]]){
				stack[top++] = i;
			}else{
				int topHeight = heights[stack[--top]];
				max = Math.max(max, topHeight * (top == 0 ? i : i-1-stack[top-1]));
				i--;
			}
		}
		
		return max;
	}
	
	/**
	 * DP方法
	 */
    public int maximalRectangle1(char[][] matrix) {
		
	}

	public static void main(String[] args) {
		char[][] matrix = new char[][]{{'1','0','1','0','0'},
			{'1','0','1','1','1'},
			{'1','1','1','1','1'},
			{'1','0','0','1','0'}};
		System.out.println(maximalRectangle(matrix));
	}

}
