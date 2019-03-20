import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LockAnalyser {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("ACQUIRE 123");
        input.add("ACQUIRE 364");
        input.add("ACQUIRE 84");
        input.add("RELEASE 84");
        input.add("RELEASE 364");
        input.add("ACQUIRE 789");
        input.add("RELEASE 456");
        input.add("RELEASE 123");
        System.out.println(lockAquire(input));
    }

    public static int lockAquire(List<String> input) {
        LinkedList<String> stack = new LinkedList<>();
        int count=0;
        for(String s:input) {
            count++;
            String data[] = s.split(" ");
            if (data[0].equals("ACQUIRE")) {
                stack.addLast(data[1]);
            } else {
                if(stack.peekLast().equals(data[1])) {
                    stack.pollLast();
                }
                else
                    break;
            }
        }
        count = (count == input.size())?count+1:count;
        if(stack.isEmpty()) {
            return 0;
        }
        else {
            return count;
        }

    }
}
