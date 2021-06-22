
/**
 * Class containing information about airports and 
 *
 * @author Noah Houghton
 * @version 10/06/2021
 */
public class Airport
{
    String airportName;
    double latitude;
    double longitude;
    int connectionI2I;
    int connectionI2D;
    int connectionD2D;
    
    public Airport(String airportName, double lat, double lon, int i2i, int i2d, int d2d){
        this.airportName=airportName;
        this.latitude=lat;
        this.longitude=lon;
        this.connectionI2I=i2i;
        this.connectionI2D=i2d;
        this.connectionD2D=d2d;
        
    }
  
    
}
