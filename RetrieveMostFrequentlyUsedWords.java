import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RetrieveMostFrequentlyUsedWords {

    public static void main(String[] args) {
//        String sentence = "Rose is a flower red rose are flower";
        String sentence = "Jack and Ji ll went to the market to buy bread and cheese. Cheese is Jack's and Jill's favorite food";
        List<String> words = new ArrayList<>();
//        words.add("is");
//        words.add("are");
//        words.add("a");
        words.add("and");
        words.add("he");
        words.add("the");
        words.add("to");
        words.add("is");
        words.add("Jack");
        words.add("Jill");
        System.out.println(retriveMostFrquentlyUsedWords(sentence, words));
    }

    public static List<String> retriveMostFrquentlyUsedWords(String literatureText, List<String> wordsToExclude) {
        List<String> res = new ArrayList<>();
        List<String> newSt = new ArrayList<>();
        for (String s : wordsToExclude)
            newSt.add(s.toLowerCase());

        HashMap<String, Integer> map = new HashMap<>();
        String[] array = fetchWords(literatureText);
        int max = Integer.MIN_VALUE;
        for (String i : array) {
            String temp = i.toLowerCase();
            if (!newSt.contains(temp)) {
                if (map.containsKey(temp)) {
                    int size = map.get(temp);
                    map.put(temp, size + 1);
                    max = Math.max(max, size + 1);
                } else {
                    map.put(temp, 1);
                    max = Math.max(max,1);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                res.add(entry.getKey());
            }
        }

        return res;
    }


    private static String[] fetchWords(String s)
    {
        Pattern p = Pattern.compile("[a-zA-Z]+");

        Matcher m1 = p.matcher(s);

        List<String> strlist = new ArrayList<>();
        while (m1.find()) {
            // System.out.println(m1.group().getClass());
            strlist.add(m1.group());
        }

        String[] strArr = new String[strlist.size()];
        int i = 0;
        for(String s1 : strlist) {
            strArr[i++] = s1;
        }


        return strArr;
    }
}