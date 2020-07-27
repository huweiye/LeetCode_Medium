package BinaryDivide;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public GenerateParenthesis() {
        super();
    }

    ArrayList<ArrayList<String>> remember_par=new ArrayList<>();//备忘录的第i项就是i对括号时的解，r[0]里存的ArrayList没有字符串,r[1]里存的ArrayList存着一个字符串()"
    public List<String> generateParenthesis(int n) {
       if(n==0) return new ArrayList<>();
        return rec1(n);
    }

    public ArrayList<String> rec1(int n){//直接递归
        ArrayList<String> temp=new ArrayList<>();
        if(n==0) return temp;
        if(n==1) {temp.add("()");return temp;}

        for(int outside=0;outside<=n-1;outside++){//固定最外侧的左括号，每一次根据与它匹配的),设outside表示该)右侧的括号对数
            ArrayList sub_out=rec1(outside);
            ArrayList sub_int=rec1(n-outside-1);
            if(outside==0){//")"右侧没有括号，单独处理
                for(int i=0;i<sub_int.size();i++){
                    temp.add("("+sub_int.get(i)+")");
                }
            }else if(n-outside-1==0){//"("左侧没有括号，单独处理
                for(int i=0;i<sub_out.size();i++){
                    temp.add("()"+sub_out.get(i));
                }
            }else {
                for (int i = 0; i < sub_int.size(); i++) {
                    for (int j = 0; j < sub_out.size(); j++) {
                        temp.add("("+sub_int.get(i)+")"+sub_out.get(j));
                    }
                }
            }
        }
        return temp;
    }


    public List<String> generatePa2(int n) {//带备忘录的递归
        if(n==0) return new ArrayList<String>();
        remember_par.add(new ArrayList<String>());//没有括号
        ArrayList<String> a=new ArrayList<>();
        a.add("()");
        remember_par.add(a);//一对括号，一个字符串

        return lookup_par(n);

    }
    ArrayList<String> lookup_par(int n){
        if(n==0) return remember_par.get(0);//没有括号时的解，直接返回
        if(n<remember_par.size()) return remember_par.get(n);//备忘录里有"n对括号"时的解，直接返回

        //还没有“n对括号的解”，则自己构造，并add进备忘录后再返回
        ArrayList<String> res=new ArrayList<>();//res即remember_par即将add进去的
        for(int outside=0;outside<=n-1;outside++) {//固定最外侧的左括号，每一次根据与它匹配的),设outside表示该)右侧的括号对数

            ArrayList sub_out=lookup_par(outside);
            ArrayList sub_int=lookup_par(n-outside-1);
            if(outside==0){//")"右侧没有括号，单独处理
                for(int i=0;i<sub_int.size();i++){
                    res.add("("+sub_int.get(i)+")");
                }
            }else if(n-outside-1==0){//"))左侧没有括号，单独处理
                for(int i=0;i<sub_out.size();i++){
                    res.add("()"+sub_out.get(i));
                }
            }else {
                for (int i = 0; i < sub_int.size(); i++) {
                    for (int j = 0; j < sub_out.size(); j++) {
                        res.add("("+sub_int.get(i)+")"+sub_out.get(j));
                    }
                }
            }

        }
        remember_par.add(res);
        return res;
    }









}
