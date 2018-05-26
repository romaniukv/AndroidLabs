package com.androidlabs.lab1;

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

public class Fragment1 extends Fragment {

    private OnFragmentInteractionListener mListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);
        Spinner dropdown1 = view.findViewById(R.id.firmSpinner);

        dropdown1.setAdapter(new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, Data.getFirms()));

        Spinner dropdown2 = view.findViewById(R.id.telephoneSpinner);
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
            Spinner dropdown1 = v.findViewById(R.id.firmSpinner);
            Spinner dropdown2 = v.findViewById(R.id.telephoneSpinner);
            mListener.onFragmentInteraction(dropdown1.getSelectedItemPosition(),dropdown2.getSelectedItemPosition());
        }
    }
}
