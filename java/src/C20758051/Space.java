package C20758051;


import processing.core.*;


//Creating class Space
public class Space {
    SongVisuals sv;
    float height; //Creating the height float
    float width; //Creating the width float
    float t = 100; //Creating a float for the vertex's positioning
    float angle1; //Creating the angle1 
    float angle2; //Creating the angle2 for the Z axis

    //Creating connection for the timer in SongVisuals
    public Space(SongVisuals sv)
    {
        this.sv = sv;
    }

    //Creating the first set of shapes Sphere + Circle for the sphere to penetrate the circle using angles and width and height meanwhile the sphere rotating through it.

    public void render() {
    sv.pushMatrix();
    sv.beginShape();


            //Making sure colormode goes with the song.
            sv.colorMode(PApplet.HSB);
            sv.noFill();
            sv.circle(sv.width/2f, sv.height/2f, 500 * sv.getSmoothedAmplitude());

            //Creating rotations for the sphere and speed of sphere using the angle1

            sv.rotateX(angle1);

            sv.rotateY(angle1);

            sv.rotateZ(angle1);

            angle1 += 0.000001f;
            //Creating a sphere to go through the circle
            sv.translate(sv.width/2, sv.height/2, 0);
            sv.strokeWeight(2);
            sv.sphere(140 * sv.getSmoothedAmplitude() * 1); //setting the spheres to grow with the rhythym of the song.

            sv.endShape();
            sv.popMatrix();

    // Creating a set of Vertex's to rotate on the right hand side
            sv.pushMatrix();
            sv.beginShape();
            sv.translate(sv.width/1.25f, sv.height/2f); //Positioning the triangles to the center of the program
            sv.stroke(PApplet.map(sv.getSmoothedAmplitude()*4, 0, 1, 0, 255), 255, 255);  //React to the colors

            //Creating code for the speed of the vertex's rotating
            if (sv.timer.seconds()  > 178 && sv.timer.seconds() <= 193)
            {
                angle1 += 0.015f;
                angle1 += 0.015f;
                angle2 += 0.015f;
            }
            else if (sv.timer.seconds()  > 193 && sv.timer.seconds() <= 198)
            {
                angle1 += 0.045f;
                angle1 += 0.045f;
                angle2 += 0.045f;
            }

            else if (sv.timer.seconds()  > 198 && sv.timer.seconds() <= 231)
            {
                angle1 += 0.06f;
                angle1 += 0.06f;
                angle2 += 0.06f;
            }

            else
            {
                sv.colorMode(PApplet.RGB);
                angle1 -= 0.015f;
                angle1 -= 0.015f;
                angle2 -= 0.015f;
            }
            
        
            sv.rotateX(angle1);
            sv.rotateY(angle1);
            sv.rotateZ(angle2);


            //Creating coordinates for the vertex's to be positioned via the float t option
            sv.vertex(-t, -t, -t);
            sv.vertex( t, -t, -t);
            sv.vertex( 0, 0, t);
    
            sv.vertex( t, -t, -t);
            sv.vertex( t, t, -t);
            sv.vertex( 0, 0, t);
        
            sv.vertex( t, t, -t);
            sv.vertex(-t, t, -t);
            sv.vertex( 0, 0, t);
        
            sv.vertex(-t, t, -t);
            sv.vertex(-t, -t, -t);
            sv.vertex( 0, 0, t);

            sv.endShape();
            sv.popMatrix();

            //Creating a set of vertex's on the left hand side.

            sv.pushMatrix();
            sv.beginShape();
            sv.translate(sv.width/4.5f, sv.height/2f); //Positioning the vertex's to the center of the program
            sv.stroke(PApplet.map(sv.getSmoothedAmplitude()*4, 0, 1, 0, 255), 255, 255);  //Making sure the vertex's react with color

                    //Making sure the vertexs rotate in an X and Y and Z Angle.
                    sv.rotateX(angle1);
                    sv.rotateY(angle1);
                    sv.rotateZ(angle2);
                    //Creating coordinates for the vertex's to be positioned via the float t option
                    sv.vertex(-t, -t, -t);
                    sv.vertex( t, -t, -t);
                    sv.vertex( 0, 0, t);
    
                    sv.vertex( t, -t, -t);
                    sv.vertex( t, t, -t);
                    sv.vertex( 0, 0, t);
        
                    sv.vertex( t, t, -t);
                    sv.vertex(-t, t, -t);
                    sv.vertex( 0, 0, t);
        
                    sv.vertex(-t, t, -t);
                    sv.vertex(-t, -t, -t);
                    sv.vertex( 0, 0, t);
                    sv.endShape();
                    sv.popMatrix();



                //Creating 2 spirals to be placed in the background of the visual left and right, Also making sure the spirals react with the song also creating gaps via sin and cos etc.
                sv.stroke(PApplet.map(sv.getSmoothedAmplitude()*4, 0, 1, 0, 255), 255, 255);  //Making sure the spirals react with color
                sv.translate(sv.width/4, sv.height/2, 0); //Positioning the spirals
                float gap = 2*sv.getSmoothedAmplitude(); //Making sure at certain times it expands
                for (float t = 0; t < sv.width; t+=0.25 ) { //incremenet every time by 0.25
                float x = (t * PApplet.cos(t)*gap); //Creates Gaps 
                float y = (t * PApplet.sin(t))*gap; //Creats Gaps
                sv.point(x, y); } //Constructs and initializes points at the x axis and y axis
            
            
                sv.stroke(PApplet.map(sv.getSmoothedAmplitude()*4, 0, 1, 0, 255), 255, 255); //Making sure the spirals react with color
                sv.translate((sv.width*3)/6, sv.height/120, 0); //Positioning the spirals
                for (float t = 0; t < sv.width; t+=0.25 ) { //Making sure at certain times it expands
                float x = (t * PApplet.cos(t)*gap); //Creats Gaps
                float y = (t * PApplet.sin(t))*gap; //Creats Gaps
                sv.point(x, y); } //Constructs and initializes points at the x axis and y axis
            
            
        


   }   }