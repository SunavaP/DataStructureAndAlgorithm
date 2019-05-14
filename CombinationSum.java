import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        int[] candidate = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidate, target));
        // Knapsack solution
        System.out.println(combinationSumKnapSack(candidate, target));
        int[] candidate2 = {2, 3};
        int target2 = 8;
        System.out.println(combinationSum(candidate2, target2));

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combine(candidates, target, result, new ArrayList<>());
        return result;

    }

    private static void combine(int[] candidates, int target, List<List<Integer>> result,
                                List<Integer> current) {
        if (target == 0) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(current);
            Collections.sort(temp);
            if (!result.contains(temp))
                result.add(temp);
            return;
        } else if (target < 0)
            return;

        for (int i : candidates) {
            current.add(i);
            combine(candidates, target - i, result, current);
            // Very Important part
            current.remove(current.size() - 1);
        }

    }

    public static List<List<Integer>> combinationSumKnapSack(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combineKnapSack(candidates, 0, target, 0, new ArrayList<>(), result);
        return result;

    }


    private static void combineKnapSack(int[] candidates, int start, int target, int sum, List<Integer> current,
                                        List<List<Integer>> result) {
        if (sum > target) {
            return;
        }

        if (sum == target) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            combineKnapSack(candidates, i, target, sum + candidates[i], current, result);
            current.remove(current.size() - 1);
        }

    }
}
