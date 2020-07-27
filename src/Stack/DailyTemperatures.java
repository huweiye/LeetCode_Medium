package Stack;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack=new Stack<>();//单调栈解决next greater element问题
        int[] res=new int[T.length];
        for(int i=T.length-1;i>=0;i--){
            while (!stack.isEmpty()&&T[stack.peek()]<=T[i]){//找位于当前温度右侧的第一个大于当前温度的下标
                stack.pop();
            }
            res[i]=stack.isEmpty()?0:(stack.peek()-i);
            stack.push(i);//对于更左面的一些元素，或许当前温度是他们的next greater element
        }
        return res;
    }
}
