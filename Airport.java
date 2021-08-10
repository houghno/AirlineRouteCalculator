import java.util.Arrays;
/**
 * Class containing information about airports and methods to calculate route distance, flight time and a constructor for Airport type
 * 
 * @author Noah Houghton
 * 
 */
public class Airport
{
    String airportName;
    double latitude;
    double longitude;
    double timeInHours;
    double timeInMinutes;
    private double aircraftVelocityFactor = 8.6; //should be capitalised but kept lower case due to possibility of changing variable later
    public Airport(String airportName, double lat, double lon){
        this.airportName=airportName;
        this.latitude=lat;
        this.longitude=lon;
    }

    public double straightLineDistance(Airport destination,boolean statementShouldRun){
        double tempDepLongitude=0;
        double tempArrLongitude=0;
        double latD=0;
        double lonD=0;
        if(true){
            if(this.longitude<0){
                //System.out.println("**Departure Longitude was less than 0");
                if(destination.longitude>0){
                    //System.out.println("Arrival Longitude was greater than 0");
                    //System.out.println(this.longitude);
                    //System.out.println(destination.longitude);
                    tempDepLongitude=this.longitude+180;
                    tempArrLongitude=destination.longitude-180;
                    //System.out.println(tempDepLongitude);
                    //System.out.println(tempArrLongitude);
                }
            }else{
                //System.out.println("Departure Longitude was greater than 0");
                if(destination.longitude<0){
                    //System.out.println("Arrival Longitude was less than 0");
                    //System.out.println(this.longitude);
                    //System.out.println(destination.longitude);
                    tempDepLongitude=this.longitude-180;
                    tempArrLongitude=destination.longitude+180;
                    //System.out.println(this.longitude);
                    //System.out.println(destination.longitude);
                }
            }
            latD=this.latitude-destination.latitude;
            lonD=tempDepLongitude-tempArrLongitude;
        }
        else{

            latD=this.latitude-destination.latitude;
            lonD=this.longitude-destination.longitude;
        }
        double straightDistance=Math.sqrt(Math.pow(latD,2)+Math.pow(lonD,2));
        /*double timeInHours;
        double timeInMinutes;
        timeInHours=straightDistance/aircraftVelocityFactor;
        timeInMinutes=60*(straightDistance/aircraftVelocityFactor);*/

        return straightDistance;
    }//calculates and returns straight line distance between departure and arrival airports

    public double flightTimeInHours(Airport destination){
        double timeInHours;
        timeInHours=this.straightLineDistance(destination,false)/aircraftVelocityFactor;
        return timeInHours;
    }//calculates and returns the time in hours that a flight takes to complete
    public double flightTimeInMinutes(Airport destination){
        double timeInMinutes;
        timeInMinutes=60*(this.straightLineDistance(destination,false)/aircraftVelocityFactor);
        return timeInMinutes;
    }//calculates and returns the time in minutes that a flight takes to complete

}