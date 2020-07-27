package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class GenerateTrees {
    public GenerateTrees() {
        super();
    }
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<TreeNode>() ;
        ArrayList<TreeNode> [][] dp=new ArrayList[n+1][n+1];//从下标1开始使用

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                dp[i][j]=new ArrayList<TreeNode>();
            }
        }
        for(int i=1;i<=n;i++) {dp[i][i].add(new TreeNode(i));}//1个节点的情况
        for(int r=2;r<=n;r++){//r个节点
            for(int i=1;i<=n-r+1;i++){//从数字i开始
                int j=i+r-1;//到数字j
                //生成i...j的二叉搜索树
                TreeNode node_root_i=new TreeNode(i);//以i为根节点,左子树为null，只有右子树
                for (TreeNode node:dp[i+1][j]) {//每一个可能的右子树
                    node_root_i.left=null;
                    node_root_i.right=node;
                    dp[i][j].add(node_root_i);
                    node_root_i= new TreeNode(i);
                }
                for(int k=i+1;k<=j-1;k++){//选择节点k作为根节点，i<k<j
                    TreeNode node_root_k=new TreeNode(k);//先创建根节点
                    //左子树为i...k-1组成的二叉搜索树
                    //右子树为k+1...j的二叉搜索树
                      for (TreeNode t_left:dp[i][k - 1]) {
                          for (TreeNode t_right:dp[k + 1][j]) {
                            node_root_k.left=t_left;
                            node_root_k.right=t_right;
                            dp[i][j].add(node_root_k);
                            node_root_k = new TreeNode(k);
                        }

                    }

                }
                TreeNode node_root_j=new TreeNode(j);//以j为根节点,右子树为null，只有左子树
                for (TreeNode node:dp[i][j-1]) {//每一个可能的左子树
                    node_root_j.right=null;
                    node_root_j.left=node;
                    dp[i][j].add(node_root_j);
                    node_root_j= new TreeNode(j);
                }
            }
        }
        return dp[1][n];


    }
}
