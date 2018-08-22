

public class Bike
{
    private  String description;
    private  String manufacturer;
    private  String customer_name;
    private  String contact_no;
    private  String email;
    
    public Bike (String descrpt, String manuf)
    {
        description = descrpt;
        manufacturer = manuf;
        customer_name = "";
        contact_no = "";
        email = "";
        
    }
    
    public  String getDescription()
    {
        return description;
    }
    public  String getManufacturer()
    {
        return manufacturer;
    }
    public  String getCustomerName()
    {
        return customer_name;
    }
    public  String getContactNo()
    {
        return contact_no;
    }
    public  String getEmail()
    {
        return email;
    }
    public  void setCustomerName(String cn)
    {
        customer_name = cn;
    }
     public  void setContactNo(String num)
    {
        contact_no = num;
    }
     public  void setEmail(String em)
    {
        email = em;
    }
    public void display()
    {
        System.out.println ("Description :" + getDescription() + "  "+"Manufacturer :"+ getManufacturer());
        System.out.println ("Customer Name :" + getCustomerName() +"  "+ "Contact No." + getContactNo() );
        System.out.println("Email :" + getEmail());
        
    }
}
