package pt.ipbeja.PAC_Project.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Component {

    @PrimaryKey(autoGenerate = true)
    long idComponent;
    long idCategory;
    String designation;
    long price;

    public Component(long idComponent, long idCategory ,String designation, long price) {
        this.idComponent = idComponent;
        this.idCategory = idCategory;
        this.designation = designation;
        this.price = price;
    }

//    public Component(ArrayList<Component> arrayList) {
//        this.idComponent = Long.parseLong(String.valueOf(arrayList.get(0)));
//        this.designation = String.valueOf(arrayList.get(1));
//        this.price = Long.parseLong(String.valueOf(arrayList.get(2)));
//        this.category = String.valueOf(arrayList.get(1));
//    }

    public long getIdComponent() {
        return idComponent;
    }

    public long getIdCategory() {
        return idCategory;
    }

    public String getDesignation() {
        return designation;
    }

    public long getPrice() {
        return price;
    }
}
