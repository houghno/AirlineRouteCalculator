
/**
 * Class containing information about airports and 
 *
 * @author Noah Houghton
 * 
 */
public class Airport
{
    String airportName;
    double latitude;
    double longitude;
    private double aircraftVelocityFactor = 8.6; //should be capitalised but kept lower case due to possibility of changing variable later
    public Airport(String airportName, double lat, double lon){
        this.airportName=airportName;
        this.latitude=lat;
        this.longitude=lon;

    }
    public double straightLineDistance(Airport destination){
        double latD=this.latitude-destination.latitude;
        double lonD=this.longitude-destination.longitude;
        double straightDistance=Math.sqrt(Math.pow(latD,2)+Math.pow(lonD,2));
        return straightDistance;
    }//calculates and returns straight line distance between departure and arrival airports
    public double flightTime(Airport destination){
        double time;
        time=this.straightLineDistance(destination)/aircraftVelocityFactor;
        return time;
    }//calculates and returns the time that a flight takes to complete
}
