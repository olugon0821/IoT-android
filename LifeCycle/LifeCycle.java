package com.example.activitylifecycle;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.util.Log;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(intent);
            }
        });
        Log.i("test","onCreate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("test","onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("test","onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("test","onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("test","onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("test","onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("test","onRestart");
    }
}
