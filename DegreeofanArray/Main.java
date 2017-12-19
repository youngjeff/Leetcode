package DegreeofanArray;

import java.util.*;

public class Main {
    public static  void main(String[] args)
    {
        Solution sl = new Solution();
        int[] nums = {1, 2, 2, 3, 1};
        System.out.println(sl.findShortestSubArray(nums));
    }
}
class Solution {
    public int findShortestSubArray(int[] nums) {
        int len = nums.length;int max = 0;int min = Integer.MAX_VALUE;if(len == 0) return 0;
        Map<Integer, Integer> count = new HashMap<>();Map<Integer, Integer> starts = new HashMap<>();Map<Integer, Integer> ends = new HashMap<>();
        for(int i=0;i<len;i++){if(!count.containsKey(nums[i])){count.put(nums[i],0);starts.put(nums[i],i);}ends.put(nums[i],i);count.put(nums[i], count.get(nums[i])+1);max = Math.max(count.get(nums[i]), max);}
        for(Integer key: count.keySet()){if(count.get(key) == max){min = Math.min(min, ends.get(key) - starts.get(key)+1);}}
        return min;
    }
}