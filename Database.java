//import packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

    private String firstName;
    private String lastName;
    private int customerID;
    private int customerPIN;
    private double savingAccount;
    private double checkingAccount;

    //member variables for current user
    private String userFirstName;
    private String userLastName;
    private int userCustomerID;
    private int userCustomerPIN;
    private double userSavingAccount;
    private double userCheckingAccount;


    public void connectDatabase(ATM atm){

        try {
            //establish connection
            String host = "jdbc:mysql://localhost:3306/mydb";
            String uName = "root";
            String uPass = "Helaman12:24";
            Connection con = DriverManager.getConnection(host, uName, uPass);

            //run query
            Statement stat = con.createStatement();
            String sql = "select c.pin, p.first_name, p.last_name, c.customer_id, c.checking, c.saving " +
                    "from customer c inner join  person p " +
                    "on p.customer_customer_id = c.customer_id;";
            ResultSet rs = stat.executeQuery(sql);

            // loop through rows, sorting into columns
            while ( rs.next()) {
                this.firstName = rs.getString("first_name");
                this.lastName = rs.getString("last_name");
                this.customerID = rs.getInt("customer_id");
                this.customerPIN = rs.getInt("pin");
                this.savingAccount = rs.getFloat("saving");
                this.checkingAccount = rs.getFloat("checking");

                // check if current row holds our id/pin
                if(this.customerID == atm.getID() & this.customerPIN == atm.getPIN()) {
                    this.userCustomerID = customerID;
                    this.userCustomerPIN = customerPIN;
                    this.userCheckingAccount = Math.round(checkingAccount * 100.0) / 100.0;
                    this.userSavingAccount = Math.round(savingAccount * 100.0) / 100.0;
                    this.userFirstName = firstName;
                    this.userLastName = lastName;
                }

            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

    }

    public String getFirstName(){
        return this.userFirstName;
    }

    public String getLastName(){
        return this.userLastName;
    }

    public int getID(){
        return this.userCustomerID;
    }

    public int getPIN(){
        return this.userCustomerPIN;
    }

    public double getSavings(){
        return this.userSavingAccount;
    }

    public double getCheckings(){
        return this.userCheckingAccount;
    }


}
