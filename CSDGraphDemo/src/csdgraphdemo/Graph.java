package csdgraphdemo;

/**
 *
 * @author tranp
 */
public class Graph {

    /**
     * @param args the command line arguments
     */
    int A[][] = {{0, 7, 9, 0, 0, 14},
    {7, 0, 10, 15, 0, 0},
    {9, 10, 0, 11, 0, 2},
    {0, 15, 11, 0, 6, 0},
    {0, 0, 0, 6, 0, 9},
    {14, 0, 2, 0, 9, 0}};
    int n; //size of matrix
    char V[] = "123456".toCharArray(); // store node as characters
    char Q[] = "123456".toCharArray();
    int color[]; // to pain a node as black

    void BFT(int k) // traversal from node k
    {
        Queue Q = new Queue(10);
        n = A.length;
        System.out.println(n);
        color = new int[n]; // create color array
        for (int i = 0; i < n; i++) {
            color[i] = 0; // paint white to all v

        }
        Q.Enqueue(k); // put the vertice k to Q
        color[k] = 1; //paint k as black
        while (!Q.isEmpty()) {
            int u = Q.dequeue(); // take a vertice
            for (int j = 0; j < n; j++) {
                if (color[j] == 0 && A[u][j] != 0) {
                    color[j] = 1; // paint as black
                    Q.Enqueue(j);
                }
            }
            System.out.print(V[u] + " ");
        }
    }

    void DFS_Visit(int color[], int v) {
        n = A.length;
        color[v] = 1; // mark V is visited
        System.out.print(Q[v] + " "); // print out v
        for (int i = 0; i < n; i++) {
            if (A[v][i] != 0 && color[i] == 0) {
                DFS_Visit(color, i); // add v to Stack 
            }
        }

    }

    void DFS(int k) {
        n = A.length;
        color = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = 0;
        }
        DFS_Visit(color, k);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Graph j = new Graph();
        j.BFT(5);
        System.out.println("\n===========");
        j.DFS(2);
    }

}
