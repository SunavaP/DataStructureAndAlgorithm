import java.util.Random;

public class MinimumNumber {

    public static void main(String[] args) {
        int a = 1;
        System.out.println(arbitaryNumber(a));
    }

    private static int arbitaryNumber(int N) {
        int max = 1000000000;
        Random random = new Random();
        int number = random.nextInt(max - N) + N;
        int lower = (number / 10) * 10;
        int upper = lower + 10;
        number = (number - lower > upper - number) ? upper : lower;
        return number > N ? number : upper;
    }
}
