package mnstate.example.projecttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;


public class finishRate extends AppCompatActivity {
    ImageView smileimg;
    TextView seekrec;
    SeekBar seekBar;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_rate);

        smileimg=findViewById(R.id.smilebtn);
        seekrec=findViewById(R.id.textrecseek);
        seekBar=findViewById(R.id.seekBar);
        progressBar=findViewById(R.id.progress);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekrec.setText(""+progress+"%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        final MediaPlayer mppp=MediaPlayer.create(this,R.raw.haveaniceday);

        smileimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mppp.start();
            }
        });
    }
}
