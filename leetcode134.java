class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalgas =0 ;
        int totalcost =0;

        for(int ele : gas) totalgas+=ele;
        for(int ele : cost) totalcost+=ele;

        if(totalcost>totalgas) return -1;
        
        int[] diff = new int[gas.length];
        int tank=0;
        int start =0 ;
        for(int i =0 ;i<gas.length;i++){
            tank += gas[i] - cost[i];
            if(tank<0){
                start=i+1;
                tank=0;
            }
        }
        return start;

        
       

    }
}

// class Solution {
//     public int canCompleteCircuit(int[] gas, int[] cost) {
//         int[] diff = new int[gas.length];

//         for(int i =0 ;i<gas.length;i++){
//             diff[i] = gas[i] - cost[i];
//         }

//         int start =0 ;
//         int max = Integer.MIN_VALUE;

//         for(int i =0 ;i<gas.length;i++){
//             if(diff[i]>max){
//                 max=diff[i];
//                 start=i;
//             }
//         }
//         int count =0;
//         int left =0 ;
//         boolean flag = true;
//         for(int i =0 ;i<gas.length;i++){
//             count =0 ;
//             left=0;
//             start = i;
//             flag = true;
//             if(gas[start]<cost[start]) continue;
//             while(count<gas.length){
//             int tank = gas[start]+left;
//              left= tank-cost[start];
//             if(left<0){
//                 flag = false;
//                 break;
//             }
//             start = (start+1)%gas.length;
//             count++;

//         }
//         if(flag) return start;

//         }
//         return -1;

//     }
// }