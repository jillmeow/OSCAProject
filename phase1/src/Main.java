import dao.MemberCollectionDAO;
import dao.MemberDAO;
import dao.MemberJdbcDAO;
import gui.*;
import java.awt.EventQueue;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws IOException, SQLException, Exception {

   
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
     
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
              




                new Login().setVisible(true);
            }
        });
    }
}
//Finished?
