package com.example.fermatsfactorizationmethod;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText input;
    private EditText calcTime;
    private EditText endResult;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onButtonClick(View v) {
        calcTime = findViewById(R.id.calcTime);
        endResult = findViewById(R.id.endResult);
        input = findViewById(R.id.number);
        button = findViewById(R.id.button);

        String result = factorize();
        String resTime = calculateTime();
        endResult.setText(result);
        calcTime.setText(resTime);

    }
    long start = System.currentTimeMillis();
    public String factorize() {
        String result = "";
        String text = input.getText().toString();

        if (text.isEmpty()){
            text = "0";
        }
        int n = Integer.parseInt(text);

        if (n <= 0) {
            result += n + " ";
            return result;
        }

        int square_root = (int) Math.ceil(Math.sqrt(n));

        if (square_root * square_root == n) {
            result += " " + square_root + ", " + square_root;
            return result;
        }

        int b;

        while (true) {
            int b1 = square_root * square_root - n;
            b = (int) (Math.sqrt(b1));

            if (b * b == b1)
                break;
            else
                square_root += 1;
        }
        result += " " + (square_root - b) + "," + (square_root + b) + " ";
        return result;
    }
    public String calculateTime(){
        String resTime = "";
        long end = System.currentTimeMillis();
        //finding the time difference and converting it into seconds
        float sec = (end - start) / 1000F;
        resTime = sec + " seconds";
        return resTime;
    }

}
