
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionProvider {

    public Connection ConnectionProvider() {
        Connection conn = null;
      
            try {
           
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student_record", "root", "");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
       
        return conn;
    }
}
