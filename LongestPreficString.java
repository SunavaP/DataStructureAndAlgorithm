public class LongestPreficString {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        int count = 0;
        if(strs.length<1)
            return "";
        else if(strs.length<2)
            return strs[0];


        int len =strs[0].length();
        for(int i=1;i<strs.length;++i) {
            if(strs[i].length()<len) {
                len = strs[i].length();
            }
        }

        count = 0;
        outerloop:
        for(int i=0;i<len;++i) {
            Character c = strs[0].charAt(i);
            for(int j=1;j<strs.length;++j) {
                if(c!=strs[j].charAt(i))
                    break outerloop;
            }
            count++;
        }

        return strs[0].substring(0,count);
    }
}
