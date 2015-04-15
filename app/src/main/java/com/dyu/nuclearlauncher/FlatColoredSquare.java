package com.dyu.nuclearlauncher;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by dingyu on 2015/4/15.
 */
public class FlatColoredSquare extends Square{
    @Override
    public void draw(GL10 gl) {
        gl.glColor4f(0.5f, 0.5f, 1.0f, 1.0f);
        super.draw(gl);
    }
}
