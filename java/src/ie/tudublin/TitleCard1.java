package ie.tudublin;

import processing.core.PConstants;
import processing.core.PFont;

public class TitleCard1 {
    SongVisuals sv;
    float x;
    float y;
    PFont f;
    public TitleCard1 (SongVisuals sv){
        this.sv = sv;
        x = this.sv.width;
        y = this.sv.height;
        f = sv.createFont("font.otf", 24);
        sv.textFont(f);
    }
    public void render(){
        sv.textSize(48);
        sv.textAlign(PConstants.CENTER, PConstants.CENTER);
        sv.text("MGMT", x/2, y/2);
        
    }
}
