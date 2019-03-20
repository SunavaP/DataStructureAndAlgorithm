public class MaximumProductSum {

    public static void main(String[] args) {
//        int[] numm = {2, -5,2,3,4};
//        int[] numm = {2, -5,0,3,4};
//        int[] numm = {2, -5,2,-3,4};
        int[] numm = {-2, -3, 0, -2, -40};


        int output = maxProduct(numm);
        System.out.println(output);

    }

    public static int maxProduct(int[] nums) {
        int max = 1;
        int result = 1;
        int min = 1;

        for (int i = 0; i < nums.length; i++) {

            if(nums[i]==0){
                max = 1;
                min = 1;
            } else if(nums[i]<0){
                int temp = max;
                max = Math.max(min*nums[i],1);
                min = temp*nums[i];
            } else {
                max = max*nums[i];
                min = Math.min(min*nums[i],1);
            }
            result = Math.max(result, max);
        }

        return result;
    }

}
