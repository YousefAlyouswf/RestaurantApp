package com.restaurant.restaurantapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivty extends AppCompatActivity {

    ListView listView;
    //BreakfastArray
    int[] imagesBreakfast = {R.drawable.egg, R.drawable.cheese, R.drawable.egg1,R.drawable.egg, R.drawable.cheese, R.drawable.egg1,R.drawable.egg, R.drawable.cheese, R.drawable.egg1};
    String[] descriptionBreakfast = {"Egg", "Cheese", "egg1","Egg", "Cheese", "egg1","Egg", "Cheese", "egg1"};
    String[] priceBreakfast = {"10", "7", "5","10", "7", "5","10", "7", "5"};
    //LunchArray
    int[] imagesLunch = {R.drawable.egg, R.drawable.cheese, R.drawable.egg, R.drawable.cheese, R.drawable.egg1,R.drawable.egg, R.drawable.cheese, R.drawable.egg1};
    String[] descriptionLunch = {"Rice", "Pasta", "Chicken","Rice",  "Chicken","Rice", "Pasta", "Chicken"};
    String[] priceLunch = {"13", "11", "12","13", "11", "12","13", "11"};
    //DinirArray
    int[] imagesDinir = {R.drawable.egg, R.drawable.cheese, R.drawable.egg1};
    String[] descriptionDinir = {"Shaorma", "Kabab", "Meat"};
    String[] priceDinir = {"6", "4", "3"};
    int type = 0;
    custtomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_activty);

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        listView = findViewById(R.id.listView);
        adapter = new custtomAdapter();
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()) {
            case R.id.item:
                breakfast();
                break;
            case R.id.item2:
                lunch();
                break;
            case R.id.item3:
                dinir();
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    private void breakfast() {
        type = 0;
        adapter.notifyDataSetChanged();
    }

    private void lunch() {
        type = 1;
        adapter.notifyDataSetChanged();
    }

    private void dinir() {
        type = 2;
        adapter.notifyDataSetChanged();
    }

    class custtomAdapter extends BaseAdapter {

        @Override
        public int getCount() {

            if(type==0){
                return priceBreakfast.length;
            }else if(type==1){
                return priceLunch.length;
            }else if(type==2){
                return priceDinir.length;
            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @SuppressLint("ViewHolder")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = getLayoutInflater().inflate(R.layout.customlayout, null);
            ImageView imageView = convertView.findViewById(R.id.imageView);
            TextView des = convertView.findViewById(R.id.des);
            TextView price = convertView.findViewById(R.id.price);
            if (type == 0) {
                imageView.setImageResource(imagesBreakfast[position]);
                des.setText(descriptionBreakfast[position]);
                price.setText(priceBreakfast[position]);
                return convertView;
            } else if (type == 1) {
                imageView.setImageResource(imagesLunch[position]);
                des.setText(descriptionLunch[position]);
                price.setText(priceLunch[position]);
                return convertView;
            } else if (type == 2) {
                imageView.setImageResource(imagesDinir[position]);
                des.setText(descriptionDinir[position]);
                price.setText(priceDinir[position]);
                return convertView;
            }


            return null;
        }
    }
}
