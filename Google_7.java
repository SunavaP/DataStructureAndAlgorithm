import java.util.*;

public class Google_7 {

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7,8,9,10};
        int N = 3;
        printRandomIncreasingOrder(a,N);
    }

    private static void printRandomIncreasingOrder(int a[],int N) {

        int[] array = new int[N];
        int length = a.length;
        int pos = 0;
        Random random = new Random();
        for (int i=0;i<N;++i) {
            int max = length-N+i;
            int min = ++pos;
            pos = random.nextInt((max-min)+1) + min;
            array[i] = a[pos];
        }
        System.out.println(Arrays.toString(array));

    }


}
