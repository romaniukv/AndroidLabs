package com.androidlabs.lab1;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Fragment2 extends Fragment {


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment2, container, false);


    }

    public void setText(int selectedFirm, int selectedTelephoneType) {
        TextView resultTextView = getView().findViewById(R.id.resultTextView);
        resultTextView.setText(Data.getFirmTelephoneNumber(Data.getFirms().get(selectedFirm),
                Data.getTelephoneTypes().get(selectedTelephoneType)));

    }



}
