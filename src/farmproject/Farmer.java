package farmproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Farmer extends Person {

 
    //To connect to a database 
    Connection dbconn = dbConnection.connectDB();

    Farmer() {

    }

    public Farmer(String userNameLastName, String userName, String userPhoneNumber, String userEmailAdress, String userPassword, String userGender, String userJob, Engineer engineerX) {
        super(userNameLastName, userName, userPhoneNumber, userEmailAdress, userPassword, userGender, userJob);
    

    }

    @Override       //to registering farmers in the database
    public boolean addUser(String userNameLastName, String username, String email, String password, String phone, String gender, String job) {

        if (dbconn != null) {

            try {
                PreparedStatement st = (PreparedStatement) dbconn.prepareStatement("INSERT INTO farmer (name,username,email,password,phone,gender,job) VALUES(?,?,?,?,?,?,?)");
                st.setString(1, userNameLastName);
                st.setString(2, username);
                st.setString(3, email);
                st.setString(4, password);
                st.setString(5, phone);
                st.setString(6, gender);
                st.setString(7, job);

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

    @Override       //to search for farmers in the database
    public int searchUser(String userNameLastName, String username, String email, String password, String phone, String gender, String job) {

        int check = 0;

        if (dbconn != null) {
            try {
                PreparedStatement st = (PreparedStatement) dbconn.prepareStatement("Select * FROM farmer");
                ResultSet res = st.executeQuery();

                while (res.next()) {
                    if (res.getString("username").equals(username)) {
                        check = 1;
                    } else if (res.getString("email").equals(email)) {
                        check = 2;
                    } else if (res.getString("phone").equals(phone)) {
                        check = 3;
                    }

                }
                return check;

            } catch (SQLException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }

    @Override       //for farmers to update their information
    public boolean updateUser(String username, String changeName, String email, String pass, String phone) throws SQLException {

        if (dbconn != null) {
            try {
                PreparedStatement st = (PreparedStatement) dbconn.prepareStatement("UPDATE farmer SET username = ? ," + "email = ? ," + "password = ? ," + "phone = ? " + "WHERE username = ?");

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

    @Override       //to delete farmers in the database 
    public boolean deleteUser(String username) {

        if (dbconn != null) {
            try {
                PreparedStatement st = (PreparedStatement) dbconn.prepareStatement("DELETE FROM farmer WHERE username = ?");

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

    //to show all farmers in the database in the table by putting an array list
    public ArrayList<Person> displayUser() {

        ArrayList<Person> liste = new ArrayList<Person>();

        try {

            PreparedStatement st = (PreparedStatement) dbconn.prepareStatement("Select * FROM farmer");
            ResultSet res = st.executeQuery();

            while (res.next()) {

                Farmer farmer = new Farmer();
                farmer.setUserNameLastName(res.getString("name"));
                farmer.setUserEmailAdress(res.getString("email"));
                farmer.setUserPhoneNumber(res.getString("phone"));
                farmer.setUserGender(res.getString("gender"));

                liste.add(farmer);
            }

        } catch (SQLException e) {

            System.out.println(e);
        }
        return liste;

    }

    public boolean searchFarmer(String username) {

        if (dbconn != null) {
            try {
                PreparedStatement st = (PreparedStatement) dbconn.prepareStatement("Select * FROM farmer");
                ResultSet res = st.executeQuery();

                while (res.next()) {
                    if (res.getString("username").equals(username)) {
                        return true;
                    }

                }

            } catch (SQLException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return false;
    }

    public String getUserNameLastName() {
        return userNameLastName;
    }

    public void setUserNameLastName(String userNameLastName) {
        this.userNameLastName = userNameLastName;
    }

    public String getUserJob() {
        return userJob;
    }

    public void setUserJob(String userJob) {
        this.userJob = userJob;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    @Override
    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    @Override
    public String getUserEmailAdress() {
        return userEmailAdress;
    }

    @Override
    public void setUserEmailAdress(String userEmailAdress) {
        this.userEmailAdress = userEmailAdress;
    }

    @Override
    public String getUserPassword() {
        return userPassword;
    }

    @Override
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String getUserGender() {
        return userGender;
    }

    @Override
    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }



}
