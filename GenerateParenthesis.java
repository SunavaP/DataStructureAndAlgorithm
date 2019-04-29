import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n < 1)
            return list;
        return generateParenthesis(list, n, 0, 0, 0, "");
    }

    public static List<String> generateParenthesis(List<String> strList, int n, int countFront, int backFront, int brk, String str) {

        if (brk < 0) {
            return null;
        }
        if (brk == 0 && str.length() == n * 2) {
            strList.add(str);
            return strList;
        }
        if (countFront < n)
            generateParenthesis(strList, n, countFront + 1, backFront, brk + 1, str + "(");
        if (backFront < n)
            generateParenthesis(strList, n, countFront, backFront + 1, brk - 1, str + ")");

        return strList;
    }
}
