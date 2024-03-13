import java.awt.HeadlessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class clienteRMI{
    public static void main(String[] args) {
        try{
            int port = 1099;
            String nombre = JOptionPane.showInputDialog("Ingresa tu nombre");
            String nom = nombre;
            
            Registry rmii = LocateRegistry.getRegistry("192.168.1.174",port);
            chatServidor servidor = (chatServidor) rmii.lookup("Chat");
            new Thread(new implementacionClienteChat(nom, servidor)).start();
            
        }catch(HeadlessException | NotBoundException | RemoteException e){
            System.out.println(e.getMessage());
        }
    }
}
