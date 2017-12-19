package RomanYearDemo;

import sun.util.resources.cldr.mas.CalendarData_mas_KE;

import java.util.Calendar;

public class RomanYear {
    public static void main(String[] argv){
        RomanNumberFormat rf = new RomanNumberFormat();
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR) -1000;

        if(argv.length == 0)
        {
            System.out.println(rf.format(year));
            return;
        }

        for(int i=0;i<argv.length;i++)
        {
            if(argv[i].equals("-")){
                System.out.println(rf.format(year));
            }
            else{
                System.out.println(argv[i]);
            }
        }
        System.out.println();
    }
}
