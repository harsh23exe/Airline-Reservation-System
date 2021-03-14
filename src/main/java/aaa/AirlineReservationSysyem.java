package aaa;

import java.util.*;


public class AirlineReservationSysyem {
    /**
     * Stores Flight object with FlightID as unique identity
     */
    public Set<Flight> ongoingFlights;

    /**
     * Passenger database with pasengerID as unique identity
     */
    Set<Passenger> allPassengers;

    
    
    public AirlineReservationSysyem()
    {
        ongoingFlights = new HashSet<Flight>();
        allPassengers = new HashSet<Passenger>();
    }
    /**
     * Initate a flight into system 
     * @param source    
     * @param destination
     * @param d take off time 
     * @param flightID  
     * @param seats maximum seats
     * @param price price per seat
     */

    public void ScheduleFlight(String source , String destination , date d , int flightID , int seats , int price)
    {
		
		Flight f = new Flight( flightID , source , destination , d , seats , price);

		if(ongoingFlights.contains(f) == true){
            System.out.println("Flight already exists . ");
        }

		else {
			ongoingFlights.add(f);
		}
	}
	
	
	/**
     * Prepone or postpone the flight 
     * @param flightID  flight_ID of the flight to reschedule 
     * @param d new take-off date
     */

    public void reScheduleFlight(int flightID , date d)
    {
		Iterator<Flight> ptr = ongoingFlights.iterator();
        Flight f ;
        while(ptr.hasNext() == true )
        {
            f = ptr.next();
            if(f.flightID() == flightID)
            {
                f.reschedule(d);
                return ;
            }
        }
	}
	
	/**
     * close a flight that has been departed 
     * @param flightID flight ID of flight that has departed
     */

    public void CloseFlight(int flightID )
    {
		Iterator<Flight> ptr = ongoingFlights.iterator();
        Flight f ;
        while(ptr.hasNext() == true )
        {
            f = ptr.next();
            if(f.flightID() == flightID)
            {
                ongoingFlights.remove(f);
                System.out.println("Flight " + flightID + " has departed now. ");
                return ;
            }
        }
        System.out.println("Flight does not exists");
	}

    /**
     * Book a seat for the passenger for the given flight 
     * @param flightID  ID of the flight 
     * @param passengerID ID of the passenger first 
     */

    public Booking Bookflight(int flightID , int passengerID)
    {
        Iterator<Flight> ptr = ongoingFlights.iterator();
        Flight f = new Flight();
        while(ptr.hasNext() == true )
        {
            f = ptr.next();
            if(f.flightID() == flightID)
            {
                break;
            }
        }

        Iterator<Passenger> ptr1 = allPassengers.iterator();
        Passenger p = new Passenger();

        while(ptr1.hasNext() == true)
        {
            p = ptr1.next();
            if(p.passengerID() == passengerID)
            {
                break;
            }
        }

        if(f != null && p!= null)
        {
            return f.BookTicket(p);
        }
        return null;
        
    }


    /**
     * cancel the flight booking of a passenger 
     * @param flightID ID of the flight 
     * @param passengerID ID of the passenger 
     */

    public void cancelTicket(int flightID , int passengerID )
    {

        Iterator<Passenger> ptr1 = allPassengers.iterator();
        Passenger p  =new Passenger();
        while(ptr1.hasNext() == true)
        {
            p = ptr1.next();
            if(p.passengerID() == passengerID){
                break;
            }
        }
        Iterator<Flight> ptr = ongoingFlights.iterator();
        Flight f ;
        while(ptr.hasNext() == true )
        {
            f = ptr.next();
            if(f.flightID() == flightID)
            {
                f.CancelTicket(p);
                return ;
            }
        }
    }
    /**
     * Add passenger info to our database 
     * @param contact_no
     * @param age
     * @param name
     */
    public void addPassenger(int passengerID , int contact_no , int age , String name)
    {
        Passenger p = new Passenger(passengerID , contact_no, age, name);
        allPassengers.add(p);
    }
    
    
    
}
