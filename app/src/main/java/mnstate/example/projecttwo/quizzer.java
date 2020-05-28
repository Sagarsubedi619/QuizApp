package mnstate.example.projecttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class quizzer extends AppCompatActivity {
    Button startbtn,nobtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizzer);
        startbtn=findViewById(R.id.start_btn);


        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoryintent =new Intent(quizzer.this,categories.class);
                startActivity(categoryintent);
            }
        });


    }
}
