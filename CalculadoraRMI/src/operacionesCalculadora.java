import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class operacionesCalculadora extends UnicastRemoteObject implements interfaceOperaciones{
    public double a, b;

    public operacionesCalculadora()throws RemoteException{
        this.a=0;
        this.b=0;
    }

    @Override
    public double suma(double a, double b) throws RemoteException {
        return a+b;
    }

    @Override
    public double resta(double a, double b) throws RemoteException {
        return a-b;
    }

    @Override
    public double multiplicacion(double a, double b) throws RemoteException {
       return a*b;
    }

    @Override
    public double division(double a, double b) throws RemoteException {
        return a/b;
    }

    @Override
    public double saberA() throws RemoteException {
        return this.a;
    }

    @Override
    public double saberB() throws RemoteException {
         return this.b;
    }

    @Override
    public void mandar(double n) throws RemoteException {
        
        if(this.a != 0 && this.b != 0){ 
            this.a = n;
            this.b = 0; 
            return;
        }
        
        if(this.a != 0){ 
            this.b = n;
            return;
        }
        
        this.a = n;    
    }

    @Override
    public boolean verificar() throws RemoteException {
        return !(this.a == 0 || this.b == 0);
    }   
}