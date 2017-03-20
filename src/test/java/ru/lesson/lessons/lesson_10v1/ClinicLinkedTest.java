package ru.lesson.lessons.lesson_10v1;

import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.*;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 20.03.2017
 **/

public class ClinicLinkedTest {
    private static Logger log = Logger.getLogger(ClinicTest.class.getName());
    ClinicLinked clinic = new ClinicLinked();
    Client cl1 = new Client("Petr");
    Client cl2 = new Client("Ivan");
    Client cl3 = new Client("Stepan");
    Cat cat1 = new Cat("Moon");
    Dog dog1 = new Dog("Tod");

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
        myLinkedList<Client> f = clinic.findClientByName("Petr");
        myLinkedList.LinkedListIterator p;
        boolean result = false;
        for(p = f.first(); p.isValid(); p.advance()) {
            if (f.retrieve(p) == cl1)  {
                result = true;
            }
        }
        assertTrue(result);
    }

    @Test
    public void findClientByPetName() throws Exception {
        clinic.addClient(cl1);
        clinic.addClient(cl2);
        clinic.addClient(cl3);
        clinic.addClientPet("Petr", dog1);
        myLinkedList<Client> f =clinic.findClientByPetName("Tod");
        myLinkedList.LinkedListIterator p;
        boolean result = false;
        for(p = f.first(); p.isValid(); p.advance()) {
            if (f.retrieve(p) == cl1)  {
                result = true;
            }
        }
        assertTrue(result);
    }

    @Test
    public void findPetByClientName() throws Exception {
        clinic.addClient(cl1);
        clinic.addClient(cl2);
        clinic.addClient(cl3);
        clinic.addClientPet("Petr", dog1);
        myLinkedList<Pet> f = clinic.findPetByClientName("Petr");
        myLinkedList.LinkedListIterator p;
        boolean result = false;
        for(p = f.first(); p.isValid(); p.advance()) {
            if (f.retrieve(p) == dog1)  {
                result = true;
            }
        }
        assertTrue(result);
    }

    @Test
    public void findPetByPetName() throws Exception {
        clinic.addClient(cl1);
        clinic.addClient(cl2);
        clinic.addClient(cl3);
        clinic.addClientPet("Petr", dog1);
        myLinkedList<Pet> f = clinic.findPetByPetName("Tod");
        myLinkedList.LinkedListIterator p;
        boolean result = false;
        for(p = f.first(); p.isValid(); p.advance()) {
            if (f.retrieve(p) == dog1)  {
                result = true;
            }
        }
        assertTrue(result);
    }

    @Test
    public void changeClientName() throws Exception {
        clinic.addClient(cl1);
        clinic.addClient(cl2);
        clinic.addClient(cl3);
        clinic.changeClientName("Ivan", "Nikolay");
        myLinkedList<Client> f = clinic.findClientByName("Nikolay");
        myLinkedList.LinkedListIterator p;
        boolean result = false;
        for(p = f.first(); p.isValid(); p.advance()) {
            if (f.retrieve(p) == cl2)  {
                result = true;
            }
        }
        assertTrue(result);
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
        myLinkedList<Client> f = clinic.findClientByPetName("Mops");
        myLinkedList.LinkedListIterator p;
        boolean result = false;
        for(p = f.first(); p.isValid(); p.advance()) {
            if (f.retrieve(p) == cl2)  {
                result = true;
            }
        }
        assertTrue(result);
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