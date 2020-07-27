package WeekContest.num199;

import java.util.ArrayList;
import java.util.Arrays;


public class CountPairs {
    int res=0;
    int dis;
    public int countPairs(TreeNode root, int distance) {
        this.dis=distance;
        dfs(root);
        return res;

    }
    private int [] dfs(TreeNode node) {
        if (node == null) return null;

        if (node.left == null && node.right == null) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(0);
            return temp.stream().mapToInt(Integer::valueOf).toArray();
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        if (left != null && right != null) {
            for (int i = 0; i < left.length; i++){
                for(int j=0;j<right.length;j++){
                    if(left[i]+right[j]+2<=dis) res++;
                }
            }
        }
        ArrayList<Integer> this_node=new ArrayList<>();
        if (left != null) {
            for (int l:left) {
                this_node.add(l+1);
            }
        }
        if (right != null) {
            for (int r:right) {
                this_node.add(r+1);
            }
        }
        return this_node.stream().mapToInt(Integer::valueOf).toArray();
    }
}
