package Les7;

import java.util.List;
import java.util.Stack;

public interface IGraph {

    void addVertex(String label);

    void addEdge(String startLabel, String endLabel);

    void addEdges(String startLabel, String secondLabel, String... others);

    int getSize();

    void display();

    /**
     * англ. Depth-first search, DFS
     */
    void dfs(String startLabel);

    /**
     * англ. breadth-first search, BFS
     */
    void bfs(String startLabel);

    List<Stack<String>> findShortPathViaBfs(String startLabel, String finishLabel);
}
