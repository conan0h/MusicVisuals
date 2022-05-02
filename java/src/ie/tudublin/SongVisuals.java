package ie.tudublin;

import processing.core.PFont;

/*
To create a visual to add to the song:
Create a separate class
Pass the SongVisuals class as a parameter to the constructor
Create an instance of the class in SongVisuals
Call the render function in the draw funciton


*/
public class SongVisuals extends Visual 
{    
    // Intro
    AMWaveForm wf;
    LineIntro li;
    TitleCard1 tc1;
    TitleCard2 tc2;
    WaveIntro wi;
    Mountains mt;
    Sun su;
    SineWave sw;
    Timer timer;
    Ripple ri;
    Finale fi;
    Star[] stars = new Star[400];
    StarFinale[] sf = new StarFinale[400];
    Piano pn;
    StartScreen ss;
    Intro in;

    //int[][] colors = new int[7][3];
    int k = 0;


    public void settings()
    {
        fullScreen(P3D);
        //size(1024, 500, P3D);
        
        
        // Use this to make fullscreen
        
    }

    public void setup()
    {
        surface.setLocation(50, 50);
        startMinim();
        loadAudio("Kids.mp3");
        strokeWeight(2);

        // Controls when visuals appear and disappear according to the time
        timer = new Timer(this);

        wf = new AMWaveForm(this);
        li = new LineIntro(this);
        tc1 = new TitleCard1(this);
        tc2 = new TitleCard2(this);
        wi = new WaveIntro(this);
        mt = new Mountains(this);
        sw = new SineWave(this);
        ri = new Ripple(this);
        fi = new Finale(this);
        pn = new Piano(this);
        ss = new StartScreen(this);
        in = new Intro(this);
        
        for (int i = 0; i < stars.length; i++)
        {
            stars[i] = new Star(this, k);
            k++;
            if (k > 6){
                k = 0;
            }
            
        }
        k = 0;
        for (int i = 0; i < sf.length; i++)
        {
            sf[i] = new StarFinale(this, k);
            k++;
            if (k > 6){
                k = 0;
            }
            
        }

        
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
            timer.start();
        }
    }

    public void draw()
    {
        background(0);

        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        // Call this is you want to use frequency bands
       // calculateFrequencyBands(); 

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();
        /*
        wf.render();
        li.render();
        tc.render();
        wi.render();
        mt.render();
        sw.render();
        */
        //ri.render();
        //fi.render();
        //sw.render();
        //translate(0.5f*width, 0.5f*height);
        //ss.render();
        /*
        for (int i = 0; i < stars.length; i++){
            stars[i].render();
        }
        */
        
        
        /*
        for (int i = 0; i < sf.length; i++){
            sf[i].render();
        }
        */
        // 6 refers to the number of seconds
        if (!timer.running){
            
            ss.render();
            translate(0.5f*width, 0.5f*height);
            for (int i = 0; i < stars.length; i++){
                stars[i].render();
            }
        }
    
        
        if(timer.running && timer.seconds() < 6){
            wi.render();
        }

        if (timer.running && timer.seconds() >= 6 && timer.seconds() + 0.5f < 21){
            
            
        }

        if (timer.running && timer.seconds() >= 6 && timer.seconds() <= 13){
            sw.render();
            //tc1.render();
        }

        if (timer.running && timer.seconds() > 13 && timer.seconds() + 0.5f < 21){
            /*
            li.render();
            wf.render();
            pn.render();
            tc2.render();
            */
            // combines the above 4
            in.render();
        }

        if (timer.running && timer.seconds() + 0.5f > 22 && timer.seconds() <= 53){
            mt.render();
        }
        
        
        
        

        


    }
    
}
