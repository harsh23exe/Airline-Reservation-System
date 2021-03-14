package aaa;
import java.util.*;


public class App extends AirlineReservationSysyem{
    

    /**
     * To store all FlightID
     */
    static Set<Integer> flights;
    /**
     * To store all passenger ID 
     */
    static Set<Integer> passengers;


    App()
    {
        flights = new HashSet<>();
        passengers = new HashSet<>();
    }


    /**
     * Interacts with I/O to get necessary requirements for scheduling flight
     * @param sc the interaction file
     */
    public void addFlight(Scanner sc) {
        int flight_ID, price , seats;
        String destination, source;
        date d;

        System.out.print("Enter flightID : ");
        flight_ID = sc.nextInt();

        System.out.print("Enter destination : ");
        destination = sc.next();

        System.out.print("Enter Source : ");
        source = sc.next();

        System.out.print("Enter price : ");
        price = sc.nextInt();

        System.out.print("Enter seats : ");
        seats = sc.nextInt();

        d = new date(sc);
        if(flights.contains(flight_ID) == false)
        {
            ScheduleFlight(source, destination, d, flight_ID , seats , price);
            flights.add(flight_ID);
            System.out.println("FLight added .");
        }
        else {
            System.out.println("FlightID already exists");
        }


    }

    /**
     * Interacts with I/O to get necessary requirements for closing flight
     * @param sc the interaction file 
     */
    public void closeFlight(Scanner sc) {

        System.out.print("Enter flightID to take-off : ");
        int flight_ID = sc.nextInt();

        if(flights.contains(flight_ID) == false ){
            System.out.println("Invalid FlightID . ");
            return;
        }
        CloseFlight(flight_ID);
        flights.remove(flight_ID);

    }


    /**
     * Interacts with I/O to flight and passenger details to book a flight
     * @param sc the interaction file 
     */
    public void BookFlight(Scanner sc) {
        
        System.out.print("Enter flightID : ");
        int flightID = sc.nextInt();
        System.out.print("Enter passengerID : ");
        int passengerID = sc.nextInt();

        if(passengers.contains(passengerID) == false)
        {
            System.out.println("Passenger not registered");
            return ;
        }

        if(flights.contains(flightID) == false ){
            System.out.println("Invalid FlightID . ");
            return ;
        }

        System.out.println("*******************************************************************");
        Bookflight(flightID, passengerID).printDetails(); 
        System.out.println("*******************************************************************");


    }
    /**
     * Interacts with I/O to flight and passenger details to cancel a flight
     * @param sc
     */
    public void cancelTicket(Scanner sc) {

        System.out.print("Enter flightID :");
        int flightID = sc.nextInt();
        System.out.print("Enter passengerID : ");
        int passengerID = sc.nextInt();

        if(passengers.contains(passengerID) == false)
        {
            System.out.println("Passenger not registered");
            return ;
        }

        if(flights.contains(flightID) == false ){
            System.out.println("Invalid FlightID . ");
            return ;
        }

        cancelTicket(flightID, passengerID);
        System.out.println("Flight ticket cancelled for passanger " + passengerID + ".");

    }
    /**
     * Add new passenger to our database
     * @param sc the interaction file 
     */
    public void registerPassenger(Scanner sc)
    {
        int age, contact_no , passengerID;
        String name ;
        System.out.print("Enter name : ");
        name = sc.next();

        System.out.print("Enter age : ");
        age = sc.nextInt();
        
        System.out.print("Enter contact number: ");
        contact_no  = sc.nextInt();

        System.out.print("Enter passenger ID : ");
        passengerID = sc.nextInt();

        if(passengers.contains(passengerID) == true )
        {
            System.out.println("Passenger already in our database ");
            return;
        }
        

        addPassenger(passengerID , contact_no, age, name);
        passengers.add(passengerID);

        System.out.println("Passenger " + name + " has been registered in our database.");
    }
    /**
     * Show the list of ongoing flights so the passengers can book 
     */
    public void showFlights()
    {
        Iterator<Flight> ptr = ongoingFlights.iterator();
        Flight f;
        date d;

        while(ptr.hasNext() == true)
        {
            f = ptr.next();
            d = f.showSchedule();

            System.out.println("******Flight ID : "+ f.flightID()+"*********");

            System.out.println(f.source() + " to " + f.destination() + " on " + d.dd + " " + d.mm + " " + d.yyyy);
            
            System.out.println("Departure time   " + d.hrs + ":" + d.min);

            System.out.println("Price per seat : "+f.price());

            System.out.println();

        }

    }

    public void RescheduleFlight(Scanner sc)
    {
        int flightID ;
        date d;
        System.out.print("Enter the flightID to reschedule :");
        flightID = sc.nextInt();

        if(flights.contains(flightID) == false ){
            System.out.println("Flight does not exist");
            return;
        }

        d = new date(sc);

        reScheduleFlight(flightID, d);

        System.out.println("Flight has been rescheduled.");

    }


    public static void main(String Args[]) {

        flights = new HashSet<>();
        passengers = new HashSet<>();


        System.out.println("Starting Airline Reservation System .......\n");

        App run = new App();

        Scanner sc = new Scanner(System.in);

        int choice =0 ;
        while(true)
        {
            System.out.println("\n\nMENU :");
            
            System.out.println("1. Add Flight. ");
            System.out.println("2. Close Flight.");
            System.out.println("3. Book Flight. ");
            System.out.println("4. Cancel TIcket. ");
            System.out.println("5. Register new passenger. ");
            System.out.println("6. Show all Flights . ");
            System.out.println("7. Reschedule a flight. ");
            System.out.print("\nEnter your choice : ");
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error :" + e);
                sc.next();
                choice  =0;
                continue;
            }
            System.out.println();

            switch(choice)
            {
                case 1 : 
                    run.addFlight(sc);
                    break;
                case 2: 
                    run.closeFlight(sc);
                    break;
                case 3:
                    run.BookFlight(sc);
                    break;
                case 4: 
                    run.cancelTicket(sc);
                    break;
                case 5: 
                    run.registerPassenger(sc);
                    break;
                case 6:
                    run.showFlights();
                    break;
                case 7:
                    run.RescheduleFlight(sc);
                    break;
                
                

                default : System.out.println("Invalid choice");

            }
        }

 

        

        
    }
}
