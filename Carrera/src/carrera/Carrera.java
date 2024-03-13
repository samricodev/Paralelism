/*
 - Distancia: 700mts
 - La gacela corre a 20 m/s
 - La guepardo corre a 28 m/s
 - El leon corre a 23 m/s
*/
package carrera;

public class Carrera {
    
    static String animales [] = new String[3];
    
    public static void main(String[] args) {
        
        Thread guepardo = new Animal("Guepardo",28);
        Thread gacela = new Animal("Gacela",20);
        Thread leon = new Animal("Leon",23);
        
        gacela.start();
        guepardo.start();
        leon.start();
        
        while(gacela.isAlive() || guepardo.isAlive() || leon.isAlive()){
        }
        
        for(int i = 0; i < Animal.posiciones.length; i++){
            System.out.println(Animal.posiciones[i] + " ha llegado en " + (i+1) + " lugar");
        }
    }
}
