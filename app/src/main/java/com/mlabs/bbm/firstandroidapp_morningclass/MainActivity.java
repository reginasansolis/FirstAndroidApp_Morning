package com.mlabs.bbm.firstandroidapp_morningclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText Email, Password;
    Pattern Reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email = (EditText) findViewById(R.id.Email);
        Password = (EditText) findViewById(R.id.Password);
        findViewById(R.id.Login).setOnClickListener(btnLoginClickListener);

        Reg = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    }

    View.OnClickListener btnLoginClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (validate(Email.getText().toString(),Password.getText().toString())){
                Intent intent = new Intent(MainActivity.this,Display.class );
                startActivity(intent);
            }
            else
                Toast.makeText(getApplicationContext(), "Invalid Email Address/Password", Toast.LENGTH_LONG).show();
        }
    };

    Boolean validate(String email, String pw)
    {   Matcher m;
        m = Reg.matcher(email);
        if (m.matches()&&pw.length()<8&&pw.length()!=0){
            return true;
        }
        else
            return false;
    }
}