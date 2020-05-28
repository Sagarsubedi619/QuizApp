package mnstate.example.projecttwo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.List;

import static android.graphics.Color.parseColor;


public class questions extends AppCompatActivity {
    private TextView question,noIndicator;

    private LinearLayout optionsContainer;
    private Button shareBtn,nextBtn;
    private int count=0;
    private  List<questionModel> list;
    private int position=0;
    private int score=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        question=findViewById(R.id.mainqestion);
        noIndicator=findViewById(R.id.mainnumberindicate);

        optionsContainer=findViewById(R.id.options_container);
        shareBtn=findViewById(R.id.start_btn);
        nextBtn=findViewById(R.id.nextbtn);

       list=new ArrayList<>();
        list.add(new questionModel("Who is known as the Father of Computer? ","Bill Gates","Charles Babbage","Steve Jobs","Ada Lovelace","Charles Babbage"));

        list.add(new questionModel("EBCDIC stands for?","Extended Binary Coded Decimal Interchange Circle","Extended Binary Coded Decimal Interchange Code","Extended Binary Coded Decimal Interchange Cellular","Extended Binary Coded Decimal Intermission Center","Extended Binary Coded Decimal Interchange Code"));

        list.add(new questionModel("What is a light pen?","a pen"," light weight Pen","Optical input device","A screen","Optical input device"));

        list.add(new questionModel("What type of computers are client computers (most of the time) in a client-server system?","Regular Computer","Microcomputer","Laptop","SuperComputer","Microcomputer"));


        list.add(new questionModel("Which of the following controls the process of interaction between the user and the operating system? ","User Interface","Hardware","Mouse","Code","User Interface"));

        list.add(new questionModel("Who is the inventor of “Difference Engine”?","Ada Lovelace","Steve Jobs","Bill Gates","Charles Babbage","Charles Babbage"));

        list.add(new questionModel("Junk e-mail is also called?","Junkyard","Trash","Spam","Garbage","Spam"));

        list.add(new questionModel("Android Studio is developed by ","Apple","Google","Microsoft","China","Google"));

        list.add(new questionModel("Which country assembles apple products ?","India","Japan","Nepal","China","China"));



        for(int i=0;i<4;i++){
            optionsContainer.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onClick(View v) {
                    checkAnswer((Button) v);
                }
            });
        }



        playAnim(question,0,list.get(position).getQuestion());

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                nextBtn.setEnabled(false);
                nextBtn.setAlpha(0.7f);
                enableoption(true);
                position++;
                if(position==list.size()){

                    Intent scoreIntent=new Intent(questions.this, mnstate.example.projecttwo.score.class);
                    scoreIntent.putExtra("Score",score);
                    scoreIntent.putExtra("total",list.size());
                    startActivity(scoreIntent);


                    //scoreActivity
                    return;
                }
                count=0;
                playAnim(question,0,list.get(position).getQuestion());
            }
        });

    }

    private void playAnim(final View view, final int value, final String data){
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).setStartDelay(100).
                setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                if (value==0 && count < 4 ){
                    String option="";
                    if(count==0){
                        option=list.get(position).getOptionA();

                    }
                    else if(count==1){ option=list.get(position).getOptionB();}
                    else if(count==2){ option=list.get(position).getOptionC();}
                    else if(count==3){ option=list.get(position).getOptionD();}

                    playAnim(optionsContainer.getChildAt(count),0,option);
                    count++;
                }

            }

            @Override
            public void onAnimationEnd(Animator animation) {



                if (value==0){
                    try {
                        ((TextView)view).setText(data);

                        noIndicator.setText(position+1+"/"+list.size());
                    }catch (ClassCastException ex){
                        ((Button)view).setText(data);
                    }
                    view.setTag(data);

                    playAnim(view,1,data);
                }

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void checkAnswer(Button Selectedoption){
        enableoption(false);
        nextBtn.setEnabled(true);
        nextBtn.setAlpha(1);



        if(Selectedoption.getText().toString().equals(list.get(position).getCorrectAns())){
            score++;
           Selectedoption.setBackgroundTintList(ColorStateList.valueOf(parseColor("#FF5EC262")));





        }
        else{
            Selectedoption.setBackgroundTintList(ColorStateList.valueOf(parseColor("#ff0000")));

            Button correctoption=(Button) optionsContainer.findViewWithTag(list.get(position).getCorrectAns());

            correctoption.setBackgroundTintList(ColorStateList.valueOf(parseColor("#FF5EC262")));




        }

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void enableoption(boolean enable ){
        for(int i=0;i<4;i++){
            optionsContainer.getChildAt(i).setEnabled(enable);
            if(enable){
                optionsContainer.getChildAt(i).setBackgroundTintList(ColorStateList.valueOf(parseColor("#FFF7EDED")));

            }
        }

    }
}
