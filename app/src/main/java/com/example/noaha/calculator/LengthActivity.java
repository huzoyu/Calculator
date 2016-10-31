package com.example.noaha.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LengthActivity extends AppCompatActivity {

    List<String> list = new ArrayList<>();
    ArrayAdapter<String> adapter;
    Spinner sIn;
    Spinner sOut;

    EditText etInput;
    TextView tvOutput;
    Button btnTurn;
    String strInput;

    double num1 =0;
    double num2 =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        list.add("千米");
        list.add("米");
        list.add("厘米");
        list.add("毫米");


        sIn = (Spinner) findViewById(R.id.spinnerInput);
        sOut = (Spinner) findViewById(R.id.spinnerOutput);
        btnTurn = (Button) findViewById(R.id.buttonTurn);
        etInput = (EditText) findViewById(R.id.txtInput);
        tvOutput = (TextView) findViewById(R.id.txtOutput);


        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



        sIn.setAdapter(adapter);
        sOut.setAdapter(adapter);

        btnTurn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int si = sIn.getSelectedItemPosition();
                int so = sOut.getSelectedItemPosition();

                strInput = etInput.getText().toString();


                switch(si){
                    case 0:
                        num1 = 1000;
                        break;
                    case 1:
                        num1 = 1;
                        break;
                    case 2:
                        num1 = 0.01;
                        break;
                    case 3:
                        num1 = 0.001;
                }

                switch(so){
                    case 0:
                        num2 = 1000;
                        break;
                    case 1:
                        num2 = 1;
                        break;
                    case 2:
                        num2 = 0.01;
                        break;
                    case 3:
                        num2 = 0.001;
                }

                if(!strInput.equals("")||strInput==null){
                    double in = Double.parseDouble(strInput);
                    double result = in*num1/num2;
                    String resultString = result + "";
                    tvOutput.setText(resultString);
                }
            }
        });

    }
}
