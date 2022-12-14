import java.io.*;
import java.util.*;

class Graph{
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int V = sc.nextInt();
        int E = sc.nextInt();

        /* Write Your Code Here
         * Complete the Rest of the Program
         * You have to take input and print the output yourself
         */
        EdgeClass[] edge = new EdgeClass[E];
        //int i = 0;
        for(int i = 0; i<E; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int w = sc.nextInt();
            edge[i] = new EdgeClass(v1, v2, w);
        }
        Arrays.sort(edge);
        EdgeClass[] mst = kruskalsAlgoright(edge, V);
        for(EdgeClass e : mst){
            if(e.src < e.dest){
                System.out.println(e.src + " " + e.dest + " " + e.weight);
            }else {
                System.out.println(e.dest + " " + e.src + " " + e.weight);
            }
        }

    }

    private static EdgeClass[] kruskalsAlgoright(EdgeClass[] edge, int v) {
        EdgeClass[] mst = new EdgeClass[v-1];
        int[] parent = new int[v];
        for(int j = 0; j<v ; j++){
            parent[j] = j;
        }

        int count = 0,  i = 0;
        while(count != v-1){
            EdgeClass curr = edge[i++];
            int parent1 = findParent(curr.src, parent);
            int parent2 = findParent(curr.dest, parent);
            if(parent1 != parent2){
                mst[count] = curr;
                count++;
                parent[parent1] = parent2;
            }
        }

        return mst;
    }

    private static int findParent(int src, int[] parent) {
        if(src == parent[src]) return src;
        return findParent(parent[src], parent);
    }


}

class EdgeClass implements Comparable<EdgeClass> {
    int src, dest, weight;

    EdgeClass(int src, int dest, int weight){
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public int compareTo(EdgeClass compareEdge)
    {
        return this.weight - compareEdge.weight;
    }
}


