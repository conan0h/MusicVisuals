package C20394301;
import ie.tudublin.*;

import processing.core.PApplet;
import processing.core.PConstants;

public class Intro {
    SongVisuals sv;
    float x;
    float y;
    float cy = 0;
    float f = 0;
    float i = 0;
    float j = 0;
    float[] lerpedBuffer;
    public Intro(SongVisuals sv)
    {
        this.sv = sv;
        x = this.sv.width;
        y = this.sv.height;
        cy = this.sv.height / 2;
        f = 0;
        lerpedBuffer = new float[this.sv.width];
    }

    public void render()
    {
        //LineIntro
        sv.stroke(255);
        sv.strokeWeight(2);
        sv.line(x, y/8, x-i, y / 8);
        sv.line(0, y - y / 8, 0 + j, y - y / 8);

        if (i < x){
            i = i + (0.003f*x);
        }

        if (j < x){
            j = j + (0.003f*x);
        }

        //Piano
        sv.stroke(255);
        sv.line(x/2, y/2 - 50, x/2 - 50, y/2 - 50);
        sv.line(x/2 - 50, y/2 - 50, x/2 - 50, y/2 - 75);
        sv.line(x/2 - 50, y/2 - 75, x/2, y/2 - 75);

        sv.line(x/2, y/2 - 50, x/2 + 50, y/2 - 50);
        sv.line(x/2 + 50, y/2 - 50, x/2 + 50, y/2 - 75);
        sv.line(x/2 + 50, y/2 - 75, x/2, y/2 - 75);

        sv.line(x/2 + 45, y/2 - 50, x/2 + 45, y/2-25);
        sv.line(x/2 - 45, y/2 - 50, x/2 - 45, y/2-25);
        
        
        sv.line(x/2 + 45, y/2 - 75, x/2+25, y/2 - 125);
        sv.line(x/2 - 45, y/2 - 75, x/2+35, y/2 - 135);

        //WaveForm
        sv.colorMode(PApplet.HSB);
        for (int i = 0; i < sv.getAudioBuffer().size(); i++)
        {
            lerpedBuffer[i] = PApplet.lerp(lerpedBuffer[i], sv.getAudioBuffer().get(i), 0.05f);
            sv.stroke
            (
                PApplet.map(i, 0, sv.getAudioBuffer().size(), 0, 255),
                255,
                255
            );
            float feh = lerpedBuffer[i] * cy * 4.0f;
            sv.line(cy+cy+cy,PApplet.map(i, 0, sv.getAudioBuffer().size(), 0, sv.height), (cy+cy+cy) + (cy*(0.001f*feh)), PApplet.map(i, 0, sv.getAudioBuffer().size(), 0, sv.height) );
            sv.line(cy/2, PApplet.map(i, 0, sv.getAudioBuffer().size(), 0, sv.height), (cy/2) + (cy *(0.001f*feh)), PApplet.map(i, 0, sv.getAudioBuffer().size(), 0, sv.height) );
        }

        //Title
        sv.textSize(48);
        sv.colorMode(PConstants.RGB);
        sv.fill(255, 0, 0);
        sv.textAlign(PConstants.CENTER, PConstants.CENTER);
        sv.text("KIDS", x/2, y/2);


    }
}
