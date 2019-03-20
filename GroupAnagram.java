import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();

    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> hs = new HashMap<>();
        //Most important !!!
        List<List<String>> result = new ArrayList<>();
        for(String a:strs) {
            // System.out.println(a);
            char tempArray[] = a.toCharArray();
            Arrays.sort(tempArray);
            String temp = new String(tempArray);
            if(hs.containsKey(temp)) {
                List<String> ls = hs.get(temp);
                ls.add(a);
                hs.put(temp,ls);
            } else {
                List<String> ls = new ArrayList<>();
                ls.add(a);
                hs.put(temp,ls);
            }


        }
        // Read this statement
        result.addAll(hs.values());
        return result;
    }
}
