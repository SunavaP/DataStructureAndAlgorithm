public class ContainerWithMostWater {

    public static void main(String[] args) {
        int a[] = {1,8,5,7,2,1,4,3};
        System.out.println(maxArea(a));
    }

    public static int maxArea(int[] a) {
        int low =0;
        int high = a.length-1;
        int max = Integer.MIN_VALUE;
        while(low<=high) {
            int vol = Math.min(a[low],a[high]) * (high-low);
            max = Math.max(max,vol);
            if(a[low]<=a[high]) {
                low++;
            } else {
                high--;
            }
        }
        return max;
    }
}
