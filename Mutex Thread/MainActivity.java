package com.example.mutex_thread;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.TextView;
import java.util.concurrent.Semaphore;

public class MainActivity extends AppCompatActivity {
    private int number = 0;
    private TextView textView;
    private Semaphore semaphore = new Semaphore(1);

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

        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    semaphore.acquire();
                    for(int i = 0; i<1000000000; i++) number++;
                    semaphore.release();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText((""+number));
                    }
                });
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    semaphore.acquire();
                    for (int i = 0; i<1000000000; i++) number--;
                    semaphore.release();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(""+number);
                    }
                });
            }
        }.start();
    }
}