public class BuddyStrings {

    public static void main(String[] args) {
        System.out.println(buddyStrings("ab", "ba")); // true
        System.out.println(buddyStrings("ab", "ab")); // false
        System.out.println(buddyStrings("aa", "aa")); // true
        System.out.println(buddyStrings("aaaaaaabc", "aaaaaaacb")); // true
        System.out.println(buddyStrings("", "aa")); // false
        System.out.println(buddyStrings("", "")); // false
        System.out.println(buddyStrings("ab","ca")); // false
        System.out.println(buddyStrings("abab","abab")); // false
    }

    public static boolean buddyStrings(String A, String B) {

        if (A.length() != B.length())
            return false;
        if (A.length() < 2)
            return false;
        char fs = 0;
        char sc = 0;
        int count = 0;
        for (int i = 0; i < A.length(); ++i) {
            if (A.charAt(i) != B.charAt(i)) {
                if (count == 1) {
                    if (A.charAt(i) != sc || B.charAt(i) != fs)
                        return false;
                }
                count++;
                fs = A.charAt(i);
                sc = B.charAt(i);
            }

        }
        if (count == 0)
            for (int i = 0; i < A.length() - 1; ++i)
                if (A.charAt(i) != A.charAt(i + 1))
                    return false;
        return count <= 2;
    }
}

