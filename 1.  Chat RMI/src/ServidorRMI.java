import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorRMI {

    public static void main(String[] args) {
        try{
            Registry rmi = LocateRegistry.createRegistry(1099);
            rmi.rebind("Chat", (Remote) new implementationChat());
            System.out.println("Servidor Activo");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}