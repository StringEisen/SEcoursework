import java.util.ArrayList;

/*
 * a Route have several journey in its list
 * we can check 'timetable' by iterating each journey in the list
 */
public class Route{
    private String routeName;
    private String routeId;
    private ArrayList<Journey> journey;
    
    public Route() {
        Random r = new Random();
        routeId = ""+ r.nextInt(999) + 1;
        routeName = null;
        journey = new ArrayList<Journey>();
    }
    /*
     * assign route name
     * @var String name
     */
    public void setRouteName(String name) {
        this.routeName = name;
    }
    
    /*
     * add journey to the end of the arraylist
     * @var Journey added journey object
     */
    public void addJourney(Journey trip) {
        journey.add(trip);
    }
    
    /*
     * remove journey by id
     * @var String id
     */
    public Journey removeJourney(String id) {
        Journey removed;
        for (Journey trip : journey) {
            if (trip.getId().equals(id)) {
                removed = trip;
                journey.remove(trip);
            }
        }
        return removed;
    }
    
    /*
     * remove journey by its position in the arraylist
     * @var int index (1~)
     */
    public Journey removeJourney(int index) {
        Journey removed = journey.remove(index);
        return removed;
    }
        
}