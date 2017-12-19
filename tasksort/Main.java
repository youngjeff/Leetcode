package nod.tasksort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        Node[] node = new Node[n];
        for(int i=0;i<n;i++)
        {
            node[i] = new Node();

            node[i].a = sc.nextInt();
            node[i].b = sc.nextInt();
        }
        MyNode myNode = new MyNode();
        Arrays.sort(node, myNode);
        long max = 0;
        long value = 0;
        for(int i=0;i<n;i++)
        {
            if(value < node[i].a)
            {
                max = max + node[i].a - value;
                value = node[i].a - node[i].b;
            }
            else{
                value = value - node[i].b;
            }
        }
        System.out.println(max);
    }
}

class Node{
    long a,b;
}

class MyNode implements Comparator<Node>{
    @Override
    public int compare(Node n1, Node n2)
    {
        if(n1.a - n1.b > n2.a- n2.b)
        {
            return -1;
        }
        else if (n1.a - n1.b == n2.a- n2.b)
        {
            return 0;
        }
        else{
            return 1;
        }
    }
}