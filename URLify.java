import java.util.Scanner;

public class URLify {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int index = in.nextInt();
        char[] charArray = s.toCharArray();
        System.out.println(urlifyUsingInSpace(charArray, index-1));
    }

    public static String urlifyUsingInSpace(char[] charArray, int index) {
        int  i = charArray.length-1;
        for (; index >= 0; --index) {

            if (charArray[index] == ' ') {
                charArray[i--] = '%';
                charArray[i--] = '2';
                charArray[i--] = '0';
            } else {
                charArray[i--] = charArray[index];
            }

        }
        String result = new String(charArray);
        return result.substring(i+1);
    }

}
