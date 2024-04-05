package com.example.handler;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    public static final long DELAY_MS = 100;
    public static final int WHAT_PROGRESS = 1;
    private ProgressBar progressBar;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(progressBar.getProgress()>0){
                progressBar.setProgress(progressBar.getProgress()-1);
                handler.sendEmptyMessageDelayed(WHAT_PROGRESS, DELAY_MS);
            }
            else{
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivity(intent);
            }
        }
    };

    private void stopHandler() {
        handler.removeCallbacksAndMessages(null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        handler.sendEmptyMessageDelayed(WHAT_PROGRESS,DELAY_MS);


        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopHandler();
            }
        });

        Button button1 = (Button)findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}