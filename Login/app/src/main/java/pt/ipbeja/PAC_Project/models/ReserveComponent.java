package pt.ipbeja.PAC_Project.models;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class ReserveComponent {

    @PrimaryKey(autoGenerate = true)
    long idReserveComponent;
    long idUSer;
    long idComp;
    int flagReservedComponent;

    public ReserveComponent(long idReserveComponent, long idUSer, long idComp, int flagReservedComponent) {
        this.idReserveComponent = idReserveComponent;
        this.idUSer = idUSer;
        this.idComp = idComp;
        this.flagReservedComponent = flagReservedComponent;
    }

    @Ignore
    public ReserveComponent(long idUSer, long idComp, int flagReservedComponent) {

        this.idUSer = idUSer;
        this.idComp = idComp;
        this.flagReservedComponent = flagReservedComponent;
    }

    public long getIdReserveComponent() {
        return idReserveComponent;
    }

    public long getIdUSer() {
        return idUSer;
    }

    public long getIdComp() {
        return idComp;
    }

    public int getFlagReservedComponent() {
        return flagReservedComponent;
    }
}
