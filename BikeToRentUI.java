import java.awt.Container;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BikeToRentUI implements ActionListener
{
    private JFrame frame;
    private JLabel lbl,Bikeid, Description, DailyRate, Company;
    private JTextField txtBike, txtDescription, txtDaily, txtCompany;
    private JButton clear, confirm;
    int count = 1;
    public BikeToRentUI()
    {
        frame = new JFrame ("Everest Motors : Add Rent Bike");
        Container panel = frame.getContentPane();
        panel.setLayout(null);
        
        lbl = new JLabel ("Add Bike To Rent");
        lbl.setBounds (190,10,200,50);
        lbl.setForeground(Color.blue);
        lbl.setFont(new Font("Times New Roman", Font.BOLD, 20));
        panel.add(lbl);
        
        Bikeid = new JLabel ("Bike Id");
        Bikeid.setBounds (10,80,100,25);
        panel.add(Bikeid);
        
        txtBike = new JTextField();
        txtBike.setBounds (120,80,120,25);
        txtBike.setEnabled(false);
        txtBike.setText(Integer.toString(BikeRentalUI.count));
        panel.add(txtBike);
        
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
        
        DailyRate = new JLabel ("DailyRate");
        DailyRate.setBounds (10,140,100,25);
        panel.add(DailyRate);
        
        txtDaily = new JTextField();
        txtDaily.setBounds (120,140,120,25);
        panel.add(txtDaily);
        
        clear = new JButton ("Clear");
        clear.setBounds(290,170,90,25);
        panel.add(clear);
        clear.addActionListener(this);
        
        confirm = new JButton ("Confirm");
        confirm.setBounds(390,170,90,25);
        panel.add(confirm);
        confirm.addActionListener(this);
        
        frame.setSize(600,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            if (ae.getSource() == confirm)
            {
                int intDailyrate = 0;
                String Bike = txtBike.getText();
                count =Integer.parseInt(Bike);
                String description = txtDescription.getText(); 
                String company = txtCompany.getText();
                String dailyrate = txtDaily.getText();
                intDailyrate = Integer.parseInt(dailyrate);
                if(description !=null && !description.equals(""))
                {
                    BikeToRent btr = new BikeToRent(description,company,intDailyrate);
                    BikeRentalUI.list.add(btr);
                    count =BikeRentalUI.list.size() + 1;
                    txtBike.setText(Integer.toString(count));
                    txtDescription.setText("");
                    txtCompany.setText("");
                    txtDaily.setText("");
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
                txtDaily.setText("");
                
            }
        }
        catch(NumberFormatException e)
        {
             
             JOptionPane.showMessageDialog(frame, "Error Message\nPlease enter valid number!!", "ERROR", JOptionPane.ERROR_MESSAGE);
            
            }
    }
}
