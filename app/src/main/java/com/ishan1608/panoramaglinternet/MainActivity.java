package com.ishan1608.panoramaglinternet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

//public class MainActivity extends PLView {
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        loadSpherical2InternetJson();
    }

    /*private void loadSpherical2InternetJson() {
        try {
            PLILoader loader = new PLJSONLoader("http://statichost.herokuapp.com/panoramagl/json_spherical2.json");
            loader.setListener(new PLLoaderListener() {
                @Override
                public void didBegin(PLILoader pliLoader) {
                    Log.d(TAG, "Loader begin");
                }

                @Override
                public void didComplete(PLILoader pliLoader) {
                    Log.d(TAG, "Loader complete");
                }

                @Override
                public void didStop(PLILoader pliLoader) {
                    Log.d(TAG, "Loader stop");
                }

                @Override
                public void didError(PLILoader pliLoader, String error) {
                    Log.d(TAG, "Loader error : " + error);
                }
            });
            load(loader, true, new PLTransitionBlend(2.0f));
        } catch (Throwable e) {
            Toast.makeText(getApplicationContext(), "Error: " + e, Toast.LENGTH_LONG).show();
        }
    }*/
}
