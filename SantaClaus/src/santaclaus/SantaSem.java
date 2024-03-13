package santaclaus;

public class SantaSem extends Thread{

    SantaClaus santa = new SantaClaus();
    public Object lock = new Object();

    SantaSem(SantaClaus santaclaus, Object loo) {
        this.santa = santaclaus;
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

            if (santa.getDuendes() == 0 && santa.getRenos() == 0) {
                santa.setDuerme(true);
            } else {
                santa.setDuerme(false);
            }

            if (santa.isDuerme() == false && santa.getRenos() == 9) {
                int renos = santa.getRenos();
                renos -=9;
                System.out.println("Santa se fue con los renos a dar regalos ");
                santa.setRenos(renos);
                santa.setDisponible(false);
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }

                santa.setDisponible(true);
                System.out.println("Santa llego de repartir regalos");

            }
            if (santa.isDuerme() == false && santa.getDuendes() >= 3) {
                int duendes = santa.getDuendes();
                duendes -= 3;
                System.out.println("**Santa ayudo a un grupo de 3 duendes quedan " + duendes + " por ayudar**");
                santa.setDuendes(duendes);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
        
    }
}
