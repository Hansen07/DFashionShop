package com.example.uas_mobileprogramming;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.sql.Array;
import java.util.ArrayList;

public class fragmenthistory extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate (R.layout.fragment_history, container,false);

        ListView lv = view.findViewById(R.id.listhistory);
        Bundle bun = getArguments();

        ArrayList<String> arlist = bun.getStringArrayList("cart");

        String[] help = new String[arlist.size()];
        int[] help2 = new int[arlist.size()];
        int i = 0 ;
        for(String s : arlist){
            boolean isDuplicate = false;
            for(int j = 0; j < i; j++){
                if(s.equals(help[j])){
                    help2[j]++;
                    isDuplicate = true;
                }
            }

            if(!isDuplicate){
                help[i] = s;
                help2[i] = 1;
                i++;
            }
        }


        int n = i;
        int[] gambarr = new int[n];
        String[] namaa = new String[n];
        int[] jumlahitemm = new int[n];
        int[] jumlahhargaa = new int[n];

        for(i = 0;i<n;i++){
            namaa[i] = help[i];
            jumlahitemm[i] =help2[i];

        }
        for(i= 0;i<n;i++){
            String str = namaa[i];
            if(str.equals("Kaos putih")){
                jumlahhargaa[i] = 50000;
                gambarr[i] = R.drawable.cloth1;
            }else if(str.equals("Kaos biru")){
                jumlahhargaa[i] = 60000;
                gambarr[i] = R.drawable.cloth2;
            }else if(str.equals("Kaos kuning")){
                jumlahhargaa[i] = 40000;
                gambarr[i] = R.drawable.cloth3;
            }else if(str.equals("Kaos hijau")){
                jumlahhargaa[i] = 40000;
                gambarr[i] = R.drawable.cloth4;
            }else if(str.equals("Kaos merah")){
                jumlahhargaa[i] = 53000;
                gambarr[i] = R.drawable.cloth5;
            }else if(str.equals("Kaos hijau polo")){
                jumlahhargaa[i] = 200000;
                gambarr[i] = R.drawable.cloth6;
            }else if(str.equals("Kaos hijau casual")){
                jumlahhargaa[i] = 55000;
                gambarr[i] = R.drawable.cloth7;
            }else if(str.equals("Kaos biru polo")){
                jumlahhargaa[i] = 200000;
                gambarr[i] = R.drawable.cloth8;
            }

        }

        lv.setAdapter(new listcustom(getContext(),namaa,jumlahhargaa,gambarr,jumlahitemm));
        return view;
    }
}
