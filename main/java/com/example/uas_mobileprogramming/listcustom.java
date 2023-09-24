package com.example.uas_mobileprogramming;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class listcustom extends ArrayAdapter<String> {
    String[] namaitem;

    int[] jumlahharga;
    int[] gambar;
    int[] jumlahitem;

    Context con;

    public listcustom(Context con, String[] namaitem, int[] jumlahharga, int[] jumlahgambar, int[] jumlahitem){
        super(con,R.layout.historylist);
        this.namaitem = namaitem;
        this.jumlahharga = jumlahharga;
        this.gambar= jumlahgambar;
        this.jumlahitem=jumlahitem;
        this.con=con;
    }
    @Override
    public int getCount(){return namaitem.length;}
    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent){
        ViewHolder vh = new ViewHolder();

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.historylist,parent, false);

            vh.namabrg = view.findViewById(R.id.namaitem);
            vh.gbr = view.findViewById(R.id.imagehistory);
            vh.jumlaharga=view.findViewById(R.id.jumlahharga);
            vh.jumlahitem = view.findViewById(R.id.jumlahitem);

            view.setTag(vh);
        }
        else {
            vh = (ViewHolder)view.getTag();
        }
        vh.namabrg.setText(namaitem[position]);
        vh.gbr.setImageResource(gambar[position]);
        vh.jumlaharga.setText("Jumlah Harga: " + String.valueOf(jumlahharga[position]*jumlahitem[position]));
        vh.jumlahitem.setText("Jumlah Item: " + String.valueOf(jumlahitem[position]));

        return view;
    }
    static class ViewHolder{
        TextView namabrg, jumlaharga,jumlahitem;
        ImageView gbr;
    }
}
