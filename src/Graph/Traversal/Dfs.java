package Graph.Traversal;

import java.util.*;

public class Dfs {

    /***
     *
     * ** Problem statement
     * Given an undirected and disconnected graph G(V, E), containing 'V' vertices and 'E' edges,
     * the information about edges is given using 'GRAPH' matrix, where i-th edge is between GRAPH[i][0]
     * and GRAPH[i][1]. print its DFS traversal.
     *
     * V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
     *
     * E is the number of edges present in graph G.
     * Note :
     * The Graph may not be connected i.e there may exist multiple components in a graph.
     * Detailed explanation ( Input/output format, Notes, Images )
     * Constraints :
     * 2 <= V <= 10^3
     * 1 <= E <= (5 * (10^3))
     *
     * Time Limit: 1sec
     * Sample Input 1:
     * 5 4
     * 0 2
     * 0 1
     * 1 2
     * 3 4
     * Sample Output 1:
     * 2
     * 0 1 2
     * 3 4
     * Explanation For Sample Input 1:
     * If we do a DFS traversal from vertex 0 we will get a component with vertices [0, 2, 1].
     * If we do a DFS traversal from 3 we will get another component with vertices [3, 4]
     *
     * Hence,  we have two disconnected components so on the first line, print 2.
     * Now, print each component in increasing order. On the first line print 0 1 2 and
     * on the second line, print 3 4.
     *
     * [0 1 2] comes before [3 4] as the first vertex 0 from the first component is smaller than the first vertex 3 from the second component.
     * Sample Input 2:
     * 9 7
     * 0 1
     * 0 2
     * 0 5
     * 3 6
     * 7 4
     * 4 8
     * 7 8
     * Sample Output 2:
     * 3
     * 0 1 2 5
     * 3 6
     * 4 7 8
     *
     *
     *
     * Question Link : https://www.naukri.com/code360/problems/dfs-traversal_630462
     *
     */

    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> dfs = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < v; i++)
            adjList.add(new ArrayList<>());
        for (int i = 0; i < e; i++) {
            adjList.get(edges.get(i).get(0)).add(edges.get(i).get(1));
            adjList.get(edges.get(i).get(1)).add(edges.get(i).get(0));
        }
        int visited[] = new int[v];
        for(int i=0;i<v;i++)
        {
            if(visited[i]==0)
            {
                ArrayList<Integer> dfsPath = new ArrayList<>();
                dfsPath.add(i);
                visited[i]=1;
                depthFirstSearch(v,adjList,visited,i,dfsPath);
                dfs.add(dfsPath);
            }
        }
        return dfs;
    }

    public static void depthFirstSearch(int v, ArrayList<ArrayList<Integer>> adjList, int visited[], Integer curNode, ArrayList<Integer> dfsPath) {
        if (adjList.get(curNode).isEmpty())
            return;
        for (int dfsNodes : adjList.get(curNode)) {
            if (visited[dfsNodes] == 0) {
                visited[dfsNodes] = 1;
                dfsPath.add(dfsNodes);
                depthFirstSearch(v, adjList, visited, dfsNodes, dfsPath);
            }
        }
        return;
    }

    public static void main(String args[])
    {
        // dfs graph traversal algorithm
        int v = 9;
        int e = 7;
        int [][] edgesArray = {{0,1},{0,2},{0,5},{3,6},{7,4},{4,8},{7,8}};
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int[] edgesElement : edgesArray)
        {
            ArrayList<Integer> edgesElements = new ArrayList<>();
            edgesElements.add(edgesElement[0]);
            edgesElements.add(edgesElement[1]);
            edges.add(edgesElements);
        }
        ArrayList<ArrayList<Integer>>dfs =  depthFirstSearch(v,e,edges);
        dfs.stream().forEach(a->{
            a.forEach(b->System.out.print(b+" "));
            System.out.println();
        });
    }
}
