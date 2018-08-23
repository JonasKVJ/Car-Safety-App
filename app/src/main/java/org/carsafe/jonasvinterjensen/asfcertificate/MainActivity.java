package org.carsafe.jonasvinterjensen.asfcertificate;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.graphics.TypefaceCompatUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    public int choice = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toastOnClick(View view)
    {
        //Toast myToast = Toast.makeText(this, message, duration);
        Toast myToast = Toast.makeText(this, "Testing how toasts works",
                Toast.LENGTH_SHORT);
        myToast.show();
    }

    public void answer1_OnClick(View view)
    {
        String selectedTextView = "";

        //Create an Intent object, which is required for a new activity
        Intent answerIntent = new Intent(this, Q1_Feedback.class);
        startActivity(answerIntent);
        TextView textview = (TextView) view;
        selectedTextView = textview.getText().toString();
        //This will work in an OnlickListener, using a RecyclerView
        System.out.println("\tSelected textView: \t" + selectedTextView);
    }
}
