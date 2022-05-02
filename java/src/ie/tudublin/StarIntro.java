package ie.tudublin;

import processing.core.*;

public class StarIntro {
    SongVisuals sv;
    int colorChange;
    float x;
    float y;
    float yspeed;
    float stary = 0;
    float starx;
    float starz;
    float starr;
    
    int[][] colors = new int[7][3];
    

    public StarIntro(SongVisuals sv, int colorChange){
        this.sv = sv;
        this.colorChange = colorChange;
        x = this.sv.width / 2;
        y = this.sv.height / 2;
        starx = sv.random(-5000, 5000);
        stary = sv.random(-5000, 5000);
        starz = sv.random(0, 2000);

        // red
        colors[0][0] = 255;
        colors[0][1] = 49;
        colors[0][2] = 49;

        // orange
        colors[1][0] = 255;
        colors[1][1] = 165;
        colors[1][2] = 0;
         

        // yellow
        colors[2][0] = 255;
        colors[2][1] = 215;
        colors[2][2] = 0;

        // green
        colors[3][0] = 15;
        colors[3][1] = 255;
        colors[3][2] = 80;

        // blue
        colors[4][0] = 31;
        colors[4][1] = 81;
        colors[4][2] = 255;

        // purple
        colors[5][0] = 128;
        colors[5][1] = 0;
        colors[5][2] = 128;


        // pink
        colors[6][0] = 255;
        colors[6][1] = 105;
        colors[6][2] = 180;
    }

    void star(float x, float y, float radius1, float radius2, int npoints) {
        float angle = PConstants.TWO_PI / npoints;
        float halfAngle = angle/2.0f;
        sv.beginShape();
        for (float a = 0; a < PConstants.TWO_PI; a += angle) {
          float sx = x + PApplet.cos(a) * radius2;
          float sy = y + PApplet.sin(a) * radius2;
          sv.vertex(sx, sy);
          sx = x + PApplet.cos(a+halfAngle) * radius1;
          sy = y + PApplet.sin(a+halfAngle) * radius1;
          sv.vertex(sx, sy);
        }
        sv.endShape(PConstants.CLOSE);
      }

    public void render()
    {
        starz -= 10;
        if (starz <= 0.0){
            
            starx = sv.random(-5000, 5000);
            stary = sv.random(-5000, 5000);
            starz = 2000;
            
        }
        
        sv.fill(colors[colorChange][0], colors[colorChange][1], colors[colorChange][2]);
        sv.noStroke();
        float offsetX = 100.0f *(starx/starz);
        float offsetY = 100.0f*(stary/starz);
        float scaleZ = 0.0001f * (2000.0f - starz);
        sv.pushMatrix();
        sv.translate(offsetX, offsetY);
        sv.scale(scaleZ);
        sv.rotate(sv.frameCount / -100.0f);
        star(0, 0, 80, 120, 5); 
        
        sv.popMatrix();



    }
}

