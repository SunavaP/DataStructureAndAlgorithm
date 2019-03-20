import java.util.ArrayList;
import java.util.List;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        System.out.println("Hello world!");

    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length<k?nums.length:k;
        int max = Integer.MIN_VALUE;
        int pos = 0;
        for(int i=0;i<length;++i) {
            if(nums[i]>max) {
                max = nums[i];
                pos = i;
            }
        }
        if(length<3)
            return new int[]{max};

        length = nums.length;

        int []array = new int[length-k+1] ;
        for(int i=3;i<length;++i) {
            if(pos<i-2) {

            } else{
                if(nums[i]>max) {
                    max = nums[i];
                    pos = i;
                }
            }
        }
        return array;
    }
}
