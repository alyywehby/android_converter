package com.example.aliwehbi.convertermobapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Temperature extends AppCompatActivity {

    private Button btnCalculate;
    private EditText value;
    private EditText result;

    private Spinner spfrom, spto;

    double num1,num2;
    int from, to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        value=(EditText)findViewById(R.id.ETvalue);
        result = (EditText)findViewById(R.id.ETresult);
        btnCalculate = (Button)findViewById(R.id.btnCalculate);
        spfrom = (Spinner)findViewById(R.id.SPfrom);
        spto = (Spinner)findViewById(R.id.SPto);

        spfrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                from = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                to = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Integer.parseInt(value.getText().toString());
                if(from==0 || to==0){
                    Toast.makeText(Temperature.this, "Please Enter Units", Toast.LENGTH_LONG).show();
                }
                else if(from==to){
                    num2 = num1;
                    result.setText(num2 + "");
                }
                else if(from==1){
                    if(to==2){
                        num2 = (num1*9/5) + 32;
                        result.setText(num2 + " °F");
                    }
                    else if(to==3){
                        num2 = num1+ 273.15;
                        result.setText(num2 + " K");
                    }
                }
                else if(from==2){
                    if(to==1){
                        num2 = (num1-32) * 5/9;
                        result.setText(num2 + " °C");
                    }
                    else if(to==3){
                        num2 = (num1-32) * 5/9 + 273.15;
                        result.setText(num2 + " K");
                    }
                }
                else if(from==3){
                    if(to==1){
                        num2 = num1 - 273.15;
                        result.setText(num2 + " °C");
                    }
                    else if(to==2){
                        num2 = (num1 - 273.15) * 9/5 + 32;
                        result.setText(num2 + " °F");
                    }
                }
            }
        });
    }
}
