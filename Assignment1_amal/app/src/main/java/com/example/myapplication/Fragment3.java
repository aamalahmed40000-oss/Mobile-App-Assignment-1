package com.example.myapplication;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class Fragment3 extends Fragment {

    private TextView textViewWelcome;
    private CheckBox checkBoxConfirm;
    private Button buttonAction;

    public static Fragment3 newInstance(String userName) {
        Fragment3 fragment = new Fragment3();
        Bundle args = new Bundle();
        args.putString("userName", userName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_3, container, false);

        textViewWelcome = view.findViewById(R.id.textViewWelcome);
        checkBoxConfirm = view.findViewById(R.id.checkBoxConfirm);
        buttonAction = view.findViewById(R.id.buttonAction);

        if (getArguments() != null) {
            String name = getArguments().getString("userName");
            if (name != null) {
                textViewWelcome.setText("أهلاً بك، " + name + "!");
            }
        }

        buttonAction.setEnabled(checkBoxConfirm.isChecked());

        checkBoxConfirm.setOnCheckedChangeListener((buttonView, isChecked) -> {
            buttonAction.setEnabled(isChecked);
            if (isChecked) {
                buttonAction.setText("إنهاء");
            } else {
                buttonAction.setText("متابعة");
            }
        });

        return view;
    }
}
