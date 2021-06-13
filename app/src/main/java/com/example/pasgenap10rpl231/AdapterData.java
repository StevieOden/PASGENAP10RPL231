package com.example.pasgenap10rpl231;

import android.content.ClipData;
import android.content.Context;
import android.media.Image;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData>{

    Context context;
    List<ItemObject> itemObjects;

    public AdapterData(Context context, List<ItemObject> itemObjects) {
        this.context = context;
        this.itemObjects = itemObjects;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, null);
        HolderData holderData = new HolderData(view);
        return holderData;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        holder.txt_judul.setText(itemObjects.get(position).strJudul);
        holder.txt_ukuran.setText(itemObjects.get(position).strUkuran);
        Glide.with(context)
                .load(itemObjects.get(position).strGambar)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.img_icon);
    }

    @Override
    public int getItemCount() {

        return itemObjects.size();
    }


    public class HolderData extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{
        TextView txt_judul, txt_ukuran;
        ImageView img_icon;
        CardView cardView;
        public HolderData(@NonNull View itemView) {
            super(itemView);

            txt_judul =itemView.findViewById(R.id.txt_judul);
            txt_ukuran= itemView.findViewById(R.id.txt_ukuran);
            img_icon = itemView.findViewById(R.id.img_icon);
            cardView = itemView.findViewById(R.id.cardview);
            cardView.setOnCreateContextMenuListener(this);
        }


        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.add(this.getAdapterPosition(), 121, 0, "Add to Wishlist");
            menu.add(this.getAdapterPosition(), 122, 1, "Delete");
        }
    }

    public void RemoveItem(int position){
        itemObjects.remove(position);
        notifyDataSetChanged();
    }

}
