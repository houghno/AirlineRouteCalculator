import java.util.Scanner;
import java.text.*;
/**
 * A program that uses preferential information from a user to decide what 
 * combination of flights they need to take to get from point A to B
 * 
 * @author Noah Houghton 
 */
public class AirlineFlightRouteCalculator
{

    private DecimalFormat decFormat = new DecimalFormat("##.##");
    private double aircraftVelocityFactor = 6.66;
    private Airport[] airportDatabase; 
    private String invalidAirport = new String("That is not a valid airport, try again.");
    private String finalChoice="Is this your final choice? Type Yes to Confirm or anything else to cancel.";
    private String selectedAirport = "ERROR, NO AIRPORT SELECTED";
    private int previousAirportSelection;
    public AirlineFlightRouteCalculator(){
        System.out.print("\f");
        airportDatabase = new Airport[3];//has to be equal to the amount of created airports
        airportDatabase[0]=new Airport("tokyo",125.5494,319.7798,60,50,40);
        airportDatabase[1]=new Airport("johannesburg",63.8655,208.2264,90,75,70);
        airportDatabase[2]=new Airport("auckland",52.9918,354.7850,60,45,30);
        returnAirports();
        int departureAirport=PickAirport(true);
        previousAirportSelection=departureAirport;

        int arrivalAirport=PickAirport(false);
        System.out.println(straightLineDistance(departureAirport,arrivalAirport)+" in "+decFormat.format(flightTime(departureAirport,arrivalAirport))+" hours");
    }

    public int PickAirport(boolean askForDeparture){

        String pickedAirport;
        int airportIndex=-1;/*counter that changes when an airport is found in the database that has the same name as the user input airport. If i is -1 once the for loop within this class is
        run, it is known that the for loop did not find a valid airport due to the for loop not being able to make i=-1 as it runs from i=0 then i++, each run of the for loop. Therefore it is 
        clear to assume that the airport is invalid*/
        Scanner airportInput = new Scanner(System.in);
        boolean airportConfirmation=false;
        while(airportConfirmation==false){
            if(askForDeparture){
                System.out.println("Enter a valid departure airport");
            }else{
                System.out.println("Enter a valid arrival airport");

            }
            pickedAirport=airportInput.nextLine();
            for (int i = 0;i<airportDatabase.length;i++){//runs for the length of the airportDatabase array
                if (airportDatabase[i].airportName.equals(pickedAirport)){
                    if(askForDeparture){
                        selectedAirport = airportDatabase[i].airportName;
                        airportIndex=i;
                        System.out.println("You Selected Airport "+ selectedAirport);
                        System.out.println("Is this your final choice? Type Yes to Confirm or anything else to cancel.");
                        if(airportInput.nextLine().equals("yes")){
                            airportConfirmation=true;
                            System.out.println("Selection confirmed.");
                        }
                        else{
                            System.out.print("Selection cancelled, ");  
                        }//confirmation process
                    }
                    else{
                        if(airportDatabase[previousAirportSelection].airportName.equals(pickedAirport)){
                            System.out.print("Selected arrival airport was the same as selected departure airport, ");
                        }//checking to see if the selected arrival airport is the same as the selected departure airport
                        else{
                            selectedAirport = airportDatabase[i].airportName;
                            airportIndex=i;
                            System.out.println("You Selected Airport "+ selectedAirport);
                            System.out.println("Is this your final choice? Type Yes to Confirm or anything else to cancel.");
                            if(airportInput.nextLine().equals("yes")){
                                airportConfirmation=true;
                                System.out.println("Selection confirmed.");
                            }
                            else{
                                System.out.print("Selection cancelled, ");  
                            }//confirmation process
                        }
                    }
                }
            }//for
            if (airportIndex==-1){
                System.out.print("Invalid Airport, ");
            }//if airporIndex=-1 it is known that the program 
        }
        return airportIndex;
    }//runs for departure and arrival airports
    public void returnAirports(){
        System.out.println("Availiable Airports:");
        for (int i=0;i<=airportDatabase.length-1;i++){
            System.out.println(airportDatabase[i].airportName);
        }
    }//returns all airport names within the airportDatabase array
    public double straightLineDistance(int airportDep,int airportArr){
        double latD=airportDatabase[airportDep].latitude-airportDatabase[airportArr].latitude;
        double lonD=airportDatabase[airportDep].longitude-airportDatabase[airportArr].longitude;
        double straightDistance=Math.sqrt(Math.pow(latD,2)+Math.pow(lonD,2));
        return straightDistance;
    }//calculates and returns straight line distance between departure and arrival airports
    public double flightTime(int airportDep,int airportArr){
        double time;
        time=straightLineDistance(airportDep,airportArr)/aircraftVelocityFactor;
        return time;
    }//calculates and returns the time that a flight takes to complete
}
