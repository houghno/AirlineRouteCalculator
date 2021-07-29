import java.util.Scanner;//importing scanner utilisation
import java.io.File;
import java.io.IOException;
import java.text.*;//importing for decFormat
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
    private Airport[] airportDatabase = new Airport[100]; 
    private String invalidAirport = new String("That is not a valid airport, try again.");
    private String finalChoice="Is this your final choice? Type Yes to Confirm or anything else to cancel.";
    private String selectedAirport = "ERROR, NO AIRPORT SELECTED";
    private int previousAirportSelection;
    private int airportNumber = 0;//counter to allocate an airport to an array index
    public AirlineFlightRouteCalculator(){
        System.out.print("\f");
        fileReader();
        returnAirports();
        int departureAirport=PickAirport(true);
        previousAirportSelection=departureAirport;
        int arrivalAirport=PickAirport(false);
        Airport from=airportDatabase[departureAirport];
        Airport to=airportDatabase[arrivalAirport];
        System.out.println(from.straightLineDistance(to)+" in "+decFormat.format(from.flightTime(to))+" hours");
    }

    public void fileReader(){

        File airports=new File("airportdatabase.txt");
        try {
            Scanner readAirportsFile = new Scanner(airports);
            while (readAirportsFile.hasNextLine()){
                double partsDoubleOne;
                double partsDoubleTwo;
                String airportsFileLine=readAirportsFile.nextLine();
                String splitAtComma=",";
                String parts[]=airportsFileLine.split(splitAtComma);
                partsDoubleOne=Double.parseDouble(parts[1]);
                partsDoubleTwo=Double.parseDouble(parts[2]);
                airportDatabase[airportNumber]= new Airport(parts[0],partsDoubleOne,partsDoubleTwo);
                airportNumber++;
            }

        }   
        catch(IOException e){
            e.printStackTrace();
        }

    }

    public int PickAirport(boolean askForDeparture){
        String pickedAirport;
        int airportIndex=-1;
        Scanner airportInput = new Scanner(System.in);
        boolean airportConfirmation=false;
        while(airportConfirmation==false){
            airportIndex=-1;/*counter that changes when an airport is found in the database that has the same name as the user input airport. If i is -1 once the for loop within this class is
            run, it is known that the for loop did not find a valid airport due to the for loop not being able to make i=-1 as it runs from i=0 then i++, each run of the for loop. Therefore it is 
            clear to assume that the airport is invalid*/
            if(askForDeparture){
                System.out.println("Enter a valid departure airport from the list above");
            }else{
                System.out.println("Enter a valid arrival airport from the list above");
            }
            pickedAirport=airportInput.nextLine();
            for (int i = 0;i<airportNumber;i++){//runs for the length of the airportDatabase array
                if (airportDatabase[i].airportName.equals(pickedAirport)){
                    if(askForDeparture){
                        selectedAirport = airportDatabase[i].airportName;
                        airportIndex=i;
                        System.out.println("You Selected Airport "+ selectedAirport);
                        System.out.println("Is this your final choice? Type yes to Confirm or anything else to cancel.");
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
                            System.out.print("The selected arrival airport " + pickedAirport + " was the same as selected departure airport, ");
                            airportIndex=0;
                        }//checking to see if the selected arrival airport is the same as the selected departure airport
                        else{
                            selectedAirport = airportDatabase[i].airportName;
                            airportIndex=i;
                            System.out.println("You Selected Airport "+ selectedAirport);
                            System.out.println("Is this your final choice? Type yes to Confirm or anything else to cancel.");
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
                System.out.print("Invalid Airport, check that your spelling is correct");
            }//if airporIndex=-1 it is known that the program did not find a valid airport to change the value of airportIndex to be >-1
        }
        return airportIndex;
    }//runs for departure and arrival airports
    public void returnAirports(){
        System.out.println("Availiable Airports:");
        for (int b=0;b<airportNumber;b++){
            System.out.println(airportDatabase[b].airportName);
        }
    }//returns all airport names within the airportDatabase array

}
