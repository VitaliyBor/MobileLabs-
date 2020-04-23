package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // получаем объект RadioGroup

    }

    public void onFragmentInteraction(String link) {
        AnswerFragment fragment = (AnswerFragment) getFragmentManager()
                .findFragmentById(R.id.answer_fragment);
        if (fragment != null && fragment.isInLayout()) {
            fragment.setText(link);
        }
    }



}
