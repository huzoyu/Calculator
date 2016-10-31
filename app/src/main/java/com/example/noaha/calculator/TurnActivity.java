package com.example.noaha.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TurnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turn);

        Button btnLength = (Button) findViewById(R.id.buttonLength);
        Button btnSystem = (Button) findViewById(R.id.buttonSystem);

        btnLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TurnActivity.this,LengthActivity.class);
                startActivity(intent);
            }
        });

        btnSystem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TurnActivity.this,SystemActivity.class);
                startActivity(intent);
            }
        });
    }
}
