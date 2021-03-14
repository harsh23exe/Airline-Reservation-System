package aaa;

public class Passenger {

    /**
     * Unique ID for each Passenger
     */
    private int passenger_ID;

    /**
     * Passenger name
     */
    private String name;

    /**
     * passenger contact Number 
     */
    private int  contact_no;

    /**
     * Passenger age
     */
    private int age ;

    /**
     * Passenger password for safe booking 
     */   
    private String password;

    /**
     * Constructor
     * @param contact_no
     * @param age
     * @param name
     */
    public Passenger(int passenger_ID ,  int contact_no , int age , String name)
    {
        this.passenger_ID = passenger_ID;
        this.contact_no = contact_no;
        this.age = age;
        this.name = name ; 

    }

    public Passenger()
    {
        
    }
    /**
     * Get Passenger ID 
     * @return Passenge_ID 
     */
    public int passengerID()
    {
        return passenger_ID;
    }

    /**
     * Get passenger Contact number
     * @return passenger contact number
     */
    public int contactNo()
    {
        return contact_no;
    }
    /**
     * Get passenger age 
     * @return age
     */
    public int age()
    {
        return age;
    }
    /**
     * Get passenger name 
     * @return Passenger name
     */
    public String name()
    {
        return name;
    }


    /**
     * Change passenger personal info
     * @param contact_no the new contact number 
     */
    void updateContactNumber(int contact_no)
    {
        this.contact_no = contact_no;
    }
    /**
     * Check if the password is correct or not 
     * @param password login credentials
     * @return true if password is correct , else false 
     */
    boolean checkPassword(String password)
    {
        return this.password.compareTo(password) == 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        return  prime + name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Passenger)) {
            return false;
        }
        Passenger other = (Passenger) obj;
        return this.passenger_ID == other.passenger_ID;
    }

    
    
}