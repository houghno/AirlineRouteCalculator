
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
    private double aircraftVelocityFactor = 8.6; //should be capitalised but kept lower case due to possibility of changing variable later
    public Airport(String airportName, double lat, double lon){
        this.airportName=airportName;
        this.latitude=lat;
        this.longitude=lon;

    }
    public double straightLineDistance(Airport destination){
        boolean depLatBelow0=true;
        boolean arrLatAbove0=true;
        double latD=0;
        if(this.latitude-180<0-180){
            depLatBelow0=true;
            if (destination.latitude+180>360){
                arrLatAbove0=true;
            }
           
        }
        else{
            depLatBelow0=false;
            if(destination.latitude-180<-180){
                arrLatAbove0=false;
            }
        }   
        if(depLatBelow0){
            if(arrLatAbove0){
                latD=180-this.latitude-destination.latitude+360;
            }
            else{
                latD=this.latitude-destination.latitude;
            }
        }
        else{
            if (arrLatAbove0=false){
                latD=this.latitude-destination.latitude+360;
            }
            else{
                latD=this.latitude-destination.latitude;
            }
        }
        latD=this.latitude-destination.latitude;
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
