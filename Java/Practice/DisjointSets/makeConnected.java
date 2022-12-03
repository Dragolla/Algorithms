package Practice.DisjointSets;
class Solution {
    public class DisjointSet{
        private int[] id;
        private int[] sz;
        int n;
        //constructor
        public DisjointSet(int N){
            id = new int[N]; 
            sz = new int[N];
            n = N;
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
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
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
                n--;
            }
            else{
                id[j] = id[i];
                sz[i] += sz[j];
                n--;
            }
            
        }
        
    }
    // intuition: each connection should lead to the same root, those
    // that are, are ignored; leave n the same.  
    // Computers that don't lead to the same root should be unionized,
    // decrease n by 1. In the end, n should be the amount of extra 
    // connections left over. 
    
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1) return -1;
        DisjointSet ds = new DisjointSet(n);
        for(int[] connection : connections){
            ds.union(connection[0], connection[1]);
        }
        return ds.n - 1;
    }
}