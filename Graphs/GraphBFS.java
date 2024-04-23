package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphBFS {
      public static void main(String[] args) {
            int V = 5;
            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                  adjList.add(new ArrayList<>());
            }
            adjList.get(0).add(1);
            adjList.get(0).add(2);
            adjList.get(1).add(2);
            adjList.get(2).add(0);
            adjList.get(2).add(3);
            adjList.get(3).add(3);
            adjList.get(3).add(4);
            adjList.get(4).add(0);
            adjList.get(4).add(1);

            System.out.print("BFS:  ");
            List<Integer> bfs = bfs(V, adjList);
            for (int node : bfs) {
                  System.out.print(node + " ");
            }
            System.out.println();
            System.out.print("DFS:  ");
            List<Integer> dfs = dfs(V, adjList);
            for (int node : dfs) {
                  System.out.print(node + " ");
            }
      }

      public static List<Integer> dfs(int V, List<List<Integer>> adjList) {
            List<Integer> bfs = new ArrayList<>();
            boolean[] visited = new boolean[V + 1];
            visited[0] = true;
            dfsUtil(0, adjList, visited, bfs);
            return bfs;
      }

      public static void dfsUtil(int node, List<List<Integer>> adjList, boolean[] visited, List<Integer> bfs) {
            visited[node] = true;
            bfs.add(node);
            for (int neighbour : adjList.get(node)) {
                  if (!visited[neighbour]) {
                        dfsUtil(neighbour, adjList, visited, bfs);
                  }
            }
      }

      public static List<Integer> bfs(int V, List<List<Integer>> adjList) {
            List<Integer> bfs = new ArrayList<>();
            boolean[] visited = new boolean[V + 1];
            Queue<Integer> queue = new LinkedList<>();

            queue.add(0);
            visited[0] = true;
            while (!queue.isEmpty()) {
                  int node = queue.poll();
                  bfs.add(node);
                  for (int neighbour : adjList.get(node)) {
                        if (!visited[neighbour]) {
                              visited[neighbour] = true;
                              queue.add(neighbour);
                        }
                  }
            }
            return bfs;
      }
}