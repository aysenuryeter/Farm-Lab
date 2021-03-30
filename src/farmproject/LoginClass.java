package farmproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginClass {

    String username;
    String password;

    public LoginClass() {

    }

    public LoginClass(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean farmerLogin(String logUsername, String logPassword) {
        Connection dbconn = dbConnection.connectDB();

        if (dbconn != null) {
            try {
                PreparedStatement st = (PreparedStatement) dbconn.prepareStatement("SELECT * from farmer WHERE username = ? AND password = ?");
                st.setString(1, logUsername);
                st.setString(2, logPassword);
                ResultSet res = st.executeQuery();
                if (res.next()) {
                    System.out.println("farmer found");
                    return true;

                } else {
                    System.out.println("farmer not found");
                    return false;

                }
            } catch (SQLException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("The connection not available");
        }
        return true;
    }
        public boolean engineerLogin(String logUsername, String logPassword) {
        Connection dbconn = dbConnection.connectDB();

        if (dbconn != null) {
            try {
                PreparedStatement st = (PreparedStatement) dbconn.prepareStatement("SELECT * from engineer WHERE username = ? AND password = ?");
                st.setString(1, logUsername);
                st.setString(2, logPassword);
                ResultSet res = st.executeQuery();
                if (res.next()) {
                    System.out.println("engineer found");
                    return true;

                } else {
                    System.out.println("engineer not found");
                    return false;

                }
            } catch (SQLException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("The connection not available");
        }
        return true;
    }


}
