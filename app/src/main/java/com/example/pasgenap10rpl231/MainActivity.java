package com.example.pasgenap10rpl231;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView list_item;
    private LinearLayoutManager linearLayoutManager;
    private List<ItemObject> itemObjects;
    private AdapterData adapterData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_item = (RecyclerView)findViewById(R.id.lst_item);

        linearLayoutManager = new LinearLayoutManager(this);
        list_item.setLayoutManager(linearLayoutManager);

        itemObjects = new ArrayList<>();
        itemObjects.add(new ItemObject("Merkurius" , "2.439 km", "https://sulchana.files.wordpress.com/2013/04/merkurius.jpg?w=584"));
        itemObjects.add(new ItemObject("Venus", "6,052 km" , "http://res.cloudinary.com/dk-find-out/image/upload/q_80,w_1440/AW_Venus_nli6oy.jpg"));
        itemObjects.add(new ItemObject("Bumi", "6.371 km", "https://hanifweb.files.wordpress.com/2013/04/bumi.jpg"));
        itemObjects.add(new ItemObject("Mars", "3.390 km", "http://res.cloudinary.com/dk-find-out/image/upload/q_80,w_1440/Mars_ICE_CAP_BACK0000_ozkwko.jpg"));
        itemObjects.add(new ItemObject("Yupiter", "69.911 km", "http://3.bp.blogspot.com/-EQlHIVsA6fI/UULmKGHEizI/AAAAAAAAAIg/ySOnayNZtrU/s1600/jupiter.jpg"));
        itemObjects.add(new ItemObject("Saturnus", "58.232 km", "http://2.bp.blogspot.com/-kFVjaebe9QA/VVmxCGg3uEI/AAAAAAAAAJk/M7R6hU0zPkY/s1600/saturn.png"));
        itemObjects.add(new ItemObject("Uranus", "25.362", "https://jagad.id/wp-content/uploads/2017/12/Planet-Uranus-Sejarah-Gambar-Diameter-dan-Penjelasan-Lengkap.jpg"));
        itemObjects.add(new ItemObject("Neptunus", "24.622 km", "https://talithaqiute.files.wordpress.com/2014/05/neptunus.jpg?w=665"));
        itemObjects.add(new ItemObject("Pluto", "1.188 km", "https://openclipart.org/image/2400px/svg_to_png/223415/pluto.png"));
        adapterData = new AdapterData(getApplicationContext(), itemObjects);
        list_item.setAdapter(adapterData);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

         switch (item.getItemId()){
             case 101:
                 Snackbar.make(findViewById(R.id.rootId), "Added to Wishlist", Snackbar.LENGTH_LONG).show();
                 return true;
                 case 102:
                 Snackbar.make(findViewById(R.id.rootId), "Deleted", Snackbar.LENGTH_LONG).show();
                 adapterData.RemoveItem(item.getGroupId());
                 return true;
             default:
                 return super.onContextItemSelected(item);
         }

    }
}