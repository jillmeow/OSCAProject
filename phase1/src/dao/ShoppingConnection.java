package dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.h2.jdbcx.JdbcConnectionPool;

/**
 * 
 * Web-based system for Otago Southland Chinese Association (OSCA)
 * 
 * @author Jill Mirandilla, Kendall Chin, Gary Lee, Sean Braid and Hans To'o
 */
public class ShoppingConnection {
    /* H2 Database - on localhost */
    private static final String url = "jdbc:h2:tcp://localhost/~/tmp/dbs/shopping";
    private static final String username = "sa";
    private static final String password = "";
    
    /* MySQL Database on remote jmirandilla.co.nz */
    private static final String jdbc_driver = "com.mysql.jdbc.Driver";
    private static final String db_url = "jdbc:mysql://jmirandilla.co.nz:3306/jmira513_shopping?zeroDateTimeBehavior=convertToNull";
    
    private static final String uName = "jmira513_jill";
    private static final String pWord = "applepie125";
    
    private static final JdbcConnectionPool pool = JdbcConnectionPool.create(url, username, password);

    public static Connection getConnection() {
        try {
            return pool.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public static Connection go() throws SQLException{
        Connection conn = null;
        try{
            Class.forName(jdbc_driver);
            
            System.out.println("Connected to jmirandilla shopping system database");
            return conn = DriverManager.getConnection(db_url, uName, pWord);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        } catch(SQLException ex){
            System.out.println("SQL connection failed");
            throw new RuntimeException(ex);
        }
    }
    
}
