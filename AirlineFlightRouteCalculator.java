import java.util.Scanner;
import java.text.*;
/**
 * A program that uses preferential information from a user to decide what 
 * combination of flights they need to take to get from point A to B.
 *
 * @author Noah Houghton
 * @version 1.0
 */

public class AirlineFlightRouteCalculator
{
    private DecimalFormat decFormat = new DecimalFormat("##.##");
    private double aircraftVelocityFactor = 6.66;
    private Airport[] airportDatabase; 
    String invalidAirport = new String("That is not a valid airport, try again.");
    public AirlineFlightRouteCalculator(){
        System.out.print("\f");
        airportDatabase = new Airport[3];//has to be equal to the amount of created airports
        airportDatabase[0]=new Airport("tokyo",125.5494,319.7798,60,50,40);
        airportDatabase[1]=new Airport("johannesburg",63.8655,208.2264,90,75,70);
        airportDatabase[2]=new Airport("auckland",52.9918,354.7850,60,45,30);
        returnAirports();
        int departureAirport=departure();
        int arrivalAirport=arrival();
        System.out.println(straightLineDistance(departureAirport,arrivalAirport)+" in "+decFormat.format(flightTime(departureAirport,arrivalAirport))+" hours");
    }

    public int departure(){
        String selectedAirport = "ERROR, NO AIRPORT SELECTED";
        String departure;
        int airportIndex = 0;
        Scanner departureInput = new Scanner(System.in);
        boolean departureConfirmation=false;
        while(departureConfirmation=false){
            System.out.println("Enter a valid departure airport");
            departure=departureInput.nextLine();
            for (int i = 0; i < airportDatabase.length; i++){
                if (airportDatabase[i].airportName.equals(departure)){
                    selectedAirport = airportDatabase[i].airportName;
                    airportIndex=i;
                    System.out.println("You Selected Departure Airport "+ selectedAirport);
                    System.out.println("Is this your final choice? Type Yes to Confirm or anything else to cancel.");
                    if(departureInput.nextLine().equals("Yes")){
                        departureConfirmation=true;
                        System.out.println("Selection confirmed.");
                    }
                    else{
                        System.out.print("Selection cancelled, ");  
                    }
                }
                else{
                    if (airportDatabase[i].airportName.equals(departure)){
                        System.out.print("Invalid Airport, ");
                    }
                }
            }
            
            
        }
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

    public void returnAirports(){
        System.out.println("Availiable Airports:");
        for (int i=0;i<=airportDatabase.length-1;i++){
            System.out.println(airportDatabase[i].airportName);
        }
    }
    //calculate straight line distance between two airports
    public double straightLineDistance(int airportDep,int airportArr){
        double latD=airportDatabase[airportDep].latitude-airportDatabase[airportArr].latitude;
        double lonD=airportDatabase[airportDep].longitude-airportDatabase[airportArr].longitude;
        double straightDistance=Math.sqrt(Math.pow(latD,2)+Math.pow(lonD,2));
        return straightDistance;
    }

    public double flightTime(int airportDep,int airportArr){
        double time;
        time=straightLineDistance(airportDep,airportArr)/aircraftVelocityFactor;
        return time;
    }

}
