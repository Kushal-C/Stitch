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

        Typeface quickBold = Typeface.createFromAsset(getAssets(), "fonts/Quicksand-Bold.ttf");
        Button loginButton = (Button)findViewById(R.id.button_login_one);
        Button signUpButton = (Button)findViewById(R.id.button_signup_one);
        signUpButton.setTypeface(quickBold);
        loginButton.setTypeface(quickBold);


    }
}
