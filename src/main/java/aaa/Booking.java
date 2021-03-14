package aaa;
/**
 * Class to store a flight reservation ticket
 */
public class Booking {
    
    private int booking_ID;
    private int  flightID;
    private int price;
    private int seat_no;
    
    private Passenger passenger;
    /**
     * Constructor
     * @param passenger
     * @param flightID
     * @param Price
     * @param seat_no
     */
    public Booking(Passenger passenger,int flightID,int Price , int seat_no)
    {

        this.passenger = passenger;
        this.flightID=flightID;
        this.price=Price;
        this.seat_no = seat_no;
    }


    
    public int BookingID()
    {
        return booking_ID;
    }
    public Passenger getPassenger()
    {
        return passenger;
    }
    public int PlaneID()
    {
        return flightID;
    }
   
    public int price()
    {
        return price;
    }

    public int seatno()
    {
        return seat_no;
    }
    /**
     * Method to print the ticket 
     */
    public void printDetails()
    {
        System.out.println("Booking details ");
        System.out.println("Booking ID : " + booking_ID);
        System.out.println("Passenger ID : " + passenger.passengerID() );
        System.out.println("Passenger name : " + passenger.name());
        System.out.println("Flight ID  : " + flightID);
        System.out.println("Price : " + price);
    }

    
    
    
}