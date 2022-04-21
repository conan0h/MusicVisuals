package ie.tudublin;


public class Piano {
    SongVisuals sv;
    float x;
    float y;
    

    public Piano(SongVisuals sv){
        this.sv = sv;
        x = this.sv.width / 2;
        y = this.sv.height / 2;
    }

    public void render()
    {
        
        sv.stroke(255);
        sv.line(x, y - 50, x - 50, y - 50);
        sv.line(x - 50, y - 50, x - 50, y - 75);
        sv.line(x - 50, y - 75, x, y - 75);

        sv.line(x, y - 50, x + 50, y - 50);
        sv.line(x + 50, y - 50, x + 50, y - 75);
        sv.line(x + 50, y - 75, x, y - 75);

        sv.line(x + 45, y - 50, x + 45, y-25);
        sv.line(x - 45, y - 50, x - 45, y-25);
        
        
        sv.line(x + 45, y - 75, x+25, y - 125);
        sv.line(x - 45, y - 75, x+35, y - 135);
        



    }
}
