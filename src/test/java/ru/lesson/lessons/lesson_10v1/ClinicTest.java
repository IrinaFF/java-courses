package ru.lesson.lessons.lesson_10v1;

import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.*;

/**
 * Created by IFatkullina on 16.03.2017.
 */
public class ClinicTest {
    private static Logger log = Logger.getLogger(ClinicTest.class.getName());
    Clinic clinic = new Clinic();
    Client cl1 = new Client("Petr");
    Client cl2 = new Client("Ivan");
    Client cl3 = new Client("Stepan");
    Cat cat1 = new Cat("Moon");
    Dog dog1 = new Dog("Tod");

//    @Before
//    public void setup(){
//        Client cl1 = new Client("Petr");
//        clinic.addClient(cl1);
//        clinic.addClient(cl2);
//        clinic.addClient(cl3);
//    }

    @Test
    public void addClient() throws Exception {
        Cat cat1 = new Cat("Moon");
        Dog dog1 = new Dog("Tod");
        clinic.addClient(cl1);
        clinic.addClient(cl2);
        clinic.addClient(cl3);
        assertTrue((clinic.getSize() == 3) && clinic.getNameClient(0).equals("Petr"));
    }

    @Test
    public void addClientPet() throws Exception {
        clinic.addClient(cl1);
        clinic.addClient(cl2);
        clinic.addClient(cl3);
        clinic.addClientPet("Petr", dog1);

        assertTrue(cl1.getPetName().equals("Tod"));
    }

    @Test
    public void findClientByName() throws Exception {
        clinic.addClient(cl1);
        clinic.addClient(cl2);
        clinic.addClient(cl3);
        clinic.addClientPet("Petr", dog1);
        assertTrue(clinic.findClientByName("Petr").contains(cl1));
    }

    @Test
    public void findClientByPetName() throws Exception {
        clinic.addClient(cl1);
        clinic.addClient(cl2);
        clinic.addClient(cl3);
        clinic.addClientPet("Petr", dog1);
        assertTrue(clinic.findClientByPetName("Tod").contains(cl1));

    }

    @Test
    public void findPetByClientName() throws Exception {
        clinic.addClient(cl1);
        clinic.addClient(cl2);
        clinic.addClient(cl3);
        clinic.addClientPet("Petr", dog1);
        assertTrue(clinic.findPetByClientName("Petr").contains(dog1));
    }

    @Test
    public void findPetByPetName() throws Exception {
        clinic.addClient(cl1);
        clinic.addClient(cl2);
        clinic.addClient(cl3);
        clinic.addClientPet("Petr", dog1);
        assertTrue(clinic.findPetByPetName("Tod").contains(dog1));
    }

    @Test
    public void changeClientName() throws Exception {
        clinic.addClient(cl1);
        clinic.addClient(cl2);
        clinic.addClient(cl3);
        clinic.changeClientName("Ivan", "Nikolay");
        assertTrue(clinic.findClientByName("Nikolay").contains(cl2));
    }

    @Test
    public void changeClientPetName() throws Exception {
        clinic.addClient(cl1);
        clinic.addClient(cl2);
        clinic.addClient(cl3);
        clinic.addClientPet("Petr", cat1);
        clinic.addClientPet("Ivan", dog1);
        clinic.changeClientPetName("Ivan", "Mops");
        clinic.showClient();
        assertTrue(clinic.findClientByPetName("Mops").contains(cl2));
    }

    @Test
    public void deleteClient() throws Exception {
        clinic.addClient(cl1);
        clinic.addClient(cl2);
        clinic.addClient(cl3);
        clinic.addClientPet("Petr", cat1);
        clinic.addClientPet("Ivan", dog1);
        clinic.deleteClient("Stepan");
        assertTrue(clinic.findClientByName("Stepan").size()== 0);
    }

    @Test
    public void deleteClientPet() throws Exception {
        clinic.addClient(cl1);
        clinic.addClient(cl2);
        clinic.addClient(cl3);
        clinic.addClientPet("Petr", cat1);
        clinic.addClientPet("Ivan", dog1);
        clinic.deleteClientPet("Ivan");
        assertNull(cl2.getPetName());
    }

}