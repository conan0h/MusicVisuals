package ie.tudublin;

import processing.core.PApplet;

public class WaveIntro {
    SongVisuals sv;
    float x;
    float y;

    public WaveIntro(SongVisuals sv){
        this.sv = sv;
        x = this.sv.width / 2;
        y = this.sv.height / 2;

    }

    public void render(){
        sv.colorMode(PApplet.HSB);
        sv.strokeWeight(2);
        for (int i = 0; i < sv.getAudioBuffer().size(); i++){
            sv.stroke(255, sv.getAudioBuffer().get(i)*700);
            sv.line((i+i+i), y + sv.getAudioBuffer().get(i)*300, (i+i+i), y - sv.getAudioBuffer().get(i)*300);
        }
    }
}
