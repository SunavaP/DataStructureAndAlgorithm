import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BuildOffices
{
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) {
        System.out.println(findMinDist(14,2,5));
    }

    static int findMinDist(int w, int h, int n)
    {

        int[][] grid = new int[w][h];
        for(int i=0;i<w;i++)
            Arrays.fill(grid[i],-1);
        return solve(n,w,h,0,0,grid);
    }

    static int bfs(int W, int H, int[][] grid) {

        int[][] dist = new int[W][H];
        for(int i=0;i<W;i++)
            for(int j=0;j<H;j++)
                dist[i][j] = grid[i][j];

        int maxDist = 0;
        Queue<Location> Q = new LinkedList<>();
        for(int i = 0; i < W; i++)
            for(int j = 0; j < H; j++)
                if(dist[i][j] == 0){
                    Q.add(new Location(i,j));
                }

        while(!Q.isEmpty()) {
            int x = Q.peek().first;
            int y = Q.peek().second;
            maxDist = Math.max(maxDist, dist[x][y]);
            Q.poll();

            for(int d = 0; d < 4; d++) {
                int newx = x + dx[d];
                int newy = y + dy[d];

                if(newx >= W || newy >= H || newx < 0 || newy < 0)
                    continue;
                if(dist[newx][newy] == -1) {
                    dist[newx][newy] = dist[x][y] + 1;
                    Q.add(new Location(newx, newy));
                }
            }
        }
        return maxDist;
    }

    static int solve(int left, int W, int H, int row, int col,int[][] grid) {
        if(left == 0) {
            return bfs(W,H,grid);
        }
        int r = row,c=col;
        if(col >= H) {
            r += col/H;
            c = col%H;
        }
        int minDistance = Integer.MAX_VALUE;
        for(int i=r;i<W;i++){
            for(int j=c;j<H;j++) {
                //Mark Building locations in the recursive call.
                grid[i][j] = 0;
                int val = solve(left-1, W, H,i,j+1,grid);
                minDistance = Math.min(minDistance, val);
                // Remove the building
                grid[i][j] = -1;
            }
        }
        return minDistance;
    }
}


class Location {
    int first;
    int second;
    Location(int x, int y) {
        first = x;
        second = y;
    }
}