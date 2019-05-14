// JAVA program to print all
// paths from a source to
// destination.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// A directed graph using
// adjacency list representation
public class ShortestPathClutter {

    // No. of vertices in graph
    private int v;

    // adjacency list
    private ArrayList<Nodal>[] adjList;

    //Constructor
    public ShortestPathClutter(int vertices) {

        //initialise vertex count
        this.v = vertices;

        // initialise adjacency list
        initAdjList();
    }

    // utility method to initialise
    // adjacency list
    @SuppressWarnings("unchecked")
    private void initAdjList() {
        adjList = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    // add edge from u to v
    public void addEdge(int u, Nodal v) {
        // Add v to u's list.
        adjList[u].add(v);
    }


    // add edge from u to v
    public void addEdge(int u, int v) {
        // Add v to u's list.
//        adjList[u].add(v);
    }

    // Prints all paths from
    // 's' to 'd'
    public void printAllPaths(int s, int d) {
        boolean[] isVisited = new boolean[v];
        ArrayList<Integer> pathList = new ArrayList<>();

        //add source to path[]
        pathList.add(s);

        HashSet<Integer> set = new HashSet<>();
        //Call recursive utility
        printAllPathsUtil(0, s, d, isVisited, pathList, set);

        System.out.println(set);
    }

    // A recursive function to print
    // all paths from 'u' to 'd'.
    // isVisited[] keeps track of
    // vertices in current path.
    // localPathList<> stores actual
    // vertices in the current path
    private void printAllPathsUtil(Integer sum, Integer u, Integer d,
                                   boolean[] isVisited,
                                   List<Integer> localPathList, HashSet<Integer> set) {

        // Mark the current node
        isVisited[u] = true;

        if (u.equals(d)) {
            System.out.println(localPathList);
            set.addAll(localPathList);
            // if match found then no need to traverse more till depth
            isVisited[u] = false;
            return;
        }

        // Recur for all the vertices
        // adjacent to current vertex
        for (Nodal i : adjList[u]) {
            if (!isVisited[i.destination]) {
                // store current node
                // in path[]
                localPathList.add(i.destination);
                sum = sum + i.distance;
                printAllPathsUtil(sum, i.destination, d, isVisited, localPathList, set);

                // remove current node
                // in path[]
                localPathList.remove(localPathList.size() - 1);
            }
        }

        // Mark the current node
        isVisited[u] = false;
    }

    // Driver program
    public static void main(String[] args) {
        // Create a sample graph
        ShortestPathClutter g = new ShortestPathClutter(5);
        g.addEdge(1, new Nodal(2, 1));
        g.addEdge(1, new Nodal(3, 1));
        g.addEdge(1, new Nodal(4, 1));
        g.addEdge(2, new Nodal(3, 1));
        g.addEdge(2, new Nodal(4, 1));
        // arbitrary source
        int s = 1;

        // arbitrary destination
        int d = 4;

        System.out.println("Following are all different paths from " + s + " to " + d);
        g.printAllPaths(s, d);

    }
}

// This code is contributed by Himanshu Shekhar.
