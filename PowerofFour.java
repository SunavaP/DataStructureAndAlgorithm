public class PowerofFour {

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(1));
        System.out.println(isPowerOfFour(3));
        System.out.println(isPowerOfFour(-7));
        System.out.println(isPowerOfFour(32));
        //Imp test case
        System.out.println(isPowerOfFour(0));
        System.out.println(isPowerOfFour(9));
        System.out.println(isPowerOfFour(1));
    }

    public static boolean isPowerOfFour(int num) {
        if(num<=0)
            return false;
        int a = (int) (Math.log(num)/Math.log(4));
        if(Math.pow(4,a) == num)
        {
            return true;
        }

        return false;

    }
}
