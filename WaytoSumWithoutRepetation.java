// Java Program to find number of ways to
// which numbers that are greater than
// given number can be added to get sum.

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class WaytoSumWithoutRepetation {
    // Driver Function to test above function
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("input total");
        int n = scanner.nextInt();
        System.out.println("Input range");
        int len = scanner.nextInt();
        int[] arr = IntStream.rangeClosed(0, len).toArray();
//        int arr[] = {1, 2};
        int m = arr.length;
        System.out.println(countWays(arr, m, n));
    }

    static long countWays(int S[], int m, int n) {
        //Time complexity of this function: O(mn)
        //Space Complexity of this function: O(n)

        // table[i] will be storing the number of solutions
        // for value i. We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)
        long[] table = new long[n + 1];

        // Initialize all table values as 0
        Arrays.fill(table, 0); //O(n)

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i = 0; i < m; i++)
            for (int j = S[i]; j <= n; j++)
                table[j] += table[j - S[i]];

        return table[n];
    }


}
