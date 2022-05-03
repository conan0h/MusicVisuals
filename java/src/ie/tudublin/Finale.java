package ie.tudublin;

import processing.core.PApplet;
import processing.core.PConstants;

public class Finale {
    SongVisuals sv;
    float x;
    float y;
    float dia = 50;
    float angle;
    float i = 0;
    float sW_max;
    float sW_angle;
    boolean reverse;

    public Finale(SongVisuals sv){
        this.sv = sv;
        x = this.sv.width;
        y = this.sv.height;



    }


    public void render()
    {
        
        sv.strokeCap(PConstants.CORNER);
        sv.stroke(255);
        sv.calculateAverageAmplitude();

        dia = PApplet.lerp(dia, i, -0.0036f);

        sv.translate(x/2, y/2);
        sv.rotate(-angle);

        // 45 degrees until 360
        for (int deg=0; deg<360; deg += 30)
        {
            sv.pushMatrix();
            sv.rotate(PApplet.radians(deg));
        

            for (int r = 0; r <180; r += 8){
                float sW = PApplet.map(PApplet.cos(PApplet.radians(r)), -1,1,sW_max,1);
                sv.strokeWeight(sW);
                sv.line(PApplet.sin(PApplet.radians(r))*dia,
                PApplet.cos(PApplet.radians(r))*dia * sv.getSmoothedAmplitude(), PApplet.sin(PApplet.radians(-r))*dia, PApplet.cos(PApplet.radians(-r))*dia * (sv.getSmoothedAmplitude()));
                
            }
            sv.popMatrix();
        }
        angle += PConstants.TWO_PI/720;

        sW_angle = PApplet.map(dia, 0, x, 0, 360);
        sW_angle = PApplet.constrain(sW_angle, 180, 360);
        sW_max = PApplet.map(PApplet.cos(PApplet.radians(sW_angle)), -1, 1, 1, 225);

        sv.noFill();
        sv.stroke(255);
        sv.ellipse(0, 0, dia*2, dia*2);

        
        if (!reverse){
            i++;
        }
        if (reverse){
            i--;
        }
        
        if (i > 10){
            i += 5;
            reverse = true;
        }
    }
}
