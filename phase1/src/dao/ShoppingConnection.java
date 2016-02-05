package dao;

import java.sql.Connection;
import java.sql.SQLException;
import org.h2.jdbcx.JdbcConnectionPool;

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
