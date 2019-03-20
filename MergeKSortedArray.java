import java.util.LinkedList;
import java.util.PriorityQueue;

public class MergeKSortedArray {
    public static void main(String[] args) {
        int k = 3; // Number of linked lists
        int n = 4; // Number of elements in each list

        // an array of pointers storing the head nodes
        // of the linked lists
        LinkedList<Integer> arr[]= new LinkedList[k];

        arr[0] = new LinkedList<Integer>();
        arr[0].add(3);
        arr[0].add(5);
        arr[0].add(7);

        arr[1] = new LinkedList<Integer>();
        arr[1].add(4);
        arr[1].add(6);
        arr[1].add(8);

        arr[2] = new LinkedList<Integer>();
        arr[2].add(9);
        arr[2].add(10);
        arr[2].add(11);

        // Merge all lists
        mergeAllLIst(arr,k);

    }

    private static void mergeAllLIst(LinkedList<Integer>[] arr,int k) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (LinkedList<Integer> a:arr) {
            Node newNode = new Node(a);
            queue.add(newNode);
        }
        LinkedList<Integer> newList = new LinkedList<>();
        while (!queue.isEmpty()) {
            Node newNode = queue.poll();
            newList.add(newNode.list.getFirst());
            newNode.list.removeFirst();
            if(!newNode.list.isEmpty()) {
                queue.add(newNode);
            }
        }
        System.out.println(newList);
    }

    static class Node implements Comparable<Node>{
        LinkedList<Integer> list;

        Node(LinkedList<Integer> l) {
            list = l;
        }

        @Override
        public int compareTo(Node o) {
            return this.list.getFirst() - o.list.getFirst();
        }
    }
}
