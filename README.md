# Music Visualiser Project

Name: Piotr Jachont

Student Number: C20758051

Name: David Prior

Student Number: C20391861

Name: Conan O'hara

Student Number: C20730175

Name: Artyom McNiff

Student Number: C20394301

## Instructions
- Fork this repository and use it a starter project for your assignment
- Create a new package named your student number and put all your code in this package.
- You should start by creating a subclass of ie.tudublin.Visual
- There is an example visualiser called MyVisual in the example package
- Check out the WaveForm and AudioBandsVisual for examples of how to call the Processing functions from other classes that are not subclasses of PApplet

# Description of the assignment
A combination of visuals which transition using an in-built timer. 



# Instructions
Simply press the space bar and watch the show unfold.
# How it works
## In order of appearance
## Timer
A timing system used throughout the program that dictates which visuals play at which time. Depending on the time set, it also influences the visual’s behaviour. 
## WaveForm
Taking advantage of the black background, the waveform blends in and out of view, with its size being influenced by the incoming audio, particularly its height.
## SineWave
A waveform comprised of multiple ellipses in a line. The size of the wave is influenced by the audio, forcing it into a sine wave pattern.
## Intro
A combination of various visuals that serves as a title card for the video. The logo in the middle is a piano drawn using the line function.  The name of the song is displayed below the piano. Flanking both sides of the song title are vertical waveforms which span the length of the screen.
At the top and bottom half are lines that expand until they hit the length of the screen. This effect is achieved by incrementing the x2 co-ordinate using a suitable variable.
## Mountains
An infinite 3-D procedurally generated landscape which reacts to audio and is coloured according to the position of the y-axis. The landscape is generated using a grid of triangle strips, where some vertices are pulled up or down depending on the values generated, creating a mountainous effect.

## Space
I created the public class space and then declared my variables with floats, height, width, t to help the vertex's to position better in the program and angles
I then proceeded to create public space SongVisuals sv this.sv = sv; to connect the main song visual java file to mine.
I then created a render class with push and pop matrix's and began to create shapes.
I first created the circle shape that reacts to the music with color and i used the width and height functions to center the shape.
I then made a sphere that rotates through the circle using sv.rotateX and Y and Z angles and made it so its hollow using the strokeWeight
function I also made it so the sphere reacts and gets bigger with the sv.getSmoothedAplitude code
I have then created a set of vertexs on the right hand side using sv.translate to position them. I also made sure that they
react to the music in terms of speed using the angles -= 0.015f; codes and also made them rotate in a X and Y and Z angles.
I used the t float method to position the shapes more carefully, I then created a 2nd set of vertexs on the left hand side
and did the exact same I did with the right hand side vertex's. I then created 2 spirals using sv.translate to position them
on the left hand side and right hand side with sv.wdith/4, and sv.height/2 to position them. I then have used the t function with
PApplet.cos and PApplet.sin to create gaps and sv.point to construct and initialise points at the x axis and y axis. I then have
created another set to have 2 spirals. I used the function angle1 += 0.015f; to correlate towards the beat of the music so it looks nice
theres also a timer at certain points to correlate inside the program for the compilation for e.g. sv.timer.seconds() > 178 && sv.timer.seconds() <= 198
and where it can transition to the next visual.

```
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






```


## Star
Generates an array of stars which give the illusion of movement by growing in size as they approach the edges of the screen. An array of colours is used to colour each star differently.
## Finale
Creates a rotating circle which has a circle pattern in its centre using trigonometry to make multiple symmetrical lines. The diameter of the circle is influenced by the audio, growing, and shrinking in size according to the audio level. The scale of the circle is gradually increased until the centre is roughly the same size as the circle in the Space visual to facilitate a smoother transition. 
## Outro
Ending portion of the video, combines the WaveIntro and SineWave visuals, along with two lines at the top and bottom which change colour as they fade in length. Contains a message thanking the viewer for their patience. 

# What I am most proud of in the assignment
### Artyom
While it required some effort to create the individual visuals, what I was most satisfied with was combining the team’s various efforts into one cohesive music video. Managing the visual transitions based on what part of the music was playing took careful planning. The result was a medley of visuals which I think fit the image and tone of the song well. I’m happy with how the project turned out.

### Piotr
What I am most proud of in this assignment is the spirals that i have created in the background of my visual the usage of sv.translate and the floats of X Y and t to create gaps
and also the float gap = 2*sv.getSmoothedAplititude(); too create the gaps needed for the spirals.
It has broadened my usage of java and it was a really fun assignment to do. But the most important and fun part of this assignment for me was creating a group with people and
creating these visuals with good communication that is one of the two things that I am most proud of in this assignment 


# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

