public class PureStorage {

    public static void main(String[] args) {

        System.out.println(countSubstrings("hellolle"));

    }

    public static int countSubstrings(String S) {
        int axis = 0, rightMost = 0;
        if (S.length() <= 1) {
            return S.length();
        }
        final int len = S.length() * 2 + 1;
        char[] ns = new char[len];
        for (int i = 0; i < S.length(); i++) {
            ns[i * 2] = '#';
            ns[i * 2 + 1] = S.charAt(i);
        }
        ns[len - 1] = '#';
        int[] pl = new int[len];
        pl[0] = 0;
        for (int i = 1; i < len; i++) {
            int r, l;
            if (i < rightMost) {
                // System.out.println(axis + ", " + 2 * i+", "+ Arrays.toString(ns));
                r = Math.min(rightMost, i + pl[2 * axis - i]);
                l = 2 * i - r;
            } else {
                r = i;
                l = i;
            }
            while (l >= 0 && r < len && ns[l] == ns[r]) {
                l--;
                r++;
            }
            if (r - 1 > rightMost) {
                rightMost = r - 1;
                axis = i;
            }
            pl[i] = r - 1 - i;
        }
        // System.out.println(Arrays.toString(pl));
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans += pl[i] / 2 + (ns[i] == '#' ? 0 : 1);
        }
        return ans;
    }
}
