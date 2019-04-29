public class SeperatingStudents {
    public static void main(String[] args) {
        int[] studentAvg = {1, 1, 1, 1, 0, 1, 0, 1};
        int[] studentAvg1 = {1, 0, 1, 0, 0, 0, 0, 1};
        int[] studentAvg2 = {1, 0, 1, 1, 1, 0};
        int[] studentAvg3 = {0, 1, 1, 1, 0, 1};
        System.out.println(minMoves(studentAvg, studentAvg.length) + "\n");
        System.out.println(minMoves(studentAvg1, studentAvg1.length) + "\n");
        System.out.println(minMoves(studentAvg2, studentAvg2.length) + "\n");
        System.out.println(minMoves(studentAvg3, studentAvg3.length) + "\n");
    }

    private static int minMoves(int[] studentAvg, int len) {
        int count = 0, count0 = 0, flag = 1;
        int moves1 = 0, moves0 = 0;
        for (int i = 0; i < len; ++i) {
            if (flag == studentAvg[i]) {
                moves1 += Math.abs(i - count);
                count++;
            } else {
                moves0 += Math.abs(i - count0);
                count0++;
            }
        }
        System.out.println("Phase-1 " + moves1);
        System.out.println("Phase-0 " + moves0);
        return Math.min(moves0, moves1);
    }

}
