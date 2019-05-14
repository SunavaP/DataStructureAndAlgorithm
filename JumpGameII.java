public class JumpGameII {

    // Driver method to test the above function
    public static void main(String[] args) {
//        int arr[] = new int[]{2, 3, 1, 3, 1, 7, 1};
        int arr[] = new int[]{3,2,1,0,4};

//        int arr[] = new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};

        // calling minJumps method
        System.out.println(jump(arr));
        System.out.println(jumps(arr));
    }


    static int jump(int arr[]) {
        if (arr.length <= 1)
            return 0;

        // Return -1 if not possible to jump
        if (arr[0] == 0)
            return -1;

        // initialization
        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;


        // Start traversing array
        for (int i = 1; i < arr.length; i++) {
            // Check if we have reached the end of the array
            if (i == arr.length - 1)
                return jump;

            // updating maxReach
            maxReach = Math.max(maxReach, i + arr[i]);

            // we use a step to get to the current index
            step--;

            // If no further steps left
            if (step == 0) {
                // we must have used a jump
                jump++;

                //Check if the current index/position or lesser index
                // is the maximum reach point from the previous indexes
                if (i >= maxReach)
                    return -1;

                // re-initialize the steps to the amount
                // of steps to reach maxReach from position i.
                step = maxReach - i;
            }
        }

        return -1;
    }

    // Minimum solution
    // {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
    public static int jumps(int[] nums) {
        int jumps = 0, curEnd = 0, nextEnd = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curEnd >= nums.length - 1) {
                return jumps;
            }
            nextEnd = Math.max(nextEnd, i + nums[i]);
            System.out.println("i   : " + i);
            System.out.println("nextEnd : " + nextEnd);
            if (i == curEnd) {
                jumps++;
                curEnd = nextEnd;
                System.out.println("Jumps : " + jumps);
            }
            System.out.println("curREnd : " + curEnd);
            System.out.println("--------------------------");
        }
        return -1;
    }

}
