package syerraBeyts.glava_18.p_669;

import java.rmi.*;

/**
 * Created by Irina on 10.02.2017.
 * удаленный интерфейс
 */
public interface ServiceServer extends Remote {
    Object[] getServiceList() throws RemoteException;
    Service getService(Object serviceKey) throws RemoteException;
}
