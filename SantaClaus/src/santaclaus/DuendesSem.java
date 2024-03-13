package santaclaus;

public class DuendesSem extends Thread {

    SantaClaus santa = new SantaClaus();
    public Object lock = new Object();

    DuendesSem(SantaClaus santa, Object loo) {
        this.santa = santa;
        this.lock = loo;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1500);
                accediendo();
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void accediendo() {
        synchronized (lock) {
            if (true) {
                int x = 1;
                int duende = santa.getDuendes();
                duende += x;
                santa.setDuendes(duende);
                System.out.println("Un duende necesita ayuda ahora hay: " + duende + " esperando...");
                lock.notifyAll();
            }
        }
    }
}
