package com.labs.lab3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.androidlabs.lab3.R;

public class SecondActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.textView);

        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS questions (result TEXT)");
        Cursor query = db.rawQuery("SELECT * FROM questions;", null);

        if(query.moveToFirst()){
            do{
                String result = query.getString(0);
                textView.append(result + "\n");
            }
            while(query.moveToNext());
        }
        else
        {
            textView.append("Database is empty");
        }
        query.close();
    }
}
