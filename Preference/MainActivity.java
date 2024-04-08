package com.example.preference;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.util.Log;
import android.content.SharedPreferences;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String PREFERENCE_NAME = "MyPreference";
    private static final String KEY_CHECK = "KeyCheck";
    private Dialog dialog;
    private CheckBox checkBox;

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
        boolean isChecked = loadPreference(KEY_CHECK);
        if (!isChecked){
            dialog = new Dialog(this);
            dialog.setContentView(R.layout.notification);
            dialog.show();
            checkBox = dialog.findViewById(R.id.checkbox);
            Button button = dialog.findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    boolean isChecked = checkBox.isChecked();
                    savePreference(KEY_CHECK, isChecked);
                }
            });
        }
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearPreferenece();
            }
        });
        return;
    }
    public void clearPreferenece(){
        SharedPreferences preferences = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
    }

    private boolean loadPreference(String key){
        SharedPreferences preferences = getSharedPreferences(PREFERENCE_NAME,MODE_PRIVATE);
        return  preferences.getBoolean(key,false);
    }

    private void savePreference(String key, boolean isChecked){
        SharedPreferences preferences = getSharedPreferences(PREFERENCE_NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, isChecked);
        editor.commit();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onStop");
    }
}