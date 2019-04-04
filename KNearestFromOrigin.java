import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KNearestFromOrigin {
    public static void main(String[] args) {
        int totalCrates = 6;
        int totaltruckcapacity = 3 ;
        List<List<Integer>> allocations = new ArrayList<List<Integer>>();

        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(3);
        list1.add(6);

        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(2);
        list2.add(4);

        List<Integer> list3 = new ArrayList<Integer>();
        list3.add(5);
        list3.add(3);

        List<Integer> list4 = new ArrayList<Integer>();
        list4.add(2);
        list4.add(7);


        List<Integer> list5 = new ArrayList<Integer>();
        list5.add(1);
        list5.add(8);

        List<Integer> list6 = new ArrayList<Integer>();
        list6.add(7);
        list6.add(9);

        allocations.add(list1);
        allocations.add(list2);
        allocations.add(list3);
        allocations.add(list4);
        allocations.add(list5);
        allocations.add(list6);
        System.out.println(listToArray(totalCrates, allocations, totaltruckcapacity));
    }

    private static int[][] listToArray(int totalCrates, List<List<Integer>> l,int k) {
        int m =l.size();
        int n = l.get(0).size();
        int[][] mat = new int[m][n];
        int i = 0,j=0;

        for(List<Integer> c: l) {
            j=0;
            for(Integer r: c)
            {
                mat[i][j] =  r;
                j++;
            }
            i++;
        }

        return kClosest(totalCrates, mat,k);
    }


    public static int[][] kClosest(int totalCrates, int[][] points, int k) {
        int[][] result = new int[k][2];
        if (points == null || k <= 0) {
            return result;
        }

        if (points.length <= k) {
            return points;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return getDistance(b) - getDistance(a);
        });

        for (int i = 0; i < points.length; i++) {
            pq.offer(points[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        for (int i = 0; i < k; i++) {
            int[] point = pq.poll();
            result[i][0] = point[0];
            result[i][1] = point[1];
        }
        return result;
    }

    public static int getDistance(int[] points) {
        return points[0] * points[0] + points[1] * points[1];
    }
}
