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
//        Client cl1 = new Client("Petr");
//        Client cl2 = new Client("Ivan");
//        Client cl3 = new Client("Ivan");
        Cat cat1 = new Cat("Moon");
        Dog dog1 = new Dog("Tod");
        clinic.addClient(cl1);
        clinic.addClient(cl2);
        clinic.addClient(cl3);
        assertTrue((clinic.getSize() == 3) && clinic.getNameClient(0).equals("Petr"));
    }

    @Test
    public void addClientPet() throws Exception {
//        Client cl1 = new Client("Petr");
//        Client cl2 = new Client("Ivan");
//        Client cl3 = new Client("Ivan");
//        Cat cat1 = new Cat("Moon");
//        Dog dog1 = new Dog("Tod");
        clinic.addClient(cl1);
        clinic.addClient(cl2);
        clinic.addClient(cl3);
        clinic.addClientPet("Petr", dog1);

        assertTrue(cl1.getPetName().equals("Tod") &&
        clinic.findClientByPetName("Tod").getClientId().equals("Petr"));
    }

    @Test
    public void findClientByName() throws Exception {
//        Client cl1 = new Client("Petr");
//        Client cl2 = new Client("Ivan");
//        Client cl3 = new Client("Ivan");
//        Cat cat1 = new Cat("Moon");
//        Dog dog1 = new Dog("Tod");
        clinic.addClient(cl1);
        clinic.addClient(cl2);
        clinic.addClient(cl3);
        clinic.addClientPet("Petr", dog1);
        assertEquals(clinic.findClientByName("Petr"), cl1);
    }

    @Test
    public void findClientByPetName() throws Exception {
        clinic.addClient(cl1);
        clinic.addClient(cl2);
        clinic.addClient(cl3);
        clinic.addClientPet("Petr", dog1);
        assertEquals(clinic.findClientByPetName("Tod"), cl1);

    }

    @Test
    public void findPetByClientName() throws Exception {
        clinic.addClient(cl1);
        clinic.addClient(cl2);
        clinic.addClient(cl3);
        clinic.addClientPet("Petr", dog1);
        assertEquals(clinic.findPetByClientName("Petr"),dog1);
    }

    @Test
    public void changeClientName() throws Exception {
        clinic.addClient(cl1);
        clinic.addClient(cl2);
        clinic.addClient(cl3);
        clinic.changeClientName("Ivan", "Nikolay");
        assertEquals(clinic.findClientByName("Nikolay"),cl2);
    }

    @Test
    public void changeClientPetName() throws Exception {
        clinic.addClient(cl1);
        clinic.addClient(cl2);
        clinic.addClient(cl3);
        clinic.addClientPet("Petr", cat1);
        clinic.addClientPet("Ivan", dog1);
        clinic.changeClientPetName("Ivan", "Mops");
        assertEquals(clinic.findClientByPetName("Mops"),cl2);
    }

    @Test
    public void deleteClient() throws Exception {
        clinic.addClient(cl1);
        clinic.addClient(cl2);
        clinic.addClient(cl3);
        clinic.addClientPet("Petr", cat1);
        clinic.addClientPet("Ivan", dog1);
        clinic.deleteClient("Stepan");
        assertNull(clinic.findClientByName("Stepan"));
    }

    @Test
    public void deleteClientPet() throws Exception {
        clinic.addClient(cl1);
        clinic.addClient(cl2);
        clinic.addClient(cl3);
        clinic.addClientPet("Petr", cat1);
        clinic.addClientPet("Ivan", dog1);
        clinic.deleteClientPet("Ivan");
        assertNull(clinic.findClientByPetName("Tod"));
    }

}