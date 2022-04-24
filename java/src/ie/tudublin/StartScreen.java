package ie.tudublin;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;

public class StartScreen
{
    SongVisuals sv;
    PFont f;
    float x;
    float y;

    public StartScreen(SongVisuals sv){
        this.sv = sv;
        x = this.sv.width;
        y = this.sv.height;
        f = sv.createFont("font.otf", 24);
        sv.textFont(f);
    }

    public void render(){
        sv.textAlign(PConstants.CENTER, PConstants.CENTER);
        sv.text("PRESS SPACEBAR TO START", x/2, y/2);
        
    }
}