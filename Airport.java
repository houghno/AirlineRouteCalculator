import java.util.Arrays;//importing array usability (unused)
/**
 * Class containing information about airports and methods to calculate route distance, flight time and a constructor for Airport type
 * 
 * @author Noah Houghton
 * 
 */
public class Airport
{
    String airportName;//the placeholder for the name of the airport within each array
    double latitude;//the placeholder for the latitude position of the airport within each array
    double longitude;//the placeholder for the longitude position of the airport within each array
    double timeInHours;//the placeholder for the time in hours 
    double timeInMinutes;//the placeholder for the time in minutes
    private static double AircraftVelocityFactor = 8.6;//factor to convert the distance of a route into time lengths
    public Airport(String airportName/**/, double lat, double lon){
        this.airportName=airportName;
        this.latitude=lat;
        this.longitude=lon;
    }

    public double straightLineDistance(Airport destination,boolean statementShouldRun){
        double tempDepLongitude=0;//temporary variable rather than altering the master variable for departure longitude
        double tempArrLongitude=0;//temporary variable rather than altering the master variable for arrival longitude
        double latD=0;//
        double lonD=0;//
        if(true){
            if(this.longitude<0){
                if(destination.longitude>0){
                    tempDepLongitude=this.longitude+180;
                    tempArrLongitude=destination.longitude-180;
                }
            }else{
                if(destination.longitude<0){
                    tempDepLongitude=this.longitude-180;
                    tempArrLongitude=destination.longitude+180;
                }
            }
            latD=this.latitude-destination.latitude;
            lonD=tempDepLongitude-tempArrLongitude;
        }
        else{
            latD=this.latitude-destination.latitude;
            lonD=this.longitude-destination.longitude;
        }
        double straightDistance=Math.sqrt(Math.pow(latD,2)+Math.pow(lonD,2));//pythagoras to calculate hypotenuse of triangle created with sides of latitude and longitude
        return straightDistance;
    }//calculates and returns straight line distance between departure and arrival airports

    public double flightTimeInHours(Airport destination){
        double timeInHours;
        timeInHours=this.straightLineDistance(destination,false)/AircraftVelocityFactor;
        return timeInHours;
    }//calculates and returns the time in hours that a flight takes to complete
    public double flightTimeInMinutes(Airport destination){
        double timeInMinutes;
        timeInMinutes=60*(this.straightLineDistance(destination,false)/AircraftVelocityFactor);
        return timeInMinutes;
    }//calculates and returns the time in minutes that a flight takes to complete

}