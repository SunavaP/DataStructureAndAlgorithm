import java.util.Arrays;

public class RansomNote {
    public static void main(String[] args) {
        System.out.println(canConstruct("fffbfg", "effjfggbffjdgbjjhhdegh")); //true
        System.out.println(canConstruct("aa", "aab")); //true
        System.out.println(canConstruct("a", "b")); //false
        System.out.println(canConstruct("aa", "ab")); //false
        System.out.println(canConstruct("", "aba")); //true
        System.out.println(canConstruct("bjaajgea", "affhiiicabhbdchbidghccijjbfjfhjeddgggbajhidhjchiedhdibgeaecffbbbefiabjdhggihccec")); //true
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] array = new int[127];
//        Arrays.fill(array, 0);

        for (int i = 0; i < magazine.length(); ++i) {
            array[magazine.charAt(i)] = array[magazine.charAt(i)] + 1;

        }
        for (int i = 0; i < ransomNote.length(); ++i) {
            array[ransomNote.charAt(i)] = array[ransomNote.charAt(i)] - 1;
            if (array[ransomNote.charAt(i)] < 0)
                return false;
        }
        return true;
    }
}