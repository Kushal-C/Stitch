package me.kushalc.stitch;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ItemDetail extends AppCompatActivity
{

    Typeface tf;
    Item mItem;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        tf = Typeface.createFromAsset(getAssets(), "fonts/Quicksand-Bold.ttf");
        Intent intent = getIntent();
        mItem = intent.getExtras().getParcelable("Item");

        setFontsAndExtras();

    }

    public void setFontsAndExtras()
    {
        TextView title = (TextView)findViewById(R.id.item_detail_nav_bar_title);
        TextView name = (TextView)findViewById(R.id.item_detail_text_view_item_name);
        TextView location = (TextView)findViewById(R.id.item_detail_view_shop_name);
        TextView price = (TextView)findViewById(R.id.item_detail_text_view_price);
        TextView dPrice = (TextView)findViewById(R.id.item_detail_text_view_discounted_price);
        ImageButton favorite = (ImageButton)findViewById(R.id.item_detail_button_favorite);

        Button holdButton = (Button)findViewById(R.id.item_detail_button_hold);
        Button addToCartButton = (Button)findViewById(R.id.item_detail_button_cart);

        holdButton.setTypeface(tf);
        addToCartButton.setTypeface(tf);

        title.setTypeface(tf);
        name.setTypeface(tf);
        location.setTypeface(tf);
        price.setTypeface(tf);
        dPrice.setTypeface(tf);

        if(mItem.isFavorite())
        {
            favorite.setImageResource(R.drawable.favorite);
        }

        if(mItem.isDiscount())
        {
            price.setPaintFlags(price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            price.setTextColor(Color.GRAY);
        }
        else
        {
            dPrice.setVisibility(View.INVISIBLE);
        }
        title.setText(mItem.getItemName());
        name.setText(mItem.getItemName());
        location.setText(mItem.getLocation());
        price.setText("$"+Double.toString(mItem.getPrice()));
        dPrice.setText("$"+Double.toString(mItem.getDiscountedPrice()));

        setSpinner();
    }

    public void favorite(View view)
    {
        ImageButton favorite = (ImageButton)view.findViewById(R.id.item_detail_button_favorite);
        if(mItem.isFavorite())
        {
            mItem.setFavorite(false);
            favorite.setImageResource(R.drawable.favorite_unfilled);
        }
        else
        {
            mItem.setFavorite(true);
            favorite.setImageResource(R.drawable.favorite);
        }
    }

    public void map(View view)
    {
        Intent i = new Intent(getApplicationContext(),MapsActivity.class);
        i.putExtra("Item",mItem);
        startActivity(i);
    }

    public void setSpinner()
    {
        Spinner color = (Spinner)findViewById(R.id.item_detail_spinner_color);

        ArrayList<String> colorArray = new ArrayList<>();

        colorArray.add("Blue");
        colorArray.add("White");
        ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item,
                colorArray);


        color.setAdapter(spinnerArrayAdapter);

        Spinner size = (Spinner)findViewById(R.id.item_detail_spinner_size);

        ArrayList<String> sizeArray = new ArrayList<>();

        sizeArray.add("Small");
        sizeArray.add("Medium");
        sizeArray.add("Large");
        sizeArray.add("Extra Large");

        ArrayAdapter sizeArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item,
                sizeArray);

        size.setAdapter(sizeArrayAdapter);
    }

    public void addToCart(View view)
    {
        Toast.makeText(getApplicationContext(),mItem.getItemName() + " added to cart.", Toast.LENGTH_SHORT).show();
    }

    public void hold(View view)
    {
        Toast.makeText(getApplicationContext(),"Item held at " + mItem.getLocation(), Toast.LENGTH_SHORT).show();
    }

}
