package pt.ipbeja.PAC_Project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UserSettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_settings);
    }

    public void goToReservedComponents(View view) {

        Intent intent = new Intent(this, ReservedComponentsListActivity.class);
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

    public void goToChangeUserSettings(View view) {

        Intent intent = new Intent(this, ChangeUserSettingsActivity.class);
        startActivity(intent);
        finish();

    }
}