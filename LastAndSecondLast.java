public class LastAndSecondLast {

    public static void main(String[] args) {
        System.out.println(lastLetters("APPLE"));
        System.out.println(lastLetters("bat"));
    }

    public static String lastLetters(String word) {

        String str = word.substring(word.length() - 2);
        StringBuilder result = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; --i) {
            if (i != 0)
                result.append(str.charAt(i)).append(" ");
            else
                result.append(str.charAt(i));
        }
        return result.toString();
    }
}
