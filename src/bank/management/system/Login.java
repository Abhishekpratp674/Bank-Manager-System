package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// swing is basically use to create desktop based application
public class Login extends JFrame implements ActionListener {

//    we make the jbutton gloabal so that we can use it outside the constructor as well.
    JButton login,clear,signup;
    JTextField cardText;
    JPasswordField cardpin;


    Login() {
//        it basically defines the frame size
//        when you gave setvisible true it becames visible.
        setSize(800, 500);
        setVisible(true);
        setLocation(400, 250);
//                       IT BASICALLY SET THE TITTLE OF THE FRAME
        setTitle("AUTOMATED TELLER MACHIENE");

//                      to atteach the image into the frame imageicon is being used in this
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logouse.jpg"));

        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
//                      you can't put an icon into the frame so jlabel is being is used
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
//                       JLabel is majorly used to create the text file.
        JLabel text = new JLabel(" WELCOME TO HDFC BANK ");
//                      you have to give it the bounds to the text custumly because you set it to the null form the autoswing
        text.setBounds(200,40,600,40);
//                      to set the font and the type
        text.setFont(new Font("Oswald", Font.BOLD, 38));
        add(text);

//                      for the card number box


        JLabel card_number = new JLabel("CARD NUMBER: ");
        card_number.setFont(new Font("Raleway", Font.BOLD, 28));
        card_number.setBounds(120,150,300,40);
        add(card_number);

//        this JtextFeild is used to create the Fillerbox

        cardText = new JTextField();
        cardText.setBounds(400,150,250,40);
        cardText.setFont(new Font("Arial", Font.BOLD, 20));
        add(cardText);

        //                      for the card pin box


        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120,220,200,40);
        add(pin);

        cardpin = new JPasswordField();
        cardpin.setBounds(400,220,250,40);
        cardpin.setFont(new Font("Arial", Font.BOLD, 20));
        add(cardpin);

//                      for the sign in button

        login = new JButton("SIGN IN");
        login.setBounds(400,300,100,40);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

//                      for the clear button
        clear = new JButton("Clear");
        clear.setBounds(550,300,100,40);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

//                  for the signup button
        signup = new JButton("SIGN UP");
        signup.setBounds(400,350,250,40);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);


//                       to put this custom layout you have set the layout to " null " so that swing will not put its default layout to centralised it.
        setLayout(null);
//                       it is used to get the backgroud colour according to yourself.
        getContentPane().setBackground(Color.white);
        add(label);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            // IT COMES IN ACTION WHEN YOU TAP ON THE CLEAR CUTTON UT BECOMES EMPLTY BEACUSE OF ("")
           cardText.setText("");
           cardpin.setText("");
        }
        else if (ae.getSource() == login) {
            // Login logic
            System.out.println("Login button clicked");
        }
        else if (ae.getSource() == signup) {
            // Signup logic
            System.out.println("Signup button clicked");
            setVisible(false);
            new SignupOne().setVisible(true);
        }

    }
    public static void main(String[] args) {
        new Login();
        
    }

}
