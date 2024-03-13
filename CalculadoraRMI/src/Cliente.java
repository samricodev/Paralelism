import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) {
         try{
//            Registry rmii = LocateRegistry.getRegistry("192.168.137.115", 1006);
            Registry rmii = LocateRegistry.getRegistry("Localhost", 1006);
            interfaceOperaciones servidor = (interfaceOperaciones) rmii.lookup("Calculadora");
            CalculadoraGUI frame = new CalculadoraGUI(servidor);
            frame.setVisible(true);
        }catch(NotBoundException | RemoteException e){
            System.out.println(e.getMessage());
        }
    }
}