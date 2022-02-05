//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Model;

import pack.JdbcConnection;

import java.sql.*;

public class Links {
    private int _id;
    private String _Ref;
    private String _DescriptionLink;
    private int _IsUseful;
    private int _IsUseless;

    public Links() {
    }

    public Links(int id, String ref, String descriptionLink, int isuseful, int isuseless) {
        this._id = id;
        this._DescriptionLink = descriptionLink;
        this._IsUseful = isuseful;
        this._IsUseless = isuseless;
        this._Ref = ref;
    }

    public Links(int id, String ref, String descriptionLink) {
        this._id = id;
        this._DescriptionLink = descriptionLink;
        this._IsUseful = 0;
        this._IsUseless = 0;
        this._Ref = ref;
    }

    public int get_id() {
        return this._id;
    }


    public String get_Ref() {
        return this._Ref;
    }

    public String get_DescriptionLink() {
        return this._DescriptionLink;
    }

    public int get_IsUseful() {
        return this._IsUseful;
    }

    public int get_IsUseless() {
        return this._IsUseless;
    }

    public void set_Ref(String _Ref) {
        this._Ref = _Ref;
    }

    public void set_DescriptionLink(String _DescriptionLink) {
        this._DescriptionLink = _DescriptionLink;
    }

    public void set_IsUseful(int _IsUseful) {
        this._IsUseful = _IsUseful;
    }

    public void set_IsUseless(int _IsUseless) {
        this._IsUseless = _IsUseless;
    }

    public static Model.Links getLinkFromDb(int Id) throws SQLException, ClassNotFoundException {
        Connection connection = JdbcConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM Links WHERE Link_ID = " + Id);

        Model.Links link;
        for(link = null; result.next(); link = new Model.Links(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4), result.getInt(5))) {
        }

        statement.close();
        connection.close();
        return link;
    }
}
