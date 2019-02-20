package com.example.kerish.data_sending_btw_activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setTitle("Activity 2");

        Intent jerry = getIntent();

        final int num1 = jerry.getIntExtra("Number1_ID", 0);
        final int num2 = jerry.getIntExtra("Number2_ID", 0);

        TextView textView1 = (TextView) findViewById(R.id.t1);
        TextView textView2 = (TextView) findViewById(R.id.t2);
        Button btn_add = (Button) findViewById(R.id.add);
        Button btn_sub = (Button) findViewById(R.id.sub);

        textView1.setText("Number 1 : " + num1);
        textView2.setText("Number 2 : " + num2);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = num1 + num2;

                Intent jj = new Intent();
                jj.putExtra("Result_ID", result);
                setResult(RESULT_OK, jj);               // To define what our MainActivity will get after calling setActivityForResult.
                finish();                               // RESULT_OK is a request code for a successful result.
            }
        });

        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = num1 - num2;

                Intent jj = new Intent();
                jj.putExtra("Result_ID", result);
                setResult(RESULT_OK, jj);
                finish();
            }
        });

    }
}
