package com.example.uas_mobileprogramming;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DashboardPage extends AppCompatActivity {
    ArrayList<String> itempilih = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_page);

        ImageView historilogo=findViewById(R.id.history);
        historilogo.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        FragmentManager fm = getSupportFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();

                        fragmenthistory selectedFragment = new fragmenthistory();
                        Bundle ba = new Bundle();
                        ba.putStringArrayList("cart",itempilih);
                        selectedFragment.setArguments(ba);

                        ft.replace(R.id.fragment_dash, selectedFragment).commit();
                    }
                }

        );

        ImageView homelogo=findViewById(R.id.home);
        homelogo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FragmentManager fm = getSupportFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();

                        fragmentdashboard selectedFragment = new fragmentdashboard();
                        fm.setFragmentResultListener("rkey",DashboardPage.this,new FragmentResultListener(){
                            @Override
                            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result){
                                itempilih = result.getStringArrayList("cart");
                            }
                        });

                        Bundle b = new Bundle();
                        b.putStringArrayList("listkosong", itempilih);
                        selectedFragment.setArguments(b);

                        ft.replace(R.id.fragment_dash, selectedFragment).commit();
                    }
                }
        );

        ImageView lokasilogo=findViewById(R.id.location);
        lokasilogo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FragmentManager fm = getSupportFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();

                        choose_location selectedFragment = new choose_location();

                        ft.replace(R.id.fragment_dash, selectedFragment).commit();
                    }
                }
        );

        //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_dash, new fragmentdashboard()).commit();

    }

}
