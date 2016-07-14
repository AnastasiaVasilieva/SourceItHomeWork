import java.sql.*;

/**
 * Created by Nastya on 15.07.2016.
 */
public class DB {
    private static final String driverName = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/gai_database";
    private static final String user = "root";
    private static final String password = "nastya2003";

    private static Connection conn;
    private static Statement stmt;
    private static ResultSet rs;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName(driverName);
        conn = DriverManager.getConnection(url, user, password);
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
        System.out.println("select");
        print(select("SELECT * FROM car_model"));
        System.out.println("insert");
        print(insert(13, "Honda", "CR-V"));
        System.out.println("delete");
        print(delete(4));

        if (conn != null) conn.close();
    }

    private static ResultSet select(String sql) throws SQLException {
        rs = stmt.executeQuery(sql);
        return rs;
    }
    private static ResultSet insert(int id, String name, String model) throws SQLException {
        rs.moveToInsertRow();
        rs.updateInt("idcar_model", id);
        rs.updateString("name", name);
        rs.updateString("model", model);
        rs.insertRow();
        return rs;
    }

    private static ResultSet delete(int id) throws SQLException {
        rs.absolute(id);
        rs.deleteRow();
        return rs;
    }

    private static void print(ResultSet rs) throws SQLException {
        rs.beforeFirst();
        while (rs.next()) {
            int id = rs.getInt("idcar_model");
            String name = rs.getString("name");
            String model = rs.getString("model");

            System.out.println("id: " + id);
            System.out.println("Name of model: " + name);
            System.out.println("Model: " + model);
            System.out.println("---------------------------------------------");

        }
    }
}
