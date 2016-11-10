package me.kushalc.stitch;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class DiscoverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);

        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "fonts/quicksand_light.otf");
        Button myTextView = (Button)findViewById(R.id.button_login_one);
        Button myTextView2 = (Button)findViewById(R.id.button2);
        myTextView.setTypeface(myTypeface);
        myTextView2.setTypeface(myTypeface);
    }
}
