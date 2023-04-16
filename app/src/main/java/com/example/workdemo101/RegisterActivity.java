package com.example.workdemo101;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        TextView btn = findViewById(R.id.already);

        TextView username = findViewById(R.id.username);
        TextView email = findViewById(R.id.Email);
        TextView password = findViewById(R.id.Password);
        Button registerbtn = findViewById(R.id.btnofResigter);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LogInActivity.class));
            }
        });
    }
    @SuppressLint("NewApi")
    public Connection connection(){
        Connection conn = null;
        String ip="192.168.0.104", port="53935" , username1="Demo", password="koria", databassname="ForWorkDemo101";
        StrictMode.ThreadPolicy tp = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(tp);
        try
        {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            String connectionurl="jdbc:jtdsL:sqlserver://"+ip+":"+port+";databasename"+databassname+";User="+username1+";password="+password+";";
            conn = DriverManager.getConnection(connectionurl);
        }
        catch (Exception exception)
        {
            Log.e("Error", exception.getMessage());
        }
        return conn;
    }
}