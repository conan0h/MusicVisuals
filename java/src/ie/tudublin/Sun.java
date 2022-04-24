package ie.tudublin;

import processing.core.PApplet;
import processing.core.PConstants;

public class Sun {
    SongVisuals sv;
    float x;
    float y;
    double rotate = 0;
    double hy = 0;
    double ad;
    double endX;
    double op; 
    double endY;
    float fendX;
    float fendY;
    boolean sizeCheck;
    float[][] land;
    int counter = 0;
    int midFlag = 0;
    double tempW;
    double tempH;
    double tempHy;
    double fade = 0;

    float leftH;
    float leftW; 

    float rightH;
    float rightW; 

    float midH;
    float midW; 
   
    public Sun(SongVisuals sv){
        this.sv = sv; 
        x = this.sv.width;
        y = this.sv.height;                   
    }

    public void spin(int stagger){
            float amp = sv.getSmoothedAmplitude(); 
            
            leftH = y/3;
            leftW = x/3; 

            rightH = y/3;
            rightW = x-(x/3); 

            midH = y/2;
            midW = x/2; 

            sv.strokeWeight(amp*25);
            sv.stroke(400*(amp/2), 400, 400);

            rotate = rotate + .005;

            if(sv.timer.seconds() > 89){
                if (sizeCheck == true){
                    hy = hy +.000006*x;
                    if (hy>x/8){
                            sizeCheck=false;
                    }
                }
                if (sizeCheck == false){
                    hy = hy - .000006*x;
                    if (hy<x/10){
                        sizeCheck=true;
                    }
                }
                midFlag = 1;
            }
            else if (sv.timer.seconds() > 78 && sv.timer.seconds() < 89){
                if (hy>=0){
                    hy = hy - 0.00005*x;
                }
            }
            else{
                if(hy<0.75*x){
                    hy = hy + 0.00002*x;
                }
            }

            if(sv.timer.seconds() < 89 & hy > .00003*x ){
                ad = Math.cos(Math.toRadians(0 + stagger*12 + rotate))*hy;
                op = Math.sin(Math.toRadians(0 + stagger*12 + rotate))*hy;
                endX = ad + midW;
                endY = op + midH;
                fendX = (float) endX;
                fendY = (float) endY;

                sv.line(midW, midH, fendX, fendY);
            }
            else if (sv.timer.seconds() > 88.5){
                ad = Math.cos(Math.toRadians(0 + stagger*12 + rotate))*hy;
                op = Math.sin(Math.toRadians(0 + stagger*12 + rotate))*hy;
            
                endX = ad + leftW;
                endY = op + leftH;
                fendX = (float) endX;
                fendY = (float) endY;

                sv.line(leftW, leftH, fendX, fendY); 
                
                endX = ad + rightW;
                endY = op + rightH;
                fendX = (float) endX;
                fendY = (float) endY;

                sv.line(rightW, rightH, fendX, fendY);
            }

            if(sv.timer.seconds() > 89){
                sv.fill(400*(amp/2), 400, 400);
                sv.rect(0, leftH+(y/3), x, sv.getSmoothedAmplitude()*250);
            }
            
    }

    public void render(){
        sv.stroke(255);
        sv.calculateAverageAmplitude();
        sv.colorMode(PApplet.HSB, 360, 360, 360);

        for (int a = 0; a < 30; a++){
            spin(a);
        } 

    }

}
