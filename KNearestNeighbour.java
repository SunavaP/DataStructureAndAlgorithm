import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// 12/22 test case passed

public class KNearestNeighbour {

    public static void main(String[] args) {
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> l1 = new ArrayList<>();
//        l1.add(1);
//        l1.add(-3);
//        result.add(l1);
//        List<Integer> l2 = new ArrayList<>();
//        l2.add(1);
//        l2.add(2);
//        result.add(l2);
//        List<Integer> l3 = new ArrayList<>();
//        l3.add(3);
//        l3.add(4);
//        result.add(l3);

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
        System.out.println(kClosest(totalCrates, allocations, totaltruckcapacity));
    }

    public static List<List<Integer>> kClosest(int totalCrates, List<List<Integer>> points, int truckCapacity) {
        List<List<Integer>> result = new ArrayList<>(truckCapacity);

        if(totalCrates < 1)
            return result;
        if(points.isEmpty())
            return result;
        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });
        for (int i = 0; i < totalCrates; ++i) {
            int distance = euclideanDistance(points.get(i).get(0), points.get(i).get(1));
            List<Integer> temp = new ArrayList<>();
            temp.add(distance);
            temp.add(i);
            priorityQueue.add(temp);
        }

        truckCapacity = totalCrates >= truckCapacity ? truckCapacity : totalCrates;

        int size = 0;
        for (List<Integer> temp : priorityQueue) {
            if (size >= truckCapacity)
                break;
            int row = temp.get(1);
            result.add(points.get(row));
            size++;
        }
        return result;
    }

    private static int euclideanDistance(int x1, int y1) {
        return x1 * x1 + y1 * y1;
    }

}
