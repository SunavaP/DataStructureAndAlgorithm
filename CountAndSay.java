import java.util.Scanner;

public class CountAndSay {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(countAndSay(n));
    }

    private static String countAndSay(int n) {
        String result = "1";

        if (n < 2)
            return result;
        int i = 2;

        while (i <= n) {
            StringBuilder str = new StringBuilder();
            int len = result.length() - 1;
            int count = 1;
            for (int j = 1; j <= len; ++j) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    str.append(count).append(result.charAt(j - 1));
                    count = 1;
                }
            }
            str.append(count).append(result.charAt(len));
            result = str.toString();
            System.out.println(result);
            ++i;
        }
        return result;
    }
}
