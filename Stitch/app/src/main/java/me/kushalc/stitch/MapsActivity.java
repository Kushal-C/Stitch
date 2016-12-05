package me.kushalc.stitch;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private View bottomLayout;

    private Item mItem;

    private TextView bottomShopName;
    private TextView bottomShopDistance;
    private TextView bottomShopTime;
    private TextView bottomAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Intent i = getIntent();
        mItem = i.getParcelableExtra("Item");

        bottomLayout = (View)findViewById(R.id.map_bottom_bar_view);
        //Set an onclick listenter to bottom view as long as it's not invisible
        bottomLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bottomLayout.getVisibility() == View.VISIBLE){
                    //Pulls active barbershop selected
                    getDirections(view);

                }
            }
        });

        setFonts();

        populateBottomBar();

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng valleyFair = new LatLng(37.3257, -121.9456);
        mMap.addMarker(new MarkerOptions().position(valleyFair).title("H&M at Valley Fair"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(valleyFair));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f));


    }

    public void setFonts()
    {
        Typeface quickBold = Typeface.createFromAsset(getAssets(), "fonts/Quicksand-Bold.ttf");
        Typeface quickReg = Typeface.createFromAsset(getAssets(),"fonts/Quicksand-Regular.ttf");


        TextView bottomApprox = (TextView)findViewById(R.id.map_bottom_bar_approx);
        bottomAddress = (TextView)findViewById(R.id.map_bottom_bar_address);

        TextView navbarTitle = (TextView)findViewById(R.id.map_nav_bar_title) ;
        bottomShopName = (TextView)findViewById(R.id.map_bottom_bar_shop_name);
        bottomShopDistance = (TextView)findViewById(R.id.map_bottom_bar_distance);
        bottomShopTime = (TextView)findViewById(R.id.map_bottom_bar_shop_time);

        bottomAddress.setTypeface(quickReg);
        bottomApprox.setTypeface(quickReg);

        bottomShopName.setTypeface(quickBold);
        navbarTitle.setTypeface(quickBold);
        bottomShopDistance.setTypeface(quickBold);
        bottomShopTime.setTypeface(quickBold);
    }

    //Implicit Intent to use Google Maps for directions
    public void getDirections(View view){

        // Map point based on address where b is intent
        Uri location = Uri.parse("geo:0,0?q="+ mItem.getAddress());
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

        //Used to check if the implicit intent is safe or not
        PackageManager packageManager = getPackageManager();
        List activities = packageManager.queryIntentActivities(mapIntent, PackageManager.MATCH_DEFAULT_ONLY);

        boolean isIntentSafe = activities.size() > 0;

        if(isIntentSafe) {
            startActivity(mapIntent);
        }
        else {
            Toast.makeText(getApplicationContext(),"No dialer to handle this function",Toast.LENGTH_SHORT).show();
        }

    }

    public void populateBottomBar()
    {
        bottomAddress.setText(mItem.getAddress());
        bottomShopName.setText(mItem.getLocation());

    }

    //Opens navigation drawer
    public void openNavbar(View view)
    {

    }

    //Future function to add multiple locations on the map to order from
    public void populateMap()
    {

    }




}
