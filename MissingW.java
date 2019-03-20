public class MissingW {

    public static void main(String[] args) {

        String s = "I am using hackerrank to improve programming";
        String t ="am hackerrank to improve";

        String[] a = s.split(" ");
        String[] b = t.split(" ");
        StringBuilder bs = new StringBuilder();

        for (int i=0,j=0; i<a.length;++i) {

            if (!a[i].equals(b[j]))
                bs.append(a[i]+" ");
            else if (j<b.length-1)
                ++j;
        }
        System.out.print(bs.toString());
    }
}
