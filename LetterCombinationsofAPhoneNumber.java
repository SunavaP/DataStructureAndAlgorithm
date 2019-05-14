import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsofAPhoneNumber {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        List<String> list = new ArrayList<>();
        System.out.println(printNumber(list, 0, map,"238",""));
        System.out.println(printNumber(list, 0, map,"9",""));
    }

    private static List<String> printNumber(List<String> list, int pos, HashMap<Integer, String> map,String input,
                                            String result) {
        if(pos > input.length())
            return null;
        if(input.length() == result.length()) {
            list.add(result);
            return list;
        }
        int number = Character.getNumericValue(input.charAt(pos));
        String variable = map.get(number);
        for (int i = 0; i <variable.length();++i) {
            printNumber(list,pos+1,map,input,result+variable.charAt(i));
        }
        return list;
    }


}
