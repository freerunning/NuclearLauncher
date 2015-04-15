package com.dyu.nuclearlauncher;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Launcher extends Activity {

    private GLSurfaceView mGLSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        mGLSurfaceView = new GLSurfaceView(this);

//        if (isOpenGL20()){
//            mGLSurfaceView.setEGLContextClientVersion(2);
            mGLSurfaceView.setRenderer(new NlRenderer());
//        }else{
//            return;
//        }

        setContentView(mGLSurfaceView);
    }

    private boolean isOpenGL20(){
        final ActivityManager am = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
        final ConfigurationInfo ci = am.getDeviceConfigurationInfo();
        return ci.reqGlEsVersion >= 0x20000;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mGLSurfaceView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mGLSurfaceView.onResume();
    }
}
