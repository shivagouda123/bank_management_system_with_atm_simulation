package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
    
    
    JTextField pan, aadhar;
    JRadioButton scyes, scno, eayes, eano;
    JButton next;
    JComboBox religion, category, income, occupation, education;
    String formno;
    
    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 70, 400, 30);
        add(additionalDetails);
        
        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 120, 100, 30);
        add(name);
        
        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Jain", "Christian", "Others"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 120, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 170, 200, 30);
        add(fname);
        
        String valCategory[] = {"General", "OBC", "SC", "ST", "Others"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 170, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);
        
        
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 220, 200, 30);
        add(dob);
        
        String incomeCategory[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300, 220, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        
        
        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 270, 200, 30);
        add(gender);

        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 300, 200, 30);
        add(email);

        String educationValues[] = {"Non-Graduation", "Graduate", "Post-Graduation", "Doctrate", "Others"};
        education = new JComboBox(educationValues);
        education.setBounds(300, 300, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);
        
        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 350, 200, 30);
        add(marital);

        String occupationValues[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300, 350, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        JLabel address = new JLabel("PAN Number:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 400, 200, 30);
        add(address);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 400, 400, 30);
        add(pan);
        
        JLabel city = new JLabel("Aadhar Number:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 450, 200, 30);
        add(city);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 450, 400, 30);
        add(aadhar);
        
        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 500, 200, 30);
        add(state);
        
        scyes = new JRadioButton("Yes");
        scyes.setBounds(300, 500, 60, 30);
        scyes.setBackground(Color.WHITE);
        add(scyes);
        
        scno = new JRadioButton("No");
        scno.setBounds(450, 500, 120, 30);
        scno.setBackground(Color.WHITE);
        add(scno);
        
        ButtonGroup seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(scyes);
        seniorCitizenGroup.add(scno);
        
        JLabel pincode = new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 550, 200, 30);
        add(pincode);
        
        eayes = new JRadioButton("Yes");
        eayes.setBounds(300, 550, 60, 30);
        eayes.setBackground(Color.WHITE);
        add(eayes);
        
        eano = new JRadioButton("No");
        eano.setBounds(450, 550, 120, 30);
        eano.setBackground(Color.WHITE);
        add(eano);
        
        ButtonGroup existingAccountGroup = new ButtonGroup();
        existingAccountGroup.add(eayes);
        existingAccountGroup.add(eano);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 600, 80, 30);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 720);
        setVisible(true);
        setLocation(300, 1);
    }
    
    public void actionPerformed(ActionEvent ae) {
//        String formno = "" + randno;
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String span = pan.getText();
        String saadhar = aadhar.getText();
    
        String seniorCitizen = null;
        if (scyes.isSelected()) {
            seniorCitizen = "Yes";
        } else if(scno.isSelected()) {
            seniorCitizen = "No";
        }
        
        
        String existingAccount = null;
        if (eayes.isSelected()) {
            existingAccount = "Yes";
        } else if(eano.isSelected()) {
            existingAccount = "No";
        }
        
        
        try {
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+seniorCitizen+"', '"+existingAccount+"')";
            c.s.executeUpdate(query);
            
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public static void main(String[] args) {
        new SignupTwo("");
    }
}
