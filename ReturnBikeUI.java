import java.awt.Container;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ReturnBikeUI implements ActionListener
{
    private JFrame frame;
    private JLabel lbl, Bikeid;
    private JTextField txtBikeid;
    private JButton clear,confirm;
    
    public ReturnBikeUI()
    {
        frame = new JFrame ("Everest Motors :Return Rent Bike");
        Container panel = frame.getContentPane();
        panel.setLayout(null);
        
        lbl = new JLabel ("Return Rent Bike");
        lbl.setBounds (120,10,200,50);
        lbl.setForeground(Color.blue);
        lbl.setFont(new Font("Times New Roman", Font.BOLD, 20));
        panel.add(lbl);
        
        Bikeid = new JLabel ("Bike Id");
        Bikeid.setBounds (10,80,100,25);
        panel.add(Bikeid);
        
        txtBikeid = new JTextField();
        txtBikeid.setBounds (120,80,120,25);
        panel.add(txtBikeid);
        
        
        clear = new JButton("Clear");
        clear.setBounds(120,120,90,25);
        panel.add(clear);
        clear.addActionListener(this);
        
        confirm = new JButton ("Confirm");
        confirm.setBounds(220,120,90,25);
        panel.add(confirm);
        confirm.addActionListener(this);
        
        frame.setSize(400,260);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
    public void actionPerformed (ActionEvent ae)
    {
        if (ae.getSource() == confirm)
        
        {
            try
            {
                String id = txtBikeid.getText();
                if (id != null && !id.equals(""))
                {
                    int index = Integer.parseInt(id);
                    if (index >0 && index <=BikeRentalUI.list.size())
                    {
                        try
                        {
                             BikeToRent obj = (BikeToRent)BikeRentalUI.list.get(index-1);
                            boolean ans = obj.getLoanStatus();
                            if (ans == true)
                            {
                                obj.FreeBike();
                                 JOptionPane.showMessageDialog(frame, "Bike was returned.");
                                txtBikeid.setText("");
                                
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(frame, "Bike is currently not on rent");
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
            catch (NumberFormatException e)
            {
                 JOptionPane.showMessageDialog(frame, "Error Message\nPlease enter valid number","ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (ae.getSource() == clear)
        {
            txtBikeid.setText("");
        }
    }
}
