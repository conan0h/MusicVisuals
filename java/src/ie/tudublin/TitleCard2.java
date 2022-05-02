package ie.tudublin;

import processing.core.PConstants;
import processing.core.PFont;

public class TitleCard2 {
    SongVisuals sv;
    float x;
    float y;
    PFont f;
    public TitleCard2 (SongVisuals sv){
        this.sv = sv;
        x = this.sv.width;
        y = this.sv.height;
    }
    public void render(){
        sv.textSize(48);
        sv.textAlign(PConstants.CENTER, PConstants.CENTER);
        sv.text("KIDS", x/2, y/2);
        
    }
}
