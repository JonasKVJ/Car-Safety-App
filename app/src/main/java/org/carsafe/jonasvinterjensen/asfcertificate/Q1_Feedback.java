package org.carsafe.jonasvinterjensen.asfcertificate;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class Q1_Feedback extends AppCompatActivity {

    protected int choice = 0;
    protected boolean isAnswerCorrect = false;
    protected boolean timerRanOut = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle bundle = getIntent().getExtras();
        try
        {
            //Android Studio warning: getInt() might throw NullPointerException
            choice = bundle.getInt("selectedAnswer");
        }
        catch(NullPointerException e)
        {
            timerRanOut = true;
        }
        if(choice==2)
        {
            setTheme(R.style.correctAnswerTheme);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q1__feedback);




        TextView feedbackTitle = findViewById(R.id.q1feedback_title);
        TextView choiceView = findViewById(R.id.Answer);
        View root = choiceView.getRootView();


        //Feedback will be given based on the answer, iff the user answered before the timer ran out
        if(!timerRanOut)
        {
            if(choice == 1)
            {
                choiceView.setText(R.string.answer1);
                feedbackTitle.setText("Incorrect");
                feedbackTitle.setTextColor(Color.parseColor("#000000"));
                //set background to red, since the answer was wrong
                root.setBackgroundColor(Color.parseColor("#e57979"));
            }
            else if(choice == 2)
            {
                feedbackTitle.setText("Correct");
                feedbackTitle.setTextColor(Color.parseColor("#000000"));

                //Set Toolbar color to black, because the rest of the screen will be green
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
                root.setBackgroundColor(Color.parseColor("#68c17b"));


                choiceView.setText(R.string.answer2);
            }
            else if(choice == 3)
            {
                feedbackTitle.setText("Incorrect");
                feedbackTitle.setTextColor(Color.parseColor("#000000"));
                //set background to red, since the answer was wrong
                root.setBackgroundColor(Color.parseColor("#e57979"));

                choiceView.setText(R.string.answer3);
            }
        }
        //Timer ran out
        else
        {
            choiceView.setText(R.string.timeRanOut);
            feedbackTitle.setTextColor(Color.parseColor("#000000"));

            //Set Toolbar color to black, because the rest of the screen will be green
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
            root.setBackgroundColor(Color.parseColor("#e57979"));

        }

    }

    public void backOnClick(View view)
    {
        Intent goBack = new Intent(this, MainActivity.class);
        startActivity(goBack);
    }
}
