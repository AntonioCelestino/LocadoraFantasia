package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;

public class DataBaseLocator {
    private static DataBaseLocator instance = new DataBaseLocator();
    public static DataBaseLocator getInstance(){
        return instance;
    }
    private DataBaseLocator(){}
    
    public Connection getConnection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/aluguel_fantasias", "root", "");
        return conn;
    }
    
    public static void closeResources(Connection conn, Statement st) throws ServletException{
        try {
            if(st!=null) st.close();
            if(conn!=null) conn.close();

        } catch(SQLException e) {
            throw new ServletException(e);
        }
    }
}
