import java.util.*;

public class RemovingElementFromListError {

    public static void main(String[] args) {
        // Check that multiple occurrences of d is not removed
        List<String> ll = new ArrayList<>(Arrays.asList("a", "b", "c", "d","d"));
        for (int i = 0; i < ll.size(); i++) {
            if (ll.get(i).equalsIgnoreCase("d"))
                ll.remove(i);
        }
        System.out.println(ll);

        List<Integer> al = new ArrayList<>();
        al.add(10);
        al.add(20);
        al.add(30);
        al.add(1);
        al.add(2);
        al.add(1);


        // Check that multiple occurrences of 1 is not removed
        // This makes a call to remove(Object) and
        // removes element 1
        al.remove(new Integer(1));

        // This makes a call to remove(Object) and
        // removes element 2
        al.remove(new Integer(2));

        System.out.println("Modified ArrayList : " + al);


        //Right method
        ArrayList<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "d"));
//        Iterator<String> iter = list.iterator();
        list.removeIf(s -> s.equals("d"));
        System.out.println("Modified ArrayList  : " + list);


        ArrayList<String> newList = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "d"));
        newList.removeAll(Collections.singleton("first"));

        System.out.println("Modified ArrayList : " + list);
    }
}
