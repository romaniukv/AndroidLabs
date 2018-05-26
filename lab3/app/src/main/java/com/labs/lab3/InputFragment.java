package com.labs.lab3;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.androidlabs.lab3.R;


public class InputFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    private RadioButton yesRadioBtn;
    private RadioButton noRadioBtn;
    private TextInputLayout textInputLayout;
    private String answer;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container, false);
        yesRadioBtn = view.findViewById(R.id.yesRadioBtn);
        yesRadioBtn.setOnClickListener(new YesRadioButtonListener());

        noRadioBtn = view.findViewById(R.id.noRadioBtn);
        noRadioBtn.setOnClickListener(new NoRadioButtonListener());

        textInputLayout = view.findViewById(R.id.textInputLayout);

        Button button = view.findViewById(R.id.okButton);
        button.setOnClickListener(new ButtonClickListener());

        return view;
    }

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(String text);
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

    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            StringBuffer stringBuffer = new StringBuffer();
            EditText editText = textInputLayout.getEditText();
            String question;
            if (editText == null) {
                mListener.onFragmentInteraction("Введіть питання!");

            } else if ((question = editText.getText().toString()).compareTo("") == 0) {
                mListener.onFragmentInteraction("Введіть питання!");
            } else if (answer == null) {
                mListener.onFragmentInteraction("Оберіть відповідь!");
            } else {
                stringBuffer.append("Введене питання: ").append(question).append("\n");
                stringBuffer.append("Відповідь: ").append(answer).append("\n");
                mListener.onFragmentInteraction(String.valueOf(stringBuffer));
            }
        }
    }

    private class YesRadioButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            answer = "Так";
        }
    }

    private class NoRadioButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            answer = "Ні";
        }
    }

}
