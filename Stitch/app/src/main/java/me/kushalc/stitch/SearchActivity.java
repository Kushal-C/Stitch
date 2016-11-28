package me.kushalc.stitch;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity
{
    private Toolbar defaultToolbar;
    private Toolbar searchToolbar;

    private TextView navBarText;
    private EditText query;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        setFonts();

        Intent i = getIntent();
        String value = i.getStringExtra("Value");

        navBarText.setText(value);

        defaultToolbar = (Toolbar)findViewById(R.id.my_toolbar);
        searchToolbar = (Toolbar)findViewById(R.id.my_toolbar_2);
    }

    private void setFonts()
    {
        Typeface quickBold = Typeface.createFromAsset(getAssets(), "fonts/Quicksand-Bold.ttf");
        navBarText = (TextView)findViewById(R.id.search_text_view_title);
        navBarText.setTypeface(quickBold);
    }

    /*
    Unhides search bar edit text , X symbol and hides menu symbol and text view
    If search toolbar is already being queried then it searches the query inside the editText
    */

    public void search(View view)
    {
        if(defaultToolbar.getVisibility() == View.VISIBLE)
        {
            defaultToolbar.setVisibility(View.GONE);
            searchToolbar.setVisibility(View.VISIBLE);
        }
        else
        {
            query = (EditText)findViewById(R.id.search_edit_text_query);
            String queryText = query.getText().toString();
            queryApi(queryText);
        }
    }

    /*
    Clears editText and reverts view
     */
    public void clear(View view){
        defaultToolbar.setVisibility(View.VISIBLE);
        searchToolbar.setVisibility(View.GONE);
    }

    /*
    Opens navigationBar on the side
     */
    public void openNavbar(View view)
    {

    }


    private void queryApi(String s)
    {

    }

}
