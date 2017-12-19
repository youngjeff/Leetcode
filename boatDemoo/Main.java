package boatDemoo;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        long height = sc.nextLong();
        int[] num = new int[number];
        for(int i=0;i<number;i++)
        {

            num[i] = sc.nextInt();
        }
        Arrays.sort(num);
        int value = Main.fun(0,number-1,num,height);
        System.out.println(value);
    }

    public static int fun(int b,int e,int[] num,long height)
    {

        if(b<e)
        {
            if(num[b] + num[e] <= height)
            {
                int a = num[b]+num[e];

                return 1+fun(b+1,e-1,num,height);
            }
            else if(num[e] <= height){

                return 1+ fun(b,e-1,num,height);
            }
            else{

                return fun(b,e-1,num,height);
            }
        }
        if(b==e)
        {
            return 1;
        }
       return 0;
    }
}
