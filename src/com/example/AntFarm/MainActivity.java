package com.example.AntFarm;

import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.ui.activity.BaseGameActivity;

public class MainActivity extends BaseGameActivity {

    private Camera mCamera;
    private Scene mMainScene;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
    }

    @Override
    public Engine onLoadEngine() {

        final Display display = getWindowManager().getDefaultDisplay();
        int cameraWidth = display.getWidth();
        int cameraHeight = display.getHeight();

        mCamera = new Camera(0, 0, cameraWidth, cameraHeight);

        return new Engine(new EngineOptions(true, EngineOptions.ScreenOrientation.LANDSCAPE,
                new RatioResolutionPolicy(cameraWidth, cameraHeight), mCamera));
    }

    @Override
    public void onLoadResources() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Scene onLoadScene() {
        mEngine.registerUpdateHandler(new FPSLogger());

        mMainScene = new Scene();
        mMainScene
                .setBackground(new ColorBackground(0.09804f, 0.6274f, 0.8784f));
        return mMainScene;
    }

    @Override
    public void onLoadComplete() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
