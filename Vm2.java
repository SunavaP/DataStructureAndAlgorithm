import java.util.Arrays;
import java.util.List;

public class Vm2 {

    public static void main(String[] args) {
        String a = "abcesffisohu";

        filterVowel(a);

    }

    private static void filterVowel(String a) {
        Character vowels[] = {'a', 'e', 'i', 'o', 'u','A','E','I','O','U'};

        List<Character> al = Arrays.asList(vowels);

        StringBuffer sb = new StringBuffer();
        StringBuffer vo = new StringBuffer();

        for (int i = 0; i < a.length(); i++) {

            if(al.contains(a.charAt(i))){
                sb.append(a.charAt(i));
            } else {
                vo.append(a.charAt(i));
            }
        }
        System.out.println(sb.toString() +"\n" + vo.toString());

    }


}
