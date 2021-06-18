package pt.ipbeja.PAC_Project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pt.ipbeja.PAC_Project.database.AppDataBase;
import pt.ipbeja.PAC_Project.models.UserLogin;

public class LoginActivity extends AppCompatActivity {

    EditText userNAme;
    EditText userPass;
    Button btnNewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        userNAme = findViewById(R.id.tilUser);
        userPass = findViewById(R.id.tilPassword);
        btnNewLogin = findViewById(R.id.btnCreateAccount);

    }

    public void createLogin(View view) {

        UserLogin lastLogin = AppDataBase.getInstance(this).databaseDAO().lastLogin();

        UserLogin newLogin = new UserLogin(lastLogin.getIdUser() + 1,userNAme.getText().toString(), userPass.getText().toString(),"sheezh", "sheeezs", "yhea", 1);

        AppDataBase.getInstance(this).databaseDAO().addLogin(newLogin);

        Toast.makeText(this, "achoque foi criado", Toast.LENGTH_LONG).show();

    }

    public void goToHomeActivity(View view) {

        UserLogin content = AppDataBase.getInstance(this).databaseDAO().login(userNAme.getText().toString(), userPass.getText().toString());

        if(content == null)
        {
            Toast.makeText(LoginActivity.this, "null content", Toast.LENGTH_LONG).show();
        }
        else {
            startActivity(new Intent(this, HomeActivity.class));

        }

    }
}

