import java.util.LinkedList;
import java.util.PriorityQueue;

public class StringMix {
    public static void main(String[] args) {
        String str = "Are they here";
        String nStr = "yes,they are here";
        // Merge all lists
        stringMix(str, nStr);

    }

    private static void stringMix(String s1, String s2) {
        int[] charLen1 = new int[27];
        for (int i = 0; i < s1.length(); ++i) {
            int num = s1.charAt(i) - 'a';
            if (num >= 0)
                charLen1[num] = charLen1[num] + 1;
        }
        int[] charLen2 = new int[27];
        for (int i = 0; i < s2.length(); ++i) {
            int num = s2.charAt(i) - 'a';
            if (num >= 0)
                charLen2[num] = charLen2[num] + 1;
        }
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (int i = 0; i < charLen1.length; ++i) {
            if(charLen1[i]>1 || charLen2[i]>1) {
                Node node;
                int length1 = charLen1[i];
                int length2 = charLen2[i];
                if(length1>length2) {
                    node = new Node(length1,i,"1");
                } else if(length1<length2) {
                    node = new Node(length2,i,"2");
                } else {
                    node = new Node(length1,i,"=");
                }
                queue.add(node);
            }
        }
        StringBuilder str = new StringBuilder();
        while (!queue.isEmpty()) {
            Node newNode = queue.poll();
            String c = String.valueOf((char)(newNode.pos + 'a'));
            str.append(newNode.cl).append(":");
            for(int i=0;i<newNode.length;++i)
                str.append(c);
            if(queue.size()>0)
                str.append("/");
        }
        System.out.println(str.toString());
    }

    static class Node implements Comparable<Node> {
        int length;
        int pos;
        String cl;

        Node(int length,int pos,String cl) {
            this.length = length;
            this.pos = pos;
            this.cl = cl;
        }


        @Override
        public int compareTo(Node o) {
            int result = o.length-this.length;
            if(result == 0 && o.cl.equals("=") && this.cl.equals("="))
                return this.pos - o.pos;
            else
                return result;
        }
    }
}
