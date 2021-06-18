package pt.ipbeja.PAC_Project.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Category {

    @PrimaryKey(autoGenerate = true)
    long idCategory;
    String category;
    String designation;

    public Category(long idCategory, String category, String designation) {
        this.idCategory = idCategory;
        this.category = category;
        this.designation = designation;
    }

    public long getIdCategory() {
        return idCategory;
    }

    public String getCategory() {
        return category;
    }

    public String getdesignation() {
        return designation;
    }
}
