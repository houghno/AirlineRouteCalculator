import java.util.Scanner;//importing scanner utilisation
import java.io.File;//importing the ability to read information from files, used to read in airports.
import java.io.IOException;//importing the utilisation of the exception error catching message
import java.text.*;//importing for decFormat
/**
 * Program in which users select two airports to fly between and the distance and time taken for the route is calculated accordingly
 * Note: Unit of distance is a made up latitude x longitude measurement
 * Note: Program cannot calculate the 
 * @author Noah Houghton 
 */
public class AirlineFlightRouteCalculator
{
    private DecimalFormat decFormat = new DecimalFormat("##.##");//for changing hours and minutes values to 2 decimal places
    private Airport[] airportDatabase = new Airport[100];//initialising the airportDatabase variable 
    private String finalChoice="Is this your final choice? Type Yes to Confirm or anything else to cancel. ";//prompt to the user for them to confirm their selected airport
    private String selectedAirport = "NO AIRPORT SELECTED";//error message in case no airport was somehow entered
    private int previousAirportSelection;//to store the departure airport and check that the input arrival airport was not the same as this
    private int airportNumber = 0;//counter to allocate an airport to an array index
    public AirlineFlightRouteCalculator(){//constructor class
        System.out.print("\f");//clears dialog box
        fileReader();//reads data out from the file of airports and sorts it into the airportDatabase variable
        returnAirports();//returns the names of all Airport variables
        int departureAirport=PickAirport(true);//runs the PickAirport method so that it runs to cater for a departure airport
        previousAirportSelection=departureAirport;//for foolproof checking of the arrival airport to check that it hasn't been repeated from the departure airport
        int arrivalAirport=PickAirport(false);//runs the PickAirport method so that it runs to cater for an arrival airport
        Airport from=airportDatabase[departureAirport];//designates the selected departure airport to the from variable
        Airport to=airportDatabase[arrivalAirport];//designates the selected arrival airport to the to variable
        System.out.println("The distance of your selected route was calculated to be "+ from.straightLineDistance(to,true) + " units");
        //prints out a message containing straightLineDistance calculations for the departure and arrival airports with a true parameter, which was previously used but is not used in the final version
        System.out.println("The estimated flight time of that route was calculated to be "+decFormat.format(from.flightTimeInHours(to))+" hours which is equivalent to " + decFormat.format(from.flightTimeInMinutes(to)) +" minutes");
        //prints out message which runs the flightTimeInHours and flightTime in minutes methods with the selected departure and arrival airports
    }

    public void fileReader(){//reads from file and splits up information within the different variable lines
        File airports=new File("airportdatabase.txt");//creates file airport variable and designates it to the airportdatabase.txt file within the project folder
        try {
            Scanner readAirportsFile = new Scanner(airports);//designates new scanner to read the airport file variable
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
        catch(IOException e){//catch
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
                System.out.println("Enter a valid departure airport from the list of availiable airports.");
            }else{
                System.out.println("Enter a valid arrival airport from the list of availiable airports");
            }
            pickedAirport=airportInput.nextLine();
            for (int i = 0;i<airportNumber;i++){//runs for the length of the airportDatabase array
                if (airportDatabase[i].airportName.equals(pickedAirport.toLowerCase())){
                    if(askForDeparture){
                        selectedAirport = airportDatabase[i].airportName;
                        airportIndex=i;
                        System.out.println("You selected the airport "+ selectedAirport+"");
                        System.out.println("Is this your final choice? Type yes to confirm or anything else to cancel. ");
                        if(airportInput.nextLine().toLowerCase().equals("yes")){
                            airportConfirmation=true;
                            System.out.println("Selection confirmed. ");
                        }
                        else{
                            System.out.print("Selection cancelled, ");  
                        }//confirmation process
                    }
                    else{
                        if(airportDatabase[previousAirportSelection].airportName.equals(pickedAirport)){
                            System.out.print("The selected arrival airport " + pickedAirport.toUpperCase() + " was the same as selected departure airport, ");
                            airportIndex=0;
                        }//checking to see if the selected arrival airport is the same as the selected departure airport
                        else{
                            selectedAirport = airportDatabase[i].airportName;
                            airportIndex=i;
                            System.out.println("You selected the airport "+ selectedAirport.toUpperCase());
                            System.out.println("Is this your final choice? Type yes to confirm or anything else to cancel. ");
                            if(airportInput.nextLine().toLowerCase().equals("yes")){
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
                System.out.print("That was an invalid airport, check that your spelling is correct. ");
            }//if airporIndex=-1 it is known that the program did not find a valid airport to change the value of airportIndex to be >-1
        }
        return airportIndex;
    }//runs for departure and arrival airports
    public void returnAirports(){
        System.out.println("Select different airports for the departure and arrival airports");
        System.out.println("Availiable Airports:");
        for (int b=0;b<airportNumber;b++){
            System.out.println(airportDatabase[b].airportName.toUpperCase());//converts airport names to upper case format
        }
    }//returns all airport names within the airportDatabase array

}
