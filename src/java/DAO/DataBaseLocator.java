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
    
    public Connection getConnection() throws SQLException, ClassNotFoundException, ServletException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/aluguel_fantasias", "root", "");
        } catch (SQLException e) {
            throw new ServletException("<br><b>Erro ao estabelecer conexão com o banco de dados:</b><br>"+e.getMessage());
        }
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
