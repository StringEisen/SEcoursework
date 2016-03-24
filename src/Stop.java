
/*
 * a Stop has its id and its time, it is the basic data structure we use
 * to realize 'timetable'
 * we can sort Stop by comparing time
 */
public class Stop implements Comparable {
    private String stopId;
    private Calendar time;
   
   /* implements Comparable interface, used to sort the ArrayList of Stops
    * compare by time
	* @return -1 if this < that, return 0 if equal, return 1 if this > that
	*/
    public int compareTo(Stop that) {
	   
    }
}