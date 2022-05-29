package edu.qc.seclass.tipcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void clickHandler(View v){

        String tempTotal = ((EditText)findViewById(R.id.checkAmountValue)).getText().toString();
        String tempParty = ((EditText)findViewById(R.id.partySizeValue)).getText().toString();

        if(tempTotal.length()==0||tempParty.length()==0){//if the checkamount or party is null
            Toast.makeText(getApplicationContext(), "Invalid input", Toast.LENGTH_SHORT).show();

        }

    else {

            Double total = Double.parseDouble(tempTotal);//holds total
            int party = Integer.parseInt(tempParty);//holds party size

            if (total <= 0 || party <= 0) {//if the checkamount or party is 0
                Toast.makeText(getApplicationContext(), "Invalid input", Toast.LENGTH_SHORT).show();

            } else {
                int fifteenPercentTip = (int) Math.round((total * 0.15) / party);//calculates 15% tip
                int twentyPercentTip = (int) Math.round((total * 0.2) / party);//calculates 20% tip
                int twentyfivePercentTip = (int) Math.round((total * 0.25) / party);//calculates 25% tip

                //the value for each person
                int fifteenPTotal = (int) Math.round((total / party) + fifteenPercentTip);
                int twentyPTotal = (int) Math.round((total / party) + twentyPercentTip);
                int twentyfivePTotal = (int) Math.round((total / party) + twentyfivePercentTip);


                ((TextView) findViewById(R.id.fifteenPercentTipValue)).setText(Integer.toString(fifteenPercentTip));//displays the 15% tip
                ((TextView) findViewById(R.id.twentyPercentTipValue)).setText(Integer.toString(twentyPercentTip));//displays 20% tip
                ((TextView) findViewById(R.id.twentyfivePercentTipValue)).setText(Integer.toString(twentyfivePercentTip));//displays 25% tip


                ((TextView) findViewById(R.id.fifteenPercentTotalValue)).setText(Integer.toString(fifteenPTotal));//displays total with 15% tip
                ((TextView) findViewById(R.id.twentyPercentTotalValue)).setText(Integer.toString(twentyPTotal));//displays total with 20% tip
                ((TextView) findViewById(R.id.twentyfivePercentTotalValue)).setText(Integer.toString(twentyfivePTotal));//displays total with 25% tip
            }
        }


    }
}