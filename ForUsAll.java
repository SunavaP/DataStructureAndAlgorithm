import java.util.*;

public class ForUsAll {
    public static void main(String[] args) {


        int minLength =2;//minLength
        int maxLength =3;//maxLength
        int maxUnique =4;//maxUnique

        String s = "ababab";
        int length = s.length();

        Map<String, Integer> substrCount = new HashMap<String, Integer>();

        for (int c = 0 ; c < length ; c++) {
            for (int i = 2 ; i <= length - c ; i++) {
                String sub = s.substring(c, c+i);
                if (sub.length() < minLength || sub.length() > maxLength) {
                    continue;
                }
                int distinct = countDistinct(sub);
                if (distinct < 2 || distinct > maxUnique) {
                    continue;
                }
                if (substrCount.containsKey(sub)) {
                    substrCount.put(sub, substrCount.get(sub) + 1);
                } else {
                    substrCount.put(sub, 1);
                }
            }
        }

        Set<String> count = rank(substrCount);
        System.out.println(Integer.valueOf(count.iterator().next().substring(0, 6)));
    }

    private static int countDistinct(String sub) {
        int distinct = 0;
        Set<Character> chars = new HashSet<Character>();
        for (Character character : sub.toLowerCase().toCharArray()) {
            if (chars.add(character)) {
                distinct++;
            }
        }
        return distinct;
    }

    private static Set<String> rank(Map<String, Integer> substrCount) {
        Set<String> count = new TreeSet<String>(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        for (Map.Entry<String, Integer> entry : substrCount.entrySet()) {
            int zeroes = 6 - String.valueOf(entry.getValue()).length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < zeroes; i++) {
                sb.append("0");
            }
            sb.append(entry.getValue());
            count.add(sb.toString() + entry.getKey());
        }
        return count;
    }
}
