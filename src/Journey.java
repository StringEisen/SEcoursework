
/*
 * a Journey consist of a list of Stop
 * we can add stop to the journey and then sort stop before use
 * we can remove stop by finding stopId
 * we can iterate stops within the journey
 */
public class Journey implements Iterable{
    private String journeyId;
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