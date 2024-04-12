package com.example.customlistview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private KaTalkListView listView;
    private KaTalkAdapter adapter;

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

        listView = (KaTalkListView)findViewById(R.id.listView);

        adapter = new KaTalkAdapter(this);

        adapter.addItem(R.drawable.image_1,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_2,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_3,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_4,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_5,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_6,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_7,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_8,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_1,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_2,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_3,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_4,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_5,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_6,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_7,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_8,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_1,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_2,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_3,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_4,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_5,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_6,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_7,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_8,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_1,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_2,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_3,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_4,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_5,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_6,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_7,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_8,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_1,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_2,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_3,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_4,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_5,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_6,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_7,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_8,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_1,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_2,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_3,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_4,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_5,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_6,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_7,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_8,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_1,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_2,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_3,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_4,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_5,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_6,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_7,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_8,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_1,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_2,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_3,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_4,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_5,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_6,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_7,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_8,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_1,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_2,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_3,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_4,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_5,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_6,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_7,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_8,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_1,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_2,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_3,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_4,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_5,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_6,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_7,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_8,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_1,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_2,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_3,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_4,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_5,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_6,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_7,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_8,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_1,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_2,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_3,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_4,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_5,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_6,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_7,"onekick","Hello Good Day");
        adapter.addItem(R.drawable.image_8,"onekick","Hello Good Day");

        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}