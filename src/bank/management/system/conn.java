package bank.management.system;
import java.sql.*;
                // we use (jdbc connection) for the connection of data base with the java
                //it is very impotant in  terms of java interview

                                //it follows 5 steps -
    /*
                    1 - register the driver
                    2-create connection
                    3 - create statement
                    4 - Execute query
                    5 - close connection
     */

//we simply make this class as a object and we use it

public class conn {

    Connection c;
    Statement s;
                // since we are connecting the databse so the chances is hight to get the errors
                // WE HAVE TO DO EXCEPTIONAL HANDLING
    public conn(){
        try {
            // 1 - here we are rigestering the diver
            c = DriverManager.getConnection("jdbc:mysql:///BankManagementSystem" ,"root","Abhishek@12");
            s = c.createStatement();
        }catch (Exception e){
            System.out.println(e);  // the error will print
        }
    }

}
