package BigDecimalDemo;

import java.math.BigDecimal;
import java.util.Stack;

public class BigNumCalc {
    public static Object[] testInput = {
            new BigDecimal("3419229223372036854775807.23343"),
            new BigDecimal("2.1"),
            "*",
    };

    public static void main(String[] args )
    {
        BigNumCalc calc = new BigNumCalc();
        System.out.println(calc.calculate(testInput));
    }

    Stack<BigDecimal> stack = new Stack<>();

    public BigDecimal calculate(Object[] input) {
        BigDecimal tmp;
        for(int i=0;i<input.length;i++)
        {
            Object o = input[i];
            if (o instanceof BigDecimal)
            {
                stack.push((BigDecimal) o);
            }else if(o instanceof String){
                switch (((String)o).charAt(0)){
                    case '+':
                        stack.push((stack.pop()).add(stack.pop()));
                        break;

                    case '*':
                        stack.push(stack.pop().multiply(stack.pop()));
                        break;
                    case '-':
                        tmp = (BigDecimal)stack.pop();
                        stack.push((stack.pop()).divide(tmp, BigDecimal.ROUND_HALF_UP));
                        break;
                    case '/':
                        tmp = (BigDecimal)stack.pop();
                        stack.push((stack.pop()).divide(tmp, BigDecimal.ROUND_HALF_UP));
                        break;
                    default:
                        throw new IllegalStateException("Unknown OPERATOR popped");

                }
            }else{
                throw new IllegalArgumentException("Syntax error in input");
            }
        }return stack.pop();
    }

}
