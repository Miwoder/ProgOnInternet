package pack;

import java.sql.*;
public class JdbcConnection {
    public static Connection getConnection(){
        try {
            String host = "192.168.43.28";
            int port = 1521;
            String sid  = "orcl";
            String user = "C##GVA";
            String pwd  = "root";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = String.format("jdbc:oracle:thin:@%s:%d:%s", host, port, sid);
            Connection connection = DriverManager.getConnection(url, user, pwd);
            System.out.println("Connected to DB");
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
