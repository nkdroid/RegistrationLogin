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


public class VerifyActivity extends ActionBarActivity {

    private EditText etVerify;
    private Button btnVerify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);

        initView();
    }



    private void initView() {
        etVerify= (EditText) findViewById(R.id.etVerify);

        btnVerify= (Button) findViewById(R.id.btnVerify);


        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isEmptyField(etVerify)){
                    Toast.makeText(VerifyActivity.this, "Please Enter Verification Code", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(VerifyActivity.this, HomeActivity.class);
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
