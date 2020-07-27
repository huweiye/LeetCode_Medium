package Hot100;

import org.junit.Test;

import static org.junit.Assert.*;

public class LowestCommonAncestorTest {
    @Test
    public void lowestCommonAncestor() throws Exception {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(5);
        root.left.left=new TreeNode(6);
        root.left.right=new TreeNode(2);
        root.left.right.left=new TreeNode(7);
        root.left.right.right=new TreeNode(4);
        root.right=new TreeNode(1);
        root.right.left=new TreeNode(0);
        root.right.right=new TreeNode(8);
        LowestCommonAncestor lowestCommonAncestor=new LowestCommonAncestor();
        lowestCommonAncestor.lowestCommonAncestor(root,root.left,root.right);
    }

}