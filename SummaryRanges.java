import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums = {0,12,22,23,24};
        System.out.println(summaryRanges(nums));
        System.out.println(summaryRangesLastNFirst(nums));
    }

    private static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int pre = nums[0]; // previous element
        int first = pre; // first element of each range

        for(int i=1; i<nums.length; i++){
            if(nums[i]==pre+1){
                if(i==nums.length-1){
                    result.add(first+"->"+nums[i]);
                }
            }else{
                if(first == pre){
                    result.add(first+"");
                }else{
                    result.add(first + "->"+pre);
                }

                if(i==nums.length-1){
                    result.add(nums[i]+"");
                }

                first = nums[i];
            }

            pre = nums[i];
        }
        return result;

    }


    private static List<String> summaryRangesLastNFirst(int[] nums) {
        List<String> result = new ArrayList<>();
        if(nums.length < 2) {
            result.add(nums.length < 1 ? "" :String.valueOf(nums[0]));
            return result;
        }


        StringBuilder str = new StringBuilder();
        for (int i = 1; i < nums.length ; ++i) {
            if (nums[i - 1] + 1 == nums[i]) {
                str.append(nums[i - 1]);
            } else {
                str.append(nums[i - 1]);
                if(str.length()>1) {
                    result.add(str.charAt(0)+"->"+str.charAt(str.length()-1));
                } else {
                    result.add(str.toString());
                }
                str = new StringBuilder();
            }
        }
        if(!str.toString().isEmpty()) {
            str.append(str.charAt(0)).append("->");
            result.add(str.charAt(0) + "->"+nums[nums.length - 1]);
        } else {
            result.add(""+nums[nums.length - 1]);
        }

        return result;
    }
}
