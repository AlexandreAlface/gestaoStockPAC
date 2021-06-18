package pt.ipbeja.PAC_Project.models;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Favourite {

    @PrimaryKey(autoGenerate = true)
    long idFavourite;
    long idUSer;
    long idComp;
    int flagFavourite;

    public Favourite(long idFavourite, long idUSer, long idComp, int flagFavourite) {
        this.idFavourite = idFavourite;
        this.idUSer = idUSer;
        this.idComp = idComp;
        this.flagFavourite = flagFavourite;
    }

    @Ignore
    public Favourite(long idUSer, long idComp, int flagFavourite) {

        this.idUSer = idUSer;
        this.idComp = idComp;
        this.flagFavourite = flagFavourite;
    }

    public long getIdFavourite() {
        return idFavourite;
    }

    public long getIdUSer() {
        return idUSer;
    }

    public long getIdComp() {
        return idComp;
    }

    public int getFlagFavourite() {
        return flagFavourite;
    }
}
