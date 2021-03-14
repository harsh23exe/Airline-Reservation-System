package aaa;
// Akshat
public class Plane {
    private final int plane_ID;
    private int maximum_seats;
    
    Plane(int plane_ID,int maximum_seats)
    {
        this.plane_ID = plane_ID;
        this.maximum_seats = maximum_seats;
    }
    public int planeID()
    {
        return plane_ID;
    }
    public int maximumSeats()
    {
        return maximum_seats;
    }

    
    
}
