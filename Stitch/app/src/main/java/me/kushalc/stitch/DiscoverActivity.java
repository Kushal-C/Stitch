package me.kushalc.stitch;

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

    public void search(View view)
    {

    }

    public void openNavbar(View view)
    {

    }
}
