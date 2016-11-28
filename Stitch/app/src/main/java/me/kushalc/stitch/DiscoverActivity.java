package me.kushalc.stitch;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class DiscoverActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);

        setFonts();
    }

    private void setFonts()
    {
        Typeface quickBold = Typeface.createFromAsset(getAssets(), "fonts/Quicksand-Bold.ttf");
        TextView navBarText = (TextView)findViewById(R.id.nav_bar_text_view);
        navBarText.setTypeface(quickBold);
    }

    /*
    Goes to search activity
     */
    public void search(View view)
    {
        Intent i = new Intent(getApplicationContext(), SearchActivity.class);
        i.putExtra("Value","Search");
        startActivity(i);
    }

    /*
    Opens navigationBar on the side
     */
    public void openNavbar(View view)
    {

    }

    /*
    Click from an image button opens feed relating to that item
     */
    public void openFeed(View view)
    {
        int viewId = view.getId();

        Intent i = new Intent(getApplicationContext(), SearchActivity.class);

        switch (viewId)
        {
            case R.id.discover_image_button_accessories:
                i.putExtra("Value","Accessories");
                break;
            case R.id.discover_image_button_dresses:
                i.putExtra("Value","Dresses");
                break;
            case R.id.discover_image_button_featured:
                i.putExtra("Value","Featured");
                break;
            case R.id.discover_image_button_jackets:
                i.putExtra("Value","Jackets");
                break;
            case R.id.discover_image_button_pants:
                i.putExtra("Value","Pants");
                break;
            case R.id.discover_image_button_shirts:
                i.putExtra("Value","Shirts");
                break;
            case R.id.discover_image_button_shoes:
                i.putExtra("Value","Shoes");
                break;
        }

        startActivity(i);
    }

}
