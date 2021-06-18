package pt.ipbeja.PAC_Project.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import pt.ipbeja.PAC_Project.models.Cart;
import pt.ipbeja.PAC_Project.models.Category;
import pt.ipbeja.PAC_Project.models.Component;
import pt.ipbeja.PAC_Project.models.Favourite;
import pt.ipbeja.PAC_Project.models.ReserveComponent;
import pt.ipbeja.PAC_Project.models.UserLogin;

@Dao
public interface DatabaseDAO {

    @Query("SELECT * FROM UserLogin WHERE userName = :userName AND userPass = :userPass")
    UserLogin login(String userName, String userPass);

    @Query("SELECT * FROM UserLogin ORDER BY idUser DESC LIMIT 1")
    UserLogin lastLogin();

    @Insert
    void addLogin(UserLogin userLogin);

    @Query("SELECT * FROM Component")
    List<Component> getAllComponents();

//    @Query("SELECT * FROM Component WHERE idComponent = :designation")
//    Component findComponent(String designation);

    @Query("SELECT * FROM Component WHERE idCategory = :idCategory")
    List<Component> findComponentByCategory(Long idCategory);

    @Query("SELECT * FROM Category")
    List<Category> getAllCategory();

    @Insert
    void addComponentCart(Cart cart);

    @Query("SELECT * FROM Cart WHERE flagCart = 1 ")
    List<Cart> getAllComponentsCart();

    @Query("SELECT * FROM Cart ORDER BY idCart DESC LIMIT 1")
    Cart lastIdCart();

    @Insert
    void addComponentFavourite(Favourite favourite);

    @Query("SELECT * FROM Favourite WHERE flagFavourite = 1 ")
    List<Favourite> getAllComponentsFavourite();

    @Query("SELECT * FROM Favourite ORDER BY idFavourite DESC LIMIT 1")
    Favourite getLastidFavourite();

    @Insert
    void addReserveComponent(ReserveComponent reserveComponent);

    @Query("SELECT * FROM ReserveComponent WHERE flagReservedComponent = 1 ")
    List<ReserveComponent> getAllReservedComponents();

    @Update
    UserLogin updateSettings(UserLogin updatedUser);


}
