package com.labs.lab3;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.androidlabs.lab3.R;


public class Fragment2 extends Fragment {


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);

        Button button = view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                startActivity(intent);
            }
        });

        return view;

    }

    public void setText(int selectedFirm, int selectedTelephoneType) {
        TextView resultTextView = getView().findViewById(R.id.resultTextView);
        resultTextView.setText(Data.getFirmTelephoneNumber(Data.getFirms().get(selectedFirm),
                Data.getTelephoneTypes().get(selectedTelephoneType)));

    }



}
