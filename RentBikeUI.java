import java.awt.Container;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class RentBikeUI implements ActionListener
{
    private JFrame frame;
    private JLabel lbl, Bikeid, Description, Company, CustomerName, Contact;
    private JLabel HireDate, Email, NoOfDays, DailyRate, TotalAmount;
    private JTextField txtBikeid, txtDescription, txtCompany, txtCustomerName, txtContact;
    private JTextField txtHireDate, txtEmail, txtNoOfDays, txtDailyRate, txtTotalAmount; 
    private JButton check, calculateRent, clear, confirm;
    
    public RentBikeUI()
    {
        frame = new JFrame ("Everest Motors : Rent Bike");
        Container panel = frame.getContentPane();
        panel.setLayout(null);
        
        lbl = new JLabel ("Rent Bike ");
        lbl.setBounds (240,10,200,50);
        lbl.setForeground(Color.blue);
        lbl.setFont(new Font("Times New Roman", Font.BOLD, 20));
        panel.add(lbl);
        
        Bikeid = new JLabel ("Bike Id");
        Bikeid.setBounds (10,80,100,25);
        panel.add(Bikeid);
        
        txtBikeid = new JTextField();
        txtBikeid.setBounds (120,80,120,25);
        panel.add(txtBikeid);
        
        Description = new JLabel ("Description");
        Description.setBounds (10,110,100,25);
        panel.add(Description);
        
        txtDescription = new JTextField();
        txtDescription.setBounds (120,110,120,25);
        txtDescription.setEnabled(false);
        panel.add(txtDescription);
        
        Company = new JLabel ("Company");
        Company.setBounds (290,110,100,25);
        panel.add(Company);
        
        txtCompany = new JTextField();
        txtCompany.setBounds (360,110,120,25);
        txtCompany.setEnabled(false);
        panel.add(txtCompany);
        
        CustomerName = new JLabel ("Customer Name");
        CustomerName.setBounds (10,140,100,25);
        panel.add(CustomerName);
        
        txtCustomerName = new JTextField();
        txtCustomerName.setBounds (120,140,120,25);
        panel.add(txtCustomerName);
        
        Contact = new JLabel ("Contact");
        Contact.setBounds (10,170,100,25);
        panel.add(Contact);
        
        txtContact = new JTextField();
        txtContact.setBounds (120,170,120,25);
        panel.add(txtContact);
        
        Email = new JLabel ("Email");
        Email.setBounds (290,170,100,25);
        panel.add(Email);
        
        txtEmail = new JTextField();
        txtEmail.setBounds (360,170,120,25);
        panel.add(txtEmail);
        
        HireDate = new JLabel ("Hire Date");
        HireDate.setBounds (10,200,100,25);
        panel.add(HireDate);
        
        txtHireDate = new JTextField();
        txtHireDate.setBounds (120,200,120,25);
        panel.add(txtHireDate);
        
        NoOfDays = new JLabel ("No Of Days");
        NoOfDays.setBounds (290,200,100,25);
        panel.add(NoOfDays);
        
        txtNoOfDays = new JTextField();
        txtNoOfDays.setBounds (360,200,120,25);
        panel.add(txtNoOfDays);
        
        DailyRate = new JLabel ("Daily rate");
        DailyRate.setBounds (10,230,100,25);
        panel.add(DailyRate);
        
        txtDailyRate = new JTextField();
        txtDailyRate.setBounds (120,230,120,25);
        txtDailyRate.setEnabled(false);
        panel.add(txtDailyRate);
        
        TotalAmount = new JLabel ("Total Amount");
        TotalAmount.setBounds (10,260,100,25);
        panel.add(TotalAmount);
        
        txtTotalAmount = new JTextField();
        txtTotalAmount.setBounds (120,260,120,25);
        txtTotalAmount.setEnabled(false);
        panel.add(txtTotalAmount);
        
        check = new JButton ("Check");
        check.setBounds(290,290,120,25);
        panel.add(check);
        check.addActionListener(this);
        
        calculateRent = new JButton ("Calculate Rent");
        calculateRent.setBounds(420,290,120,25);
        calculateRent.setEnabled(false);
        panel.add(calculateRent);
        calculateRent.addActionListener(this);
        
        clear = new JButton ("Clear");
        clear.setBounds(290,320,120,25);
        panel.add(clear);
        clear.addActionListener(this);
        
        confirm = new JButton ("Confirm");
        confirm.setBounds(420,320,120,25);
        confirm.setEnabled(false);
        panel.add(confirm);
        confirm.addActionListener(this);
        
        frame.setSize(600,460);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == check)
        {
            String Bikeid = txtBikeid.getText();
            try
            {
                if (Bikeid !=null && !Bikeid.equals(""))
                {
                    int index = Integer.parseInt(Bikeid);
                    if (index >0 && index <=BikeRentalUI.list.size())
                    {
                        try
                        {
                             BikeToRent obj = (BikeToRent)BikeRentalUI.list.get(index-1);
                            boolean ans = obj.getLoanStatus();
                        
                            if( ans == false)
                            {
                                BikeToRent btr =(BikeToRent)BikeRentalUI.list.get(index-1);
                                txtDescription.setText(btr.getDescription());
                                txtCompany.setText(btr.getManufacturer());
                                txtDailyRate.setText(Integer.toString(btr.getDailyRate()));
                                calculateRent.setEnabled(true);
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(frame, "Bike is currently on rent");
                            }
                        }
                        catch (Exception e)
                        {
                            JOptionPane.showMessageDialog(frame, "Bike id belongs to bike to be sold");
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(frame, "Error Message\nPlease enter valid index","ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(frame, "Error Message/ do not leave field blank!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(frame, "Error Message\nPlease enter valid number","ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (ae.getSource() == calculateRent)
        {
            try
            {
                String days = txtNoOfDays.getText();
                String dailyrate = txtDailyRate.getText();
                if (days !=null && !days.equals(""))
                {
                    int intdays = Integer.parseInt(days);
                    int rate = Integer.parseInt(dailyrate);
                    int total = intdays * rate;
                    txtTotalAmount.setText(Integer.toString(total));
                    confirm.setEnabled(true);
 
                }
                else
                {
                    JOptionPane.showMessageDialog(frame, "Error Message/ do not leave field blank!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    
                }
            }
            catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(frame, "Error Message\nPlease enter valid number","ERROR", JOptionPane.ERROR_MESSAGE);
            } 
        }
        else if (ae.getSource() == confirm)
        {
            try
            {
                String name = txtCustomerName.getText();
                String contact = txtContact.getText();
                String email = txtEmail.getText();
                String hiredate = txtHireDate.getText();
                String days = txtNoOfDays.getText();
                int intdays = Integer.parseInt(days);
                
                if (name !=null && !name.equals(""))
                {
                    String Bikeid = txtBikeid.getText();
                     int index = Integer.parseInt(Bikeid);
                     BikeToRent obj = (BikeToRent)BikeRentalUI.list.get(index-1);
                    obj.RentBike(name, contact, email, hiredate, intdays);
                     JOptionPane.showMessageDialog(frame, "Bike was rented to "+ name);
                    txtBikeid.setText("");
                    txtDescription.setText("");
                    txtCompany.setText("");
                    txtCustomerName.setText("");
                    txtContact.setText("");
                    txtEmail.setText("");
                    txtHireDate.setText("");
                    txtNoOfDays.setText("");
                    txtDailyRate.setText("");
                    txtTotalAmount.setText("");
                    calculateRent.setEnabled(false);
                    confirm.setEnabled(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(frame, "Error Message/ do not leave field blank!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(frame, "Error Message\nPlease enter valid number","ERROR", JOptionPane.ERROR_MESSAGE);
            }  
        }
        else if (ae.getSource() == clear)
        {
            txtBikeid.setText("");
            txtDescription.setText("");
            txtCompany.setText("");
            txtCustomerName.setText("");
            txtContact.setText("");
            txtEmail.setText("");
            txtHireDate.setText("");
            txtNoOfDays.setText("");
            txtDailyRate.setText("");
            txtTotalAmount.setText("");
            
        }
    }
}
