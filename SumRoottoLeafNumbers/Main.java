package SumRoottoLeafNumbers;

import ArrayDemo2.Array;

import java.util.ArrayList;
import java.util.List;

public class Main {
}
class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
class Solution {
    public int sumNumbers(TreeNode root) {
        return bfs(root,0);
    }
    int bfs(TreeNode root, int result)
    {
        if(root==null)
        {
            return 0;
        }
        else{
            result = result*10+root.val;
            int temp = 0;
            if(root.left!=null || root.right!=null)
            {
                return bfs(root.left,result)+bfs(root.right,result);
            }
            else{
                return result;
            }
        }
    }


}