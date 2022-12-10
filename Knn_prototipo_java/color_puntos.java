import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public final class color_puntos {
    private int x,y;
    private GPuntos algoritmo;

    private ArrayList<Color> colores;

    public void paintPunto(Graphics g){//generando color del punto apra identificar vecino
        if(this.x >=0 && this.y>=0){
            g.setColor(Color.BLACK);
            g.fillOval(this.x,this.y,5,5);
        }
    }

    public void clasifica(Graphics g){//generando la clasificacion de punto y colorearlo
        if(this.x >=0 && this.y>=0){
            g.setColor(colores.get(algoritmo.pertenece));
            g.fillOval(this.x,this.y,5,5);
        }
    }
}