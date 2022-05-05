package C20391861;


/*
To create a visual to add to the song:
Create a separate class
Pass the SongVisuals class as a parameter to the constructor
Create an instance of the class in SongVisuals
Call the render function in the draw funciton
*/
public class SongVisuals extends Visual 
{    
    Timer timer;
    WaveIntro wi;
    Intro in;
    Mountains mt;
    Sun su;
    SineWave sw;
    Finale fi;
    Star[] stars = new Star[400];
    StartScreen ss;
    BoxSphere bx;
    BoxForm bf;
    Space sc;
    Outro ou;

    int k = 0;


    public void settings()
    {
        fullScreen(P3D);
        
    }

    public void setup()
    {
        surface.setLocation(100, 100);
        startMinim();
        loadAudio("Kids.mp3");
        strokeWeight(2);

        // Controls when visuals appear and disappear according to the time
        timer = new Timer(this);

        // Initializing visuals
        wi = new WaveIntro(this);
        mt = new Mountains(this);
        sw = new SineWave(this);
        fi = new Finale(this);
        ss = new StartScreen(this);
        in = new Intro(this);
        su = new Sun(this);
        bx = new BoxSphere(this);
        sc = new Space(this);
        bf = new BoxForm(this);
        ou = new Outro(this);

        for (int i = 0; i < stars.length; i++)
        {
            stars[i] = new Star(this, k);
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

        calculateAverageAmplitude();
        
        if (!timer.running){
            ss.render();
        }
    
        // 6 refers to the number of seconds
        if(timer.running && timer.seconds() < 6){
            wi.render();
        }

        if (timer.running && timer.seconds() >= 6 && timer.seconds() <= 13){
            sw.render();
        }

        if (timer.running && timer.seconds() > 13 && timer.seconds() + 0.5f < 21){
            in.render();
        }

        if (timer.running && timer.seconds() + 0.5f > 22 && timer.seconds() <= 53){
            mt.render();
        }
        if (timer.running && timer.seconds() > 53 && timer.seconds() <= 115){
            su.render();
        }
        if (timer.running && timer.seconds() > 115 && timer.seconds() <= 177){
            bx.render();
        }

        if (timer.running && timer.seconds() > 146 && timer.seconds() <= 177){
            bf.render();
        }

        if (timer.running && timer.seconds() > 177 && timer.seconds() <= 193){
            colorMode(RGB);
            translate(0.5f*width, 0.5f*height);
            for (int i = 0; i < stars.length; i++){
                stars[i].render();
            }   
        }

        if (timer.running && timer.seconds() > 193 && timer.seconds() <= 223){
            sc.render();
        }
        if (timer.running && timer.seconds() > 223 && timer.seconds() <= 232 ){
            fi.render();
        }
        if (timer.running && timer.seconds() > 232 && timer.seconds() <= 247 ){
            sc.render();
        }
        if (timer.running && timer.seconds() > 247 && timer.seconds() <= 263 ){
            bx.render();
            bf.render();
        }

        if (timer.running && timer.seconds() > 263 && timer.seconds() <= 279 ){
            su.render();
        }
        if (timer.running && timer.seconds() > 279 && timer.seconds() <= 289 ){
            mt.render();
        }
        if (timer.running && timer.seconds() > 289 && timer.seconds() <= 294){
            colorMode(RGB);
            translate(0.5f*width, 0.5f*height);
            for (int i = 0; i < stars.length; i++){
                stars[i].render();
            }
        }

        if (timer.running && timer.seconds() > 294){
            ou.render();
            wi.render();
            sw.render();
        }
        


        
        
        
        

        


    }
    
}
