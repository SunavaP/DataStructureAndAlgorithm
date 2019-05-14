public class SortingOn {

    public static void main(String[] args) {
        int[] a = {1,2,0,4,3};
        sort(a);
    }

    // 0 1 2 3 4
    public static void sort(int a[]) {
        boolean flag = false;
        int position = 0;
        while(flag) {
            if(a[position]!=position) {
                int temp = a[position];
                position = a[temp];
                a[temp] = temp;
            }
        }
    }
}
