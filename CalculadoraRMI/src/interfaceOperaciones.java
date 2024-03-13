import java.rmi.Remote;
import java.rmi.RemoteException;

public interface interfaceOperaciones extends Remote{
    public double suma(double a, double b) throws RemoteException;
    public double resta(double a, double b) throws RemoteException;
    public double multiplicacion(double a, double b) throws RemoteException;
    public double division(double a, double b) throws RemoteException;
    public double saberA() throws RemoteException;
    public double saberB() throws RemoteException;
    public void mandar(double n) throws RemoteException;
    public boolean verificar() throws RemoteException;
}