import java.util.ArrayList;

public class otherquestion {
    public otherquestion() {
        super();
    }
    ArrayList<String> a=new ArrayList<>();
    ArrayList<Object> b=new ArrayList<>();
    public void test1(){
        String s1=new String("111");
        a.add(s1);
        s1+="aaaaaaaaaaaa";
        a.add(s1);//元素是字符串时是深拷贝
        System.out.println("调用函数里实参s的地址："+System.identityHashCode(s1));
        test2(s1);
        System.out.println(Integer.parseInt("012"));
    }
    public void test2(String s){
        //Java String类型的参数传递的是String对象的内存地址，但是在被调用函数体内一旦对String对象对象做了修改，就给他分配新的地址，做了深拷贝，以至于不影响调用函数里的实参的值
        //Java以此实现的对String类型参数的“按值传递”效果
        System.out.println("被调用函数里形参s的地址："+System.identityHashCode(s));
        s=s+"XXXXXXXXXXXXXX";
        System.out.println("修改以后，被调用函数里形参s的地址："+System.identityHashCode(s));

    }
}
