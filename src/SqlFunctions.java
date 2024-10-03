import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SqlFunctions {
    public static void createUser (String username, String email, String password){
        String passwordhash ="";
        try {
            //make a hash for the password with SHA-256 algorithm
            passwordhash = hashing.generateHash(password, "SHA-256");
            System.out.println("SHA-256 hash: " + passwordhash);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Fel: Algoritmen finns inte.");
        }
        Connection connection = DatabaseConnect.getConnection();
        if (connection == null) {
            System.out.println("Could not connect");
            System.exit(-1);
        }

        String sql = "INSERT into users (username, email, password)VALUES ('"+username+"', '"+email+"', '"+passwordhash+"')";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

        }catch (SQLException exception) {
            throw  new RuntimeException(exception);
        }
    }
    public static void deleteUser (String username, String email) {
        String sql = "DELETE FROM users WHERE username = '"+username+"' AND email = "+email+"'";
        Connection connection = DatabaseConnect.getConnection();
        if (connection == null) {
            System.out.println("Could not connect");
            System.exit(-1);
        }

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

        }catch (SQLException exception) {
            throw  new RuntimeException(exception);
        }
    }
    public static int verifyUser (String username, String email, String password) {
        String sql = "SELECT id FROM users WHERE username = '"+username+"'AND email = '"+email+"'";
        Connection connection = DatabaseConnect.getConnection();
        if (connection == null) {
            System.out.println("Could not connect");
            System.exit(-1);
        }
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            int value = resultSet.getInt("id");
            if (value>1) {
                return 1;
            }else {
                return 0;
            }

        }catch (SQLException exception) {
            throw  new RuntimeException(exception);
        }
    }
}
