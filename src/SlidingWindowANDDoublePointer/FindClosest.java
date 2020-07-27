package SlidingWindowANDDoublePointer;

public class FindClosest {
    public FindClosest() {
        super();
    }
    public int findClosest(String[] words, String word1, String word2) {
        int num=words.length;
        int left=0,right=0;
        int res=Integer.MAX_VALUE;
        while (left<num&&right<num){
            if(words[left].equals(word1)){
                right=left+1;
                while (right<num){
                    if(words[right].equals(word2)){
                        res=Math.min(res,right-left);

                        break;
                    }
                    right++;
                }

            }else if(words[left].equals(word2)){
                right=left+1;
                while (right<num){
                    if(words[right].equals(word1)){
                        res=Math.min(res,right-left);

                        break;
                    }
                    right++;
                }

            }
                left++;


        }
        return res;

    }
}
