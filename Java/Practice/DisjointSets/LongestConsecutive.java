package Practice.DisjointSets;
import java.util.*;
class Solution {
    public class LongestConsecutive {
        private int[] id;
        private int[] sz;
        //constructor
        public LongestConsecutive(int N){
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

        public int longestConsecutive(int[] nums) {
            //create a hashmap
            Map<Integer, Integer> map = new HashMap<>();
            int n = nums.length;
            
            //create new disjoint set of size nums.length
            LongestConsecutive lc = new LongestConsecutive(n);


            for(int i = 0; i < n; i++){
                //if key already exists in hashmap, move onto the next
                if(map.containsKey(nums[i])) continue;

                //  if it does not, then put the value into hashmap
                // with a value of i (this is what the disjoint set uses)
                map.put(nums[i], i);

                //check if hashmap contains value of 1 lower than itself
                if(map.containsKey(nums[i] - 1)){
                    // if so, get the val of that number and 
                    // unionize it onto the tree
                    lc.union(i, map.get(nums[i] - 1));
                }

                //same thing above but with 1 higher than itself
                if(map.containsKey(nums[i] + 1)){
                    lc.union(i, map.get(nums[i] + 1));
                }
            }
                
            return lc.greatest();
        }
}