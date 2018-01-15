package EvaluateReversePolishNotation;

import java.util.Stack;

public class Main {
}

class Solution{
    public int evalRPN(String[] tokens)
    {
        int sum = 0;
        Stack<Integer> stack = new Stack();
        for (int i = 0;i<tokens.length;i++)
        {
            if (tokens[i].equals("+"))
            {
                stack.add(stack.pop()+ stack.pop());
            }
            else if(tokens[i].equals("-"))
            {
                int a = (int)(stack.pop());
                int b = (int)(stack.pop());
                stack.add(b-a);
            }
            else if(tokens[i].equals("*"))
            {
                stack.add(stack.pop()*stack.pop());
            }
            else if(tokens[i].equals("/"))
            {
                int a = (int)(stack.pop());
                int b = (int)(stack.pop());
                stack.add(b/a);
            }
            else{
                stack.add(Integer.parseInt(tokens[i]));
            }
            String sa = "";

        }
        return stack.pop();

    }
}