package DynamicProgramming;

public class TranslateNum {
    public TranslateNum() {
        super();
    }
    public int translateNum(int num) {
        String s=String.valueOf(num);
        int[] m=new int[s.length()];
        m[0]=1;//单独一个数字（0~9）必合法
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='0'){//当前数字为‘0’
                if(s.charAt(i-1)=='1'||s.charAt(i-1)=='2') m[i]=(i-2)<0?2:(m[i-1]+m[i-2]);
                else m[i]=i-1<0?1:m[i-1];//“00”或者“30”的情况，拆开解码，不能绑定，如“30”只有1种解码方法，即：[3，0]
            }else{//当前数字不为0
                if(s.charAt(i-1)=='0') m[i]=m[i-1];//如“1105”，指到5时，5不能和前面的0组合
                else{//前面数字也不是0
                    if(Integer.parseInt(s.substring(i-1,i+1))<=25) m[i]=(i-2)<0?2:(m[i-1]+m[i-2]);//只要满足1...25之间就合法，如“10”可解码成2种:[1,0]和[10]
                    else m[i]=m[i-1];//如“138”，3和8必须分开解码
                }
            }
        }
        return m[s.length()-1];

    }
}
