package com.example.lab1;


import android.app.Activity;
import android.graphics.Typeface;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.content.Context;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.Date;

public class MainFragment extends Fragment {
    public  String Font  = "";
    public RadioGroup radGrp ;
    private OnFragmentInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       final   View view = inflater.inflate(R.layout.main_fragment, container, false);

        Button buttonOK = (Button) view.findViewById(R.id.ButtonOk);
        Button buttonCancel = (Button) view.findViewById(R.id.ButtonCancel) ;
        // получаем объект RadioGroup
        radGrp = (RadioGroup)view.findViewById(R.id.radios);
        // обработка переключения состояния переключателя
        radGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int id) {

                switch(id) {
                    case R.id.amatic:
                        Font = "AmaticSC-Regular.ttf";
                        break;
                    case R.id.antonio:
                        Font = "Antonio-Regular.ttf";
                        break;
                    case R.id.lato:
                        Font = "Lato-Regular.ttf";
                        break;
                    case R.id.pacifico:
                        Font = "Pacifico.ttf";
                        break;
                    default:
                        break;
                }

            }});

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MakeProgramm(view);
            }
        });
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackProgramm(view);
            }
        });

        return view;
    }

    interface OnFragmentInteractionListener {

        void onFragmentInteraction(String link);
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



    public void MakeProgramm(View view){
        String outInformation = "";
        TextView answer=(TextView)getView().findViewById(R.id.andStr);
        if(!Font.equals("")) {
            TextView tv = (TextView) getView().findViewById(R.id.mainStr);
            String message = tv.getText().toString();
            if (!message.equals("")) {
                outInformation= Font +"\n"+message;
                mListener.onFragmentInteraction(outInformation);
            } else {
                mListener.onFragmentInteraction("1");
            }
        }
        else{
            mListener.onFragmentInteraction("0");
        }
    }

    public void BackProgramm(View view){
        radGrp.clearCheck();//check(R.id.end);
        Font = "";
        mListener.onFragmentInteraction("2");
        TextView tv=(TextView)getView().findViewById(R.id.mainStr);
        tv.setText("");
    }

}