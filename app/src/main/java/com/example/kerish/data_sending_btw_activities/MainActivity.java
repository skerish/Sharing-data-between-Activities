package com.example.kerish.data_sending_btw_activities;

import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private EditText num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text);
        num1 = (EditText) findViewById(R.id.input1);
        num2 = (EditText) findViewById(R.id.input2);
        button = (Button) findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(num1.getText().toString().equals("") || num2.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Enter Number First", Toast.LENGTH_SHORT).show();
                }
                else{
                    int n1 = Integer.parseInt(num1.getText().toString());
                    int n2 = Integer.parseInt(num2.getText().toString());

                    Intent jerry = new Intent(MainActivity.this, Main2Activity.class);
                    jerry.putExtra("Number1_ID", n1);
                    jerry.putExtra("Number2_ID", n2);
                    startActivityForResult(jerry, 100);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100){
            if(resultCode == RESULT_OK){
                int num = data.getIntExtra("Result_ID", 0);
                textView.setText("Result : " + num);
            }
            else if(resultCode == RESULT_CANCELED){
                Toast.makeText(getApplicationContext(), "No Action Selected !", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
