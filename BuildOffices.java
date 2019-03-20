//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.PriorityQueue;
//
//
//public class BuildOffices {
//    public void main(String[] args) {
//        N = 2;
//        System.out.println(solve(0,N));
//    }
//
//    int W, H, N;
////
//    int dx[] = {1, -1, 0, 0};
//    int dy[] = {0, 0, -1, 1};
////
//    int calc(int i, int j) {
//        if(W <= H)
//            return  i + W * j;
//        return H * i + j;
//    }
////
//    boolean get(int bitmask, int i, int j) {
////        return (bitmask && (1<<calc(i,j)));
//    }
//
//    int bfs(int bitmask) {
//        int dist[][] = new int[W][H];
//////        memset(dist, -1, sizeof dist);
//        Arrays.fill(dist,-1);
//
//        int maxDist = 0;
//        queue<pair<int,int>> Q;
////        PriorityQueue<Integer> Q = new PriorityQueue<>();
////
//        for(int i = 0; i < W; i++)
//            for(int j = 0; j < H; j++)
//                if(get(bitmask, i, j)) {
//                    dist[i][j] = 0;
//                    Q.offer({i, j});
//                }
//        assert(Q.size() == N);
//
//        while(!Q.empty()) {
//            int x = Q.front().first;
//            int y = Q.front().second;
//            maxDist = Math.max(maxDist, dist[x][y]);
//            Q.pop();
//
//            for(int d = 0; d < 4; d++) {
//                int newx = x + dx[d];
//                int newy = y + dy[d];
//
//                if(newx >= W || newy >= H || newx < 0 || newy < 0)
//                    continue;
//                if(dist[newx][newy] == -1) {
//                    dist[newx][newy] = dist[x][y] + 1;
//                    Q.push({newx, newy});
//                }
//            }
//        }
//
//        return maxDist;
//    }
////
//    HashMap<HashMap<Integer,Integer>, Integer> dp;
////
//    int solve(int bitmask, int left) {
//        if(left == 0) {
//            return bfs(bitmask);
//        }
//        if(dp.put({bitmask, left}) != dp.end()) {
//            return dp[{bitmask, left}];
//        }
//        int minDistance = Integer.MAX_VALUE;
//        for(int i = 0; i < W; i++)
//            for(int j = 0; j < H; j++)
//                if(!get(bitmask, i, j)) {
//                    int val = solve((bitmask|(1<<calc(i, j))), left-1);
//                    minDistance = Math.min(minDistance, val);
//                }
//        return dp[{bitmask, left}] = minDistance;
//    }
//
//
//
//}
