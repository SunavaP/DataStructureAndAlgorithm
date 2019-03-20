import java.util.ArrayList;
import java.util.List;

public class CostOfATreeMathWorks {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(1);
        /////////
        List<Integer> arr1 = new ArrayList<>();
        arr1.add(4);
        arr1.add(6);
        arr1.add(2);
        ////////////
        List<Integer> arr2 = new ArrayList<>();
        arr2.add(5);
        arr2.add(3);
        arr2.add(1);

        List<Integer> arr3 = new ArrayList<>();
        arr3.add(2);
        arr3.add(1);
        arr3.add(4);
        arr3.add(6);
        arr3.add(2);
        arr3.add(5);
        arr3.add(3);
        arr3.add(1);
        System.out.println(solution(arr));
        System.out.println(solution(arr1));
        System.out.println(solution(arr2));
        System.out.println(solution(arr3));
    }

    private static int solution(List<Integer> arr) {
        int len = arr.size();
        if (len == 1) {
            return arr.get(0);
        }
        if (len == 2) {
            return arr.get(0) * arr.get(1);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < len; ++i) {
//            sum = cost(arr,0,i,0) + cost(arr,i,len,0);
            int sum = partition(arr, 0, i) + partition(arr, i, len) + findMax(arr, 0, i)
                    * findMax(arr, i, len);
            System.out.println("result:\t"+sum);
            min = Math.min(sum, min);
        }
        return min;
    }

    private static int partition(List<Integer> arr, int start, int end) {
        if (end - start == 1) {
            return 0;
        } else if (end - start == 2) {
            return arr.get(start) * arr.get(start + 1);
        }
        int min = Integer.MAX_VALUE;
        for (int i = start + 1; i < end; ++i) {
            int sumleft = partition(arr, start, i);
            int sumRight = partition(arr, i, end);
            int currentSum = findMax(arr, start, i) * findMax(arr, i, end);
            int totalSum = sumleft + sumRight + currentSum;
            min = Math.min(min, totalSum);
        }
        return min;
    }

    private static int findMax(List<Integer> arr, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; ++i)
            max = Math.max(max, arr.get(i));
        return max;
    }

}
