package santaclaus;

public class SantaClaus {
    private int renos;
    private int duendes;
    private boolean duerme;
    private boolean disponible;
    
    SantaClaus(){
        this.renos = 0;
        this.duendes = 0;
        this.duerme = false;
        this.disponible = true;
    }

    public int getRenos() {
        return renos;
    }

    public void setRenos(int renos) {
        this.renos = renos;
    }

    public int getDuendes() {
        return duendes;
    }

    public void setDuendes(int duendes) {
        this.duendes = duendes;
    }

    public boolean isDuerme() {
        return duerme;
    }

    public void setDuerme(boolean duerme) {
        this.duerme = duerme;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean esta) {
        this.disponible = esta;
    }
}
