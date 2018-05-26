package com.labs.lab3;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.androidlabs.lab3.R;

public class MainActivity extends AppCompatActivity implements Fragment1.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onFragmentInteraction(int selectedFirm, int selectedTelephoneType) {

        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS telephones (result TEXT)");
        ContentValues contentValues = new ContentValues();
        String text = Data.getFirmTelephoneNumber(Data.getFirms().get(selectedFirm),
                Data.getTelephoneTypes().get(selectedTelephoneType));
        contentValues.put("result", text);

        db.insert("telephones", null, contentValues);

        db.close();

        Fragment2 fragment = (Fragment2) getFragmentManager().findFragmentById(R.id.resultFragment);
        if (fragment != null && fragment.isInLayout()) {
            fragment.setText(selectedFirm, selectedTelephoneType);
        }
    }
}
