package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    EditText userName;
    EditText password;
    EditText email;

    public LoginActivity(){}

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btnLogin);
        userName = findViewById(R.id.edtUsername);
        password = findViewById(R.id.editPassword);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = validate(userName.getText().toString(),password.getText().toString());
                if(!validate_email(email.getText().toString())){
                    email.setError("Wrong email format");
                }
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
            }
        });
    }
    public LoginActivity(Context context){

    }

    public String validate(String userName, String password) {
        boolean result = validate_email(userName);
        if(password.equals("admin") && result)
            return "Login was successful";
        else
            return "Invalid login!";
    }

    private boolean validate_email(String e){
        String pattern = "^[a-zA-Z0-9][\\w.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z.]*[a-zA-Z]$";
        return e.matches(pattern);
    }
}