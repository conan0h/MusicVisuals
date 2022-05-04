package C20758051;

import processing.core.PApplet;

public class SineWave {
    SongVisuals sv;
    float x = 0;
    float y = 0;
    float t = 0;
    float diameter  = 2;
    float frequency = 3.0f;
    float[] lerpedBuffer;

    public SineWave(SongVisuals sv){
        this.sv = sv;
        x = this.sv.width / 2;
        y = this.sv.height/ 2;
        lerpedBuffer = new float[this.sv.width];
    }

    public void render(){
        

        sv.colorMode(PApplet.HSB);
        sv.strokeWeight(1);
        for(int i = 0 ; i < sv.getAudioBuffer().size() ; i ++)
        {
            lerpedBuffer[i] = PApplet.lerp(lerpedBuffer[i], sv.getAudioBuffer().get(i), 0.05f);
            sv.stroke(
                PApplet.map(i, 0, sv.getAudioBuffer().size(), 0, 255)
                , 255
                , 255
            );
            float feh = lerpedBuffer[i] * (y / 2) * 4.0f;
            sv.ellipse((PApplet.map(i, 0, sv.getAudioBuffer().size(), 0, sv.width)), 2*(feh)*PApplet.sin(frequency*(feh))+y, diameter, diameter);
        }
    }
}
