package WeekContest.num199;

import java.util.Arrays;
import java.util.Comparator;

public class RestoreString {
    public String restoreString(String s, int[] indices) {
        char [] res=new char[s.length()];
        for(int i=0;i<s.length();i++){
            res[indices[i]]=s.charAt(i);
        }
        return String.valueOf(res);

    }
}
