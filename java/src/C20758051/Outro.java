package C20758051;

import processing.core.PApplet;
import processing.core.PConstants;

public class Outro {

    SongVisuals sv;
    float x;
    float y;
    float i = 0;
    float j = 0;
    public Outro(SongVisuals sv)
    {
        this.sv = sv;
        x = this.sv.width;
        y = this.sv.height;
    }

    public void render()
    {
        sv.colorMode(PConstants.HSB);
        sv.stroke(PApplet.map(i, 0, x, 0, 255), 255, 255 );
        sv.strokeWeight(2);
        sv.line(x, y/8, 0+i, y / 8);
        sv.line(0, y - y / 8, x - j, y - y / 8);

        if (i < x){
            i = i + (0.003f*x);
        }

        if (j < x){
            j = j + (0.003f*x);
        }

       if (sv.timer.seconds() > 299)
        {
            sv.textSize(48);
            sv.colorMode(PConstants.RGB);
            sv.fill(255);
            sv.textAlign(PConstants.CENTER, PConstants.CENTER);
            sv.text("THANK YOU FOR WATCHING", x/2, y/3);
        }
    }
    
    
}
