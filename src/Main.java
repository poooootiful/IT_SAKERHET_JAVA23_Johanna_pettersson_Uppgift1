import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("1.Login");
        System.out.println("2.Create Account");
        System.out.println("3.Exit");
        Scanner number = new Scanner(System.in);
        String value = number.nextLine();
        if (value.matches("1")) {
            LoginMenu();
        }else if (value.matches("2")) {
            CreateAccount();
        }else if (value.matches("3")){

        }
    }
    public static void LoginMenu () {
        System.out.println("Username:");
        Scanner username = new Scanner(System.in);
        String user = username.nextLine();
        System.out.println("Password:");
        Scanner password = new Scanner(System.in);
        String pass = password.nextLine();
        if (user !=null) {
            int value = Login(user,pass);
            if (value == 1) {
                Menu(user,pass);
            }else if (value == 0) {
                System.out.println("Login Failed try again");
                System.out.println("Username:");
                String user1 = username.nextLine();
                System.out.println("Password:");
                String pass1 = password.nextLine();
                int value2 = Login(user,pass);
                if (value2 == 1) {
                Menu(user1,pass1);
                }else {

                }
            }
        }
    }
    public static void Menu (String username, String password) {
        System.out.println("1.Account info");
        System.out.println("2.Delete Account");
        System.out.println("3.Logout & Exit");

        Scanner number = new Scanner(System.in);
        String value = number.nextLine();

        if (value.matches("1")) {
            ShowAccount(username,password);
        }else if (value.matches("2")) {
            DeleteAccount(username,password);
        }else if (value.matches("3")){

        }

    }
    public static void CreateAccount () {
        System.out.println("Make a Username:");
        Scanner username = new Scanner(System.in);
        String user = username.nextLine();
        System.out.println("Make a Password:");
        Scanner password = new Scanner(System.in);
        String pass = password.nextLine();
        Menu(user,pass);

    }
    public static void ShowAccount (String username, String password) {
        System.out.println("Your username is: "+username);
        System.out.println("Your password is: "+password);
        System.out.println("Press 1 to go back to previous");
        Scanner move = new Scanner(System.in);
        String moving = move.nextLine();
        if (moving.matches("1")) {
            Menu(username, password);
        }
    }

    public static void DeleteAccount (String username, String password) {
        System.out.println("Press 1 if you want to delete account with username "+username+" and password "+password);
        System.out.println("Press 2 to go back to previous");
        Scanner input = new Scanner(System.in);
        String number = input.nextLine();
        if (number.matches("1")) {
            Delete(username,password);
        }else if (number.matches("2")){
            Menu(username,password);
        }else {
            System.out.println("You pressed the wrong number");
        }
    }
    public static int Login (String username, String password) {
        SqlFunctions.verifyUser(username,password);
        return 1;
    }
    public static void Delete (String username, String password) {


        System.out.println("Account deleted exiting app");

    }
}