
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pinchange extends JFrame implements ActionListener {
    
    JPasswordField pin, repin;
    JButton change, back;
    String pinnumber;
    
    Pinchange(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,850,750);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setBounds(240, 250, 500, 30);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        JLabel pintext = new JLabel("NEW PIN");
        pintext.setForeground(Color.WHITE);
        pintext.setBounds(160, 340, 180, 25);
        pintext.setFont(new Font("System", Font.BOLD, 14));
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setBounds(300, 340, 180, 25);
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(pin);
        
        JLabel repintext = new JLabel("RE-ENTER NEW PIN");
        repintext.setForeground(Color.WHITE);
        repintext.setBounds(160, 370, 180, 25);
        repintext.setFont(new Font("System", Font.BOLD, 14));
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setBounds(300, 370, 180, 25);
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(330, 405, 150, 28);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(330, 440, 150, 28);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(850, 750);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String npin = pin.getText();
                String rpin = repin.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match.");
                    return;
                }
                
                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }
                
                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                }
                
                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String query2 = "update login set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'";
                String query3 = "update signupthree set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'";
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                
                setVisible(false);
                new Transactions(rpin).setVisible(true);
 
            } catch(Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Pinchange("").setVisible(true);
    }
}
