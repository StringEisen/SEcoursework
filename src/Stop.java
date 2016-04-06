/* 
 * a Stop has its id and its duration (minute) to next stop, 
 * it is the basic data structure we use
 * to realize 'timetable'
 */

import java.util.Random;

public class Stop {
    private String stopId;
    private int time;
    
    public Stop() {
        Random r = new Random();
        stopId = ""+ r.nextInt(99) + 1;
        time = 0;
    }
    
    public void setTime(int min) {
        if (min < 0) throw new IllegalArgumentException("Invalid time duration");
        this.time = min;
    }
    
    public String getId() {
        return stopId;
    }
    
    public int getTime() {
        return time;
    }
}