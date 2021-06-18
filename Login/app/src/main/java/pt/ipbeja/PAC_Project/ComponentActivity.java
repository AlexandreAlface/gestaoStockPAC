package pt.ipbeja.PAC_Project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import pt.ipbeja.PAC_Project.adapters.ComponentsListAdapter;
import pt.ipbeja.PAC_Project.database.AppDataBase;
import pt.ipbeja.PAC_Project.models.Component;


public class ComponentActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Component> componentList;
    private ComponentsListAdapter adapter;

    private static final String KEY_CATID = "CatID";

    public static void startActivity(Context context, long CatID) {
        Intent intent = new Intent(context, ComponentActivity.class);
        intent.putExtra(KEY_CATID, CatID);
        context.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_component);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            long CatID = bundle.getLong(KEY_CATID, -1);
            if (CatID == -1) finish();

            this.componentList = AppDataBase.getInstance(this).databaseDAO().findComponentByCategory(CatID);

            this.adapter = new ComponentsListAdapter(this);
            this.recyclerView = findViewById(R.id.recyclerViewListComponentsByCat);
            this.recyclerView.setAdapter(this.adapter);
            this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
            this.adapter.refreshList(this.componentList);

        }

    }

    public void goToCartActivity(View view) {

        Intent intent = new Intent(this, CartComponentsActivity.class);
        startActivity(intent);
        finish();

    }

    public void goToHomeActivityFromMenu(View view){

        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();

    }

    public void goToFavouriteActivity(View view) {

        Intent intent = new Intent(this, FavouriteComponentsActivity.class);
        startActivity(intent);
        finish();

    }

    public void goToUserSettingsActivity(View view) {

        Intent intent = new Intent(this, UserSettingsActivity.class);
        startActivity(intent);
        finish();

    }
}