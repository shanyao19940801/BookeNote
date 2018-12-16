package chapter04;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class TrackCounter {
    private Map<Integer, Integer> trackCounts = new HashMap<>();

    @Pointcut("execution(* chapter04.BlankDisc.playTrack(int)) && args(trackNumber)")
    public void trackPlayed(int trackNumber) {
    }
    @Before("trackPlayed(trackNumber)")
    public void countTrack(int trackNumber) {
        int currentCont = getPlayCount(trackNumber);
        trackCounts.put(trackNumber, currentCont + 1);
    }

    public int getPlayCount(int trackNumber) {
        return trackCounts.containsKey(trackNumber) ? trackCounts.get(trackNumber) : 0;
    }
}
