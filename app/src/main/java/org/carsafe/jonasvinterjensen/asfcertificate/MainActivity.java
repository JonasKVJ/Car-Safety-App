package org.carsafe.jonasvinterjensen.asfcertificate;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.v4.graphics.TypefaceCompatUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
{

    //The countdown timer for each question, which will last 30 seconds
    //private CountDownTimer questionTimer;
    private int countDownIntervalSec = 1;
    private int timerLengthSec = 30;
    public int choice = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //startTimer();
    }

    //Start timer
    /*void startTimer()
    {
        TextView timerView = findViewById(R.id.Timer);

        CountDownTimer questionTimer = new CountDownTimer(timerLengthSec*1000, countDownIntervalSec*1000)
        {
            //Called on every CountDownInterval, once per second
            @Override
            public void onTick(long remainingMilliSec)
            {
                int remainingSec = (int) remainingMilliSec/1000;
                timerView.setText(remainingSec);
            }

            @Override
            public void onFinish()
            {
                timerView.setText("Done!");
            }
        };
        questionTimer.start();
    }*/

    public void toastOnClick(View view)
    {
        //Toast myToast = Toast.makeText(this, message, duration);
        Toast myToast = Toast.makeText(this, "Testing how toasts works",
                Toast.LENGTH_SHORT);
        myToast.show();
    }

    public void answer_OnClick(View view)
    {
        //Create an Intent object, in order to start the new activity
        Intent answerIntent = new Intent(this, Q1_Feedback.class);

        //Get the ID of the clicked answer button
        String viewID = getResources().getResourceName(view.getId());

        String answer1_ID = "org.carsafe.jonasvinterjensen.asfcertificate:id/Answer1";
        String answer2_ID = "org.carsafe.jonasvinterjensen.asfcertificate:id/Answer2";
        String answer3_ID = "org.carsafe.jonasvinterjensen.asfcertificate:id/Answer3";
        if (viewID.equals(answer1_ID))
        {
            choice = 1;
        }
        else if (viewID.equals(answer2_ID))
        {
            choice = 2;
        }
        else if (viewID.equals(answer3_ID))
        {
            choice = 3;
        }
        if (choice != 0)
        {
            //Ready the the selected answer for transfer to the upcoming activity
            answerIntent.putExtra("selectedAnswer", choice);
        }


        startActivity(answerIntent);
    }

}
