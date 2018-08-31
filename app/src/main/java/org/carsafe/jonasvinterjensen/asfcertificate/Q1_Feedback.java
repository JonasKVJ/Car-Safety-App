package org.carsafe.jonasvinterjensen.asfcertificate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Q1_Feedback extends AppCompatActivity {

    protected int choice = 0;
    protected boolean timerRanOut = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q1__feedback);


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

        TextView choiceView = findViewById(R.id.Answer);
        //Feedback will be given based on the answer, iff the user answered before the timer ran out
        if(!timerRanOut)
        {
            if(choice == 1)
            {
                choiceView.setText(R.string.answer1);
            }
            else if(choice == 2)
            {
                choiceView.setText(R.string.answer2);
            }
            else if(choice == 3)
            {
                choiceView.setText(R.string.answer3);
            }
        }
        else
        {
            choiceView.setText(R.string.timeRanOut);
        }

    }

    public void backOnClick(View view)
    {
        Intent goBack = new Intent(this, MainActivity.class);
        startActivity(goBack);
    }
}
