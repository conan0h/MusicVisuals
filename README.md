# Music Visualiser Project

Name: Piotr Jachont

Student Number: C20758051

Name: David Prior

Student Number: C20391861

Name: Conan O'hara

Student Number: C20730175

Name: Artyom McNiff

Student Number: C20394301

# Description of the assignment
Our groups Music Visualizer compiles a montage of different visuals all inspired by the song "Kids" by MGMT. The song was split into parts which transition using an in-built timer. 

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
## Spiral
A visualisation of a growing eye at it's center a spiraling circle with a small smiley. After which a robotic face appears. 
I implemented dynamic responses to the music through ampiltude, changing variables scale, stroke weight and colour. 
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

## BoxSphere
Three Cubes containing Spheres who's colour adapts based on the amplitude of the song. The spheres expand and shrink inside of the boxes dynamically according to the amplitude of the audio aswell.
## BoxForm
An rainbow coloured waveform that is comprised of a bunch of lines spanning the width of the screen. The height of these lines are affected by the song audio making them display the song playing as a wave pattern.
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

### David
What I am most proud of in this assignment was the Box-Sphere visual I made. Though it was relatively simple in terms of actual code after putting the amount of time I did into making it I was very pleased with how it turned out looking while the song was playing. This was even more satisfying in the end compilation when paired with the Box wave visual that brought a more completed look to the visual.

### Conan
Creating the spiraling effect took a lot of logical thinking and experimentation. During which I accidently constructed a horizontal eclipse, similar somewhat to an eye. I thought it looked amazing and knew it would make a greater outside border for my inner circle. The end result created an almost surreal visual I'm very fond of.

# Our youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

