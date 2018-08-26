package org.carsafe.jonasvinterjensen.asfcertificate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Q1_Feedback extends AppCompatActivity {

    public int choice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q1__feedback);


        Bundle bundle = getIntent().getExtras();
        try
        {
            choice = bundle.getInt("selectedAnswer");
        }
        catch(NullPointerException e)
        {
            System.err.println("Caught NullPointerException" + e.getMessage());
            Toast myToast = Toast.makeText(this, "NullPointerException!",
                    Toast.LENGTH_SHORT);
            myToast.show();
            finish();
        }


        TextView choiceView = findViewById(R.id.Answer);

        if(choice==1)
        {
            choiceView.setText(R.string.answer1);
        }
        else if(choice==2)
        {
            choiceView.setText(R.string.answer2);
        }
        else if(choice==3)
        {
            choiceView.setText(R.string.answer3);
        }
    }

    public void backOnClick(View view)
    {
        Intent goBack = new Intent(this, MainActivity.class);
        startActivity(goBack);
    }
}
