public class BudgetShopping {

    public static void main(String[] args) {

    }

    static int budgetShopping(int n, int[] bundleQuantities, int[] bundleCosts) {

        if (n <= 0
                || bundleCosts == null || bundleQuantities == null
                || bundleCosts.length == 0 || bundleQuantities.length == 0
                || bundleCosts.length != bundleQuantities.length
        ) {
            return 0;
        }

        final int[] max = {0};

        calculateRecursive(n, bundleCosts, bundleQuantities, max, 0, 0);

        return max[0];
    }

    static void calculateRecursive(int n, int[] cost, int[] quantity, int[] max, int position, int count) {
        if (n == 0 || position == cost.length) {
            if (count > max[0]) {
                max[0] = count;
            }
            return;
        }
        for (int i = 0; i <= n / cost[position]; i++) {
            calculateRecursive(n - i * cost[position], cost, quantity, max, position + 1, count + i * quantity[position]);
        }
    }


}


