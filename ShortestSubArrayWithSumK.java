public class ShortestSubArrayWithSumK {

    public static void main(String[] args) {
        int[] a1 = {1};
        int k1 = 1;
        int[] a2 = {1, 2};
        int k2 = 4;
        int[] a3 = {2, -1, 2};
        int k3 = 3;
        int[] a4 = {2, 0, -3, 2};
        int k4 = -1;
        int[] a5 = {84, -37, 32, 40, 95};
        int k5 = 167;

        System.out.println(shortestSubarray(a1, k1)); // 1
        System.out.println(shortestSubarray(a2, k2)); // -1
        System.out.println(shortestSubarray(a3, k3)); // 3
        System.out.println(shortestSubarray(a4, k4)); // 1
        System.out.println(shortestSubarray(a5, k5)); // 3
    }

    static public int shortestSubarray(int[] A, int k) {
        if (A.length < 1) {
            return -1;
        }
        int left = -1;
        int right = 0;
        int sum = A[0];
        int minL = Integer.MAX_VALUE;
        while (left < right) {

            if (sum >= k && left < right) {
                minL = Math.min(minL, Math.abs(right - left));
                left++;
                sum = sum - A[left];
            } else if (A[right] == k) {
                return 1;
            } else if (right == A.length -1) {
                left++;
                sum = sum - A[left];
            } else {
                ++right;
                if (right < A.length)
                    sum += A[right];

            }
        }
        return minL == Integer.MAX_VALUE ? -1 : minL;
    }
}
