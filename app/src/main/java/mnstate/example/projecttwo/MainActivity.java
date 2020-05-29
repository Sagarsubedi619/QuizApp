
/*
Name: Sagar Subedi
Date: March 30 2020

Description: This is a simple quiz app . Varieties of features that we learned till today like bundles, shared preference, fragments,SQLite Databse etc..
             are being applied while making this app.

pre-condition: The specification and requirements as mentioned in project 2 description must meet.

post -condition: An working app






 */



package mnstate.example.projecttwo;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button SignIN, Register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SignIN=findViewById(R.id.logInbtn);
        Register=findViewById(R.id.register);

        SignIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,signin.class);
                startActivity(intent);

            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,register.class);
                startActivity(intent);


            }
        });
    }
}

