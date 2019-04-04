import java.lang.reflect.Array;
import java.util.*;

public class KnearestPoints {

    public static void main(String[] args) {
//        int[][] points = {{-2, 4}, {5, -1}, {3, 3}};
        int[][] points = {{1, -3}, {1, 2}, {3, 4}};
        int k = 1;
        System.out.println(Arrays.deepToString(kClosest(points, k)));
    }

    public static int[][] kClosest(int[][] points, int k) {
        int x = 0, y = 0;
        PriorityQueue<List<Double>> priorityQueue = new PriorityQueue<>(new Comparator<List<Double>>() {
            @Override
            public int compare(List<Double> o1, List<Double> o2) {
                return Double.compare(o1.get(0), o2.get(0));
            }
        });
        for (int i = 0; i < points.length; ++i) {
            double distance = euclideanDistance(points[i][0], points[i][1], x, y);
            List<Double> temp = new ArrayList<>();
            temp.add(distance);
            temp.add(i * 1.0);
            priorityQueue.add(temp);
        }
        int[][] result = new int[k][2];
        int pos = 0;
        for (List<Double> temp : priorityQueue) {
            if (pos >= k)
                break;
            int row = (int) Math.round(temp.get(1));
            result[pos][0] = points[row][0];
            result[pos][1] = points[row][1];
            pos++;
        }
        return result;
    }

    private static double euclideanDistance(int x1, int y1, int x2, int y2) {
        double distance = Math.pow(2, (x2 - x1)) + Math.pow(2, (y2 - y1));
        return Math.sqrt(distance);
    }
}
