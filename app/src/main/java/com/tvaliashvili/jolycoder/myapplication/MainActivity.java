package com.tvaliashvili.jolycoder.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.here.android.mpa.common.GeoCoordinate;
import com.here.android.mpa.common.Image;
import com.here.android.mpa.common.OnEngineInitListener;
import com.here.android.mpa.common.ViewObject;
import com.here.android.mpa.mapping.Map;
import com.here.android.mpa.mapping.MapFragment;
import com.here.android.mpa.mapping.MapGesture;
import com.here.android.mpa.mapping.MapMarker;
import com.here.android.mpa.mapping.MapObject;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            // Search for the Map Fragment
            final MapFragment mapFragment = (MapFragment)
                    getFragmentManager().findFragmentById(R.id.mapfragment);
            // initialize the Map Fragment and
            // retrieve the map that is associated to the fragment

            mapFragment.init(new OnEngineInitListener() {
                @Override
                public void onEngineInitializationCompleted(
                        OnEngineInitListener.Error error) {
                    if (error == OnEngineInitListener.Error.NONE) {
                        // now the map is ready to be used
                        Map map = mapFragment.getMap();
                        map.setCenter(new GeoCoordinate(43.025168990759376, 44.68965415527805), Map.Animation.NONE);
                        System.out.println("SetUp\n");
                        GeoCoordinate geo = new GeoCoordinate(43.02053449840314,44.68205451861843);
                        GeoCoordinate geo1 = new GeoCoordinate(43.02928510821587,44.68055413017191);
                        Image img = new Image();
                        Image img1 = new Image();
                        try {
                            img.setImageResource(R.drawable.shtiba);
                            img1.setImageResource(R.drawable.prosp);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        MapMarker mp = new MapMarker(geo, img);
                        MapMarker mp1 = new MapMarker(geo1, img1);
                        map.addMapObject(mp);
                        map.addMapObject(mp1);
                    } else {
                        System.out.println("ERROR: Cannot initialize MapFragment");
                    }
                }
            });


//            Map map = mapFragment.getMap();
//            if(map != null) {
//                map.setCenter(new GeoCoordinate(67.196261,
//                        -76.004773), Map.Animation.NONE);
//                System.out.println("SetUp\n");
//            }
//            else
//            {
//                System.out.println("Null\n");
//            }
//            GeoCoordinate geo = new GeoCoordinate(49.2488091, -122.98051040000001, 59);
//            MapMarker mp = new MapMarker();
//            if(!mp.isVisible())
//            {
//                mp.setVisible(true);
//            }
            MapGesture.OnGestureListener listener =
                    new MapGesture.OnGestureListener.OnGestureListenerAdapter() {
                        @Override
                        public boolean onMapObjectsSelected(List<ViewObject> objects) {
                            for (ViewObject viewObj : objects) {
                                if (viewObj.getBaseType() == ViewObject.Type.USER_OBJECT) {
                                    if (((MapObject)viewObj).getType() == MapObject.Type.MARKER) {
                                        // At this point we have the originally added
                                        // map marker, so we can do something with it
                                        // (like change the visibility, or more
                                        // marker-specific actions)
                                        ((MapObject)viewObj).setVisible(false);
                                        System.out.println("OK\n");
                                    }
                                }
                            }
                            // return false to allow the map to handle this callback also
                            return false;
                        }
                    };
//
        }
        catch(Exception e)
        {
            System.out.println("ERROR " + e + " ");
        }
    }


    public void onC(View view) {
        Intent intent = new Intent(MainActivity.this, MenuActivity.class);
        startActivity(intent);
    }
}
