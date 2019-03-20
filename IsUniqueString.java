import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class IsUniqueString {

    public static void main(String[] args) {
        Scanner br = new Scanner(System.in);
        String str = br.nextLine();
        System.out.println(isUniqueBybits(str));
        System.out.println(isUniqueByDatastructure(str));
    }

    // O(max(128,c) size of character array
    public static boolean isUniqueBybits(String str) {
        // IMPORTANT!!!
        if (str.length() > 128)
            return false;
        Boolean[] check = new Boolean[128];
        Arrays.fill(check, false);
        for (int i = 0; i < str.length(); ++i) {
            int pos = str.charAt(i);
            if (check[pos]) {
                return false;
            }
            check[pos] = true;
        }
        return true;
    }

    public static boolean isUniqueByDatastructure(String str) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < str.length(); ++i) {
            int pos = str.charAt(i);
            if (!hs.add(pos)) {
                return false;
            }
        }
        return true;
    }

}
