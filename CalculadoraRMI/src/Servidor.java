import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        try{
//            System.setProperty("java.rmi.server.hostname","192.168.137.115");
            Registry rmi = LocateRegistry.createRegistry(1006);
            rmi.rebind("Calculadora", (Remote) new operacionesCalculadora()); 
            System.out.println("Server up");
        }catch(RemoteException e){
            System.out.println(e);
        }
    }
}
