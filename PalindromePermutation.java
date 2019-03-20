import java.util.HashSet;
import java.util.Scanner;

public class PalindromePermutation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(finditsPalindromic(input));
    }

    public static boolean finditsPalindromic(String input) {
        input = input.toLowerCase();
        int sum = 0, length = 0;
        HashSet<Character> map = new HashSet<>();
        for (int i = 0; i < input.length(); ++i) {
            char letter = input.charAt(i);
            if (letter == ' ')
                continue;
            if (map.add(letter)) {
                sum++;
            } else {
                sum--;
            }
            length++;
        }
        if (length % 2 == sum)
            return true;
        return false;
    }
}
