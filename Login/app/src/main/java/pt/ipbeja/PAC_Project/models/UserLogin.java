package pt.ipbeja.PAC_Project.models;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class UserLogin {

    @PrimaryKey(autoGenerate = true)
    long idUser;
    String userName;
    String userPass;
    String firstName;
    String lastName;
    String email;
    int userType;


    public UserLogin(long idUser, String userName, String userPass, String firstName, String lastName, String email, int userType) {
        this.idUser = idUser;
        this.userName = userName;
        this.userPass = userPass;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userType = userType;
    }

    @Ignore
    public UserLogin(String userName, String userPass, String firstName, String lastName, String email, int userType) {

        this.userName = userName;
        this.userPass = userPass;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userType = userType;
    }

    @Ignore
    public UserLogin(String userName, String userPass, String firstName, String lastName, String email) {

        this.userName = userName;
        this.userPass = userPass;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }



    public long getIdUser() {
        return idUser;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getUserType() {
        return userType;
    }

}
