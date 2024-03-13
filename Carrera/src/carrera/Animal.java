package carrera;

public class Animal extends  Thread{
    
    String nombre;
    int velocidad;
    int distancia = 700;
    int segundos = 0;
    static String [] posiciones = new String[3];
    static int index = 0;
    
    Animal(String nombre, int velocidad){
        this.nombre = nombre;
        this.velocidad = velocidad;
    }
    
    @Override
    public void run(){
        for(int i = 0; i < distancia; i = i + velocidad){
            int suma = 0;
            suma += velocidad;
            if (suma <= distancia){
                try {
                    System.out.println(this.nombre + " recorrio " + this.velocidad + " mts.");
                    sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            }
            segundos++;
        }
        System.out.println(this.nombre + " ha llegado a la meta en " + segundos + " segundos.");
        setPosiciones(this.nombre);
    }
    
    private void setPosiciones(String nombre){
        posiciones[index] = nombre;
        index++;
    }
}
