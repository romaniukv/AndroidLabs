package com.labs.lab3;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.androidlabs.lab3.R;

public class Fragment1 extends Fragment {

    private OnFragmentInteractionListener mListener;

    private Spinner dropdown1;
    private Spinner dropdown2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);
        dropdown1 = view.findViewById(R.id.firmSpinner);

        dropdown1.setAdapter(new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, Data.getFirms()));

        dropdown2 = view.findViewById(R.id.telephoneSpinner);
        dropdown2.setAdapter(new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, Data.getTelephoneTypes()));

        Button btn = view.findViewById(R.id.button);
        btn.setOnClickListener(new OnClickListener());
        return view;
    }

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(int selectedFirm, int selectedTelephoneType);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс OnFragmentInteractionListener");
        }
    }

    private class OnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            mListener.onFragmentInteraction(dropdown1.getSelectedItemPosition(),dropdown2.getSelectedItemPosition());
        }
    }
}
