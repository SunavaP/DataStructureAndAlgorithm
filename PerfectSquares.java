public class PerfectSquares {
    public static void main(String[] args) {
        int a = 9, b = 25;
        System.out.println(perfectSquare(a,b));
    }

    static int perfectSquare(int A, int B) {

        return (int) (Math.abs(Math.floor(Math.sqrt(B)) - Math.ceil(Math.sqrt(A))) + 1);
    }
}
