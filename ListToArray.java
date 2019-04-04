import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListToArray {

    public static void main(String[] args) {
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        ArrayList<Integer> k ;
        k = new ArrayList<Integer>();

        k.add(1);
        k.add(0);
        k.add(1);
        k.add(1);
        k.add(0);
        l.add(k);

        k = new ArrayList<Integer>();

        k.add(0);
        k.add(1);
        k.add(0);
        k.add(0);
        k.add(1);
        l.add(k);

        k = new ArrayList<Integer>();

        k.add(1);
        k.add(0);
        k.add(1);
        k.add(1);
        k.add(0);
        l.add(k);

        k = new ArrayList<Integer>();

        k.add(1);
        k.add(0);
        k.add(1);
        k.add(1);
        k.add(0);
        l.add(k);

        k = new ArrayList<Integer>();

        k.add(0);
        k.add(1);
        k.add(0);
        k.add(0);
        k.add(1);
        l.add(k);
        System.out.println(Arrays.deepToString(listToArray(l)));
    }

    private static int[][] listToArray(List<List<Integer>> l) {
        int m =l.size();
        int n = l.get(0).size();
        int[][] mat = new int[m][n];
        int i = 0,j=0;

        for(List<Integer> c: l) {
            j=0;
            for(Integer r: c)
            {
                mat[i][j] =  r;
                j++;
            }
            i++;
        }

        return mat;
    }
}
