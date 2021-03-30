package farmproject;

import java.sql.SQLException;
import java.util.ArrayList;

//Person is a SystemClass
public abstract class Person {

    String userNameLastName;
    String userName;
    String userPhoneNumber;
    String userEmailAdress;
    String userPassword;
    String userGender;
    String userJob;

    Person() {

    }

    //This class is an abstract class that will have the farmer and engineer classes that will have abstract functions and will have the informations about the users.
    public Person(String userNameLastName, String userName, String userPhoneNumber, String userEmailAdress, String userPassword, String userGender,String userJob) {

        this.userNameLastName = userNameLastName;
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmailAdress = userEmailAdress;
        this.userPassword = userPassword;
        this.userGender = userGender;
        this.userJob= userJob;
    }

    public String getUserJob() {
        return userJob;
    }

    public void setUserJob(String userJob) {
        this.userJob = userJob;
    }

    public String getUserNameLastName() {
        return userNameLastName;
    }

    public void setUserNameLastName(String userNameLastName) {
        this.userNameLastName = userNameLastName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
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

    abstract boolean addUser(String userNameLastName,String username, String email, String password, String phone, String gender,String job);

    abstract int searchUser(String userNameLastName,String username, String email, String password, String phone, String gender,String job);

    abstract boolean updateUser(String username, String changeName, String email, String pass, String phone) throws SQLException;

    abstract boolean deleteUser(String username);
    
    abstract public ArrayList<Person> displayUser();
    
 

}
