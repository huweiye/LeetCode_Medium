package Stack;

import java.util.Stack;

public class NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack=new Stack<>();//单调栈
        int [] res=new int[nums.length];
        for(int i=2*nums.length-1;i>=0;i--){//next greater element问题都是逆序遍历数组元素的
            //因为是循环数组，所以假装是两个原数组拼接在一起的
            while (!stack.isEmpty()&&stack.peek()<=nums[i%(nums.length)]){
                stack.pop();
            }
            //没找到或者找到了最近的右侧的更大元素
            res[i%(nums.length)]=stack.isEmpty()?-1:stack.peek();
            stack.push(nums[i%(nums.length)]);//因为还不知道左边元素有多小，所以当前元素有可能成为左面其他元素的“下一个更大元素”
        }
        return res;

    }

}
