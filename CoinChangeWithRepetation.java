import java.util.ArrayList;
import java.util.List;

public class CoinChangeWithRepetation {

    public static void main(String[] args) {

        List<String> result = countWays(8,2);
        System.out.println(result.toString());
        System.out.println(result.size());
    }

    private static List<String> countWays(int total, int k) {
        List<String> results = new ArrayList<>();
        countWays(total, 0,k,"", results);
        return results;
    }

    private static void countWays(int total,int start, int k,String partial, List<String> results) {
        if (start == total) {
            results.add(partial);
            return;
        } else if (start >= total) {
            return;
        }
        for (int i = 1; i <= k; ++i) {
            countWays(total, start+i, k,partial + i, results);
        }
    }

}