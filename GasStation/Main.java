package GasStation;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        Solution sl = new Solution();
        int[] gas = {1,2};
        int[] cost = {2,1};
        int a = sl.canCompleteCircuit(gas,cost);
        System.out.println(a);
    }
}
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        for(int i = 0; i < gas.length; i++)
            tank += gas[i] - cost[i];
        if(tank < 0)
            return - 1;

        int start = 0;
        int accumulate = 0;
        for(int i = 0; i < gas.length; i++){
            int curGain = gas[i] - cost[i];
            if(accumulate + curGain < 0){
                start = i + 1;
                accumulate = 0;
            }
            else accumulate += curGain;
        }

        return start;
    }
}