package com.example.pasgenap10rpl231;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

public class Holder extends RecyclerView.ViewHolder {
    public TextView txt_judul, txt_ukuran;
    public ImageView img_icon;

    public Holder(@NonNull View itemView) {
        super(itemView);

        txt_judul= (TextView) itemView.findViewById(R.id.txt_judul);
        txt_ukuran= (TextView) itemView.findViewById(R.id.txt_ukuran);
        img_icon = (ImageView) itemView.findViewById(R.id.img_icon);
    }
}
