import java.awt.Container;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BikeToSellUI implements ActionListener
{
   private JFrame frame;
   private JLabel lbl, Bikeid,Description,Company,Price,TaxRate;
   private JTextField txtBikeid,txtDescription,txtCompany,txtPrice,txtTaxRate;
   private JButton clear,confirm;
   int count = 1; 
   public BikeToSellUI()
   {
       frame = new JFrame ("Everest Motors : Add Sell Bike");
       Container panel = frame.getContentPane();
       panel.setLayout(null);
        
       lbl = new JLabel ("Add Bike To Sell");
       lbl.setBounds (190,10,200,50);
       lbl.setForeground(Color.blue);
       lbl.setFont(new Font("Times New Roman", Font.BOLD, 20));
       panel.add(lbl);
       
       Bikeid = new JLabel ("Bike Id");
       Bikeid.setBounds (10,80,100,25);
       
       panel.add(Bikeid);
        
       txtBikeid = new JTextField();
       txtBikeid.setBounds (120,80,120,25);
       txtBikeid.setEnabled(false);
       txtBikeid.setText(Integer.toString(BikeRentalUI.count));
       panel.add(txtBikeid);
       
       Description = new JLabel ("Description");
       Description.setBounds (10,110,100,25);
       panel.add(Description);
        
       txtDescription = new JTextField();
       txtDescription.setBounds (120,110,120,25);
       panel.add(txtDescription);
       
       Company = new JLabel ("Company");
       Company.setBounds (290,110,100,25);
       panel.add(Company);
        
       txtCompany = new JTextField();
       txtCompany.setBounds (360,110,120,25);
       panel.add(txtCompany);
       
       Price = new JLabel ("Price");
       Price.setBounds (10,140,100,25);
       panel.add(Price);
        
       txtPrice = new JTextField();
       txtPrice.setBounds (120,140,120,25);
       panel.add(txtPrice);
       
       TaxRate = new JLabel ("Tax Rate(%)");
       TaxRate.setBounds (10,170,100,25);
       panel.add(TaxRate);
        
       txtTaxRate = new JTextField();
       txtTaxRate.setBounds (120,170,120,25);
       panel.add(txtTaxRate);
       
       clear = new JButton ("Clear");
       clear.setBounds(290,200,90,25);
       panel.add(clear);
       clear.addActionListener(this);
        
       confirm = new JButton ("Confirm");
       confirm.setBounds(390,200,90,25);
       panel.add(confirm);
       confirm.addActionListener(this);
        
       frame.setSize(600,350);
       frame.setVisible(true);
       frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        try
       {
           if (ae.getSource() == confirm)
           {
               int Bikeid = Integer.parseInt(txtBikeid.getText());
               String description = txtDescription.getText();
               String company = txtCompany.getText();
               int price =Integer.parseInt(txtPrice.getText());
               int taxRate = Integer.parseInt(txtTaxRate.getText());
               if (description !=null || !description.equals(""))
               {
                   BikeToSell bts = new BikeToSell (description, company, price, taxRate);
                   BikeRentalUI.list.add(bts);
                   
                   count =BikeRentalUI.list.size() + 1;
                   txtBikeid.setText(Integer.toString(count));
                   txtDescription.setText("");
                   txtCompany.setText("");
                   txtPrice.setText("");
                   txtTaxRate.setText("");
                    JOptionPane.showMessageDialog(frame, "Bike was added.");
                }
                else
                {
                    JOptionPane.showMessageDialog(frame, "Error Message/ do not leave field blank!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    
                }
            }
            else if (ae.getSource() == clear)
            {
                txtDescription.setText("");
                txtCompany.setText("");
                txtPrice.setText("");
                txtTaxRate.setText("");
            }
        }
         catch(NumberFormatException e)
        {
             
             JOptionPane.showMessageDialog(frame, "Error Message\nPlease enter valid number!!", "ERROR", JOptionPane.ERROR_MESSAGE);
            
        }
    }
}
