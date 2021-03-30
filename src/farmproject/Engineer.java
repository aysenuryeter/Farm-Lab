package farmproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Engineer extends Person {

    //To connect to a database 
    Connection dbconn = dbConnection.connectDB();

    Engineer() {

    }

    public Engineer(String userNameLastName, String userName, String userPhoneNumber, String userEmailAdress, String userPassword, String userGender, String userJob) {
        super(userNameLastName, userName, userPhoneNumber, userEmailAdress, userPassword, userGender,userJob);

    }

    @Override       //to registering engineers in the database
    boolean addUser(String name,String username, String email, String password, String phone, String gender,String job) {

        if (dbconn != null) {

            try {
                PreparedStatement st = (PreparedStatement) dbconn.prepareStatement("INSERT INTO engineer (name,username,email,password,phone,gender,job) VALUES(?,?,?,?,?,?,?)");
                st.setString(1,name);
                st.setString(2, username);
                st.setString(3, email);
                st.setString(4, password);
                st.setString(5, phone);
                st.setString(6, gender);
                st.setString(7,job);

                int res = st.executeUpdate();
                System.out.println("user data inserted");
                return true;

            } catch (SQLException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            System.out.print("could not add");
        }
        return false;
    }

    @Override       //to delete engineers in the database  
    boolean deleteUser(String username) {

        if (dbconn != null) {
            try {
                PreparedStatement st = (PreparedStatement) dbconn.prepareStatement("DELETE FROM engineer WHERE username = ?");

                st.setString(1, username);
                st.executeUpdate();
                return true;

            } catch (SQLException ex) {

                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            System.out.println("not be delete");
        }
        return false;
    }

    @Override       //to search for engineers in the database
    int searchUser(String userNameLastName, String username, String email, String password, String phone, String gender,String job) {
        int check = 0;

        if (dbconn != null) {
            try {
                PreparedStatement st = (PreparedStatement) dbconn.prepareStatement("Select * from engineer");
                ResultSet res = st.executeQuery();

                while (res.next()) {  
                    if (res.getString("username").equals(username)) {
                        check = 1;
                    } else if (res.getString("email").equals(email)) {
                        check = 2;
                    } else if (res.getString("phone").equals(phone)) {
                        check = 3;
                    }

                } //we returned the check value to give the user a detailed error message
                return check;

            } catch (SQLException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }

    @Override       //for engineers to update their information
    boolean updateUser(String username, String changeName, String email, String pass, String phone) throws SQLException {

        if (dbconn != null) {
            try {
                PreparedStatement st = (PreparedStatement) dbconn.prepareStatement("UPDATE engineer  SET username = ? ," + "email = ? ," + "password = ? ," + "phone = ? " + "WHERE username = ?");

                st.setString(1, changeName);
                st.setString(2, email);
                st.setString(3, pass);
                st.setString(4, phone);
                st.setString(5, username);

                st.executeUpdate();
                return true;

            } catch (SQLException ex) {

                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            System.out.println("not be update");
        }
        return false;
    }
        

//to assign random engineer to each farmer from database
    public void randEng() {

        if (dbconn != null) {
            try {
                PreparedStatement st = (PreparedStatement) dbconn.prepareStatement("Select * FROM engineer ORDER BY RAND() LIMIT 1");
                ResultSet res = st.executeQuery();

                while (res.next()) {
                    userNameLastName = res.getString(2);
                    userEmailAdress = res.getString(4);
                    userPhoneNumber = res.getString(6);
                    userGender = res.getString(7);

                }

            } catch (Exception ex) {

                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
    

    public String getUserNameLastName() {
        return userNameLastName;
    }

    public void setUserNameLastName(String userNameLastName) {
        this.userNameLastName = userNameLastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserEmailAdress() {
        return userEmailAdress;
    }

    public void setUserEmailAdress(String userEmailAdress) {
        this.userEmailAdress = userEmailAdress;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserJob() {
        return userJob;
    }

    public void setUserJob(String userJob) {
        this.userJob = userJob;
    }

    @Override
    public ArrayList<Person> displayUser() {
                ArrayList<Person> liste = new ArrayList<Person>();

        try {

            PreparedStatement st = (PreparedStatement) dbconn.prepareStatement("Select * FROM engineer");
            ResultSet res = st.executeQuery();

            while (res.next()) {

                Engineer engineer = new Engineer();
                engineer.setUserNameLastName(res.getString("name"));
                engineer.setUserEmailAdress(res.getString("email"));
                engineer.setUserPhoneNumber(res.getString("phone"));
                engineer.setUserGender(res.getString("gender"));

                liste.add(engineer);
            }

        } catch (SQLException e) {

            System.out.println(e);
        }
        return liste;
    }

 
}
