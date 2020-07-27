package DynamicProgramming;

public class NumDecodings {
    public NumDecodings() {
        super();
    }
    public int numDecodings(String s) {
        if(s.charAt(0)=='0') return 0;
        int[] m=new int[s.length()];
        m[0]=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='0'){
                if(s.charAt(i-1)=='0') return 0;
                else{
                    if(s.charAt(i-1)>'2') return 0;
                    else m[i]=i-2<0?1:m[i-2];
                }
            }else{
                if(s.charAt(i-1)=='0') m[i]=m[i-1];
                else{
                    if(Integer.parseInt(s.substring(i-1,i+1))<=26) m[i]=i-2<0?2:(m[i-1]+m[i-2]);
                    else m[i]=m[i-1];
                }
            }

        }
        return m[s.length()-1];

    }
}
