public class ReverseWordsInString {

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWordsSolution("the sky is blue"));
    }

    private static String reverseWords(String s) {
        if (s.trim().length() == 0)
            return "";
        StringBuilder str = new StringBuilder();
        StringBuilder result = new StringBuilder();
        boolean flag = false;
        int len = s.length() - 1;
        for (int i = 0; i <= len; ++i) {
            char a = s.charAt(i);
            if (a == ' ') {
                if (flag)
                    continue;
                if(result.length()>0)
                    str.append(a);
                str.append(result);
                result = str;
                str = new StringBuilder();
                flag = true;
            } else {
                str.append(a);
                flag = false;
            }
        }
        str.trimToSize();
        if (str.length() > 0) {
            if(result.length()>0)
                str.append(' ');
            str.append(result);
            return str.toString();
        } else
            return result.toString();
    }

    public static String reverseWordsSolution(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while(i >= 0){
            if(s.charAt(i) == ' '){
                i--;
                continue;
            }
            int start = s.lastIndexOf(' ', i);
            sb.append(' ');
            sb.append(s.substring(start + 1, i + 1));
            i = start - 1;
        }
        if(sb.length() > 0){
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}
