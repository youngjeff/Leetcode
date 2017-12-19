package ArrayDemo1;

import java.util.Calendar;

public class Array {
    @SuppressWarnings("unused")
    public static void main(String[] argv)
    {
        int[] monthLen1;
        monthLen1 = new int[12];
        int[] monthLen2 = new int[12];
        int[] monthLen3 = {
                31, 28, 31, 30,
                31, 30, 31, 31,
                30, 31, 30, 31,
        };

        final int MAX = 10;
        Calendar[] days = new Calendar[MAX];
        for(int i=0;i<MAX;i++)
        {
            days[i] = Calendar.getInstance();
        }

        int[][] me = new int[10][];
        for(int i=0;i<10;i++)
        {
            me[i] = new int[24];
        }
        System.out.println(me.length);
        System.out.println(me[0].length);
    }
}
