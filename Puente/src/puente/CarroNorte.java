package puente;

public class CarroNorte extends Thread {

    Puente p = new Puente(0,0);
    Object lock = new Object();

    CarroNorte(Puente pue, Object loo) {
        this.p = pue;
        this.lock = loo;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(7000);
                accediendo();
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void accediendo() {
        synchronized (lock) {
            if (true) {
                int cn = (int) (Math.random() * 5 + 1);
                int cn_esperando = p.getCarrosNorte();
                cn_esperando += cn;
                p.setCarrosNorte(cn_esperando);
                System.out.println("Han llegado: " + cn + " carros del norte, ahora hay: " + cn_esperando + " esperando...");
                lock.notifyAll();
            }
        }
    }
}
