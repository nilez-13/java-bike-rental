
public class BikeToSell extends Bike
{
    private  int Price;
    private  int TaxAmount;
    private  int TotalAmount;
    private  String SellDate;
    private  boolean SellStatus; 
   
    public BikeToSell(String description, String manufacturer, int price, int tax)
    {
        super(description , manufacturer);
        Price = price ;
        TaxAmount = tax;
        TotalAmount = 0;
        SellDate = "";
        SellStatus = false;
        
    }
    public  int getPrice()
    {
        return Price;
    }
    public  int getTaxAmount()
    {
       return TaxAmount; 
    }
    public  int getTotalAmount()
    {
        return TotalAmount;
    }
    public  String getSellDate()
    {
        return SellDate;
    }
    public  boolean getSellStatus()
    {
        return SellStatus;
    }
    
    public  void SellBike(String customerName, String contact, String email, String sellDate)
    {
        
        if (SellStatus == true)
        {
            System.out.println("The bike has already been sold");
        }
        else
        {
            super.setCustomerName(customerName);
            super.setContactNo(contact);
            super.setEmail(email);
            TotalAmount = Price + (Price*TaxAmount);
            SellDate = sellDate;
            SellStatus = true;
        }
    }
}
