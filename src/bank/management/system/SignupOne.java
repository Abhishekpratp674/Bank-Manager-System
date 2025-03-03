package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class SignupOne extends JFrame implements ActionListener{

    long random;
    JTextField nameTextfeild,FathersTextfeild,EmailTextfeild,AddressTextfeild,CityTextfeild,StateTextfeild,PincodeTextfeild;
    JButton next;
    JRadioButton male , female , other, married , unmarried;
    JDateChooser dateChooser;
    SignupOne(){

        setLayout(null);
        // its for page
        getContentPane().setBackground(Color.white);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000l) + 1000l);

        // its for form
        JLabel formno = new JLabel("APPLICATION NUMBER " + random);
        formno.setFont(new Font("Raleway",Font.BOLD,30));
        formno.setBounds(190,20,500,40);
        add(formno);

        JLabel personalDetails = new JLabel("page 1 : Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290,80,500,30);
        add(personalDetails);

        JLabel name = new JLabel("Name : ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        nameTextfeild = new JTextField();
        nameTextfeild.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextfeild.setBounds(300,140,400,30);
        add(nameTextfeild);


        JLabel FathersName = new JLabel("Fathers Name : ");
        FathersName.setFont(new Font("Raleway",Font.BOLD,20));
        FathersName.setBounds(100,190,200,30);
        add(FathersName);

        FathersTextfeild = new JTextField();
        FathersTextfeild.setFont(new Font("Raleway",Font.BOLD,14));
        FathersTextfeild.setBounds(300,190,400,30);
        add(FathersTextfeild);

        JLabel Dob = new JLabel("Date of Birth : ");
        Dob.setFont(new Font("Raleway",Font.BOLD,20));
        Dob.setBounds(100,240,200,30);
        add(Dob);
        //its a class and you need to import a jar file

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,200,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);

        JLabel Gender = new JLabel("Gender : ");
        Gender.setFont(new Font("Raleway",Font.BOLD,20));
        Gender.setBounds(100,290,200,30);
        add(Gender);

        //              it is for the radio button
        male = new JRadioButton("MALE");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("FEMALE");
        female.setBounds(450,290,100,30);
        female.setBackground(Color.white);
        add(female);
        //              for the selection of onlt one button at a time
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel Email = new JLabel("Email : ");
        Email.setFont(new Font("Raleway",Font.BOLD,20));
        Email.setBounds(100,340,200,30);
        add(Email);

        EmailTextfeild = new JTextField();
        EmailTextfeild.setFont(new Font("Raleway",Font.BOLD,14));
        EmailTextfeild.setBounds(300,340,400,30);
        add(EmailTextfeild);

        JLabel marital = new JLabel("Marital Status : ");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.white);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.white);
        add(unmarried);

        other = new JRadioButton("other");
        other.setBounds(630,390,100,30);
        other.setBackground(Color.white);
        add(other);
        //              for the selection of onlt one button at a time
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);

        JLabel address = new JLabel("Address : ");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

        AddressTextfeild = new JTextField();
        AddressTextfeild.setFont(new Font("Raleway",Font.BOLD,14));
        AddressTextfeild.setBounds(300,440,400,30);
        add(AddressTextfeild);

        JLabel city = new JLabel("City : ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        CityTextfeild = new JTextField();
        CityTextfeild.setFont(new Font("Raleway",Font.BOLD,14));
        CityTextfeild.setBounds(300,490,400,30);
        add(CityTextfeild);

        JLabel state = new JLabel("State : ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        StateTextfeild = new JTextField();
        StateTextfeild.setFont(new Font("Raleway",Font.BOLD,14));
        StateTextfeild.setBounds(300,540,400,30);
        add(StateTextfeild);

        JLabel pincode = new JLabel("Pin code : ");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        PincodeTextfeild = new JTextField();
        PincodeTextfeild.setFont(new Font("Raleway",Font.BOLD,14));
        PincodeTextfeild.setBounds(300,590,400,30);
        add(PincodeTextfeild);

        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);


    }
    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;
        String name = nameTextfeild.getText();
        String Fathersname = FathersTextfeild.getText();
        String Dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
        String email = EmailTextfeild.getText();
        String marital = null;
        if (married.isSelected()) {
            marital = "married";
        } else if (unmarried.isSelected()) {
            marital = "unmarried";
        } else if (other.isSelected()) {
            marital = "other";
        }
        String address = AddressTextfeild.getText();
        String city = CityTextfeild.getText();
        String state = StateTextfeild.getText();
        String pin = PincodeTextfeild.getText();

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null,"Name is Required");
            } else if (Fathersname.equals("")) {
                JOptionPane.showMessageDialog(null,"Father's name Required");
            }  else if (email.equals("")) {
                JOptionPane.showMessageDialog(null,"Email is Required");
            } else if (AddressTextfeild.equals("")) {
                JOptionPane.showMessageDialog(null,"Address is Required");
            }else if (CityTextfeild.equals("")) {
                JOptionPane.showMessageDialog(null,"City name is Required");
            }else if (StateTextfeild.equals("")) {
                JOptionPane.showMessageDialog(null,"State name is Required");
            }else if (PincodeTextfeild.equals("")) {
                JOptionPane.showMessageDialog(null,"pincode is Required");
            }
            else {
                conn c = new conn();
                String query = "INSERT INTO signup (formno, name, father_name, dob, gender, email, marital_status, address, city, pincode, state) VALUES ('"
                        + formno + "', '"
                        + name + "', '"
                        + Fathersname + "', '"
                        + Dob + "', '"
                        + gender + "', '"
                        + email + "', '"
                        + marital + "', '"
                        + address + "', '"
                        + city + "', '"
                        + pin + "', '"
                        + state + "')";
                c.s.executeUpdate(query);

               // it is because when the user fill all the details sucessfully the current frame needs to be close and the next frame
               //which is SignupTwo page needs to be open.
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {


        new SignupOne();
    }
}
