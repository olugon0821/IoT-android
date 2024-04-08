package com.example.db_sqlite;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TextView;
import static com.example.db_sqlite.DBOpenHelper.TABLE_NAME;
import static com.example.db_sqlite.DBOpenHelper.TIME;
import static com.example.db_sqlite.DBOpenHelper.TITLE;
import static com.example.db_sqlite.DBOpenHelper._ID;

public class MainActivity extends AppCompatActivity {
    private static final String DB_NAME = "MyDB";
    private static final int DB_VERSION = 1;
    private DBOpenHelper openHelper;

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
        openHelper = new DBOpenHelper(this, DB_NAME, null, DB_VERSION);
        writeDB("Hello World!");
        Cursor cursor = readDB();
        displayDB(cursor);
        openHelper.close();
    }

    private void displayDB(Cursor cursor){
        StringBuilder builder = new StringBuilder("Saved DB: \n");
        while (cursor.moveToNext()){
            long id = cursor.getLong(0);
            long time = cursor.getLong(1);
            String title = cursor.getString(2);
            builder.append(id).append(": ");
            builder.append(time).append(": ");
            builder.append(title).append("\n");
        }
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(builder);
    }

    private  Cursor readDB(){
        SQLiteDatabase db = openHelper.getReadableDatabase();
        String[] from = {_ID, TIME, TITLE, };
        Cursor cursor = db.query(TABLE_NAME, from, null, null, null, null, TIME + " " +"DESC");
        startManagingCursor(cursor);
        return cursor;
    }

    private void writeDB(String title){
        SQLiteDatabase db = openHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TIME, System.currentTimeMillis());
        values.put(TITLE, title);
        db.insertOrThrow(TABLE_NAME, null , values);
    }
}