package puente;

public class CarroSur extends Thread {
    
    Puente p = new Puente(0,0);
    Object lock = new Object();

    CarroSur(Puente pue, Object loo) {
        this.p = pue;
        this.lock = loo;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(12000);
                accediendo();
            }
        } catch (InterruptedException e) {
                System.out.println(e);
        }
    }

    public void accediendo() {
        synchronized (lock) {
            if (true) {
                int cs = (int) (Math.random() * 5 + 1);
                int cs_esperando = p.getCarrosSur();
                cs_esperando += cs;
                p.setCarrosSur(cs_esperando);
                System.out.println("Han llegado: " + cs + " carros del sur, ahora hay: " + cs_esperando + " esperando...");
                lock.notifyAll();
            }
        }
    }
}
