package com.androidlabs.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment1.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onFragmentInteraction(int selectedFirm, int selectedTelephoneType) {
        Fragment2 fragment = (Fragment2) getFragmentManager().findFragmentById(R.id.resultFragment);
        if (fragment != null && fragment.isInLayout()) {
            fragment.setText(selectedFirm, selectedTelephoneType);
        }
    }
}
