package SimplifyPath;

import java.util.LinkedList;

public class Main {
}
class Solution {
    public String simplifyPath(String path) {
        if(path.length() == 0){
            return path;
        }

        String[] splits = path.split("/");
        LinkedList<String> stack = new LinkedList<>();
        for(String s : splits){
            if(s.length() == 0 || s.equals(".")){
                continue;
            }
            else if(s.equals(".."))
            {
                if(!stack.isEmpty())
                {
                    stack.pop();
                }
            }
            else{
                stack.push(s);
            }
        }
        String res = "";
        for(String dir: stack){
            res = "/"+dir+res;
        }
        return res.isEmpty() ? "/" : res;
    }
}