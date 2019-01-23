public class Sol {

    // Driver code
    public static void main(String[] args) {
        int A[] = {-1,0,4,2,1};
        int D =3;
        int[] finalA = new int[A.length];
        for(int i=0;i<A.length;++i)
        {
            finalA[i] = findParent(A,i,D);

            System.out.println(finalA[i]);

        }

    }

    private static int findParent(int[] a, int i,int D) {

        if(a[i]==-1 && D>0)
            return -1;

        if (D <= 0)
            return i ;

        return findParent(a,a[i],--D);
    }


}
