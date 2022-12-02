package Practice.DisjointSets;

class Solution {
    public class FindRedundantConnection {
    private int[] id;
    private int[] sz;
    //constructor
    public FindRedundantConnection(int N){
        id = new int[N]; 
        sz = new int[N];
        for (int i = 0; i < N; i++){
            sz[i] = 1;
            id[i] = i;
        }
    }
    // this is the find function
    private int root(int i){
        //iterate through the array
        // until the element points to itself (root)
        while (i != id[i]){
            //set it to its own grandparent
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
    // checks if two numbers are connected
    // by checking their id
    public boolean connected(int p, int q){
        return root(p) == root(q);
    }
    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        //already in same root
        // if equal 
        if(i == j) return;
        if(sz[i] < sz[j]){
            id[i] = j;
            sz[j] += sz[i];
        }
        else{
            id[j] = id[i];
            sz[i] += sz[j];
        }
        
    }
    
    // search for the disjoint set with greatest size
    public int greatest(){
        int greatest = 0;
        for(int i = 0; i < sz.length; i++){
            greatest = Math.max(greatest, sz[i]);
        }
        return greatest;
    }
}
public int[] findRedundantConnection(int[][] edges) {
    //first create union find path
        int n = edges.length;
        FindRedundantConnection fr = new FindRedundantConnection(n+1);
        // loop to find if the parent of first edge
        for (int[] edge : edges){
        // is equal to the parent of second edge, 
            if(fr.root(edge[0]) == fr.root(edge[1])){
                //this means we have found the redundant connection
                return new int[] {edge[0], edge[1]};
            }
            else{
                fr.union(edge[0], edge[1]);
            }
        }
        return new int[] {};
}
}