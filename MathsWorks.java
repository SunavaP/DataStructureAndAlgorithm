public class MathsWorks {
    public static void main(String[] args) {
        int arr[] = {4,6,2};
        int arr1[] = {1,4,6,2};
//        System.out.println(findmaximum(arr));
//        System.out.println(findmaximum(arr1));
        System.out.println(findnum());
    }

    private static int findnum() {
        int sum = 0;
        for(int i=100;i<=999;++i){
            if(i%4==0 || i%3==0)
                sum++;
        }
        return sum;
    }

    private static int findmaximum(int[] arr) {
        int sum = 0;
        int length = arr.length-1;
        for(int pos=0;pos<length;++pos) {
            sum = sum + findValue(0,pos,arr)*findValue(pos+1,length,arr);
        }
        return sum;
    }

    private static int findValue(int low,int high, int[] arr) {
        int max = Integer.MIN_VALUE;
        while(low<=high){
            max = Math.max(max,arr[low++]);
        }
        return max;
    }
}
