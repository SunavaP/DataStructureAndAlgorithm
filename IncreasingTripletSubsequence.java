public class IncreasingTripletSubsequence {

    public static void main(String[] args) {
        int[] nums = {5,9,9,8,6,2,7,-1};
        System.out.println(increasingTriplet(nums));
    }

    private static boolean increasingTriplet(int[] nums) {

        if (nums.length < 3)
            return false;
        int pre = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {

            if (nums[i] > pre) {
                count++;
            } else {
                count = 1;
            }
            pre = nums[i];
            if (count == 3)
                return true;

        }
        return false;
    }
}
