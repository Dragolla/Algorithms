package Notes.QuickUnion;
import java.util.Arrays;
public class QuickUnionUF{
    private int[] id;
    private int[] sz;
    //constructor
    public QuickUnionUF(int[] N){
        id = N;
        sz = new int[N.length];
        for (int i = 0; i < N.length; i++){
            sz[i] = 1;
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
    public void returnID(){
        System.out.println(Arrays.toString(id));
    }
}