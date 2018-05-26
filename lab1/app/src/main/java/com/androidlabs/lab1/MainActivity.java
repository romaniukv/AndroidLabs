package com.androidlabs.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String selectedFirm;
    private String selectedTelephoneType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner dropdown1 = findViewById(R.id.firmSpinner);
        dropdown1.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Data.getFirms()));
        dropdown1.setOnItemSelectedListener(new FirmSelectedListener());

        Spinner dropdown2 = findViewById(R.id.telephoneSpinner);
        dropdown2.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Data.getTelephoneTypes()));
        dropdown2.setOnItemSelectedListener(new TelophoneTypeSelectedListener());

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new OnClickListener());
    }

    private class FirmSelectedListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            selectedFirm = Data.getFirms().get(position);

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    public class TelophoneTypeSelectedListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            selectedTelephoneType = Data.getTelephoneTypes().get(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class OnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            TextView resultTextView = findViewById(R.id.resultTextView);
            resultTextView.setText(Data.getFirmTelephoneNumber(selectedFirm, selectedTelephoneType));
        }
    }

}
