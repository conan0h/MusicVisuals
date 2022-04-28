package ie.tudublin;

import processing.core.PApplet;
//to comment
public class Sun {
    SongVisuals sv;
    float x;
    float y;

    double rotate = 0;
    double hy = 0;
    double ad;
    double op; 

    double endY;
    double endX;

    float fendX;
    float fendY;
    boolean sizeCheck;

    double tempW;
    double tempH;
    double tempHy;

    float leftH;
    float leftW; 
    float rightH;
    float rightW; 
    float midH;
    float midW; 

    float startX;
    float startY;

    float corner;
   
    public Sun(SongVisuals sv){
        this.sv = sv; 
        x = this.sv.width;
        y = this.sv.height;                   
    }

    public void render(){
        sv.stroke(255);
        sv.calculateAverageAmplitude();
        sv.colorMode(PApplet.HSB, 360, 360, 360);

        for (int a = 0; a < 30; a++){
            spin(a);
        } 

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
                hy = hy + .000006*x;
                
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

        corner = (float) hy;

        if(sv.timer.seconds() < 89 & hy > .00003*x ){
            
            //float distance = sv.dist(midW, midH, fendX, fendY)/2;
            
            fendX = midW;
            fendY = midH;
            
            //sv.arc(midW, midH-corner/20, 180, 0, sv.HALF_PI, sv.PI);
            //sv.arc(midW, midH+corner/20, corner/15, corner/15, sv.QUARTER_PI, sv.PI-sv.QUARTER_PI);
            sv.circle(midW, midH+corner/18, corner/5*(amp));
            sv.line(midW+corner/30, midH-corner/12, midW+corner/30, midH-corner/50);
            sv.line(midW-corner/30, midH-corner/12, midW-corner/30, midH-corner/50);

            for(int i = 0; i < 8; i++)
            {
                if (i%2==0)
                {
                    ad = Math.cos(Math.toRadians(stagger*12 + rotate - 15))*hy/i;
                    op = Math.sin(Math.toRadians(stagger*12 + rotate - 15))*hy/i;
                    startX = fendX;
                    startY = fendY;
                    endX = ad + midW;
                    endY = op + midH;
                    fendX = (float) endX;
                    fendY = (float) endY;
                    sv.line(startX, startY, fendX, fendY);
                }
                else
                {
                    ad = Math.cos(Math.toRadians(stagger*12 + rotate + 15))*hy/i;
                    op = Math.sin(Math.toRadians(stagger*12 + rotate + 15))*hy/i;
                    startX = fendX;
                    startY = fendY;
                    endX = ad + midW;
                    endY = op + midH;
                    fendX = (float) endX;
                    fendY = (float) endY;
                    sv.line(startX, startY, fendX, fendY);
                }
            }

            
            if(sv.timer.seconds() < 89 & hy > .00003*x ){
                ad = Math.cos(Math.toRadians(0 + stagger*12 + rotate))*hy;
                op = Math.sin(Math.toRadians(0 + stagger*12 + rotate))*hy;
                
                sv.noFill();

                for(int i = 0; i<8; i++){
                    float circleCenter = (float) (hy*2)/i;
                    sv.circle(midW, midH, circleCenter);
                }
                
                

                endX = ad + midW;
                endY = op + midH;
                fendX = (float) endX;
                fendY = (float) endY;
                
                float distance = sv.dist(midW, midH, fendX, fendY)/2;
    
                for(int i = 0; i < 4; i++)
                {
                    if(i == 0 || i == 2)
                    {
                        startX = fendX;
                        startY = fendY;
                        endX = ad + endX + distance;
                        //endY = op + endY + distance;
                        fendX = (float) endX;
                        fendY = (float) endY;
                        sv.line(startX , startY, fendX, fendY);
                    }
                    else{
                        startX = fendX;
                        startY = fendY ;
                        endX = ad + endX - distance;
                        //endY = op + endY - distance;
                        fendX = (float) endX;
                        fendY = (float) endY;
                        sv.line(startX, startY, fendX, fendY);
                    }
                }
                
    
                //sv.line(midW, midH, fendX, fendY);
            }
            

        }
        else if (sv.timer.seconds() > 88){
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

            sv.noFill();
            sv.circle(leftW, leftH, corner*2);
            sv.circle(rightW, rightH, corner*2);
            sv.fill(400*(amp/2), 400, 400);
            sv.rect(0, leftH+(y/3), x, sv.getSmoothedAmplitude()*x/3);
        }
        
}

}
