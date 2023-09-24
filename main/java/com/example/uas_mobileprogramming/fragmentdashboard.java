package com.example.uas_mobileprogramming;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class fragmentdashboard extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate (R.layout.fragment_dashboard, container,false);

        ArrayList<String> list = getArguments().getStringArrayList("listkosong");

        Button tombol1 = view.findViewById(R.id.tombolone);
        tombol1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        list.add("Kaos putih");
                        cek(list);
                    }
                }
        );

        Button tombol2 = view.findViewById(R.id.tomboltwo);
        tombol2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        list.add("Kaos biru");
                        cek(list);
                    }
                }
        );

        Button tombol3 = view.findViewById(R.id.tombolthree);
        tombol3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        list.add("Kaos kuning");
                        cek(list);
                    }
                }
        );

        Button tombol4 = view.findViewById(R.id.tombolfour);
        tombol4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        list.add("Kaos hijau");
                        cek(list);
                    }
                }
        );

        Button tombol5 = view.findViewById(R.id.tombolfive);
        tombol5.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        list.add("Kaos merah");
                        cek(list);
                    }
                }
        );

        Button tombol6 = view.findViewById(R.id.tombolsix);
        tombol6.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        list.add("Kaos hijau polo");
                        cek(list);
                    }
                }
        );

        Button tombol7 = view.findViewById(R.id.tombolseven);
        tombol7.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        list.add("Kaos hijau casual");
                        cek(list);
                    }
                }
        );

        Button tombol8 = view.findViewById(R.id.tomboleight);
        tombol8.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        list.add("Kaos biru polo");
                        cek(list);
                    }
                }
        );

        Bundle ba = new Bundle();
        ba.putStringArrayList("cart",list);
        getParentFragmentManager().setFragmentResult("rkey",ba);


        return view;
    }

    void cek(ArrayList<String> cart){
//        String txt = "";
//        for(String s : cart){
//            txt += (s + "-");
//        }
//
//        Toast.makeText(getContext(), txt, Toast.LENGTH_SHORT).show();
    }
}