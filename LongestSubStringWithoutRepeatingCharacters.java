public class LongestSubStringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String input1 = "abcabcbb";
        String input2 = "bbbbb";
        String input3 = "pwwkew";
        String input4 = " ";
        System.out.println(lengthOfLongestSubstring(input1)); // abc : 3
        System.out.println(lengthOfLongestSubstring(input2)); // b : 1
        System.out.println(lengthOfLongestSubstring(input3)); // wke : 3
        System.out.println(lengthOfLongestSubstring(input4)); // " " : 1
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() < 1)
            return 0;
        StringBuilder str = new StringBuilder();
        int max = Integer.MIN_VALUE;
        str.append(s.charAt(0));
        for (int i = 1; i < s.length(); ++i) {
            char c = s.charAt(i);
            int pos = str.indexOf(String.valueOf(c));
            if (pos >= 0) {
                max = Math.max(max, str.length());
                str = new StringBuilder(str.substring(pos+1));
            }
            str.append(c);
        }
        return Math.max(max,str.length());
    }
}
