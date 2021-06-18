package pt.ipbeja.PAC_Project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import pt.ipbeja.PAC_Project.IDUserClass.IDUser;
import pt.ipbeja.PAC_Project.database.AppDataBase;
import pt.ipbeja.PAC_Project.models.UserLogin;

public class ChangeUserSettingsActivity extends AppCompatActivity {

    private TextView textViewUserNameChange;
    private TextView textViewUserPassChange;
    private TextView textViewFirstName;
    private TextView textViewLastName;
    private TextView textViewEmail;

    private EditText editTextUserName;
    private EditText editTextPassword;
    private EditText editTextFirstName;
    private EditText editTextLastName;
    private EditText editTextEmail;

    private Button buttonChangeuSer;

    private UserLogin idUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_user_settings);

        this.textViewUserNameChange = findViewById(R.id.textViewUserNameChange);
        this.textViewUserPassChange = findViewById(R.id.textViewUserPassChange);
        this.textViewFirstName = findViewById(R.id.textViewFirstName);
        this.textViewLastName = findViewById(R.id.textViewLastName);
        this.textViewEmail = findViewById(R.id.textViewEmail);

        this.editTextUserName = findViewById(R.id.editTextUserName);
        this.editTextPassword = findViewById(R.id.editTextPassword);
        this.editTextFirstName = findViewById(R.id.editTextFirstName);
        this.editTextLastName = findViewById(R.id.editTextLastName);
        this.editTextEmail = findViewById(R.id.editTextEmail);

        this.buttonChangeuSer = findViewById(R.id.buttonChangeUserDetails);

        UserLogin userLogin = AppDataBase.getInstance(this).databaseDAO().lastLogin();

        this.editTextUserName.setText(userLogin.getUserName());
        this.editTextPassword.setText(userLogin.getUserPass());
        this.editTextFirstName.setText(userLogin.getFirstName());
        this.editTextLastName.setText(userLogin.getLastName());
        this.editTextEmail.setText(userLogin.getEmail());


    }

    public void changeSettings(View view) {

        UserLogin updatedUser = new UserLogin(this.editTextUserName.getText().toString() ,this.editTextPassword.getText().toString(), this.editTextFirstName.getText().toString(),  this.editTextLastName.getText().toString(), this.editTextEmail.getText().toString());

        AppDataBase.getInstance(this).databaseDAO().updateSettings(updatedUser);


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