package aaa;
import java.util.*;


public class Flight {

    private int flightID , seats_booked , planeID , price;
    final int total_seats;
    private String source , destination; 
    private date flightTime;
        
    private Map<Passenger , Booking > reservations;
    List<Integer> seatsPool;

    /**
     * Constructor
     * @param flightID
     * @param source
     * @param destination
     * @param d
     * @param seats
     * @param price
     */
    public Flight(int flightID , String source , String destination , date d , int seats , int price)
    {
        this.flightID = flightID;

        total_seats = seats;

        this.source = source;
        this.destination = destination;
        this.price = price;

        flightTime = d;


        seats_booked = 0;

        reservations = new HashMap<>();
        seatsPool = new LinkedList<>();
        for (int i = 1; i <= total_seats; i++) {
            seatsPool.add(i);
        }

    }
    /**
     * garbage
     */
    public Flight()
    {
        total_seats = 0;
    }

    // private int generateRandomNumber(final int max, final int min) {
    //     return min + (int)(Math.random() * ((max - min) + 1));
    // }

    /**
     * Method to book fliht seat for the passenger 
     * @param p
     * @return
     */
    Booking BookTicket(Passenger p)
    {
        if(reservations.containsKey(p) == true ){
            return null;
        }

        if(p == null){
            return null;
        }

        int seat_no = seats_booked;

        Booking ticket = new Booking(p, flightID, price, seat_no);

        reservations.put(p, ticket);
        
        seats_booked++;
        return ticket;
    }
    /**
     * cancel a booking for passenger on the flight 
     */
    void CancelTicket(Passenger p)
    {
        if(p == null )  return;

        if(reservations.containsKey(p)){
            // int seatno = reservations.get(p).seatno();
            reservations.remove(p);
            seats_booked--;
        }
    }

    
    public int flightID()
    {
        return flightID;
    }

    public int planeID()
    {
        return planeID;
    }

    public String source()
    {
        return source;
    }

    public String destination()
    {
        return destination;
    }

    public date showSchedule()
    {
        return flightTime;
    }

    public int price()
    {
        return price;
    }


    public int availabeSeats()
    {
        return total_seats - seats_booked;
    }

    protected void reschedule(date d)
    {
        flightTime = d;
    }

    

    public void changePrice(int price)
    {
        this.price = price;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        return  prime + flightID;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Flight)) {
            return false;
        }
        Flight other = (Flight) obj;
        return this.flightID== other.flightID;
    }


    
  
}
