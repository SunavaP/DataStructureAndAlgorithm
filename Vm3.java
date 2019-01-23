import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Vm3 {

    public static void main(String[] args) {
        List<Integer> al = new ArrayList<Integer>();
        al.add(1);
        al.add(1);
        al.add(1);
        al.add(1);
        al.add(1);

        uniqueArrays(al);

    }

    private static void uniqueArrays(List<Integer> a) {

        Collections.sort(a);
        Integer previous = null;
        int sum = 0;
        for (int i = 0; i < a.size(); i++)
        {
            if (previous != null && previous >= a.get(i))
            {
                a.set(i,previous + 1);
            }

            previous = a.get(i);
            sum += previous;
        }


        System.out.println(sum);

    }


}
