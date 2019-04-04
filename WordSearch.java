import java.util.ArrayList;
import java.util.List;
import java.util.Map;


// Incomplete code
public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        char[][] board = {{'a', 'a'}};
//        System.out.println(exist(board, "aaa")); // True
        System.out.println(exist(board, "ABCCED")); // True
        System.out.println(exist(board, "SEE")); // True
        System.out.println(exist(board, "ABCB")); // False
    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == word.charAt(0)) {
                    List<String> map = new ArrayList<>();
                    if (explore(board, i, j, word, 0, map))
                        return true;
                }
            }
        }
        return false;
    }

    public static boolean explore(char[][] board, int i, int j, String word, int position, List<String> map) {

        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || position > word.length() - 1 || board[i][j] != word.charAt(position)) {
            return false;
        } else if (board[i][j] == word.charAt(position) && position == word.length() - 1 && !map.contains(i + "" + j)) {
            return true;
        }

        map.add(i + "" + j);
        return explore(board, i - 1, j, word, position + 1, map)
                || explore(board, i + 1, j, word, position + 1, map)
                || explore(board, i, j - 1, word, position + 1, map)
                || explore(board, i, j + 1, word, position + 1, map);
    }
}
