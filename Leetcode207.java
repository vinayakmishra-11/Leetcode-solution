import java.util.*;
import java.util.*;
public class Leetcode207 {
    public static void main(String[] args) {

    }
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int n = numCourses;
            if(n==0) return false;
            boolean[] v = new boolean[n];
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for(int i =0 ; i<n ;i++){
                list.add(new ArrayList<>());
            }


            for (int i = 0; i < prerequisites.length; i++) { // adjency list
                for (int j = 1; j < 2; j++) {

                    list.get(prerequisites[i][j]).add(prerequisites[i][0]);

                }
            }

            int[] id = new int[n]; // indegeree array intialization
            ArrayList<Integer> ans = new ArrayList<>();

            for(int i =0 ; i<n;i++){ // in degree calculation
                for(int neh : list.get(i)){
                    int temp = id[neh];
                    temp++;
                    id[neh] = temp;
                }
            }

            Queue<Integer> q = new LinkedList<>();
            for(int i=0;i<id.length;i++){ // insert id with 0
                if(id[i]==0){
                    q.add(i);
                }
            }

            while(!q.isEmpty()){
                int curr = q.poll();
                ans.add(curr);
                for(int neh : list.get(curr)){
                    int temp = id[neh];
                    temp--;
                    id[neh] = temp;
                    if(id[neh]==0){
                        q.add(neh);
                    }
                }
            }
            if(ans.size() != n){
                return false ; // cycle exists
            }
            return true;
        }
    }
}
