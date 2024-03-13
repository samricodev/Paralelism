import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.rmi.Remote;

public class servidorRMI {
    public static void main(String[] args) throws RemoteException{
        int port = 1099;
        try{
            System.setProperty("java.rmi.server.hostname","192.168.1.174");
            Registry rmi = LocateRegistry.createRegistry(port);
            rmi.rebind("Chat", (Remote) new implementacionChat());
            System.out.println("Servidor Activo");
        } catch(RemoteException e){}
    }
}