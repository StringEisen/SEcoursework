import java.util.Iterator;
import java.util.Calendar;
/*
 * a Journey consist of a list of Stop (time durations to the next stop)
 * we can add stop after any stop by finding previous stopId
 * we can remove stop by finding stopId
 * we can iterate stops within the journey
 */
public class Journey implements Iterable{
    private String journeyId;
    private Calendar startTime;
    private ArrayList<Stop> timetable;
    public Iterator<Stop> iterator() {
        return new StopIterator();
    }
    // iterator of stops
    private class StopIterator implements Iterator<Stop> {
         public boolean hasNext() { }
         public void remove() { }
         public Stop next() { }
    }
}
