import java.util.*;
import java.util.stream.Collectors;

public class ArrayToListAndReverse {

    public static void main(String[] args) {

        int array[] = {1, 2, 2, 3, 4, 4, 5, 5, 5, 7, 9, 8};
        // Not working
//        List<Integer> list = new ArrayList<Integer>(Arrays.asList(array));
        // Not working
//        List<Integer> list = Arrays.asList(array);
        // Not working
//        List<Integer> list = new ArrayList<>(array.length);
//        Collections.addAll(list,array);

        // Working
        List<Integer> list = Arrays.stream(array)		// IntStream
                .boxed()  		// Stream<Integer>
                .collect(Collectors.toList());

        // Since array is in int
        List<Integer> intList = new ArrayList<>();
        for (int i : array)
            intList.add(i);

        Integer [] listToArray = intList.toArray(new Integer[0]);
        Integer [] listToArray2 = (Integer[]) intList.toArray();


        System.out.println(intList);
        System.out.println(Arrays.toString(array));

        Node[] arrayUserType = {new Node(1, "sun"), new Node(1, "Moon"),
                new Node(1, "rin"), new Node(1, "kun")};
        // Working
        List<Node> listNode = new ArrayList<>(Arrays.asList(arrayUserType));

        System.out.println(listNode);
        System.out.println(Arrays.toString(arrayUserType));

//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

    }
}
