package com.alifilali.loginandregistersqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {


    private EditText e1 , e2;
    private Button b1;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        db= new DatabaseHelper(this);
        e1 = (EditText) findViewById(R.id.email);
        e2 = (EditText) findViewById(R.id.pass);
        b1 = (Button) findViewById(R.id.login);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email= e1.getText().toString();
                String pass= e2.getText().toString();
                Boolean Chkemailpass = db.emailpassword(email,pass);
                   if(Chkemailpass==true)
                       Toast.makeText(getApplicationContext(),"Successfully Login",Toast.LENGTH_LONG).show();
                   else
                       Toast.makeText(getApplicationContext(),"Wrong email or password",Toast.LENGTH_LONG).show();

            }

        });
    }
}




