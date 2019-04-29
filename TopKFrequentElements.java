import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] num = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(topKFrequent(num, k));
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> keySet : map.entrySet())
            pq.offer(keySet);
        List<Integer> res = new ArrayList<>();
        while (k > 0) {
            res.add(pq.poll().getKey());
            k--;
        }
        return res;
    }
}
