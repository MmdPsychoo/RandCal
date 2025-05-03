package com.example.randcal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtResult = findViewById(R.id.txtResult);

        Intent intent = getIntent();
        int num1 = intent.getIntExtra("num1", 0);
        int num2 = intent.getIntExtra("num2", 0);
        String op = intent.getStringExtra("operation");
        int result = intent.getIntExtra("result", 0);

        txtResult.setText(num1 + " " + op + " " + num2 + " = " + result);

        // برگشت به صفحه اصلی بعد از ۵ ثانیه
        new Handler().postDelayed(() -> {
            Intent back = new Intent(ResultActivity.this, MainActivity.class);
            back.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(back);
            finish();
        }, 5000);
    }
}
