package XXLChess.Interfaces;


import processing.core.PImage;
import processing.data.JSONObject;

public interface IPAppletWrapper {
    void fill(int color);
    void rect(float x, float y, float width, float height);
    JSONObject GetConfiguration();
    void fill(float v1, float v2, float v3);
    void background(int rgb); 
    void textSize(int size);
    PImage loadImage(String path);
    JSONObject loadJSONObject(String filePath);
    void image(PImage image, float x, float y, float width, float height);
} 