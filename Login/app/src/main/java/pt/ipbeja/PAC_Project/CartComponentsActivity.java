package pt.ipbeja.PAC_Project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import pt.ipbeja.PAC_Project.adapters.ComponentsOnCartListAdapter;
import pt.ipbeja.PAC_Project.database.AppDataBase;
import pt.ipbeja.PAC_Project.models.Cart;

public class CartComponentsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Cart> cartList;
    private ComponentsOnCartListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_components);


        this.cartList = AppDataBase.getInstance(this).databaseDAO().getAllComponentsCart();

        if (this.cartList == null){

            Toast.makeText(this,"null",Toast.LENGTH_LONG ).show();
        }
        else{


            this.adapter = new ComponentsOnCartListAdapter(this);
            this.recyclerView = findViewById(R.id.recyclerViewCartComponents);
            this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
            this.recyclerView.setAdapter(adapter);
            this.adapter.refreshList(cartList);


        }



    }

    public void goToCartActivity(View view) {

        Intent intent = new Intent(this, CartComponentsActivity.class);
        startActivity(intent);
        finish();

    }

    public void goToFavouriteActivity(View view) {

        Intent intent = new Intent(this, FavouriteComponentsActivity.class);
        startActivity(intent);
        finish();

    }

    public void goToHomeActivityFromMenu(View view){

        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();

    }

    public void goToUserSettingsActivity(View view) {

        Intent intent = new Intent(this, UserSettingsActivity.class);
        startActivity(intent);
        finish();

    }


}