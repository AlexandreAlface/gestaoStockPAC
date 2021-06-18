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
import pt.ipbeja.PAC_Project.adapters.ComponentsOnFavouriteListAdapter;
import pt.ipbeja.PAC_Project.database.AppDataBase;
import pt.ipbeja.PAC_Project.models.Cart;
import pt.ipbeja.PAC_Project.models.Favourite;

public class FavouriteComponentsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Favourite> favouriteList;
    private ComponentsOnFavouriteListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_components);

        this.favouriteList = AppDataBase.getInstance(this).databaseDAO().getAllComponentsFavourite();

        if (this.favouriteList == null){

            Toast.makeText(this,"null",Toast.LENGTH_LONG ).show();
        }
        else{

            this.adapter = new ComponentsOnFavouriteListAdapter(this);
            this.recyclerView = findViewById(R.id.recyclerViewFavouriteComponents);
            this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
            this.recyclerView.setAdapter(adapter);
            this.adapter.refreshList(favouriteList);


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