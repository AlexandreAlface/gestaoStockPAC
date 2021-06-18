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
import pt.ipbeja.PAC_Project.adapters.ReservedComponentAdapter;
import pt.ipbeja.PAC_Project.database.AppDataBase;
import pt.ipbeja.PAC_Project.models.Cart;
import pt.ipbeja.PAC_Project.models.ReserveComponent;

public class ReservedComponentsListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<ReserveComponent> reservedComponentList;
    private ReservedComponentAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserved_components_list);

        this.reservedComponentList = AppDataBase.getInstance(this).databaseDAO().getAllReservedComponents();

        if (this.reservedComponentList == null){

            Toast.makeText(this,"null",Toast.LENGTH_LONG ).show();
        }
        else{


            this.adapter = new ReservedComponentAdapter(this);
            this.recyclerView = findViewById(R.id.recyclerViewListReservedComponents);
            this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
            this.recyclerView.setAdapter(adapter);
            this.adapter.refreshList(reservedComponentList);


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