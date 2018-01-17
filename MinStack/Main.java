package MinStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args)
    {
        MinStack min = new MinStack();
        min.push(-2);
        min.push(0);
        min.push(-3);
        int x = min.getMin();
        System.out.println(x);
        min.pop();
        System.out.println(min.top());
        int y = min.getMin();
        System.out.print(y);
    }
}

class MinStack {

    /** initialize your data structure here. */
    ArrayList<Integer> list;
    public MinStack() {
        list = new ArrayList<>();
    }

    public void push(int x) {
        list.add(x);
    }

    public void pop() {
        list.remove(list.size()-1);
    }

    public int top() {
        return list.get(list.size()-1);
    }

    public int getMin() {
        int result = list.get(0);
        for(int i=0;i<list.size();i++)
        {
            if (result>list.get(i))
            {
                result = list.get(i);
            }
        }
        return result;
    }
}