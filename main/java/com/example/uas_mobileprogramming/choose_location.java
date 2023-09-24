package com.example.uas_mobileprogramming;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class choose_location extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choose_location, container, false);
        Button button1 = view.findViewById(R.id.buttonA);
        Button button2 = view.findViewById(R.id.buttonB);
        Button button3 = view.findViewById(R.id.buttonC);

        button1.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        getParentFragmentManager().beginTransaction().replace(R.id.fragment_dash,new fragmentlokasi()).commit();
                    }

                }
        );

        button2.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        getParentFragmentManager().beginTransaction().replace(R.id.fragment_dash,new fragmentlokasiB()).commit();
                    }

                }
        );

        button3.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        getParentFragmentManager().beginTransaction().replace(R.id.fragment_dash,new fragmentlokasiC()).commit();
                    }

                }
        );

        return view;
    }
}