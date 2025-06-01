
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit, withdrawl, fastcash, ministatement, pinchange, balanceenquiry, exit;
    String pinnumber;
    
    Transactions(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,850,750);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(210, 230, 700, 30);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(160, 343, 150, 28);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(325, 343, 150, 28);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(160, 377, 150, 28);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(325, 377, 150, 28);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(160, 411, 150, 28);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(325, 411, 150, 28);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        exit = new JButton("Exit");
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
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource() == withdrawl) {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if (ae.getSource() == fastcash) {
            setVisible(false);
            new Fastcash(pinnumber).setVisible(true);
        } else if (ae.getSource() == pinchange) {
            setVisible(false);
            new Pinchange(pinnumber).setVisible(true);
        } else if (ae.getSource() == ministatement) {
            new MiniStatement(pinnumber).setVisible(true);
        } else if (ae.getSource() == balanceenquiry) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Transactions("");
    }
}
