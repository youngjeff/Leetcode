package nod.primsort;

import java.util.*;

// fisrt sort by length
//  then use if statement find out the answer
public class Main {
    public static void main(String[] args)
    {
        int N,M;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        List<Line> list = new ArrayList<Line>();
        for(int i=0;i<M;i++)
        {
            Line line = new Line();
            line.a = sc.nextInt();
            line.b = sc.nextInt();
            line.value = sc.nextInt();
            list.add(line);
        }
        Collections.sort(list, new MyNode());
        List<Integer>Alist = new ArrayList<Integer>();
        int max = 0;
        Alist.add(1);
        while(Alist.size() < N)
        {
            for(int i=0, len =list.size();i<len;i++)
            {
                Line test = list.get(i);
                if(Alist.contains(test.a) && !Alist.contains(test.b) )
                {
                    max += test.value;
                    Alist.add(test.b);
                    list.remove(i);
                    i--;
                    len--;

                    break;
                }
                else if(Alist.contains(test.b) && !Alist.contains(test.a))
                {
                    max += test.value;
                    Alist.add(test.a);
                    list.remove(i);
                    i--;
                    len--;

                    break;
                }
                else if(Alist.contains(test.a) && Alist.contains(test.b))
                {
                    list.remove(i);
                    i--;
                    len--;

                }
                else
                    continue;;
            }

        }
        System.out.println(max);

    }
}

class Line{
    int a,b;
    int value;
}

class MyNode implements Comparator<Line>{
    @Override
    public int compare(Line n1, Line n2)
    {
        if(n1.value > n2.value)
        {
            return 1;
        }
        else if (n1.value == n2.value)
        {
            return 0;
        }
        else{
            return -1;
        }
    }
}
