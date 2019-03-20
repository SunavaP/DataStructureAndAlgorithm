public class NonDecreasingArray {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 3, 3, 2, 4})); //true
        System.out.println(solution(new int[]{-1, 4, 2, 3})); //true
        System.out.println(solution(new int[]{4, 2, 3})); //true
        System.out.println(solution(new int[]{3, 4, 2, 3})); //false
        System.out.println(solution(new int[]{1, 4, 2, 3})); //true
    }

    public static boolean solution(int[] nums) {
        if (nums.length < 3)
            return true;
        boolean flag = false;
        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] > nums[i + 1]) {
                if (flag)
                    return false;
                flag = true;
                if (i > 0 && i < nums.length - 2) {
                    if (nums[i - 1] <= nums[i] && nums[i] <= nums[i + 2])
                        nums[i + 1] = nums[i];
                    else if (nums[i - 1] <= nums[i + 1] && nums[i + 1] <= nums[i + 2])
                        nums[i] = nums[i + 1];
                    else
                        return false;

                }

            }

        }
        return true;
    }

  /*  public static  boolean checkPossibility(int[] nums) {
        if(nums.length < 3)
            return true;
        int prev = nums[0], count = 0, prev1 = Integer.MAX_VALUE;
        for(int i=1;i<=nums.length-1;i++) {
            if(prev <= nums[i] || prev1 <= nums[i] )  {
                prev1 = Integer.MAX_VALUE;
                prev = nums[i];
                continue;
            }else {
                count++;
                if(count >1)
                    return false;
               //if(i>=2 && nums[i-2] > Math.min(nums[i-1],nums[i]))
                prev1 = nums[i];


            }
        }

        return true;
    } */

    public static boolean checkPossibility(int[] nums) {
        if (nums.length < 3)
            return true;
        int prev = nums[0];
        for (int i = 1; i <= nums.length - 1; i++) {
            if (prev > nums[i]) {
                int temp = nums[i];
                nums[i] = prev;
                if (!checkIncreasing(nums)) {
                    nums[i] = temp;
                    nums[i - 1] = temp;
                    if (!checkIncreasing(nums))
                        return false;
                }
            }
            prev = nums[i];
        }
        return true;
    }

    public static boolean checkIncreasing(int[] nums) {
        int pr = nums[0];
        for (int i = 1; i <= nums.length - 1; i++) {
            if (pr > nums[i]) {
                return false;
            }
            pr = nums[i];
        }
        return true;
    }
}
