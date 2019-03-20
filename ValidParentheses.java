import java.util.LinkedList;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("([)]")); //false
        System.out.println(isValid("()[]{}")); //true
        System.out.println(isValid("(]")); //false
        System.out.println(isValid("{[]}")); //true
    }
    private static boolean isValid(String s) {

        LinkedList<Character> stack = new LinkedList<>();
        if(s.length()<1)
            return true;
        if(s.length()<2)
            return false;
        int i=0;
        while(i<s.length()) {

            if (s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[') {
                stack.add(s.charAt(i));
                ++i;
                continue;
            }
            char c;
            if(!stack.isEmpty())
                c = stack.pollLast();
            else
                return false;
            if(s.charAt(i)==')') {
                if(c!='(')
                    return false;
            } else if(s.charAt(i)=='}') {
                if(c!='{')
                    return false;
            } else if(s.charAt(i)==']') {
                if(c!='[')
                    return false;
            }
            ++i;
        }

        return stack.isEmpty();
    }
}
