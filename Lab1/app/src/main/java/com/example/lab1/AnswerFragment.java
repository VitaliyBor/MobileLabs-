package com.example.lab1;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AnswerFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.answer_fragment, container, false);
        return view;
    }

    // обновление текстового поля
    public void setText(String item) {
        TextView answer = (TextView) getView().findViewById(R.id.andStr);
        if( item.equals("1")||item.equals("0")|| item.equals("2"))
        {
            answer.setTypeface(null);
            answer.setText(Listener(item));
        } else{
            String[] subStr;
            subStr = item.split("\\\n");

            Typeface face = Typeface.createFromAsset(getActivity().getAssets(), subStr[0]);
            answer.setTypeface(face);
            answer.setText(subStr[1]);
        }
    }
    public String Listener(String item ) {
        String returnStr="";
        switch(item){
            case "0":
                returnStr="You didn't choose a font";
                break;
            case "1":
                returnStr="You didn't input a string";
                break;
            case "2":
                returnStr="";
                break;
        }
        return returnStr;
    }

}