// import packages
import java.util.Scanner;

public class ATM {

    private int ID;
    private int PIN;

    // set instances
    Scanner sc= new Scanner(System.in);

    Transactions tran = new Transactions();

    public int getID(){
        return this.ID;
    }

    public int getPIN(){
        return this.PIN;
    }

    public void accessAccount() throws Exception{
        // get id and pin
        System.out.print("Enter your ID: ");
        this.ID = sc.nextInt();
        System.out.print("Enter your PIN: ");
        this.PIN = sc.nextInt();

        // connect to database, feed in member variables
        Database cdb = new Database();
        cdb.connectDatabase(this);

        boolean exit = false;

        if (cdb.getID() == this.ID & cdb.getPIN() == this.PIN & exit == false) {
            System.out.println("\nWelcome " + cdb.getFirstName() + "!");
            System.out.println("What would you like to do today?");
        }
        while (cdb.getID() == this.ID & cdb.getPIN() == this.PIN & exit == false) {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Withdraw from Checkings");
            System.out.println("3. Withdraw from Savings");
            System.out.println("4. Sign out");
            System.out.print("Select: ");
            int choice = sc.nextInt();
            System.out.println();

            if (choice == 1) {
                tran.getBalance(this);
            } else if (choice == 2) {
                tran.pullCheckings(this);
            } else if (choice == 3) {
                tran.pullSavings(this);
            } else if (choice == 4) {
                exit = true;
            } else {
                System.out.println("Please choose a valid option.");
            }
        } if (cdb.getID() != this.ID & cdb.getPIN() != this.PIN) {
            System.out.println("\nCustomer ID and PIN doesn't match. Please try again.\n");
        }

    }

    // main function
    public static void main(String[] args) throws Exception {
        // Welcome, introduce atm -- log in or exit
        System.out.println("\nWelcome to the ATM\n");
        // Start a while loop with a menu that'll give them the option to:
        boolean exit = false;
        while (exit == false) {
            Scanner sc= new Scanner(System.in);
            System.out.println("1. Sign in");
            System.out.println("2. Exit");
            System.out.print("Select: ");
            int choice = sc.nextInt();
            System.out.println();

            if (choice == 1) {
                // -- log in
                //establish current account instance
                ATM myAccount = new ATM();
                myAccount.accessAccount();
                // if wrong, reject and go back to main menu
            } else if (choice == 2){
                // -- quit
                exit = true;
            }  else{
                System.out.println("...\n");
                System.out.println("Please choose a valid option\n");
            }

        }

        System.out.println("Goodbye...");
    }

}

