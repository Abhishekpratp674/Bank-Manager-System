package bank.management.system;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SignupTwo extends JFrame implements ActionListener {


    JTextField aadhar, pan;
    JButton next;
    JRadioButton syes, sno, eyes, eno, unmarried;
    // it is for the connetion of the one and two signup page connectivity
    String formno;


    JComboBox religion, category, income, occupation, education;


    SignupTwo(String formno) {
        this.formno = formno;

        setLayout(null);
        // its for page
        getContentPane().setBackground(Color.white);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        setTitle("NEW ACCOUNCT APPLICATION - PAGE 2");


        JLabel additionalDetails = new JLabel("page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 500, 30);
        add(additionalDetails);

        JLabel name = new JLabel("Religion : ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        //jcomBox is used to create the  option menu in the box
        String valRelegion[] = {"Hindu", "Muslim", "Sikh", "Christan", "Other"};
        religion = new JComboBox(valRelegion);
        religion.setBackground(Color.WHITE);
        religion.setBounds(300, 140, 400, 30);
        add(religion);


        JLabel FathersName = new JLabel("Category : ");
        FathersName.setFont(new Font("Raleway", Font.BOLD, 20));
        FathersName.setBounds(100, 190, 200, 30);
        add(FathersName);

        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox(valCategory);
        category.setBackground(Color.WHITE);
        category.setBounds(300, 190, 400, 30);
        add(category);

        JLabel Dob = new JLabel("Income : ");
        Dob.setFont(new Font("Raleway", Font.BOLD, 20));
        Dob.setBounds(100, 240, 200, 30);
        add(Dob);
        //its a class and you need to import a jar file

        String incomecategory[] = {"Null", "<1.5L", "<2.5L", "<5L", "UPTO 10L"};
        income = new JComboBox(incomecategory);
        income.setBackground(Color.WHITE);
        income.setBounds(300, 240, 400, 30);
        add(income);


        JLabel Gender = new JLabel("Eductaional ");
        Gender.setFont(new Font("Raleway", Font.BOLD, 20));
        Gender.setBounds(100, 290, 200, 30);
        add(Gender);


        JLabel Email = new JLabel("Qualification : ");
        Email.setFont(new Font("Raleway", Font.BOLD, 20));
        Email.setBounds(100, 315, 200, 30);
        add(Email);

        String educationvalues[] = {"Non - Graduate", "Graduate", "Post-Graduate", "Doctrate", "others"};
        education = new JComboBox(educationvalues);
        education.setBackground(Color.WHITE);
        education.setBounds(300, 315, 400, 30);
        add(education);


        JLabel marital = new JLabel("Occupation : ");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        String occupationValues[] = {"Salaried", "Self Employed", "Bussiness", "Student", "Retiered"};
        occupation = new JComboBox(occupationValues);
        occupation.setBackground(Color.WHITE);
        occupation.setBounds(300, 390, 400, 30);
        add(occupation);


        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.white);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.white);
        add(sno);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(syes);
        maritalGroup.add(sno);

        JLabel address = new JLabel("PAN NUMBER : ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);

        JLabel addressS = new JLabel("Aadhar Number: ");
        addressS.setFont(new Font("Raleway", Font.BOLD, 20));
        addressS.setBounds(100, 490, 200, 30);
        add(addressS);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);

        JLabel state = new JLabel("Senior citizen: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        JLabel pincode = new JLabel("Existing account : ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);


        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.white);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.white);
        add(eno);

        ButtonGroup emaritalGroup = new ButtonGroup();
        emaritalGroup.add(eyes);
        emaritalGroup.add(eno);


        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);


    }

    public void actionPerformed(ActionEvent ae) {
//       m
//        getSelectedItem();this is used to pull the values from dropboxes
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();

        String seniorcitizen = null;
        if (syes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }
        String existingaccount = null;
        if (eyes.isSelected()) {
            existingaccount = "Yes";
        } else if (eno.isSelected()) {
            existingaccount = "No";
        }
        String span = pan.getText();
        String saadhar = aadhar.getText();

        if (saadhar == null) {

        }
        try {
            Conn c = new Conn();

            String query = "INSERT INTO signuptwo (formo, religion, category, income, education, occupation, pan, aadhar, seniorcitizen, existingAccount) VALUES ('"
                    + formno + "', '"  // Use formno properly
                    + sreligion + "', '"
                    + scategory + "', '"
                    + sincome + "', '"
                    + seducation + "', '"
                    + soccupation + "', '"
                    + span + "', '"
                    + saadhar + "', '"
                    + seniorcitizen + "', '"
                    + existingaccount + "')";

            c.s.executeUpdate(query);

            //Signup3 object
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
