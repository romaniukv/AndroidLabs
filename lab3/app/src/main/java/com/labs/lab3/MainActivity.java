package com.labs.lab3;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.androidlabs.lab3.R;


public class MainActivity extends AppCompatActivity implements InputFragment.OnFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onFragmentInteraction(String text) {
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS questions (result TEXT)");
        ContentValues contentValues = new ContentValues();

        contentValues.put("result", text);

        db.insert("questions", null, contentValues);

        db.close();

        Result fragment = (Result) getFragmentManager().findFragmentById(R.id.resultFragment);
        if (fragment != null && fragment.isInLayout()) {
            fragment.setText(text);
        }
    }
}
