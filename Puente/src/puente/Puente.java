package puente;

public class Puente {
    private int carrosNorte;
    private int carrosSur;
    private boolean ocupado;

    public Puente(int carrosNorte, int carrosSur) {
        this.carrosNorte = carrosNorte;
        this.carrosSur = carrosSur;
    }

    public int getCarrosNorte() {
        return carrosNorte;
    }

    public void setCarrosNorte(int carrosNorte) {
        this.carrosNorte = carrosNorte;
    }

    public int getCarrosSur() {
        return carrosSur;
    }

    public void setCarrosSur(int carrosSur) {
        this.carrosSur = carrosSur;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    } 
}
