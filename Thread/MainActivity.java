package com.example.threadfunction;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private Thread thread;
    private Thread thread2;
    private TextView textView;
    private TextView textView2;
    private int number = 0;
    private int number2 = 10000;

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
        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);

        thread = new Thread(){
            @Override
            public void run() {
                super.run();
                while (true){
                    try {
                        sleep(500);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    number ++;
                    Log.i("test","thread running..."+number);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(String.valueOf(number));
                        }
                    });
                }
            }
        };
        thread.start();

        thread2 = new Thread(){
            @Override
            public void run() {
                super.run();
                while (true){
                    try {
                        sleep(500);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    number2--;
                    Log.i("test","Thread running..."+number2);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView2.setText(String.valueOf(number2));
                        }
                    });
                }
            }
        };
        thread2.start();
        }
    }