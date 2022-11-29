package Notes.QuickUnion;
public class Main {
	public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3 ,4 , 5, 6, 7, 8, 9};
        QuickUnionUF uf = new QuickUnionUF(arr);
        //makes the whole thing into a branch based off first element
        /* 
        for(int i=1; i < arr.length; i++){
            if(arr[i-1] != arr[i]){
                while(!uf.connected(arr[i-1], arr[i])){
                    uf.union(arr[i-1], arr[i]);
                    uf.returnID();
                }   
            }
            else {
                uf.returnID();
            }
        }
        */
        int[] arr2 = {1, 1, 1, 2, 2, 2, 2, 2};
        int p = 0;
        int q = 4;
        QuickUnionUF uf2 = new QuickUnionUF(arr2);
        uf2.union(p, q); 
        uf2.returnID();
	}
}
