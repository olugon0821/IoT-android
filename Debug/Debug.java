package com.example.debug;

import android.support.v4.app.RemoteActionCompatParcelizer;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        int result = 0;
        int a = 2;
        int b = 3;
        int c = 5;
        result = a << 2;
        result += b;
        result = (result+c) >> 1;
        result = add(result, 3);
        textView.setText(String.valueOf(result));
    }
    int add(int a, int b) {
        int sum = 0;
        sum = a;
        sum += b;
        return sum;
    }
}
