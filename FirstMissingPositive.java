public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] num = {1};
        System.out.println(firstMissingPositive(num));
    }

    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        boolean a[] = new boolean[len];
        for(int i:nums) {
            if(i>0 && i<len)
                a[i-1] = true;
        }
        int i=0;
        for(;i<len;++i) {
            if(!a[i])
                return i+1;
        }
        return i+1;
    }
}
