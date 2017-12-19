package RomanYearDemo;

import com.sun.istack.internal.NotNull;

import java.text.FieldPosition;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParsePosition;

public class RomanNumberFormat extends Format{

    final static char A2R[][] = {
            { 0, 'M' },
            { 0, 'C' , 'D' , 'M' },
            { 0, 'X' , 'L' , 'C' },
            { 0, 'I' , 'V' , 'X' },
    };
    static class R2A{
        char ch;
        public R2A(char ch, int amount){
            super();
            this.ch = ch;
            this.amount = amount;
        }
        int amount;
    }
    final static R2A[] R2A = {
            new R2A('M', 1000),
            new R2A('D', 500),
            new R2A('C', 100),
            new R2A('L', 50),
            new R2A('X', 10),
            new R2A('V', 5),
            new R2A('I', 1),
    };

    public String format(double n){
        return format((long) n);
    }

    public String format(long n){
        if(n <= 0 || n>=4000){
            throw new NumberFormatException(n + " must be > 0 && < 4000");

        }
        StringBuffer sb = new StringBuffer();
        format(Integer.valueOf((int)n), sb, new FieldPosition(NumberFormat.INTEGER_FIELD));
        return sb.toString();
    }
    @Override
    public StringBuffer format(Object on, @NotNull StringBuffer sb, @NotNull FieldPosition fp) {
        if(! (on instanceof Number)){
            throw new IllegalArgumentException(on + "Must be a Number object");
        }
        if(fp.getField() != NumberFormat.INTEGER_FIELD)
            throw new IllegalArgumentException(fp + "Must be FieldPosition(NumberFormat.INTEFER_FIELD)");
        int n = ((Number)on).intValue();

        for(int i=0;i<4;i++){
            int d = n % 10;
            push(d);
            n=n/10;
        }

        for(int i=0;i<4;i++)
        {
            int ch = pop();
            if(ch == 0)
                continue;
            else if(ch <= 3)
            {
                for(int k=1;k<=ch;k++)
                {
                    sb.append(A2R[i][1]);
                }
            }
            else if (ch == 4){
                    sb.append(A2R[i][1]);
                    sb.append(A2R[i][2]);
            }
            else if(ch == 5){
                sb.append(A2R[i][2]);
            }
            else if(ch <= 8){
                sb.append(A2R[i][2]);
                for(int k=6;k<=ch;k++)
                {
                    sb.append(A2R[i][1]);
                }
            }
            else{
                sb.append(A2R[i][1]);
                sb.append(A2R[i][1]);
            }
        }
        return sb;
    }

    @Override
    public Object parseObject(String what, @NotNull ParsePosition where) {
        int n = 0;
        for(char ch: what.toUpperCase().toCharArray()){
            for(R2A r : R2A){
                if(r.ch == ch){
                    n += r.amount;
                    break;
                }
            }
        }
        return new Long(n);
    }

    protected int stack[] = new int[10];
    protected int depth = 0;

    protected void push(int n){
        stack[depth++] = n;
    }

    protected int pop(){
        return stack[--depth];
    }
}
