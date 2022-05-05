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
## Artyom
### In order of appearance
### Timer
A timing system used throughout the program that dictates which visuals play at which time. Depending on the time set, it also influences the visual’s behaviour. 
### WaveForm
Taking advantage of the black background, the waveform blends in and out of view, with its size being influenced by the incoming audio, particularly its height.
### SineWave
A waveform comprised of multiple ellipses in a line. The size of the wave is influenced by the audio, forcing it into a sine wave pattern.
### Intro
A combination of various visuals that serves as a title card for the video. The logo in the middle is a piano drawn using the line function.  The name of the song is displayed below the piano. Flanking both sides of the song title are vertical waveforms which span the length of the screen.
At the top and bottom half are lines that expand until they hit the length of the screen. This effect is achieved by incrementing the x2 co-ordinate using a suitable variable.
### Mountains
An infinite 3-D procedurally generated landscape which reacts to audio and is coloured according to the position of the y-axis. The landscape is generated using a grid of triangle strips, where some vertices are pulled up or down depending on the values generated, creating a mountainous effect.
### Star
Generates an array of stars which give the illusion of movement by growing in size as they approach the edges of the screen. An array of colours is used to colour each star differently.
### Finale
Creates a rotating circle which has a circle pattern in its centre using trigonometry to make multiple symmetrical lines. The diameter of the circle is influenced by the audio, growing, and shrinking in size according to the audio level. The scale of the circle is gradually increased until the centre is roughly the same size as the circle in the Space visual to facilitate a smoother transition. 
### Outro
Ending portion of the video, combines the WaveIntro and SineWave visuals, along with two lines at the top and bottom which change colour as they fade in length. Contains a message thanking the viewer for their patience. 

# What I am most proud of in the assignment
## Artyom
While it required some effort to create the individual visuals, what I was most satisfied with was combining the team’s various efforts into one cohesive music video. Managing the visual transitions based on what part of the music was playing took careful planning. The result was a medley of visuals which I think fit the image and tone of the song well. I’m happy with how the project turned out.

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

