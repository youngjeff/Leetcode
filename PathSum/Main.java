package PathSum;

import sun.reflect.generics.tree.Tree;

public class Main {
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    boolean flag = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
        {
            return flag;
        }
        dfs(root,sum,0);
        return flag;
    }
    void dfs(TreeNode root,int sum ,int num)
    {
        if(root.left == null && root.right == null)
        {
            if(num+root.val == sum)
            {
                flag = true;
                return;
            }
        }
        else{
            if(!flag)
            {
                if(root.left != null)
                {
                    dfs(root.left,sum,num+root.val);
                }
                if(root.right!=null)
                {
                    dfs(root.right,sum,num+root.val);
                }

            }
            else{
                return;
            }
        }
    }
}