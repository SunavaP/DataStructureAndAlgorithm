public class MergeTwoStrings {

    public static void main(String[] args) {
        String a = "abc";
        String b = "sas";

        String output = merge(a, b);
        System.out.println(output);

    }

    private static String merge(String a, String b) {
        int lengthA = a.length();
        int lengthB = b.length();
        if (lengthA == 0)
            return b;
        if (lengthB == 0)
            return a;
        StringBuilder finalString = new StringBuilder();


        int i = 0, j = 0;
        while (i < lengthA && j < lengthB) {
            finalString.append(a.charAt(i++));
            finalString.append(b.charAt(j++));
        }
        if (i != lengthA) {
            finalString.append(a.substring(i));
        }
        if (j != lengthB) {
            finalString.append(b.substring(j));
        }
        return finalString.toString();
    }


}
