package Model;
import pack.JdbcConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Commentarii {
    private int Com_ID;
    private int Link_ID;
    private String author;
    private String comtext;
    private String stamp;

    public int getCom_ID() {
        return this.Com_ID;
    }

    public Commentarii(int id, int LinkId, String author, String date, String comment) {
        this.Com_ID = id;
        this.comtext = comment;
        this.Link_ID = LinkId;
        this.stamp = date;
        this.author = author;
    }

    public static Boolean existCookieName(String name, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Cookie[] var3 = cookies;
        int var4 = cookies.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            Cookie cookie = var3[var5];
            if (cookie.getName() == "UserName" && cookie.getValue() == name) {
                return true;
            }
        }

        return false;
    }

    public String getComtext() {
        return this.comtext;
    }

    public String getStamp() {
        return this.stamp;
    }

    public String getAuthor() {
        return this.author;
    }

    public static ArrayList<Model.Commentarii> getCommentsFromDb(int LinkId) throws SQLException, ClassNotFoundException {
        ArrayList<Model.Commentarii> resultSet = new ArrayList();
        Connection connection = JdbcConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM commentarii WHERE Link_ID = " + LinkId);

        while(result.next()) {
            Model.Commentarii comment = new Model.Commentarii(result.getInt(1), result.getInt(2), result.getString(3), result.getString(4), result.getString(5));
            resultSet.add(comment);
        }

        statement.close();
        connection.close();
        return resultSet;
    }

    public static Model.Commentarii getCommentFromDb(int Id) throws SQLException, ClassNotFoundException {
        Connection connection = JdbcConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM commentarii WHERE com_id = " + Id);

        Model.Commentarii comment;
        for(comment = null; result.next(); comment = new Model.Commentarii(result.getInt(1), result.getInt(2), result.getString(3), result.getString(4), result.getString(5))) {
        }

        statement.close();
        connection.close();
        return comment;
    }

    public int get_LinkId() {
        return this.Link_ID;
    }
}
