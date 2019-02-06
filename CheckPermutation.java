import java.util.Arrays;
import java.util.Scanner;

public class CheckPermutation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String firstString = in.nextLine();
        String secondString = in.nextLine();

        System.out.println(checkPermute(firstString, secondString));
        System.out.println(checkPermuteUsingDataStructure(firstString, secondString));
    }

    // Check with the interviewer if it is ASCII
    public static boolean checkPermute(String a, String s) {
        if (a.length() != s.length())
            return false;
        int[] array = new int[128];
        Arrays.fill(array, 0);
        for (int i = 0; i < a.length(); ++i) {
            int temp = a.charAt(i);
            array[i] += 1;
        }
        for (int i = 0; i < s.length(); ++i) {
            array[i] -= 1;
            if (array[i] < 0)
                return false;
        }
//        for(int i=0;i<array.length;++i) {
//            if(array[i]!=0)
//                return false;
//        }
        return true;
    }

    // Using Sorting
    public static boolean checkPermuteUsingDataStructure(String a, String s) {
        if (a.length() != s.length())
            return false;
        char[] chars = a.toCharArray();
        Arrays.sort(chars);
        a = new String(chars);
        chars = s.toCharArray();
        Arrays.sort(chars);
        s = new String(chars);
        return a.equals(s);
    }
}
