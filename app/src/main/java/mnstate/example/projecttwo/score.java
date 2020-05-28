package mnstate.example.projecttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class score extends AppCompatActivity {
    private TextView scored,total;
    private Button done,share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        scored=findViewById(R.id.scored);
        total=findViewById(R.id.outoftotal);
        done=findViewById(R.id.done_btn);
        share=findViewById(R.id.shhh_btn);

        scored.setText(String.valueOf(getIntent().getIntExtra("Score",0)));
        total.setText(String.valueOf(getIntent().getIntExtra("total",0)));

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(score.this,finishRate.class);

                startActivity(intent);


            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchintent=getPackageManager().getLaunchIntentForPackage("com.facebook.katana");
                if(launchintent!=null){
                    startActivity(launchintent);
                }
            }
        });
    }
}
