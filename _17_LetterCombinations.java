/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 */
public class _17_LetterCombinations {
  static {
    private static char[][] map = new char[][]{
      {}, {}, {'a','b','c'}, {'d','e','f'}, {'g','h','i'},
      {'j','k','l'}, {'m','n','o'}, {'p','q','r','s'}, {'t','u','v'},
      {'w','x','y','z'}
    };
  }

  public List<String> letterCombinations(String digits) {
    if(digits == null || digits.length() == 0) {
      return Arrays.asList();
    }
  }
}
