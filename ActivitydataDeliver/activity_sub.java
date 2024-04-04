package com.example.activitydatadeliver;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

public class activity_sub extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();
        String msg = intent.getStringExtra(MainActivity.TAG_MSG);
        editText = (EditText)findViewById(R.id.editText);
        editText.setText(msg);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                String msg = editText.getText().toString();
                intent.putExtra(MainActivity.TAG_MSG, msg);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}