import java.util.Arrays;

public class FirstAndLastPosition {
    public static void main(String[] args) {
        int n[] = {5, 7, 7, 8, 8, 10, 11, 14, 15, 15, 16, 17};
        System.out.println(Arrays.toString(searchRange(n, 1)));
    }

    private static int[] searchRange(int[] nums, int target) {
        boolean found = false;
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (high + low) / 2;
            if (nums[mid] < target)
                low = mid + 1;
            else if (nums[mid] > target)
                high = mid - 1;
            else {
                found = true;
                break;
            }
        }

        if (!found)
            return new int[]{-1, -1};


        System.out.println(found + " " + mid);
        low = 0;
        high = mid;
        int temp = mid;
        int[] position = new int[2];
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] != target)
                low = mid + 1;
            else if (nums[mid] == target) {

                if (mid == 0 || nums[mid] != nums[mid - 1]) {
                    position[0] = mid;
                    break;
                }

                high = mid - 1;
            }

        }
        System.out.println(position[0]);
        low = temp;
        high = nums.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] != target)
                high = mid - 1;
            else if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid] != nums[mid + 1]) {
                    position[1] = mid;
                    break;
                }

                low = mid + 1;
            }

        }
        System.out.println(position[1]);
        return nums;
    }
}
