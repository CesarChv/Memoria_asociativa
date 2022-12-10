import java.awt.*;
import javax.swing.*;

  public class Panel extends JPanel{
  //     public void paintComponent(Graphics p){
  //     //super.paintComponent(p);
  //     int alto_plano = this.getHeight(); //alto
  //     int ancho_plano = this.getWidth(); //ancho
  //     p.drawLine(ancho_plano/2, 0, ancho_plano/2, alto_plano);
  //     p.drawLine(0, alto_plano/2, ancho_plano, alto_plano/2);
  // }

  public void paintComponent(Graphics g){ //generando panel de cartesiano
    int alto_plano = this.getHeight(); //alto
    int ancho_plano = this.getWidth(); //ancho
    g.drawLine(0, alto_plano/2, ancho_plano, alto_plano/2);
    g.drawLine(ancho_plano/2, 0, ancho_plano/2, alto_plano);
    g.drawLine(50, 100, 50, 100);
    //g.drawLine(50, 100, 50, 100);
}


}
