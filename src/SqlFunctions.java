public class SqlFunctions {
    public static void createUser (String username, String email, String password){
        String sql = "INSERT into users (username, email, password)VALUES ('"+username+"', '"+email+"', '"+password+"');";
    }
    public static void deleteUser (String username) {

    }
    public static int verifyUser (String username, String email, String password) {
        String sql = "SELECT id FROM users WHERE username = 'test'AND password = 'test'";

        return 0;
    }
}
