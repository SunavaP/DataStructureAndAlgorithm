import java.util.Arrays;
import java.util.LinkedList;

public class DirectionsReductions {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"})));
        System.out.println(Arrays.toString(dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"})));
    }

    public static String[] dirReduc(String arr[]){
        if(arr.length < 1)
            return null;
        LinkedList<String> stack = new LinkedList<>();
        stack.offer(arr[0]);
        for(int i=1;i<arr.length;++i) {
            String s = arr[i];
            if(s.equalsIgnoreCase("North")){
                if(!stack.isEmpty() && stack.peekLast().equalsIgnoreCase("South") ) {
                    stack.removeLast();
                } else {
                    stack.offer(s);
                }
            } else if(s.equalsIgnoreCase("South")){
                if(!stack.isEmpty() && stack.peekLast().equalsIgnoreCase("North") ) {
                    stack.removeLast();
                } else {
                    stack.offer(s);
                }
            } else if(s.equalsIgnoreCase("East")){
                if(!stack.isEmpty() && stack.peekLast().equalsIgnoreCase("West") ) {
                    stack.removeLast();
                } else {
                    stack.offer(s);
                }
            } else if(s.equalsIgnoreCase("West")){
                if(!stack.isEmpty() && stack.peekLast().equalsIgnoreCase("East") ) {
                    stack.removeLast();
                } else {
                    stack.offer(s);
                }
            }
        }
        return stack.toArray(new String[0]);
    }
}
