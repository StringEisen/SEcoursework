//import java.util.Iterator;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.GregorianCalendar;
import java.util.Random;
import java.util.ArrayList;

/*
 * a Journey consist of a list of Stop (time durations to the next stop)
 * we can add stop after any stop by finding previous stopId
 * we can remove stop by finding stopId
 * we can iterate stops within the journey
 */
public class Journey{
    private String journeyId;
    private Time startTime;
    private ArrayList<Stop> timetable;
    
    public Journey() {
        timetable = new ArrayList<Stop>();
        startTime = null;
        Random id = new Random();
        journeyId = ""+id.nextInt(999)+1;
    }
    
    public void setStartTime(int hour, int min) {
        //startTime = new GregorianCalendar();
        //startTime.set(Calendar.HOUR_OF_DAY, hour);
        //startTime.set(Calendar.MINUTE, min);
        if (hour < 0 || min < 0) throw new IllegalArgumentException("Invalid argument");
        startTime =  new Time();
        startTime.hour = hour;
        startTime.min = min;
    }
    
    public int removeStop(String id) {
        int value = 0;
        for (Stop station : timetable) {
            if (station.getId().equals(""+id)) {
                value = station.getTime();
                timetable.remove(station);
            }
        }
        return value;
    }
    
    public int removeStop(int index) {
        Stop station = timetable.remove(index);
        return station.getTime();
    }
    
    public void addStop(Stop stop) {
        if (stop.getTime() <= 0) throw new IllegalArgumentException("Invalid stop time");
        // add stop by the end of the journey
        timetable.add(stop);
    }
    
    // insert stop to a specific position
    public void addStop(Stop stop, int index) {
        timetable.add(index, stop);
    }
    
    public ArrayList<Time> getJourney() {
        int minute = startTime.min;
        int hour = startTime.hour;
        ArrayList<Time> time = new ArrayList<Time>();
        for (Stop stop : timetable) {
            if (minute + stop.getTime() < 60) {
                minute += stop.getTime();
                
                Time stopTime = new Time();
                stopTime.hour = hour;
                stopTime.min = minute;
                
                time.add(stopTime);
            }
            
            else if (minute + stop.getTime() >= 60) {
                hour += (minute + stop.getTime()) / 60;
                if (hour > 24) throw new IllegalArgumentException("Invalid timetable");
                minute = (minute + stop.getTime()) % 60;
                
                Time stopTime = new Time();
                stopTime.hour = hour;
                stopTime.min = minute;
                
                time.add(stopTime);
            }
        }
        return time;
    }
    
    private class Time {
        int hour;
        int min;
    }
    
    public static void main(String arg[]) {
        Journey journey = new Journey();
        journey.setStartTime(9, 0);
        for (int i = 0; i < 10; i++) {
            Stop s = new Stop();
            Random r = new Random();
            s.setTime(r.nextInt(60) + 1);
            if (i == 8) { 
                journey.addStop(s, 2);
                System.out.println("adding 9th stop to the second, value is " + s.getTime()); 
            }
            else if (i == 9) {
                journey.addStop(s);
                System.out.println("removing the 2nd stop, value is " + journey.removeStop(2));
            }
            else journey.addStop(s);
        }
        ArrayList<Time> timetable = journey.getJourney();
        System.out.print("timetable: ");
        for (Time t : timetable) {
            System.out.print(t.hour + ":" + t.min + " ");
        }
    }
        
}
