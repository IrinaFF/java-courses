package ru.lesson.lessons.lesson_6v1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 25.02.2017
 **/

public class ClinicTest {
    @Test
    public void addClient() throws Exception {
        int clinicsize = 10;
        Clinic clinic = new Clinic(clinicsize);

        for (int i=0; i < clinicsize; i++) {
            clinic.addClient(i, new Client("Jon"+i, new Dog("Pit"+i)));
        }

        Client client = clinic.findClientByName("Jon1");
        assertEquals("Pit1", client.getPetName());
    }

}