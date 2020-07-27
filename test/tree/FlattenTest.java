package tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class FlattenTest {
    @Test
    public void flatten() throws Exception {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.right=new TreeNode(5);
        root.right.right=new TreeNode(6);
        Flatten f=new Flatten();
        f.flatten(root);
    }

}