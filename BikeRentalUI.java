import java.awt.Container;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BikeRentalUI implements ActionListener
{
    private JFrame frame;
    private JLabel lbl;
    private JButton AddBikeRent, AddBikeSell, RentBike, SellBike, Return, Display;
    public static ArrayList<Bike> list;
    
    public static int count = 1;
    public BikeRentalUI()
    {
        list = new ArrayList <Bike>();
        
        frame = new JFrame ("Bike Company");
        Container panel = frame.getContentPane();
        panel.setLayout(null);
        
        
        lbl = new JLabel("Bike Company");
        lbl.setBounds (150,10,200,50);
        lbl.setForeground(Color.blue);
        lbl.setFont(new Font("Times New Roman", Font.BOLD, 20));
        panel.add(lbl);
        
        AddBikeRent = new JButton ("Add Bike to Rent");
        AddBikeRent.setBounds(10,80,200,50);
        panel.add(AddBikeRent);
        AddBikeRent.addActionListener(this);
        
        AddBikeSell = new JButton ("Add Bike to Sell");
        AddBikeSell.setBounds (230,80,200,50);
        panel.add(AddBikeSell);
        AddBikeSell.addActionListener(this);
        
        RentBike = new JButton ("Rent Bike");
        RentBike.setBounds(10,150,200,50);
        panel.add(RentBike);
        RentBike.addActionListener(this);
        
        SellBike = new JButton ("Sell Bike");
        SellBike.setBounds (230,150,200,50);
        panel.add(SellBike);
        SellBike.addActionListener(this);
        
        Return = new JButton ("Return");
        Return.setBounds(10,220,200,50);
        panel.add(Return);
        Return.addActionListener(this);
        
        Display = new JButton("Display");
        Display.setBounds(230,220,200,50);
        panel.add(Display);
        Display.addActionListener(this);
        
        frame.setSize(460,350);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        Object click = ae.getSource();
        if (click == AddBikeRent)
        {
            count = list.size() + 1;
            BikeToRentUI emp = new BikeToRentUI();
        }
        else if (click == AddBikeSell)
        {
            count = list.size() + 1;
            BikeToSellUI emp = new BikeToSellUI();
        }
         else if (click == RentBike)
        {
            RentBikeUI emp = new RentBikeUI();
        }
        else if (click == SellBike)
        {
            SellBikeUI emp = new SellBikeUI();
        }
        else if (click == Return)
        {
            ReturnBikeUI emp = new ReturnBikeUI();
        }
        else
        {
            this.display();
        }
    }
    private void display()
    {
         int i=1;
        for (Bike bk : list)
        {
             System.out.println("Record " +i);
            if (bk instanceof BikeToRent)
            {
                BikeToRent val = (BikeToRent)bk;
                System.out.println ("Description :" + val.getDescription() + "  "+"Manufacturer :"+ val.getManufacturer());
                System.out.println ("Customer Name :" + val.getCustomerName() +"  "+ "Contact No." + val.getContactNo() );
                System.out.println("Email :" + val.getEmail());
                System.out.println("Daily rate:" + val.getDailyRate());
               
            }
            else if (bk instanceof BikeToSell)
            {
               BikeToSell val = (BikeToSell)bk;
               System.out.println ("Description :" + val.getDescription() + "  "+"Manufacturer :"+ val.getManufacturer());
               System.out.println("Customer Name :" + val.getCustomerName()+"  "+ "Contact No." + val.getContactNo());
               System.out.println( "Email :" + val.getEmail());
               System.out.println("Price :" + val.getPrice());
            }
            System.out.println();
            i= i+ 1;
            
        }
    }
    public static void main (String[] args)
    {
        new BikeRentalUI();
    }
    
}
