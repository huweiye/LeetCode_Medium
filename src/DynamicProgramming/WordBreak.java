package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    public WordBreak() {
        super();
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.isEmpty()) return false;
        boolean [] dp=new boolean[s.length()];
        for (boolean b:dp
             ) {
            b=false;
        }
        ArrayList<Integer> arrayList=new ArrayList<>();
        if(wordDict.contains(s.substring(0,1))) {
            dp[0]=true;
            arrayList.add(1);
        }
        for(int j=1;j<dp.length;j++){
            for(int i=0;i<arrayList.size();i++){
                if(arrayList.get(i)<=j){
                    if(wordDict.contains(s.substring(arrayList.get(i),j+1))){
                        dp[j]=true;
                        arrayList.add(j+1);
                        break;
                    }
                }
            }




            if(wordDict.contains(s.substring(0,j+1))) {
                dp[j]=true;
                arrayList.add(j+1);
            }

        }
        return dp[s.length()-1];



    }
}
