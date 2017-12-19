package activitySort2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Main {

    public static void main(String[] args){
        class node {
            int b, e;
        }

        class MyComparator implements Comparator {
            public int compare(Object obj1, Object obj2) {
                node u1 = (node) obj1;
                node u2 = (node) obj2;
                if (u1.e >= u2.b) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        node[] Node = new node[num];
        for(int i=0;i<num;i++)
        {
            Node[i] = new node();
            Node[i].b = sc.nextInt();
            Node[i].e = sc.nextInt();
        }
        Arrays.sort(Node, new MyComparator());
        for(int i=0;i<num;i++)
        {
            System.out.print(Node[i].b + "-----------"+ Node[i].e);
        }
        int last = 0;
        for(int i=1;i<num;i++)
        {
            if(Node[last].e >= Node[i].b)
            {
                last++;
            }
        }
        if(last != 0)
            last++;
        System.out.println(last);

    }
}



