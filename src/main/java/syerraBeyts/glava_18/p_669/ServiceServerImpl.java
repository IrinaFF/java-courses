package syerraBeyts.glava_18.p_669;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

/**
 * Created by Irina on 10.02.2017.
 * удаленная реализация RMI
 */
public class ServiceServerImpl extends UnicastRemoteObject implements ServiceServer {
    //для хранения сервисов
    HashMap serviceList;

    public ServiceServerImpl() throws RemoteException {
        setUpServices();
    }

    //инициализация сервисов
    private void setUpServices () {
        serviceList = new HashMap() ;
        serviceList.put("Dice Rolling Service", new DiceService());
        serviceList.put("Day of the Week Service", new DayOfTheWeekService());
        serviceList.put("Visual Music Service", new MiniMusicService()) ;
    }

    //клиент вызывает список сервисов
    //масиив содержит строки из ключей HashMap
    public Object [] getServiceList() {
        System.out.println("getServiceList: " + serviceList.size());
        return serviceList.keySet().toArray();
    }

    //клиент выбирает сервис
    public Service getService(Object serviceKey) throws RemoteException {
        Service theService = (Service) serviceList.get(serviceKey);
        return theService;
    }

    public static void main (String[] args) {
        try {
            //так уже на работает
            //Naming.rebind("ServiceServer", new ServiceServerImpl());
            Registry registry = LocateRegistry.createRegistry(12345);
            registry.bind("ServiceServer", new ServiceServerImpl());
        } catch(Exception ex) {
            ex.printStackTrace() ;
            System.out.println("Remote service is running");
        }
    }
}
