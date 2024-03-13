package santaclaus;

public class RenosSem extends Thread {

    SantaClaus santa = new SantaClaus();
    public Object lock = new Object();

    RenosSem(SantaClaus santa, Object loo) {
        this.santa = santa;
        this.lock = loo;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(3000);
                accediendo();
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void accediendo() {
        synchronized (lock) {
            if (santa.getRenos() < 9 && santa.isDisponible() == true) {
                int x = 1;
                int renos = santa.getRenos();
                renos += x;
                santa.setRenos(renos);
                System.out.println("Ha llegado un reno, ahora hay: " + renos + " esperando");
                lock.notifyAll();
                if (santa.getRenos() == 9) {
                    System.out.println("Llegaron todos los renos de vacaciones!");
                }
            }
        }

    }
}
