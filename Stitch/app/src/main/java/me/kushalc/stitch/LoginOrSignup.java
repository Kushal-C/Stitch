package me.kushalc.stitch;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LoginOrSignup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_or_signup);

        Typeface quickBold = Typeface.createFromAsset(getAssets(), "fonts/Quicksand-Bold.ttf");
        Button loginButton = (Button)findViewById(R.id.button_login_one);
        Button signUpButton = (Button)findViewById(R.id.button_signup_one);
        signUpButton.setTypeface(quickBold);
        loginButton.setTypeface(quickBold);

    }

    public void login(View view){
        Intent i = new Intent(getApplicationContext(), DiscoverActivity.class);
        startActivity(i);
    }

    public void signUp(View view){
        Intent i = new Intent(getApplicationContext(), DiscoverActivity.class);
        startActivity(i);
    }

}
