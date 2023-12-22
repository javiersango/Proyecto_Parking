/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;




/**
 *
 * @author Javier
 */
public class Load {
    
      public static void main(String[] args) {
         vista.Loading l =new vista.Loading();  
          l.setVisible(true);
          vista.Inicio p= new vista.Inicio();
          p.setVisible(false);
    
                try{
                for(int x=0;x<=100;x++){
              Thread.sleep(110);
              l.jLPorciento.setText(Integer.toString(x)+"%");
              
              l.jPBarraProgreso.setValue(x);
            
                 if(x==100){
                   p.setVisible(true);
                   l.setVisible(false);
                 
            }
                     }
                   } 
                 catch (Exception e) 
                 {
                 }
      }
 
}
