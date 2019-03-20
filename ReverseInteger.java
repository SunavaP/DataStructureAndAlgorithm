public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(-1563847412));
    }
    public static int reverse(int x) {
        long n=0;
        int z=0;
        if (x<0)
            z =-x;
        else
            z = x;
        while(z>0) {
            n = n*10 + z%10;
            z = z/10;
        }

        if(x<0) {
            // Reversing an integer can result in min lesser than MIN_VALUE
            if(-n<Integer.MIN_VALUE)
                return 0;
            return (int)-n;
        }
        else {
            // Reversing an integer can result in max greater than MAX_VALUE
            if(n>Integer.MAX_VALUE)
                return 0;
            return (int)n;
        }
    }
}
