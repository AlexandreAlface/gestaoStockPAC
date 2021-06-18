package pt.ipbeja.PAC_Project.models;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Cart {

    @PrimaryKey(autoGenerate = true)
    long idCart;
    long idUSer;
    long idComp;
    int flagCart;

    public Cart(long idCart, long idUSer, long idComp, int flagCart) {
        this.idCart = idCart;
        this.idUSer = idUSer;
        this.idComp = idComp;
        this.flagCart = flagCart;
    }


    @Ignore
    public Cart(long idUSer, long idComp, int flagCart) {

        this.idUSer = idUSer;
        this.idComp = idComp;
        this.flagCart = flagCart;
    }

    public long getIdCart() {
        return idCart;
    }

    public long getIdUSer() {
        return idUSer;
    }

    public long getIdComp() {
        return idComp;
    }

    public int getFlagCart() {
        return flagCart;
    }
}

