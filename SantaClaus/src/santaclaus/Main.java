package santaclaus;

public class Main {
    private static Object lock = new Object();
    
    public static void main(String[] args) {
        
        SantaClaus santa = new SantaClaus();
        
        RenosSem renos = new RenosSem(santa, lock);
        DuendesSem duendes = new DuendesSem(santa, lock);
        SantaSem santi = new SantaSem(santa, lock);
        
        santi.start();
        renos.start();
        duendes.start();
    }   
}
