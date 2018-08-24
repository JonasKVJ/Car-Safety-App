package org.carsafe.jonasvinterjensen.asfcertificate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Q1_Feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q1__feedback);
    }

    public void backOnClick(View view)
    {
        Intent goBack = new Intent(this, MainActivity.class);
        startActivity(goBack);
    }
}
