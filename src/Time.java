public class Time implements Comparable<Time> {
    public int hour;
    public int min;
    
    public int compareTo(Time that) {
        int value = 0;
        if (this.hour < that.hour) value = -1;
        else if (this.hour > that.hour) value = 1;
        else if (this.hour == that.hour) {
            if (this.min < that.min) value = -1;
            else if (this.min == that.min) value = 0;
            else if (this.min > that.min) value = 1;
        }
        return value;
    }
}
    
    