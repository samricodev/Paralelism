package puente;

public class Semaforo extends Thread {
    
    Puente p = new Puente(0,0);
    public Object lock = new Object();

    Semaforo(Puente pue, Object loo) {
        this.p = pue;
        this.lock = loo;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }

            if (p.getCarrosSur() == 0 && p.getCarrosNorte() == 0) {
                p.setOcupado(true);
            } else {
                p.setOcupado(false);
            }

            if (p.isOcupado() == false && p.getCarrosSur() > 0) {
                for (int i = 0; p.getCarrosSur() != 0; i++) {
                    int cs = p.getCarrosSur();
                    cs--;
                    System.out.println("Un carro del sur a pasado el puente, quedan: " + cs);
                    p.setCarrosSur(cs);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                }
            }
            
            if (p.isOcupado() == false && p.getCarrosNorte() > 0) {
                for (int i = 0; p.getCarrosNorte() != 0; i++) {
                    int cn = p.getCarrosNorte();
                    cn--;
                    System.out.println("Un carro del norte a pasado el puente, quedan: " + cn);
                    p.setCarrosNorte(cn);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                }
            }
            
        }
    }
}
