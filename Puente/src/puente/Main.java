package puente;

public class Main {
    private static Object lock = new Object();
    
    public static void main(String[] args) {
        Puente puente = new Puente(0,0);
        
        CarroSur carrosNorte = new CarroSur(puente,lock);
        CarroNorte carrosSur = new CarroNorte(puente,lock);       

        Semaforo semaforo = new Semaforo(puente, lock);
        
        semaforo.start();
        carrosNorte.start();
        carrosSur.start();
    }
}
