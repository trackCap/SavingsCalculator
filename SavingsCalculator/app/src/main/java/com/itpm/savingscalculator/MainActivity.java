package com.itpm.savingscalculator;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    private SeekBar seekBar;
    private TextView spendingBudgetB, totalSavingsB;
    private EditText userIncomeB;
    private EditText timePeriodB;
    private int totalSavingsAC;
    private Button calculateB;


    int userIncome;
    //Editable getUserIncome = userIncomeB.getText();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spendingBudgetB = (TextView) findViewById(R.id.spendingBudgetB);
        seekBar =(SeekBar) findViewById(R.id.seekBar);
        totalSavingsB = (TextView) findViewById(R.id.totalSavingsB);
        userIncomeB =(EditText) findViewById(R.id.userIncomeB);
        calculateB = (Button) findViewById(R.id.resetButtonB);
        timePeriodB=(EditText) findViewById(R.id.timePeriodB);






        //setup seekBar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                //display changes on seekBar


                spendingBudgetB.setText("Per week savings:\n"+progress+"%");


                //calculate and display the savings




            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar){

            }
        });




        calculateB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userIncomeB.getText().toString().equals("")||timePeriodB.getText().equals("")){
                    Toast.makeText(MainActivity.this,"Please enter Details Above", Toast.LENGTH_SHORT).show();

                }
                else{
                    userIncomeB.getText().toString();
                    timePeriodB.getText().toString();
                    double a1=Double.valueOf(userIncomeB.getText().toString());
                    double a2=Double.valueOf(timePeriodB.getText().toString());
                    double a3;
                    a3 = a1+a2;

                    totalSavingsB.setText(String.valueOf(a3));
                }
            }
        });



        //setup edit text

        totalSavingsB.addTextChangedListener(new TextWatcher(){


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                //calculate max amount allowed on seekbar

                int maxSavingsAllowed = userIncome/(1/3);

                 seekBar.setMax(maxSavingsAllowed);

            }
        });


    }
}
