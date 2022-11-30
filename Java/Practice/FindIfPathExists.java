package Practice;
import Notes.QuickUnion.QuickUnionUF;
public class FindIfPathExists {
    private int[] id;
    private int[] sz;
    //constructor
    public FindIfPathExists(int N){
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
    public static void main(String[] args) {
        int[][] edges = {{2,0},{0,1},{1,2}};
        int n = 3;
        int start = 0;
        int end = 2;
        
        //   0          1            2
        // ^edge[0]   ^edge[1]     ^edge[2]
        // {2, 0}:
        // unite 2 and 0 = 0 1 0
        // {0, 1}
        // unite 0 and 1 = 0 0 0
        // {1, 2}
        // unite 1 and 2 = 0 0 0 
        // array itself is all the same; path found

        // given {{0,1},{1,3},{2,0}} and n = 
        FindIfPathExists u = new FindIfPathExists(n);

        for(int[] edge : edges){
            u.union(edge[0], edge[1]);
        }
        System.out.println(u.connected(start, end));
	}
}
