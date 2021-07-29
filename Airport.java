
/**
 * Class containing information about airports and 
 *
 * @author Noah Houghton
 * 
 */
public class Airport
{
    String airportName;
    private double aircraftVelocityFactor = 6.66; //should be capitalised but kept lower case due to possibility of changing variable later
    double latitude;
    double longitude;
    /*int connectionI2I;
    int connectionI2D;
    int connectionD2D;*/

    public Airport(String airportName, double lat, double lon/*, int i2i, int i2d, int d2d*/){
        this.airportName=airportName;
        this.latitude=lat;
        this.longitude=lon;
        /*this.connectionI2I=i2i;
        this.connectionI2D=i2d;
        this.connectionD2D=d2d;*/

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
