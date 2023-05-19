package XXLChess.Implementations;
import java.io.File;

import XXLChess.Interfaces.*;
import processing.core.PApplet;
import processing.core.PImage;
import processing.data.JSONObject;


public class PAppletWrapper implements IPAppletWrapper {
    private final PApplet applet;
    private JSONObject configuration;


    public PAppletWrapper(PApplet applet, String configName) {
        this.applet = applet;
        configuration = PApplet.loadJSONObject(new File(configName));
    }
    
    
    @Override
    public JSONObject GetConfiguration() {
        return configuration;
    }

    @Override
    public void fill(int color) {
        applet.fill(color);
    }

    @Override
    public void rect(float x, float y, float width, float height) {
        applet.rect(x, y, width, height);
    }

    public void fill(float v1, float v2, float v3) 
    {
        applet.fill(v1, v2, v3);
    }
   
    @Override
    public void background(int rgb) {
       applet.background(rgb);
    }

    @Override
    public void textSize(int size) {
        applet.textSize(size);
    }


    @Override
    public PImage loadImage(String path) {
        return applet.loadImage(path);
    }


    @Override
    public JSONObject loadJSONObject(String filePath) {
        return applet.loadJSONObject(filePath);
    }

    @Override
    public void image(PImage image, float x, float y, float width, float height) {
        applet.image(image, x, y, width, height);
    }
    
}