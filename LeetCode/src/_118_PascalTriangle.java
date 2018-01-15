import java.util.ArrayList;
import java.util.List;

/**
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 *
 */
public class _118_PascalTriangle {
    
    public static List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows <= 0) return res;
        
        List<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(1);
        res.add(firstRow);
        
        for(int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();
            List<Integer> upper = res.get(i-1);
            for(int j = 0; j <= i; j++) {
                row.add(j == 0 ? 1 : (j == i ? 1 : upper.get(j-1)+upper.get(j)));
            }
            res.add(row);
        }
        
        return res;
    }
    
    /*
     * 上面这种写法很不简洁，下面这个方法更简练
     */
    public static List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> row = new ArrayList<Integer>();
        
        for(int i = 0; i < numRows; i++) {
            row.add(0, 1); // 每一行第1个数肯定是1
            for(int j = 1; j < row.size()-1; j++) { //最后一个数也肯定是1，所以只用j<size-1
                row.set(j, row.get(j)+row.get(j+1));
            }
            res.add(new ArrayList<Integer>(row)); // 由于row是重复使用的,所以需要深拷贝一份
        }
        
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = generate1(6);
        for(List<Integer> row : res) {
            System.out.println(row);
        }
    }

}
