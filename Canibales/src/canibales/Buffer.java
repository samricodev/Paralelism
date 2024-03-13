package canibales;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Buffer { 

    public int comida;
    
    public Buffer(){
        this.comida = 0;
    }
    
    public int getcomida(){
        return this.comida;
    }
    
    public synchronized void producir(){
        while(this.comida > 0){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.comida = Cocinero.noPlatillos;
        notifyAll();
    }
    
    public synchronized void consumir(){
        while(this.comida == 0){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.comida--;
        notifyAll();
    }
}
