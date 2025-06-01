
package bank.management.system;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Fastcash extends JFrame implements ActionListener {

    JButton deposit, withdrawl, fastcash, ministatement, pinchange, balanceenquiry, exit;
    String pinnumber;
    
    Fastcash(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,850,750);
        add(image);
        
        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setBounds(210, 230, 700, 30);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        deposit = new JButton("Rs 100");
        deposit.setBounds(160, 343, 150, 28);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(325, 343, 150, 28);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(160, 377, 150, 28);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Rs 2000");
        ministatement.setBounds(325, 377, 150, 28);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(160, 411, 150, 28);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry = new JButton("Rs 10000");
        balanceenquiry.setBounds(325, 411, 150, 28);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        exit = new JButton("Back");
        exit.setBounds(325, 443, 150, 28);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(850,750);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn conn = new Conn();
            try {
                ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amount + " Withdrawled Successfully.");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                        
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    } 
        
    public static void main(String[] args) {
        new Fastcash("");
    }
}
