package canibales;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Comensal extends Thread{
    
    private int id;
    private Buffer b;
    
    public Comensal(Buffer b, int id){
        this.b = b;
        this.id = id;
    }
    
    @Override
    public void run(){
        while(true){
            try {
                b.consumir();
                System.out.println("Canibal " + id + " ha consumido una porcion");
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Comensal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
