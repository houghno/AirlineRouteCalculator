/**
 * A program that uses preferential information from a user to decide what 
 * combination of flights they need to take to get from point A to B.
 *
 * @author Noah Houghton
 * @version 1.0
 */

public class AirlineFlightRouteCalculator
{
    public int x = 0;
    public AirlineFlightRouteCalculator(){
        /*for the airportDatabase array, the first dimension will represent an individual airport and the second will represent the properties of that airport, for example, the name of Wellington
        Airport is stored at airportDatabase[0][0] [Airport][AirportName]  */
        /*String[][] airportDatabase={{"tokyo","125.5494","319.7798","60","50","40"},{"johannesburg","2","","22","23","45"},{"mumbai",}};
        String[][] airportDatabase = new String[9][];
        airportDatabase[0][0]="tokyo";
        airportDatabase[1][0]="johannesburg";
        airportDatabase[2][0]="mumbai";
        airportDatabase[3][0]="sydney";
        airportDatabase[4][0]="singapore";
        airportDatabase[0][1]="";
        airportDatabase[1][1]="";
        airportDatabase[2][1]="";
        airportDatabase[3][1]="";
        airportDatabase[4][1]="";
        airportDatabase[5][1]="";
        airportDatabase[6][1]="";
        airportDatabase[7][1]="";
        airportDatabase[8][1]="";
        airportDatabase[9][1]="";
        airportDatabase[0][2]="";
        airportDatabase[1][2]="";
        airportDatabase[2][2]="";
        airportDatabase[3][2]="";
        airportDatabase[4][2]="";
        airportDatabase[5][2]="";
        airportDatabase[6][2]="";
        airportDatabase[7][2]="";
        airportDatabase[8][2]="";
        airportDatabase[9][2]="";*/
        Airport[]   airportDatabase   = new Airport[4];
        airportDatabase[0]=new Airport("tokyo",125.5494,319.7798,60,50,40);
        airportDatabase[1]=new Airport("johannesburg",63.8655,208.2264,90,75,70);
    }
    //calculate straight line distance between two airports
    public int straightLineDistance(int airportDep,int aiportArr){
        float latD=airportDatabase[airportDep].latitude-airportDatabase[airportArr].latitude;
        return airport
    }
    
    
    public int locationDigitParser(){
        
        for (int i=0;i<10;i++){
            int airportLocationX=new int[9];
            int airportLocationY=new int[9];
            airportLocation[i] = Integer.parseInt(airportDatabase[i][1]);
        }
    }
    //hello
    public boolean RangeCalculator(){
        boolean range
        (airportLocation[x][1])
    }
    //String[] places = {"abc","def","ghi"};

}
