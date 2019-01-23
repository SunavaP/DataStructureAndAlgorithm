public class AdditionWithoutAdd {

    public static void main(String[] args) {
        System.out.println("chutia");
        int x = 25;
        int y = 74;
        while (y != 0)
        {
            // carry now contains common
            // set bits of x and y
            int carry = x & y;

            // Sum of bits of x and
            // y where at least one
            // of the bits is not set
            x = x ^ y;

            // Carry is shifted by
            // one so that adding it
            // to x gives the required sum
            y = carry << 1;
            System.out.println(x);
        }
        System.out.println(y);

    }
}