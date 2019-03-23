import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountingGroup {
    public static void main(String[] args) {
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        ArrayList<Integer> k ;
        k = new ArrayList<Integer>();

        k.add(1);
        k.add(0);
        k.add(1);
        k.add(1);
        k.add(0);
        l.add(k);

        k = new ArrayList<Integer>();

        k.add(0);
        k.add(1);
        k.add(0);
        k.add(0);
        k.add(1);
        l.add(k);

        k = new ArrayList<Integer>();

        k.add(1);
        k.add(0);
        k.add(1);
        k.add(1);
        k.add(0);
        l.add(k);

        k = new ArrayList<Integer>();

        k.add(1);
        k.add(0);
        k.add(1);
        k.add(1);
        k.add(0);
        l.add(k);

        k = new ArrayList<Integer>();

        k.add(0);
        k.add(1);
        k.add(0);
        k.add(0);
        k.add(1);
        l.add(k);


        ArrayList<Integer> t=  new ArrayList<Integer>();
        t.add(1);
        t.add(2);
        t.add(3);
        t.add(4);
        t.add(5);
        System.out.println(countGroups(l,t));

    }

    public static List<Integer> countGroups(List<List<Integer>> l, List<Integer> t) {
        int m =l.size();
        int n = l.get(0).size();
        int[][] mat = new int[m][n];
        int i = 0,j=0;

        for(List<Integer> c: l) {
            j=0;
            for(Integer r: c)
            {
                mat[i][j] =  r;
                j++;
            }
            i++;
        }

        return maxAreaOfIsland(mat,t);
    }

    public static List<Integer> maxAreaOfIsland(int[][] grid,List<Integer> t) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return null;
        }
        Map<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> result=  new ArrayList<>();
//        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = explore(grid, i, j);
                    if(map.containsKey(area)) {
                        int newCount = map.get(area) + 1;
                        map.put(area,newCount);
                    } else {
                        map.put(area,1);
                    }

//                    result.add(explore(grid, i, j));
                }
            }
        }

        for(Integer temp:t){
            result.add(map.getOrDefault(temp, 0));
        }
        return result;
    }

    public static int explore(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        int area = 1;
        grid[i][j] = 0;
        area += explore(grid, i - 1, j) + explore(grid, i + 1, j) + explore(grid, i, j - 1) + explore(grid, i, j + 1);
        return area;
    }
}
