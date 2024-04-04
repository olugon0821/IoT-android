package com.example.activitydatadeliver;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.SubMenu;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 1;
    public static final String TAG_MSG = "message";
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        Button button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, activity_sub.class);
                String msg = editText.getText().toString();
                editText.setText("");
                intent.putExtra(TAG_MSG,msg);
               startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String msg = data.getStringExtra(TAG_MSG);
        editText.setText(msg);
    }
}