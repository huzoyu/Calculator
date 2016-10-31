package com.example.noaha.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SystemActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_system);

        list.add("二进制");
        list.add("十进制");

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

                if(!strInput.equals("")||strInput==null){
                    if(si==so){
                        tvOutput.setText(strInput);
                    }else if(si==0){
                        int i = Integer.parseInt(strInput,2);
                        tvOutput.setText(i + "");
                    }else if(si==1){
                        int i = Integer.parseInt(strInput);
                        String out = Integer.toBinaryString(i);
                        tvOutput.setText(out);
                    }
                }
            }
        });


    }
}
