package canibales;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Buffer b = new Buffer();
        
        Cocinero p = new Cocinero(b);
        
        Comensal c1 = new Comensal(b, 1);
        Comensal c2 = new Comensal(b, 2);
        Comensal c3 = new Comensal(b, 3);
        Comensal c4 = new Comensal(b, 4);
        
        p.start();
        try {
            p.join(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        c1.start();
        c2.start();
        c3.start();
        c4.start();
    }
    
}
