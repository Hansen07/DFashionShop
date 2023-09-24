package com.example.uas_mobileprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        LinearLayout tombol=findViewById(R.id.buttonlogin);
        tombol.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText nama = findViewById(R.id.namauser);
                        EditText pasword = findViewById(R.id.password);
                        String temnama = nama.getText().toString();
                        String tempasword = pasword.getText().toString();

                        if(temnama.equals("user")&&tempasword.equals("pwuser")){
                            Intent intent = new Intent(v.getContext(),DashboardPage.class);
                            startActivity(intent);
                        }else if(temnama.equals("admin")&&tempasword.equals("pwadmin")){
                            Intent intent = new Intent(v.getContext(),DashboardPage.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(LoginPage.this,"Your Username or Password is Incorrect", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }
}