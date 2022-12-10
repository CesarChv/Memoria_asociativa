import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.util.ArrayList;

public class Ventana extends JFrame{
  int x,y;
  int canC,cant, k;
  GPuntos generacion;
  Panel panel1;
  JLabel clases, limite, labelk;
  JTextField jTextc, jTextk, jTextt;
  JButton ok ;
  private GPuntos algoritmo;
  private ArrayList<Color> colores;

  //constructor
  public Ventana(){
      setSize(979,900);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setTitle("Metodo de Knn ");
      setLocationRelativeTo(null);
      setLayout(null);
      initComponents();
      setVisible(true);
      
      generaclases(); //llamando funcion para pintar en el plano
      repaint();
  }

  public void  initComponents(){
      panel1 = new Panel();
      panel1.setLayout(null);

      clases = new JLabel("Numero de clases");
      jTextc= new JTextField("5");//5
      limite = new JLabel("Limite");
      jTextk= new JTextField("6");//6
      labelk = new JLabel("Numero de vecinos ");
      jTextt= new JTextField("4");//4
      ok= new JButton("Salir ");

      panel1.setBounds(7,7,800,800); //tamaño de la grafica 800 800
      clases.setBounds(822,83,120,38); //numero de clases posiscion
      limite.setBounds(822,200,120,30);//texto de lmites
  		labelk.setBounds(822,139,120,30); //texto de vecinoccreo
  		ok.setBounds(890,820,63,18); //boton salir

  		jTextc.setBounds(827,120,30,20);
  		jTextk.setBounds(827,175,30,20);
      jTextt.setBounds(827,235,30,20);
      //Color colroGris=new Color(128, 128, 128);//declarando el color
      panel1.setBackground(Color.gray); //color en rgb de la grafica Color.gray
      //agregando
  		add(clases);
  		add(limite);
  		add(labelk);
  		add(ok);
  		add(jTextc);
  		add(jTextk);
      add(jTextt);
      add(panel1);

      jTextc.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jTextcActionPerformed(evt);
        }
    });


      panel1.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent evt){
            formMouseClicked(evt); //llamando funcion del mause
        }

      });
      
      ok.addActionListener(new java.awt.event.ActionListener() { //boton y funcion para slair
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          System.exit(1);
        }
      });
  }

  // public void formMouseClicked(MouseEvent evt){ //funciuon del mause
  //   x=evt.getX();
  //   y=evt.getY();
  //   generacion.px = x;
  //   generacion.py = y;
  //   generacion.calculaDistancia();
  //   generacion.imprimirDistancias();
  //   generacion.ordena();
  //   generacion.imprimirDistancias();
  //   //JOptionPane.showMessageDialog(this, "La clase es: " + generacion.seleccionada); //mostrar clase cercana
  //   puntos(panel1.getGraphics());//funcion que permite pintar
  // }
    //funciones del mause
    
//---------------------------------------------------------------------
    private void initComponents2(){ //generando funcion de mause
      colores = new ArrayList<>();
      panel1.addMouseListener(new java.awt.event.MouseAdapter() {
          @Override
          public void mouseClicked(java.awt.event.MouseEvent evt){
              formMouseClicked(evt);            
          }
      });
  }

  private void formMouseClicked(java.awt.event.MouseEvent evt){ //metodo del mause
         this.x = evt.getX();
         this.y = evt.getY();
         algoritmo.x = this.x;
         algoritmo.y = this.y;
         paintPunto(panel1.getGraphics());
         //plano.updateUI();
  }//formMouseClicked
  
 
      @Override
  public void update(Graphics g) {
      super.update(g);
  }

//---------------------------------------------------------------------
  public void puntos(Graphics p){ //pintar puntos por mause en la grafica
      p.setColor(Color.red);
      p.fillOval(x,y,7,7);
}

  public void generaclases(){ //funcion para 
    canC= Integer.parseInt(jTextc.getText()); //pasando valores establecidos
    cant= Integer.parseInt(jTextt.getText());
    k= Integer.parseInt(jTextk.getText());

    System.out.println(k);
    //int k, int clases , int items , int x, int y , int anchoPlano, int altoPlano
    //generacion = new GPuntos(k, clases,  items, x, y, anchoPlano, altoPlano);
    System.out.println ("Antes");
    pindatos(panel1.getGraphics());
    //puntosalea(panel1.getGraphics());
    System.out.println("Terminado");
  }

   //----------------------------------------------------------------------------------------------------------------------   
   public void paintPunto(Graphics g){//generando color del punto apra identificar vecino
    System.out.println("Iniciando funcion pintando puntos ");
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
//---------------------------------------------------------------------

  // public void puntosalea(Graphics p){ //pintando puntos aleatorios por clase en el plano
  //   for (int j=0;j<=generacion.arreglo.size();j++ ){
  //     System.out.println("Pintando puntos por clase");
  //     p.setColor(Color.red);
  //     p.fillOval(generacion.arreglo.get(j).x,generacion.arreglo.get(j).y,10,10);
  //   }
  // }

  public void pindatos(Graphics g){ //pintando puntos aleatorios por clase en el plano
    if(this.x >=0 && this.y>=0){
      g.setColor(Color.BLACK);
      g.fillOval(this.x,this.y,5,5);
    }
    update(g);
    System.out.println("Iniciando funcion ");
    // for (int j=0; j<=generacion.arreglo.size(); j++ ){
    //   System.out.println("Pintando puntos por clase");
    //   g.setColor(Color.blue);
    //   .fillOval(generacion.arreglo.get(j).x,generacion.arreglo.get(j).y,5,5);
    // }
    // update(p);
  }

  private void jTextcActionPerformed(java.awt.event.ActionEvent evt) {
  }
  public static void main(String[] args) {
    //Ventana vs = new Ventana();
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
          if ("Nub".equals(info.getName())) {
              javax.swing.UIManager.setLookAndFeel(info.getClassName());
              break;
          }
      }
  } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  }

    /* Crear y mostrar el formulario */
    java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            new Ventana().setVisible(true);
        }
    });
    //generando();
  }


}
