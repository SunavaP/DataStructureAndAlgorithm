import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6,7},2);
    }
    private static void rotate(int[] nums, int k) {
        if (nums == null || nums.length==0 || k < 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }
        if(k > nums.length){
            k = k %nums.length;
        }
        //length of first part
        int a = nums.length - k;
        reverse(nums, 0, a-1);
        reverse(nums, a, nums.length-1);
        reverse(nums, 0, nums.length-1);
    }
    public static void reverse(int[] arr, int left, int right){
        if(arr == null || arr.length == 1)
            return;
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
