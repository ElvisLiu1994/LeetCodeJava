/**
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 *
 */
public class _79_WordSearch {
	
    public boolean exist(char[][] board, String word) {
    	
    	int n = board.length;
    	int m = board[0].length;
    	
    	boolean[][] used = new boolean[n][m];
    	
    	for(int i = 0; i < n; i++){
    		for(int j = 0; j < m; j++){
    			if(exist(board, used, i, j, word, 0))
    				return true;
    		}
    	}
    	
        return false;
    }
    
    private boolean exist(char[][] board, boolean[][] used, int i, int j, String word, int index){
    	
    	if(word.length() == index) return true;
    	
    	if(i > board.length || i < 0 || j > board[0].length || j < 0 || used[i][j] || board[i][j] != word.charAt(index))
    		return false;
    	
    	used[i][j] = true;
    	boolean res = exist(board, used, i-1, j, word, index+1) ||
    				  exist(board, used, i+1, j, word, index+1) ||
    				  exist(board, used, i, j+1, word, index+1) ||
    				  exist(board, used, i, j-1, word, index+1);
    	used[i][j] = false;
    	
    	return res;
    }

	public static void main(String[] args) {
//		char[][] board = new char[][]{  {'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		char[][] board = new char[][]{ {'a', 'a'} };
		_79_WordSearch test = new _79_WordSearch();
		System.out.print(test.exist(board, "aaa"));
			  
	}

}
