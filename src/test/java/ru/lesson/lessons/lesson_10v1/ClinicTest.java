package ru.lesson.lessons.lesson_10v1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IFatkullina on 16.03.2017.
 */
public class ClinicTest {

//    @Before
//    public static void setup(){
//
//        Client cl2 = new Client("Ivan");
//        Client cl3 = new Client("Ivan");
//
//    }

    @Test
    public void addClient() throws Exception {
        Clinic clinic = new Clinic();
        Client cl1 = new Client("Petr");
        //setup();
        clinic.addClient(cl1);
        assertTrue((clinic.getSize() == 1) && clinic.getNameClient(0).equals("Petr"));
    }

    @Test
    public void addClientPet() throws Exception {

    }

    @Test
    public void findClientByName() throws Exception {

    }

    @Test
    public void findClientByPetName() throws Exception {

    }

    @Test
    public void findPetByNameClient() throws Exception {

    }

    @Test
    public void changeClientName() throws Exception {

    }

    @Test
    public void changeClientPetName() throws Exception {

    }

    @Test
    public void deleteClient() throws Exception {

    }

    @Test
    public void deleteClientPet() throws Exception {

    }

}