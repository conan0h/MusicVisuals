package ie.tudublin;

import processing.core.PApplet;

public class Ripple {
    SongVisuals sv;
    Timer timer;
    float x;
    float y;
    int count = 0;
    int i = 0;
    int lastTime = 0;
    float[] randX = new float[9];
    float[] randY = new float[9];
    // 8;
    // 250

    public Ripple(SongVisuals sv){
        this.sv = sv;
        this.x = this.sv.width;
        this.y = this.sv.height;
        for (int i = 0; i < 8; i++){
            randX[i] = this.sv.random(0, this.x);
            randY[i] = this.sv.random(0, this.y);
        }
        timer = new Timer(this.sv);
        timer.start();
    }

    public void render(){
        
        sv.colorMode(PApplet.HSB);
        sv.stroke(255);
        sv.strokeWeight(3);
        sv.noFill();
        if (count < 9){
            sv.circle(x/2, y/2, i);
            if (sv.millis() - lastTime > 250){
                sv.strokeWeight(3);
                sv.circle(randX[count], randY[count], i);
                count++;
                lastTime = sv.millis();
    
            }
        }
        i += 10;
    }
}
