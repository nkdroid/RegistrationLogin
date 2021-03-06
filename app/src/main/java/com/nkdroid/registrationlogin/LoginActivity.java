package com.nkdroid.registrationlogin;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends ActionBarActivity {

    private EditText etUsername,etPassword;
    private Button btnLogin,btnNewRegistration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //check isLogin or not
        if(PrefUtils.isLoggedIn(LoginActivity.this)){
            Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
            startActivity(intent);
            finish();
        }
        initView();
    }

    private void initView() {
        etUsername= (EditText) findViewById(R.id.etUsername);
        etPassword= (EditText) findViewById(R.id.etPassword);
        btnLogin= (Button) findViewById(R.id.btnLogin);
        btnNewRegistration= (Button) findViewById(R.id.btnNewRegistration);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isEmptyField(etUsername)){
                    Toast.makeText(LoginActivity.this,"Please Enter Username",Toast.LENGTH_LONG).show();
                } else if(isEmptyField(etPassword)){
                    Toast.makeText(LoginActivity.this,"Please Enter Password",Toast.LENGTH_LONG).show();
                } else {
                    // check from shared preference
                    User user=PrefUtils.getLoggedIn(LoginActivity.this);
                    PrefUtils.setLoggedIn(LoginActivity.this,true,user.getUsername(),user.getPassword());
                    Log.e("username", user.getUsername()+"");
                    if( user.getUsername().equals(etUsername.getText().toString().trim()) && user.getPassword().equals(etPassword.getText().toString().trim())){
                        Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this,"Please Enter Valid Username or Password",Toast.LENGTH_LONG).show();
                    }

                }
            }
        });

        btnNewRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegistrationActivity.class);

                startActivity(intent);
                finish();
            }
        });

    }


    public boolean isEmptyField(EditText param1) {

        boolean isEmpty = false;
        if (param1.getText() == null || param1.getText().toString().equalsIgnoreCase("")) {
            isEmpty = true;
        }
        return isEmpty;
    }

}
