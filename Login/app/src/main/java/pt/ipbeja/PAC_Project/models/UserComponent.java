package pt.ipbeja.PAC_Project.models;

//lista de reservas

import androidx.room.Entity;

@Entity(primaryKeys = {"idUSer", "idComp"})
public class UserComponent {

    long idUSer;
    long idComp;

    public UserComponent(long idUSer, long idComp) {
        this.idUSer = idUSer;
        this.idComp = idComp;
    }

    public long getIdUSer() {
        return idUSer;
    }

    public long getIdComp() {
        return idComp;
    }
}
