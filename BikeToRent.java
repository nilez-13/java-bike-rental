public class BikeToRent extends Bike
{
   private  String HireDate;
   private  int NoOfDays;
   private  int DailyRate;
   private  int TotalRent;
   private  boolean LoanStatus;
   
   public BikeToRent(String description, String manufacturer, int dailyR)
   {
       super(description,manufacturer);
       DailyRate = dailyR;
       HireDate = "";
       NoOfDays = 0;
       
       TotalRent = 0;
       LoanStatus = false;
       
    }
    public  String getHireDate()
    {
        return HireDate;
    }
    public  int getNoOfDays()
    {
        return NoOfDays;
    }
    public  int getDailyRate()
    {
        return DailyRate;
    }
    public  int getTotalRent()
    {
        return TotalRent;
    }
    public  boolean getLoanStatus()
    {
        return LoanStatus; 
    }
    
    public  void RentBike(String customer_n, String contact, String email, String hire_date, int noOfdays)
    {
        if (LoanStatus == true)
        {
            System.out.println("Bike is currently being rented");
            System.out.println("Date of hire = "+ HireDate);
            System.out.println("Number of days on rent = " +NoOfDays); 
        }
        else
        {
            super.setCustomerName(customer_n);
            super.setContactNo(contact);
            super.setEmail(email);
            HireDate = hire_date;
            NoOfDays = noOfdays;
            LoanStatus = true;
            TotalRent = DailyRate*NoOfDays;
        }
    }
    public  void FreeBike()
    {
        if (LoanStatus == false)
        {
            System.out.println("Bike is not being rented");
        }
        else
        {
            super.setCustomerName ("");
            super.setContactNo("");
            super.setEmail("");
            NoOfDays = 0;
            HireDate = "";
            LoanStatus = false;
        }
    }
}
    

