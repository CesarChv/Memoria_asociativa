// import java.util.*;
// import java.lang.Math;

//   public class  GPuntos{
//     public int anchp,largp;
//     public int canC,cant,k;
//     public int px,py;
//     //public ArrayList <Punto> arreglo = new ArrayList();
//     //public ArrayList <Integer> evaluados = new ArrayList();
//     public ArrayList <Punto> arreglo = new ArrayList<>();
//     public ArrayList <Integer> evaluados = new ArrayList<>();
//     //public List<Punto> arreglo = new ArrayList<>();
//     //public List<Integer> evaluados = new ArrayList<>();
    
//     public String seleccionada;
//     Random b= new Random();

//     public GPuntos(int canC, int cant, int k, int anchp, int largp){
//       this.canC = canC;
//       this.cant = cant;
//       this.k= k;
//       this.anchp=anchp;
//       this.largp=largp;
//     } 

//     public void generaClases(){
//       for (int i=0;i<canC ; i++) {
//         int semillaX = b.nextInt(anchp-70)+70;
//         int semillaY = b.nextInt(largp-70)+70;
//         for (int j=0;j<cant ;j++ ) {
//             Punto nuevo = new Punto(semillaX-b.nextInt(70),semillaY-b.nextInt(70) ,""+i);
//             arreglo.add(nuevo);
//         }
//       }
//     }
    

//     public void calculaDistancia(){
//       for (int j=0;j<arreglo.size();j++ ) {
//           arreglo.get(j).distancia = (int) Math.sqrt((Math.pow(arreglo.get(j).x,2))+(Math.pow(arreglo.get(j).y,2)));
//       }
//     }

//     public void imprimir() {
//       for (int j=0;j<arreglo.size();j++ ) {
//           System.out.println("Punto:"+ arreglo.get(j).x+ " , "+arreglo.get(j).y+" ");
//       }

//     }

//     public void imprimirDistancias() {
//       for (int j=0;j<arreglo.size();j++ ) {
//           System.out.println("Punto:"+ arreglo.get(j).x+ " , "+arreglo.get(j).y+" Distancia: " + arreglo.get(j).distancia);
//       }
//     }

//     public void ordena(){
//       for(int i=0; i< arreglo.size()-1;i++){
//           for(int s=0; s< arreglo.size()-1;s++){
//               if(arreglo.get(s).distancia>arreglo.get(s+1).distancia){
//                   Punto aux = arreglo.get(s+1);
//                   arreglo.remove(s+1);
//                   arreglo.add(s,aux);
//               }
//           }
//       }

//       System.out.println(k);
//       for (int h =0; h< k;h++){
//         evaluados.add(arreglo.get(h).distancia);
//       }
//       for (int h =0; h< k;h++){
//         System.out.println(arreglo.get(h).distancia);
//       }

//       Integer maximo =evaluados.get(0);
//       for (int e : evaluados){
//         if(maximo<e){
//           maximo=e;
//         }
//       }
//       seleccionada = arreglo.get(evaluados.indexOf(maximo)).clase;
//     }
  
// }
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;
//import java.util.Arrays;

public final class GPuntos {
    public int k,x,y,clases,items,limite,anchoPlano,altoPlano,pertenece;
    public Random r;
    public ArrayList<Num_clase>  itemsArray; 
    public GPuntos(int k, int clases , int items , int x, int y , int anchoPlano, int altoPlano){    
        this.k = k;
        this.x = x;
        this.y = y;
        this.clases = clases;
        this.items = items;
        this.anchoPlano = anchoPlano;
        this.altoPlano = altoPlano;
        this.r = new Random();
        this.itemsArray = new ArrayList<>();
        this.limite=20;
        generaClases();
        imprimeClases();
    }
    
    public void generaClases(){
    
        if(this.clases >= 0 && this.clases <= this.limite ){
        
            for(int i=0; i<this.clases; i++){
                int base1 = r.nextInt(anchoPlano-70) + 70;
                int base2 = r.nextInt(altoPlano-70) + 70;
                for(int j=0; j<this.items; j++){
                    int a = r.nextInt(70);
                    int b = r.nextInt(70);
                    Num_clase nuevo = new Num_clase(""+i,base1 - a,base2 - b);
                    itemsArray.add(nuevo);
                }
            
            }
        
        }else{
            System.out.println("No es posible generar tantas clases");
        }
        
    }
    
    public void calculaCercano(){
        double aux;
        for(int i=0; i< itemsArray.size();i++){
            aux = Math.sqrt( Math.pow( (itemsArray.get(i).x - this.x),2) +  Math.pow( (itemsArray.get(i).y - this.y),2) );
            itemsArray.get(i).distancia = aux;
        }
        for(int i=0; i< itemsArray.size();i++){
            System.out.println("Original: " + itemsArray.get(i).tipo);
        }
        //ordenar de mayor a menor las distancias 
        for(int i=0; i< itemsArray.size()-1;i++){
        
            for(int l=0; l< itemsArray.size()-1;l++){
        
                if(itemsArray.get(l).distancia>itemsArray.get(l+1).distancia){
                    Num_clase aux2 = itemsArray.get(l+1);
                    itemsArray.remove(l+1);
                    itemsArray.add(l,aux2);
                }
            }

        }
        
        for(int i=0; i< itemsArray.size();i++){
            System.out.println("Ordenado: " + itemsArray.get(i).tipo);
        }
        
        int[] repetidos = new int[this.clases]; 
        for (int j =0; j<this.clases;j++){
            repetidos[j] = 0;
        }
        for (int j =0; j<this.k;j++){
            repetidos[ Integer.parseInt(itemsArray.get(j).tipo) ] ++;
        }
        int maxNum = repetidos[0];
        for (int j : repetidos) {
            if (j > maxNum)
                maxNum = j;
        }
        for (int j : repetidos) {
            System.out.println("Repetidos: " + j);
        }
        System.out.println("Max Num: " + maxNum);
        int indice=0;
        for (int j : repetidos) {
            if( j  == maxNum){
                break;
            }
            indice++;
        }
        System.out.println("\nLa clase " + indice + " es a la que pertenece" );
        this.pertenece = indice;
    }

    public void imprimeClases(){
        for(int i=0; i< itemsArray.size();i++){
            System.out.println(""+i + ": " + itemsArray.get(i).x + ","+ itemsArray.get(i).y);
        }
    
    }
    
}
