//import packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Transactions {
    //set instance for scanner
    Scanner sc = new Scanner(System.in);

    //pass in current atm instance to access balance, pulling from savings and checkings
    public void getBalance(ATM atm){
        //refresh database by reconnecting it.
        Database cdb = new Database();
        cdb.connectDatabase(atm);
        String c = "Checkings: $" + cdb.getCheckings();
        String s = "Savings: $" + cdb.getSavings();
        float tot = cdb.getCheckings() + cdb.getSavings();
        String total = "Total Balance: $" + tot;
        System.out.println("---Your Balance---");
        System.out.println(c);
        System.out.println(s);
        System.out.println(total);
    }

    public void pullSavings(ATM atm) throws Exception {
        //refresh database by reconnecting it.
        Database cdb = new Database();
        cdb.connectDatabase(atm);
        System.out.println("You have $" + cdb.getSavings() + " in your saving account.");
        System.out.print("How much would you like to withdraw? $");
        float s_amount = sc.nextFloat();

        if (s_amount > cdb.getSavings()){
            System.out.println("\nInsufficient funds in account.");
        } else{
            String host = "jdbc:mysql://localhost:3306/mydb";
            String uName = "root";
            String uPass = "Helaman12:24";
            Connection con = DriverManager.getConnection(host, uName, uPass);

            float new_sav = cdb.getSavings() - s_amount;
            // create the java mysql update statement
            String querysav = "update customer set saving = ? where customer_id = ?";
            PreparedStatement preparedStmtsav = con.prepareStatement(querysav);
            preparedStmtsav.setFloat(1, new_sav);
            preparedStmtsav.setInt(2, cdb.getID());
            preparedStmtsav.executeUpdate();

            //refresh database by reconnecting it.
            Database cdb2 = new Database();
            cdb2.connectDatabase(atm);
            System.out.println("Your new saving balance is $" + cdb2.getSavings() + ".");
        }

    }

    public void pullCheckings(ATM atm) throws SQLException {
        //refresh database by reconnecting it.
        Database cdb = new Database();
        cdb.connectDatabase(atm);
        System.out.println("You have $" + cdb.getCheckings() + " in your checking account.");
        System.out.print("How much would you like to withdraw? $");
        float c_amount = sc.nextFloat();

        if (c_amount > cdb.getCheckings()) {
            System.out.println("\nInsufficient funds in account.");
        } else {
            String host = "jdbc:mysql://localhost:3306/mydb";
            String uName = "root";
            String uPass = "Helaman12:24";
            Connection con = DriverManager.getConnection(host, uName, uPass);

            float new_check = cdb.getCheckings() - c_amount;
            // create the java mysql update statement
            String querycheck = "update customer set checking = ? where customer_id = ?";
            PreparedStatement preparedStmtcheck = con.prepareStatement(querycheck);
            preparedStmtcheck.setFloat(1, new_check);
            preparedStmtcheck.setInt(2, cdb.getID());
            preparedStmtcheck.executeUpdate();

            //refresh database by reconnecting it.
            Database cdb2 = new Database();
            cdb2.connectDatabase(atm);
            System.out.println("Your new checking balance is $" + cdb2.getCheckings() + ".");
        }
    }
}
