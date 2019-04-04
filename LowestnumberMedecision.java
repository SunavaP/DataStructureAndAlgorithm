import java.util.*;

public class LowestnumberMedecision {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        System.out.println(lowestSum(list, 1));
    }

    private static int lowestSum(List<Integer> num, int k) {
        
        PriorityQueue<Integer> priorityQueue = new PriorityQueue(Collections.reverseOrder());
        for (int j : num) {
            priorityQueue.offer(j);
        }

        for (int i = 1; i <= k; ++i) {
            int max = priorityQueue.poll();
            priorityQueue.offer((int) Math.ceil(max / 2.0));
        }

        Iterator<Integer> it = priorityQueue.iterator();
        int sum = 0;
        while (it.hasNext()) {
            sum += it.next();
        }

        return sum;
    }
}
