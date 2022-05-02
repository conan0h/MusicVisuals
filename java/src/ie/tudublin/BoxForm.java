package ie.tudublin;

import processing.core.PApplet;

public class BoxForm{
    SongVisuals sv;
    float cy = 0;
    float f = 0;
    float[] lerpedBuffer;

    public BoxForm(SongVisuals sv)
    {
        this.sv = sv;
        cy = this.sv.height / 2;
        f = 0;
        lerpedBuffer = new float[this.sv.width];
    }

    public void render()
    {
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
            sv.strokeWeight(2);
            sv.line(i+i+i, 0, i+i+i, (0) + (cy *(0.001f*feh))  );
            sv.line(i+i+i, cy + cy, i+i+i, (cy+cy) + (cy *(0.001f*feh))  );
        }
        
    }
}