package jianzhi.chapter04.c03;

/**
 * Created by shanyao on 2018/6/25.
 */
public class Problem24 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0)
            return false;
        if(sequence.length == 1)
            return true;
        return judge(0,sequence.length-1,sequence);
    }

    public boolean judge(int start, int end, int [] pSe){
        if(end-start <= 1)
            return true;
        int g = 0;
        while(pSe[end] > pSe[g]) {
            g++;
        }
        for(int i = g;i<end;i++){
            if(pSe[i]<pSe[end])
                return false;
        }
        return (judge(start,g-1,pSe)&&judge(g,end-1,pSe));
    }
}
