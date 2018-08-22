import java.awt.Container;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SellBikeUI implements ActionListener
{
     private JFrame frame;
    private JLabel lbl, Bikeid, Description, Company, CustomerName, Contact;
    private JLabel SellDate, Email,TaxRate, Price,TotalAmount;
    private JTextField txtBikeid, txtDescription, txtCompany, txtCustomerName, txtContact;
    private JTextField txtSellDate, txtEmail, txtTaxRate, txtPrice, txtTotalAmount; 
    private JButton check, clear, confirm;
    
    public SellBikeUI()
    {
        frame = new JFrame ("Everest Motors : Sell Bike");
        Container panel = frame.getContentPane();
        panel.setLayout(null);
        
        lbl = new JLabel ("Sell Bike ");
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
        txtCompany.setBounds (370,110,120,25);
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
        txtEmail.setBounds (370,170,120,25);
        panel.add(txtEmail);
        
        SellDate = new JLabel ("Sell Date");
        SellDate.setBounds (10,200,100,25);
        panel.add(SellDate);
        
        txtSellDate = new JTextField();
        txtSellDate.setBounds (120,200,120,25);
        panel.add(txtSellDate);
        
        TaxRate = new JLabel ("Tax Rate (%)");
        TaxRate.setBounds (290,200,100,25);
        panel.add(TaxRate);
        
        txtTaxRate = new JTextField();
        txtTaxRate.setBounds (370,200,120,25);
        txtTaxRate.setEnabled(false);
        panel.add(txtTaxRate);
        
        Price = new JLabel ("Price");
        Price.setBounds (10,230,100,25);
        panel.add(Price);
        
        txtPrice = new JTextField();
        txtPrice.setBounds (120,230,120,25);
        txtPrice.setEnabled(false);
        panel.add(txtPrice);
        
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
                String id = txtBikeid.getText();
                try
                {
                    if (id !=null && !id.equals(""))
                    {
                        int index = Integer.parseInt(id);
                         if (index >0 && index <=BikeRentalUI.list.size())
                         {
                             try
                             {
                                  BikeToSell obj = (BikeToSell)BikeRentalUI.list.get(index-1);
                                 boolean ans = obj.getSellStatus();
                                 if (ans == false)
                                 {
                                     BikeToSell bts = (BikeToSell)BikeRentalUI.list.get(index-1);
                                     txtDescription.setText(bts.getDescription());
                                     txtCompany.setText(bts.getManufacturer());
                                     txtPrice.setText(Integer.toString(bts.getPrice()));
                                     txtTaxRate.setText(Integer.toString(bts.getTaxAmount()));
                                     
                                     int price = bts.getPrice();
                                     int tax = bts.getTaxAmount();
                                     int cost = price + (price*tax);
                                     txtTotalAmount.setText(Integer.toString(cost));
                                     confirm.setEnabled(true);
                                 }
                                 else
                                 {
                                     JOptionPane.showMessageDialog(frame, "Bike has already been sold");
                                 }
                            }
                            catch (Exception e)
                            {
                                JOptionPane.showMessageDialog(frame, "Bike id belongs to bike to be rented");
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
                catch (NumberFormatException e)
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
                    String date = txtSellDate.getText();
                    if (name !=null && !name.equals(""))
                    {
                        String id = txtBikeid.getText();
                        int index = Integer.parseInt(id);
                        BikeToSell obj = (BikeToSell)BikeRentalUI.list.get(index-1);
                        obj.SellBike(name, contact, email, date);
                         JOptionPane.showMessageDialog(frame, "Bike was sold to "+ name);
                         txtBikeid.setText("");
                        txtDescription.setText("");
                        txtCompany.setText("");
                        txtCustomerName.setText("");
                        txtContact.setText("");
                        txtEmail.setText("");
                        txtSellDate.setText("");
                        txtPrice.setText("");
                        txtTaxRate.setText("");
                        txtTotalAmount.setText("");
                        confirm.setEnabled(false);
                    }
                    else
                    {
                          JOptionPane.showMessageDialog(frame, "Error Message/ do not leave field blank!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch (Exception e)
                {
                     JOptionPane.showMessageDialog(frame, "Error Message/ do not leave field blank!!", "ERROR", JOptionPane.ERROR_MESSAGE);
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
                    txtSellDate.setText("");
                    txtPrice.setText("");
                    txtTaxRate.setText("");
                    txtTotalAmount.setText("");
            }
        }
       
}

