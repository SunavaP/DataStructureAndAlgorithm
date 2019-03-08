public class AddDigits {
    public static void main(String[] args) {
        System.out.println(addDigits(999999));
        System.out.println(addDigits(12344));
    }

//    digital_root(n) = 0 		if n == 0
//    digital_root(n) = 9 		if n != 0 and n % 9 == 0
//    digital_root(n) = n % 9 	if n % 9 != 0
    public static int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }
}
