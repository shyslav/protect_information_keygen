import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by vladyslavshyshkin on 05.11.16.
 */
public class KeyGenerator {
    private static final Gson gson = new GsonBuilder().create();

    public static void main(String[] args) {
        if(args == null || args.length == 0 || args[0].isEmpty() ||  args[1].isEmpty() ||  args[2].isEmpty()){
            System.out.println("INCORRECT INPUT VALUE");
            return;
        }
        String mysqlName = args[0];
        String mysqlPass = args[1];
        String databaseName = args[2];
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        }
        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/"+databaseName,mysqlName, mysqlPass);

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
        if (connection != null) {
            String query = "INSERT into license(computerData, computerDataMd) values(?,?)";
            try {
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1,generateComputerData());
                statement.setString(2,generateComputerDataMd5());
                statement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
                return;
            }
        } else {
            System.out.println("Failed to make connection!");
            return;
        }
        System.out.println("You can use your product");
    }

    /**
     * Generate computer data to md5
     *
     * @return md5 computer info with computer name + username + osname
     */
    private static String generateComputerDataMd5() {
        return LazyMD5.md5(LazyComputerInfo.getComputerName() + "..." + LazyComputerInfo.getUserName() + "..." + LazyComputerInfo.getOSName());
    }

    /**
     * Generate comuter data licence to json
     *
     * @return compute json data
     */
    private static String generateComputerData() {
        LicensedUser user = new LicensedUser(
                LazyComputerInfo.getComputerName(),
                LazyComputerInfo.getUserName(),
                LazyComputerInfo.getOSName(),
                LazyComputerInfo.getDriverInfo().get(0).getTotalSpace(),
                "09/25/2016",
                "12/25/2018"
        );
        return gson.toJson(user);
    }
}
