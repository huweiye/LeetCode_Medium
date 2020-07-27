package WeekContest.num192;

import java.util.Stack;

public class BrowserHistory {
    Stack<String> past_stack=new Stack<>();//栈顶是当前正在访问的页面
    Stack<String> front_stack=new Stack<>();//栈顶是下一次前进将会访问的页面
    public BrowserHistory(String homepage) {
        past_stack.push(homepage);
    }

    public void visit(String url) {
        //从当前页跳转访问 url 对应的页面  。执行此操作会把浏览历史前进的记录全部删除
        past_stack.push(url);
        front_stack=new Stack<>();//前进的记录清空
    }

    public String back(int steps) {
        while (steps>0&&!past_stack.empty()){
            front_stack.push(past_stack.pop());
            steps--;
        }
        if(past_stack.empty()){
            past_stack.push(front_stack.pop());
        }
        return past_stack.peek();

    }

    public String forward(int steps) {
        while (steps>0&&!front_stack.empty()){
            past_stack.push(front_stack.pop());
            steps--;
        }
        return past_stack.peek();
    }
}
