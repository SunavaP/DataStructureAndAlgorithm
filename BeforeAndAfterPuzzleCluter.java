import java.util.*;

public class BeforeAndAfterPuzzleCluter {

    public static void main(String[] args) {
        String[] array = {
                "mission statement",
                "a quick bite to eat",
                "a chip off the old block",
                "chocolate bar",
                "mission impossible",
                "a man on a mission",
                "block party",
                "eat my words",
                "bar of soap"};
        List<String> input = Arrays.asList(array);
        System.out.println(generate_phrases(input));
    }


    public static List<String> generate_phrases(List<String> phrases) {
        HashMap<String, int[]> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        int i = 0;
        for (String res : phrases) {
            String[] array = res.split(" ");
            if (!map.containsKey(array[0]))
                map.put(array[0],new int[] {0,i});
            else {
                int[] pos = map.get(array[0]);
                if (pos[0] != 0) {
                    String str = concat(phrases.get(pos[1]), res);
                    result.add(str);
                }
            }

            int len = array.length - 1;
            if (!map.containsKey(array[len]))
                map.put(array[len], new int[] {len,i});
            else {
                int[] pos = map.get(array[len]);
                if (pos[0] != len) {
                    String str = concat(res, phrases.get(pos[1]));
                    result.add(str);
                }
            }
            ++i;
        }


        return result;
    }

    private static String concat(String left, String right) {

        System.out.println("\n" + left + "   " + right);
        String commonString = "";
        for (int i = 0; i < left.length(); i++) {
            if (right.indexOf(left.substring(i)) >= 0) {
                commonString = left.substring(i);
                break;
            }
        }

        System.out.println("\n common is :" + commonString);

        String firstPart = left.substring(0, left.indexOf(commonString));
        String secondPart = right.substring(right.indexOf(commonString) + commonString.length());
        String finalString = firstPart + commonString + secondPart;

        System.out.println("\n Final String of " + left + " ------ " + right + " ===> " + finalString);
        return finalString;

    }

}
