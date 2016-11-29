package me.kushalc.stitch;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SearchActivity extends AppCompatActivity
{
    private Toolbar defaultToolbar;
    private Toolbar searchToolbar;

    private TextView navBarText;
    private EditText query;

    private List<Item> mItemList = new ArrayList<>();
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

        ListView listView = (ListView)findViewById(R.id.search_list_view_items);

        populateItemList();

        SearchAdapter searchAdapter = new SearchAdapter(this, mItemList);
        listView.setAdapter(searchAdapter);

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

    //Populate item list
    private void populateItemList()
    {
        //Passing in Mock Data
        Bitmap bitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.blue_oxford);
        ArrayList<byte[]> bm = new ArrayList<>();

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] bytes = stream.toByteArray();
        bm.add(bytes);


        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Blue", 5);

        Item a = new Item("H&M","Blue Oxford Shirt","Shirt","H&M Valley Fair", true, true, 16.78, 13.32,
                bm, hashMap);

        mItemList.add(a);
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
