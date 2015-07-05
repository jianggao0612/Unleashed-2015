package com.lordmayors.shftr;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.util.Property;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnCameraChangeListener, GoogleMap.OnMapClickListener, ViewPager.OnPageChangeListener {

    private static final LatLng ADELAIDE_LAT_LONG = new LatLng(-34.9290, 138.6010);
    private static final double ADELAIDE_ZOOM = 13.5;

    private static final LatLng INIT_LAT_LONG = new LatLng(-30.389121312623146,134.01996407657862);
    private static final double INIT_ZOOM = 3.5;

    private static final String TAG = "MapsActivity";
    private GoogleMap map; // Might be null if Google Play services APK is not available.

    private GameState gameState;

    private ShftrGameFactory shftrGameFactory;
    private ShftrGame game;

    private LinearLayout tabs;
    private StartMenuFragment startMenu;

    private Marker playerMarker;
    private Marker destMarker;
    private ArrayList<ImageButton> tabsList;
    private SparseArray<BitmapDescriptor> mapBitDesc = new SparseArray();
    private WinFragment winMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();

        shftrGameFactory = new ShftrGameFactory();

        initStartMenu();

        tabs = (LinearLayout) findViewById(R.id.tabs);
        tabs.setVisibility(View.GONE);
        tabsList = new ArrayList<>();


//        startNewGame();
    }

    private void initStartMenu()
    {
        startMenu = new StartMenuFragment();
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();

//        tx.add( startMenu , "start" );
        tx.add(R.id.activity_maps, startMenu, "sad");
//        findViewById(R.id.activity_maps);
        tx.setCustomAnimations(R.anim.abc_popup_enter, R.anim.abc_fade_out);
        tx.commitAllowingStateLoss();

        startMenu.setStartListener(this);
    }

    public void start()
    {
        startNewGame();
    }

    private void startNewGame()
    {
        if( playerMarker != null ) playerMarker.remove();

        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.remove(startMenu);
        tx.commitAllowingStateLoss();
        startMenu = null;

        tabs.setVisibility(View.VISIBLE);

        game = shftrGameFactory.newGame();
        gameState = new GameState();


        for(int i = 0; i < arr_transport_icon.length; i ++ )
        {
            ImageButton tab = new ImageButton(this);
            tab.setColorFilter(getResources().getColor(R.color.c5));
            tab.setImageResource(arr_transport_icon[i]);
            tabsList.add(tab);
            tabs.addView(tab);
            tab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int i = tabsList.indexOf( v );
                    selectTransport( i );
                }
            });
        }

        setLocation(game.getPlayerLocation());

        generateNextDestination();
    }

    public void generateNextDestination()
    {
        setDestination(game.getLocations().remove(0), game.getPlayerLocation());
    }


    private void selectTransport(int i)
    {
        if( playerMarker != null ) playerMarker.setIcon(getBitmapDescriptor(arr_transport_icon[i]));


        DecimalFormat two = new DecimalFormat("#0.00");

        double d = distance(playerMarker.getPosition(), destMarker.getPosition());
        int rounded = (int) Math.ceil( d );

        gameState.distance += d;

        //distance
        Toast.makeText(this,"" + rounded + "m",Toast.LENGTH_SHORT).show();

        //cost
        if( i <= 1 ) Toast.makeText(this,"$0.00",Toast.LENGTH_SHORT).show();
        else if( i == 2 )
        {
            if( gameState.busPaid() )
            {
                Toast.makeText(this, "$0, you've already paid!", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "-$3", Toast.LENGTH_SHORT).show();
                gameState.getCash().increment(3);
            }
        }
        else if( i == 3 )
        {
            // 78c / km

            double amt = d * 0.78 / 1000;
            Toast.makeText(this,"-$" + two.format(amt),Toast.LENGTH_SHORT).show();
            gameState.getCash().increment( amt );
        }

        //calories
        // 0.1 per m
        if( i == 0 )
        {
            double amt = d * 0.1;
            Toast.makeText(this,"" + two.format(amt) + " calories burned!",Toast.LENGTH_SHORT).show();
            gameState.getCalories().increment( amt );
        } else if( i == 1 )
        {
            double amt = d * 0.05;
            Toast.makeText(this,"" + two.format(amt) + " calories burned!",Toast.LENGTH_SHORT).show();
            gameState.getCalories().increment( amt);
        }else
        {
            Toast.makeText(this,"about zero calories burned...",Toast.LENGTH_SHORT).show();
        }

        //CO2
//        165g/km
        if( i == 0 )
        {
            Toast.makeText(this, "no CO2 emissions (:", Toast.LENGTH_SHORT).show();
        } else if( i == 1 )
        {
            Toast.makeText(this,"no CO2 emissions! :)", Toast.LENGTH_SHORT).show();
        } else if( i == 2 )
        {
            double amt = .01 * d;
            Toast.makeText(this,"" + two.format(amt) + "kg of CO2 emissions :(",Toast.LENGTH_SHORT).show();
            gameState.getCo2().increment( amt );
        }else
        {
            double amt = .165 * d;

            Toast.makeText(this,"" + two.format(amt) + "kg of CO2 emissions :(",Toast.LENGTH_SHORT).show();
            gameState.getCo2().increment( amt );
        }

//        Toast.makeText(this,"" + co2 + "kg of CO2",Toast.LENGTH_SHORT).show();



        game.setPlayerLocation(destMarker.getPosition());

        //TODO animate
        animateMarkerToICS(playerMarker, destMarker.getPosition(), new LatLngInterpolator());

    }

    public void animateMarkerToICS(Marker marker, LatLng finalPosition, final LatLngInterpolator latLngInterpolator) {
        TypeEvaluator<LatLng> typeEvaluator = new TypeEvaluator<LatLng>() {
            @Override
            public LatLng evaluate(float fraction, LatLng startValue, LatLng endValue) {
                return latLngInterpolator.interpolate(fraction, startValue, endValue);
            }
        };
        Property<Marker, LatLng> property = Property.of(Marker.class, LatLng.class, "position");
        ObjectAnimator animator = ObjectAnimator.ofObject(marker, property, typeEvaluator, finalPosition);

        animator.setInterpolator(new LinearInterpolator());

        animator.setDuration(2000);
        animator.start();

        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (destMarker != null) destMarker.remove();
                if (game.getLocations().isEmpty()) {
                    win();
                } else {
                    generateNextDestination();
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    private void win() 
    {
        tabs.setVisibility(View.GONE);




        CameraPosition cameraPos = CameraPosition.builder().zoom((float) ADELAIDE_ZOOM).tilt(45f + (float) (Math.random() * 20f)).target(ADELAIDE_LAT_LONG).build();
        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPos);

        map.animateCamera(cameraUpdate, 6000, new GoogleMap.CancelableCallback() {
            @Override
            public void onFinish() {
                initWinMenu();
                winMenu.setGameState(gameState);
            }

            @Override
            public void onCancel() {

            }
        });


    }

    private void initWinMenu() {
        winMenu = new WinFragment();

        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.add( R.id.activity_maps, winMenu , "zzz");

//        tx.setCustomAnimations(R.anim.abc_fade_in,R.anim.abc_fade_out);

        tx.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);

        tx.commitAllowingStateLoss();

        winMenu.setGameState(gameState);
    }

    private BitmapDescriptor getBitmapDescriptor(int i)
    {
        BitmapDescriptor b = mapBitDesc.get(i);
        if( b != null ) return b;

        b = BitmapDescriptorFactory.fromResource( i );
        mapBitDesc.put( i , b );
        return b;
    }

    private void setLocation(LatLng location)
    {
        BitmapDescriptor icon = getBitmapDescriptor(arr_transport_icon[0]);

        MarkerOptions markerOptions = new MarkerOptions()
                .title("Current Location")
                .snippet("That's you...")
                .icon(icon);

        markerOptions.position( location );

        playerMarker = map.addMarker(markerOptions);
    }

    private void setDestination(ShftrLocation location, LatLng playerPos)
    {
        BitmapDescriptor icon = getBitmapDescriptor(location.getIcon() );

        MarkerOptions markerOptions = new MarkerOptions()
                .title(location.getName())
                .snippet(location.getDescription())
                .icon(icon);

        markerOptions.position( location.getLatLng() );

        destMarker = map.addMarker(markerOptions);

        LatLng dest = location.getLatLng();

        LatLng focus = new LatLng((dest.latitude + playerPos.latitude)/2, (dest.longitude + playerPos.longitude)/2);

//        double dLong = dest.longitude - playerPos.longitude;
//        double dLat = dest.latitude - playerPos.latitude;

//        Log.d(TAG,"dLat: " + dLat + " dLong: " + dLong + " zoom: " + map.getCameraPosition().zoom );



        LatLngBounds.Builder builder = new LatLngBounds.Builder();

        builder.include(dest);
        builder.include(new LatLng(dest.latitude + 0.001 , dest.longitude));
        builder.include(new LatLng(dest.latitude - 0.001 , dest.longitude));
        builder.include(playerPos);
        builder.include(new LatLng(playerPos.latitude + 0.001 , playerPos.longitude));
        builder.include(new LatLng(playerPos.latitude - 0.001 , playerPos.longitude));

        LatLngBounds bounds = builder.build();

        int padding = 100;

        CameraPosition cameraPos = CameraPosition.builder().zoom((float) ADELAIDE_ZOOM).tilt(45f + (float) (Math.random() * 20f)).target(focus).build();
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, padding);
//        CameraUpdate cameraUpdate = /CameraUpdateFactory.newCameraPosition(cameraPos);
        map.animateCamera(cameraUpdate, 2000, new GoogleMap.CancelableCallback() {
            @Override
            public void onFinish() {

            }

            @Override
            public void onCancel() {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #map} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (map == null) {
            // Try to obtain the map from the SupportMapFragment.
            map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (map != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #map} is not null.
     */
    private void setUpMap() {
//        map.addMarker(new MarkerOptions().position(ADELAIDE_LAT_LONG).title("Marker"));

        map.setOnCameraChangeListener(this);

        CameraUpdate initPos = CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(INIT_LAT_LONG, (float) INIT_ZOOM));
        map.moveCamera(initPos);

        map.getUiSettings().setAllGesturesEnabled(false);

//        CameraUpdate adelaide = CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(ADELAIDE_LAT_LONG, (float) ADELAIDE_ZOOM));
        panToAdelaide();

//        map.setOnMapClickListener(this);

        map.setBuildingsEnabled(true);
    }

    private void panToAdelaide() {
        CameraPosition cameraPos = CameraPosition.builder().zoom((float) ADELAIDE_ZOOM).tilt(45f).target(ADELAIDE_LAT_LONG).build();
        CameraUpdate adelaide = CameraUpdateFactory.newCameraPosition(cameraPos);
        map.setOnMapLoadedCallback(new CameraUpdateCallback(adelaide, map));
    }

    @Override
    public void onCameraChange(CameraPosition cameraPosition) {
        LatLng target = cameraPosition.target;
        float zoom = cameraPosition.zoom;

        Log.d(TAG, "target: " + target + " zoom: " + zoom);
    }

    @Override
    public void onMapClick(LatLng latLng) {
        MarkerOptions marker = newMarkerIconFromIndex((int) (Math.random() * 4)).position(latLng);
//        MarkerOptions marker = new LocationMarker( ShftrLocation );

        map.addMarker(marker);
    }

    int[] arr_transport_icon = new int[]
    {
        R.drawable.walk,
        R.drawable.cycle1,
        R.drawable.bus,
        R.drawable.car
    };

    private MarkerOptions newMarkerIconFromIndex( int index )
    {
        return newMarkerIcon( arr_transport_icon[ index ] );
    }
    private MarkerOptions newMarkerIcon( int transport_icon )
    {
//        int resource = resources;
        BitmapDescriptor icon = BitmapDescriptorFactory.fromResource( transport_icon );

        MarkerOptions markerOptions = new MarkerOptions()
                .title("Current Location")
                .snippet("Thinking of finding some thing...")
                .icon(icon);

//        mMarker = googleMap.addMarker(markerOptions);

        return markerOptions;
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.d(TAG,"transport: " + position);
    }

    @Override
    public void onPageSelected(int position)
    {
        Log.d(TAG,"transport: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        Log.d(TAG,"onPageScrollStateChanged: " + state);
    }



    public static double distance(LatLng a , LatLng b)
    {
        return distance( a.latitude , b.latitude, a.longitude , b.longitude );
    }
    public static double distance(double lat1, double lat2, double lon1, double lon2)
    {
        return distance( lat1 , lat2 , lon1 , lon2 , 0.0 , 0.0 );
    }
    public static double distance(double lat1, double lat2, double lon1, double lon2, double el1, double el2) {

        final int R = 6371; // Radius of the earth

        Double latDistance = Math.toRadians(lat2 - lat1);
        Double lonDistance = Math.toRadians(lon2 - lon1);
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = el1 - el2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }

    public void winAcked()
    {

    }
}
