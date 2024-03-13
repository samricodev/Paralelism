package canibales;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Cocinero extends Thread{
    
    private final Buffer b;
    public static int noPlatillos = 8;
    
    public Cocinero(Buffer b){
        this.b = b;
    }
    
    @Override
    public void run(){
        while(true){
            try {
                b.producir();
                System.out.println("Cocinero ha producido " + b.getcomida() + " porciones de comida");
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
            
}
