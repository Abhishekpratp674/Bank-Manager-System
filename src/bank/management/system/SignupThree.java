package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {
    JRadioButton saving, fixed, current, recurring;
    JCheckBox atm, internet, mobile, email, cheque, estatement, declaration;
    JButton submit, cancel;
    String formno;

    // Constructor
    SignupThree(String formno) {
        this.formno = formno;
        setLayout(null);

        JLabel label = new JLabel("Page 3: Account Details");
        label.setFont(new Font("Raleway", Font.BOLD, 22));
        label.setBounds(280, 40, 400, 40);
        add(label);

        JLabel accType = new JLabel("Account Type:");
        accType.setFont(new Font("Raleway", Font.BOLD, 18));
        accType.setBounds(100, 100, 200, 30);
        add(accType);

        saving = new JRadioButton("Saving Account");
        saving.setFont(new Font("Raleway", Font.PLAIN, 16));
        saving.setBackground(Color.WHITE);
        saving.setBounds(100, 140, 200, 30);
        add(saving);

        fixed = new JRadioButton("Fixed Deposit Account");
        fixed.setFont(new Font("Raleway", Font.PLAIN, 16));
        fixed.setBackground(Color.WHITE);
        fixed.setBounds(350, 140, 250, 30);
        add(fixed);

        current = new JRadioButton("Current Account");
        current.setFont(new Font("Raleway", Font.PLAIN, 16));
        current.setBackground(Color.WHITE);
        current.setBounds(100, 180, 200, 30);
        add(current);

        recurring = new JRadioButton("Recurring Deposit Account");
        recurring.setFont(new Font("Raleway", Font.PLAIN, 16));
        recurring.setBackground(Color.WHITE);
        recurring.setBounds(350, 180, 250, 30);
        add(recurring);

        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(saving);
        accountGroup.add(fixed);
        accountGroup.add(current);
        accountGroup.add(recurring);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 18));
        services.setBounds(100, 230, 200, 30);
        add(services);

        atm = new JCheckBox("ATM Card");
        atm.setFont(new Font("Raleway", Font.PLAIN, 16));
        atm.setBackground(Color.WHITE);
        atm.setBounds(100, 270, 200, 30);
        add(atm);

        internet = new JCheckBox("Internet Banking");
        internet.setFont(new Font("Raleway", Font.PLAIN, 16));
        internet.setBackground(Color.WHITE);
        internet.setBounds(350, 270, 200, 30);
        add(internet);

        mobile = new JCheckBox("Mobile Banking");
        mobile.setFont(new Font("Raleway", Font.PLAIN, 16));
        mobile.setBackground(Color.WHITE);
        mobile.setBounds(100, 310, 200, 30);
        add(mobile);

        email = new JCheckBox("Email & SMS Alerts");
        email.setFont(new Font("Raleway", Font.PLAIN, 16));
        email.setBackground(Color.WHITE);
        email.setBounds(350, 310, 200, 30);
        add(email);

        cheque = new JCheckBox("Cheque Book");
        cheque.setFont(new Font("Raleway", Font.PLAIN, 16));
        cheque.setBackground(Color.WHITE);
        cheque.setBounds(100, 350, 200, 30);
        add(cheque);

        estatement = new JCheckBox("E-Statement");
        estatement.setFont(new Font("Raleway", Font.PLAIN, 16));
        estatement.setBackground(Color.WHITE);
        estatement.setBounds(350, 350, 200, 30);
        add(estatement);

        declaration = new JCheckBox("I hereby declare that the above details are correct to the best of my knowledge.");
        declaration.setFont(new Font("Raleway", Font.PLAIN, 14));
        declaration.setBackground(Color.WHITE);
        declaration.setBounds(100, 400, 600, 30);
        add(declaration);

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 16));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250, 450, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 16));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(400, 450, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);
        setSize(800, 600);
        setLocation(350, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String accountType = null;
            if (saving.isSelected()) accountType = "Saving Account";
            else if (fixed.isSelected()) accountType = "Fixed Deposit Account";
            else if (current.isSelected()) accountType = "Current Account";
            else if (recurring.isSelected()) accountType = "Recurring Deposit Account";

            if (accountType == null) {
                JOptionPane.showMessageDialog(null, "Please select an account type.");
                return;
            }

            // Generate a 16-digit Card Number
            Random ran = new Random();
            long firstPart = (long) (Math.random() * 9000000000L) + 5040936000000000L;
            String cardno = Long.toString(firstPart);

            // Generate a 4-digit PIN
            String pin = String.format("%04d", ran.nextInt(10000));

            // Collect selected services
            StringBuilder facilities = getStringBuilder();

            if (!declaration.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please agree to the declaration.");
                return;
            }

            // Insert into database
            try {
                Conn conn = new Conn();
                String query1 = "instert into signup3 (formno, accountType, cardno, pin, facilities) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.c.prepareStatement(query1);
                pstmt.setString(1, formno);
                pstmt.setString(2, accountType);
                pstmt.setString(3, cardno);
                pstmt.setString(4, pin);
                pstmt.setString(5, facilities.toString());

                pstmt.executeUpdate();

                String query2 = "INSERT INTO login (formno, cardno, pin) VALUES (?, ?, ?)";
                PreparedStatement pstmt2 = conn.c.prepareStatement(query2);
                pstmt2.setString(1, formno);
                pstmt2.setString(2, cardno);
                pstmt2.setString(3, pin);

                pstmt2.executeUpdate();

                JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\nPIN: " + pin);
                setVisible(false);
                    new SignupThree(formno).setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        } else if (e.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    private StringBuilder getStringBuilder() {
        StringBuilder facilities = new StringBuilder();
        if (atm.isSelected()) facilities.append("ATM Card, ");
        if (internet.isSelected()) facilities.append("Internet Banking, ");
        if (mobile.isSelected()) facilities.append("Mobile Banking, ");
        if (email.isSelected()) facilities.append("Email & SMS Alerts, ");
        if (cheque.isSelected()) facilities.append("Cheque Book, ");
        if (estatement.isSelected()) facilities.append("E-Statement");

        if (facilities.isEmpty()) {
            facilities.setLength(facilities.length() - 2); // Remove last comma
        }
        return facilities;
    }
    public static void main(String[] args) {
        new SignupTwo("");
    }
}
