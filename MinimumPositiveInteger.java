import java.util.Arrays;
import java.util.HashSet;

public class MinimumPositiveInteger {

    public static void main(String[] args) {
//        int a[] = {1, 3, 6, 4, 1, 2};
//        int a[] = {1, 2, 3};
        int a[] = {-1, -3};
        System.out.println(minPositiveInteger(a));
    }

    private static int minPositiveInteger(int[] A) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i : A) {
            hs.add(i);
        }
        int min = 1;
        for (int i = 0; i < hs.size(); ++i) {
            if (hs.add(min))
                break;
            min++;
        }
        return min;

    }

    private static int minPosInteger(int[] A) {
        Arrays.sort(A);
        int j = 0;


        while (A[j] != 1) {
            j++;
        }

        if (j == A.length) {
            return 1;
        }

        for (int i = 1; i < A.length; i++) {
            if (i == A[j]) {
                j++;
            } else {
                return i;
            }
        }

        return 1;

    }


}
