import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int a[] ={1,2,3,4,5,6,7,8,9};
        int target = 8;
        System.out.println(twoSum(a,target));
    }

    public static int[] twoSum(int[] a, int target) {
        Map<Integer,Integer> diff = new HashMap<>();
        for(int i=0;i<a.length;++i) {
            if(diff.containsKey(a[i])) {
                return new int[]{i, diff.get(a[i])};
            }
            diff.put(target-a[i],i);
        }
        return null;
    }
}
