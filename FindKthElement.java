import java.util.PriorityQueue;

public class FindKthElement {
    public static void main(String[] args) {

        int[] nums = {1,2,5,0,9,6,3,4};
        int k = 3;
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for(int i: nums){
            q.offer(i);

            if(q.size()>k){
                q.poll();
            }
        }
        System.out.println(q.peek());

    }
}
