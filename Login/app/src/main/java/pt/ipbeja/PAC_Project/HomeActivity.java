package pt.ipbeja.PAC_Project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;

import java.util.List;

import pt.ipbeja.PAC_Project.adapters.CategoryListAdapter;
import pt.ipbeja.PAC_Project.database.AppDataBase;
import pt.ipbeja.PAC_Project.models.Category;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CategoryListAdapter adapter;
    private List<Category> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    this.categoryList = AppDataBase.getInstance(this).databaseDAO().getAllCategory();

    this.adapter = new CategoryListAdapter(this);
    this.recyclerView = findViewById(R.id.recyclerViewCategoryList);
    this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    this.recyclerView.setAdapter(adapter);
    this.adapter.refreshList(this.categoryList);

    }

    public void goToLoginActivity(View view) {

        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();

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

    public void goToUserSettingsActivity(View view) {

        Intent intent = new Intent(this, UserSettingsActivity.class);
        startActivity(intent);
        finish();

    }
}