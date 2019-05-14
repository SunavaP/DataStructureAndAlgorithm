import java.util.*;

public class MergeKSortedArray {
    public static void main(String[] args) {
        int k = 3; // Number of linked lists
        int n = 4; // Number of elements in each list

        // an array of pointers storing the head nodes
        // of the linked lists
        LinkedList<Integer> arr[] = new LinkedList[k];

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
        mergeAllLIst(arr, k);

        // Merge k Sorted Lists
        // mergeAllList(ListNode[] arr)

    }

    private static void mergeAllLIst(LinkedList<Integer>[] arr, int k) {
        PriorityQueue<ComponentNode> queue = new PriorityQueue<>();
        for (LinkedList<Integer> a : arr) {
            ComponentNode newNode = new ComponentNode(a);
            queue.add(newNode);
        }
        LinkedList<Integer> newList = new LinkedList<>();
        while (!queue.isEmpty()) {
            ComponentNode newNode = queue.poll();
            newList.add(newNode.list.getFirst());
            newNode.list.removeFirst();
            if (!newNode.list.isEmpty()) {
                queue.add(newNode);
            }
        }
        System.out.println(newList);
    }

    static class ComponentNode implements Comparable<ComponentNode> {
        LinkedList<Integer> list;

        ComponentNode(LinkedList<Integer> l) {
            list = l;
        }

        @Override
        public int compareTo(ComponentNode o) {
            return this.list.getFirst() - o.list.getFirst();
        }
    }

    private static ListNode mergeAllList(ListNode[] arr) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
//        Collections.addAll(queue,arr);
        for(ListNode a:arr){
            if(a!=null)
                queue.add(a);
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (!queue.isEmpty()) {
            ListNode newNode = queue.poll();
            cur.next = newNode;
            cur = cur.next;

            if (newNode.next!=null) {
                queue.add(newNode.next);
            }
        }
        return head.next;
    }

}
