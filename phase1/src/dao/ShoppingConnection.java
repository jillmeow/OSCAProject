package dao;

import java.sql.Connection;
import java.sql.SQLException;
import org.h2.jdbcx.JdbcConnectionPool;

/**
 * 
 * Web-based system for Otago Southland Chinese Association (OSCA)
 * 
 * @author Jill Mirandilla, Kendall Chin, Gary Lee, Sean Braid and Hans To'o
 */
public class ShoppingConnection {

    private static final String url = "jdbc:h2:tcp://localhost/~/tmp/dbs/shopping";
    private static final String username = "sa";
    private static final String password = "";

    private static final JdbcConnectionPool pool = JdbcConnectionPool.create(url, username, password);

    public static Connection getConnection() {
        try {
            return pool.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
