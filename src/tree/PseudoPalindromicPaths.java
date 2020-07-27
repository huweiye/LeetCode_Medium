package tree;

import java.util.Collection;
import java.util.HashMap;

public class PseudoPalindromicPaths {
    public PseudoPalindromicPaths() {
        super();
    }
    int amount=0;
    public int pseudoPalindromicPaths (TreeNode root) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();//key=节点值,value=次数
        //一条路径是伪回文：
        // 1.路径里的每个节点的值出现次数为偶数
        //2.只有一个节点的值出现次数为奇数，其他所有节点出现次数都是偶数
        dfs(root,hashMap);
        return amount;
    }
    public void dfs(TreeNode node,HashMap<Integer,Integer> hashMap){
        if(node==null) return;
        if(node.left==null&&node.right==null){//是叶子节点，检查该路径
            hashMap.put(node.val,hashMap.get(node.val)==null?1:hashMap.get(node.val)+1);
            Collection<Integer> coll = hashMap.values();
            int flag=0;
            for(Integer counter : coll) {
                if(counter%2!=0){
                    flag++;
                }
                if(flag>=2) { hashMap.put(node.val,hashMap.get(node.val)-1);return;}//有两个或两个以上的节点值出现次数为奇数，该路径行不通，直接返回
            }
            amount+=1;
            hashMap.put(node.val,hashMap.get(node.val)-1);//因为是按引用传参，要还原
            return;
        }
        hashMap.put(node.val,hashMap.get(node.val)==null?1:hashMap.get(node.val)+1);
        dfs(node.left,hashMap);
        dfs(node.right,hashMap);
        hashMap.put(node.val,hashMap.get(node.val)-1);//因为是按引用传参，要还原
    }
}
