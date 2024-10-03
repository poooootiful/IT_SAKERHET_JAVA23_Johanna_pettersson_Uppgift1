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

        System.out.println("Email:");
        Scanner email = new Scanner(System.in);
        String e = email.nextLine();

        System.out.println("Password:");
        Scanner password = new Scanner(System.in);
        String pass = password.nextLine();

        if (user !=null) {
            int value = Login(user,e,pass);
            if (value == 1) {
                Menu(user,e,pass);
            }else if (value == 0) {
                System.out.println("Login Failed try again");
                System.out.println("Username:");
                String user1 = username.nextLine();
                System.out.println("Email:");
                String e1 = email.nextLine();
                System.out.println("Password:");
                String pass1 = password.nextLine();
                int value2 = Login(user,e1,pass);
                if (value2 == 1) {
                Menu(user1,e1,pass1);
                }else {

                }
            }
        }
    }
    public static void Menu (String username ,String email, String password) {
        System.out.println("1.Account info");
        System.out.println("2.Delete Account");
        System.out.println("3.Logout & Exit");

        Scanner number = new Scanner(System.in);
        String value = number.nextLine();

        if (value.matches("1")) {
            ShowAccount(username,email,password);
        }else if (value.matches("2")) {
            DeleteAccount(username, email,password);
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
        System.out.println("Add a email:");
        Scanner email = new Scanner(System.in);
        String e = email.nextLine();
        Menu(user,e,pass);

    }
    public static void ShowAccount (String username,String email, String password) {
        System.out.println("Your username is: "+username);
        System.out.println("Your password is: "+password);
        System.out.println("Press 1 to go back to previous");
        Scanner move = new Scanner(System.in);
        String moving = move.nextLine();
        if (moving.matches("1")) {
            Menu(username,email, password);
        }
    }

    public static void DeleteAccount (String username,String email, String password) {
        System.out.println("Press 1 if you want to delete account with username "+username+" and email "+email);
        System.out.println("Press 2 to go back to previous");
        Scanner input = new Scanner(System.in);
        String number = input.nextLine();
        if (number.matches("1")) {
            Delete(username,email);
        }else if (number.matches("2")){
            Menu(username,email,password);
        }else {
            System.out.println("You pressed the wrong number");
        }
    }
    public static int Login (String username,String email, String password) {
        SqlFunctions.verifyUser(username,email, password);
        return 1;
    }
    public static void Delete (String username,String email) {
        SqlFunctions.deleteUser(username,email);
        System.out.println("Account deleted exiting app");

    }
}