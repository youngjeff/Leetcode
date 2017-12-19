package InsertInterval;
import java.util.*;
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class Main {
    public static void main(String[] args)
    {
        ArrayList<Interval> list = new ArrayList<Interval>();
        list.add(new Interval(1,3));list.add(new Interval(6,9));
        Solution sl = new Solution();
        List<Interval>  data = sl.insert(list,new Interval(2,5));
        for(int i=0;i<data.size();i++)
            System.out.println(data.get(i).start+" "+data.get(i).end);
    }
}
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                if(o1.start == o2.start)
                {
                    return 0;
                }
                else{
                    return o1.start - o2.start;
                }
            }
        });

        for(int i=1;i<intervals.size();)
        {
            if(intervals.get(i).start <= intervals.get(i-1).end)
            {
                intervals.set(i-1, new Interval(intervals.get(i-1).start,Math.max(intervals.get(i).end,intervals.get(i-1).end)));
                intervals.remove(i);
            }
            else{
                i++;
            }
        }
        return intervals;
    }
}