package com.nkdroid.registrationlogin;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegistrationActivity extends ActionBarActivity {

    private EditText etUsername,etPassword;
    private Button btnRegistration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        initView();
    }



    private void initView() {
        etUsername= (EditText) findViewById(R.id.etUsername);
        etPassword= (EditText) findViewById(R.id.etPassword);
        btnRegistration= (Button) findViewById(R.id.btnRegister);


        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isEmptyField(etUsername)){
                    Toast.makeText(RegistrationActivity.this, "Please Enter Username", Toast.LENGTH_LONG).show();
                } else if(isEmptyField(etPassword)){
                    Toast.makeText(RegistrationActivity.this,"Please Enter Password",Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(RegistrationActivity.this, VerifyActivity.class);
                    startActivity(intent);
                }

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
