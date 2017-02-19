package syerraBeyts.glava_18.p_669;

import syerraBeyts.glava_18.p_646.MyRemote;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Irina on 10.02.2017.
 * (клиент)
 */

public class ServiceBrowser {
    JPanel mainPanel;
    JComboBox serviceList;
    ServiceServer server;

    public void buildGUI() {
        JFrame frame = new JFrame("RMI Browser");
        mainPanel = new JPanel();
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);

        Object[] services = getServicesList();

        serviceList = new JComboBox(services);
        frame.getContentPane().add(BorderLayout.NORTH, serviceList);

        serviceList.addActionListener(new MyListListener());
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
    //добавляем на панель настоящий сервис
    void loadServiсе (Object serviceSelection) {
        try {
            Service svc = server.getService(serviceSelection);
            mainPanel.removeAll();
            mainPanel.add(svc.getGuiPanel());
            mainPanel.validate();
            mainPanel.repaint();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    Object[] getServicesList() {
        Object obj = null;
        Object[] services = null;

        try {
            //поискк по реесчтру rmi
            //переделала
           //obj = Naming.lookup("rmi://127.0.0.1/ServiceServer");
            Registry registry = LocateRegistry.getRegistry(null, 12345);
            obj = registry.lookup("ServiceServer");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        server = (ServiceServer) obj;

        try {
            services = server.getServiceList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return services;
    }

    class MyListListener implements ActionListener {
        public void actionPerformed (ActionEvent ev) {
            Object selection = serviceList.getSelectedItem();
            loadServiсе(selection);
        }
    }

    public static void main(String[] args) {
        new ServiceBrowser().buildGUI();
    }
}
