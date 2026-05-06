package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Fragment2 extends Fragment {

    private OnboardingListener listener;
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextAge;
    private Spinner spinnerGender;
    private Button buttonContinue;

    public static Fragment2 newInstance(String name) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putString("name", name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnboardingListener) {
            listener = (OnboardingListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnboardingListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        editTextName = view.findViewById(R.id.editTextName);
        editTextEmail = view.findViewById(R.id.editTextEmail);
        editTextAge = view.findViewById(R.id.editTextAge);
        spinnerGender = view.findViewById(R.id.spinnerGender);
        buttonContinue = view.findViewById(R.id.buttonContinueFragment2);

        if (getArguments() != null) {
            String name = getArguments().getString("name");
            if (name != null) {
                editTextName.setText(name);
            }
        }

        buttonContinue.setOnClickListener(v -> {
            String name = editTextName.getText().toString();
            String email = editTextEmail.getText().toString();
            String ageStr = editTextAge.getText().toString();
            Integer age = ageStr.isEmpty() ? null : Integer.parseInt(ageStr);
            String gender = spinnerGender.getSelectedItem().toString();

            if (listener != null) {
                listener.onFragment2DataCollected(name, email, gender, age);
            }
        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
