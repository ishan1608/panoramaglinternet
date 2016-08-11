package com.ishan1608.panoramaglinternet;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.panoramagl.PLView;
import com.panoramagl.loaders.PLILoader;
import com.panoramagl.loaders.PLJSONLoader;
import com.panoramagl.loaders.PLLoaderListener;
import com.panoramagl.transitions.PLTransitionBlend;

public class MainActivity extends PLView {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected View onContentViewCreated(View contentView) {
        //Load layout
        ViewGroup mainView = (ViewGroup)this.getLayoutInflater().inflate(R.layout.activity_main, null);
        //Add 360 view
        mainView.addView(contentView, 0);

        // Loading panorama from internet
        loadSpherical2InternetJson();

        //Return root content view
        return super.onContentViewCreated(mainView);
    }

    private void loadSpherical2InternetJson() {
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
    }
}
