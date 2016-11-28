package me.kushalc.stitch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Kushal on 11/27/16.
 */

public class SearchAdapter extends BaseAdapter implements ListView.OnItemClickListener
{

    private Activity activity;
    private List<Item> data;
    private static LayoutInflater inflater=null;
    Typeface quickBold;

    public SearchAdapter(Activity a, List d)
    {
        this.activity= a;
        this.data = d;
        //Used to call an external xml file, in this case expandable_list_view.xml
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        quickBold = Typeface.createFromAsset(a.getAssets(), "fonts/Quicksand-Bold.ttf");

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
    {
        Log.i("Position",Integer.toString(i));
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Item getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        //Make it recycle views for better performance
        View row = inflater.inflate(R.layout.shop_item_list_view,viewGroup, false);

        //Pull views from shop_item_list_view.xml
        TextView location = (TextView)row.findViewById(R.id.search_text_view_shop_name);
        TextView itemName = (TextView)row.findViewById(R.id.search_text_view_item_name);
        TextView price = (TextView)row.findViewById(R.id.search_text_view_price);
        TextView discountedPrice = (TextView)row.findViewById(R.id.search_text_view_discounted_price);

        ImageView productImage = (ImageView)row.findViewById(R.id.search_image_view_product);
        final ImageButton favorite = (ImageButton)row.findViewById(R.id.search_image_button_favorite);

        //Grab item from list
        final Item a = data.get(i);

        //Populate view with data
        location.setText(a.getLocation());
        itemName.setText(a.getItemName());
        price.setText(Double.toString(a.getPrice()));
        discountedPrice.setText(Double.toString(a.getDiscountedPrice()));
        productImage.setImageDrawable(a.getImageViews().get(i).getDrawable());

        if(a.isFavorite())
        {
            favorite.setImageResource(R.drawable.favorite);
        }
        else
        {
            favorite.setImageResource(R.drawable.favorite_unfilled);
        }

        if(a.isDiscount())
        {
            price.setTextColor(Color.GRAY);
            price.setPaintFlags(price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
        else
        {
            discountedPrice.setVisibility(View.INVISIBLE);
        }

        location.setTypeface(quickBold);
        itemName.setTypeface(quickBold);
        price.setTypeface(quickBold);
        discountedPrice.setTypeface(quickBold);

        favorite.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(a.isFavorite())
                {
                    a.setFavorite(false);
                    favorite.setImageResource(R.drawable.favorite_unfilled);
                }
                else
                {
                    a.setFavorite(true);
                    favorite.setImageResource(R.drawable.favorite);
                }
            }
        });

        row.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(view.getContext(),ItemDetail.class);
                i.putExtra("Item", a);
                view.getContext().startActivity(i);
            }
        });

        return row;
    }

}
