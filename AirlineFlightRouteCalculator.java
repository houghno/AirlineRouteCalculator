import java.util.Scanner;
/**
 * A program that uses preferential information from a user to decide what 
 * combination of flights they need to take to get from point A to B.
 *
 * @author Noah Houghton
 * @version 1.0
 */

public class AirlineFlightRouteCalculator
{
    private Airport[] airportDatabase; 
    String invalidAirport = new String("That is not a valid airport, try again.");
    public AirlineFlightRouteCalculator(){
        airportDatabase = new Airport[2];
        airportDatabase[0]=new Airport("tokyo",125.5494,319.7798,60,50,40);
        airportDatabase[1]=new Airport("johannesburg",63.8655,208.2264,90,75,70);
        int departureAirport=departure();
        int arrivalAirport=arrival();
        straightLineDistance(departureAirport,arrivalAirport);
    }
    public int departure(){
        String selectedAirport = "ERROR, NO AIRPORT SELECTED";
        String departure;
        int airportIndex = 0;
        Scanner departureInput = new Scanner(System.in);
        System.out.println("Enter a valid departure airport");
        departure=departureInput.nextLine();
        for (int i = 0; i < airportDatabase.length; i++){
            if (airportDatabase[i].airportName.equals(departure)){
                selectedAirport = airportDatabase[i].airportName;
                airportIndex=i;
            }
            else{
                //System.out.println(invalidAirport);
            }
        }
        System.out.println("You Selected Departure Airport "+ selectedAirport);
        return airportIndex;
    }
    public int arrival(){
        String selectedAirport = "ERROR, NO AIRPORT SELECTED";
        String arrival;
        int airportIndex = 0;
        Scanner arrivalInput = new Scanner(System.in);
        System.out.println("Enter a valid arrival airport");
        arrival=arrivalInput.nextLine();
        for (int i=0;i<airportDatabase.length;i++){
            if (airportDatabase[i].airportName.equals(arrival)){
                selectedAirport = airportDatabase[i].airportName;
                airportIndex = i;
            } 
            else{
                //System.out.println(invalidAirport);
            }
        }
        System.out.println("You Selected Arrival Airport "+ selectedAirport);
        return airportIndex;
    }
    
    
    //calculate straight line distance between two airports
    public double straightLineDistance(int airportDep,int airportArr){
        
        double latD=airportDatabase[airportDep].latitude-airportDatabase[airportArr].latitude;
        double lonD=airportDatabase[airportDep].longitude-airportDatabase[airportArr].longitude;
        double straightDistance=Math.sqrt(Math.pow(latD,2)+Math.pow(lonD,2));
        return straightDistance;
    }
    
    /*
    public int locationDigitParser(){

    for (int i=0;i<10;i++){
    int airportLocationX=new int[9];
    int airportLocationY=new int[9];
    airportLocation[i] = Integer.parseInt(airportDatabase[i][1]);
    }
    }
     */
    //hello
    /*public boolean RangeCalculator(){
    boolean range
    (airportLocation[x][1])
    }*/
    //String[] places = {"abc","def","ghi"};

}
