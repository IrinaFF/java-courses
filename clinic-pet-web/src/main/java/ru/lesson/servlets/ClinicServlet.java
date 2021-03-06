package ru.lesson.servlets;

import com.sun.net.httpserver.HttpServer;
import ru.lessons.lesson_10v1.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 18.04.2017
 **/

public class ClinicServlet extends HttpServlet {
    //final List<Pet> pets = new CopyOnWriteArrayList<Pet>();
    Clinic clinic = new Clinic();
    myArrayList<Client> clients = new myArrayList<Client>();
    String searche;
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.append(
        "<!DOCTYPE html" +
             "<html>" +
             "<head>" +
              "<title>Clinic Pet Web</title>" +
                "</head>" +
                "<body>" +
                "<form action='>" + req.getContextPath() + "/' method = 'post'>" +
                "   Client Name : <input type='text' name='client'>" +
                "   Dog Name : <input type='text' name='pet'>" +
                "   <input type='submit' value='Submit'>" +
                "</form>" +
                this.viewClientsAndPets() +
                "   <form action='>" + req.getContextPath() + "/' method = 'post'>" +
                "   Client Searche : <input type='text' name='searche'>" +
                "   <input type='submit' value='Submit'>" +
                "</form>" +
                this.searcheClient() +
                "</body>" +
                "</html>"
        );
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //this.pets.add(new Dog(new Animal(req.getParameter("name"))));
        clinic.addClient(new Client(req.getParameter("client"), new Dog(req.getParameter("pet"))));
        searche = req.getParameter("searche");
        doGet(req, resp);
    }

    /**
    private String viewPets() {
        StringBuilder sb = new StringBuilder();
        sb.append("<p>Pets</p>");
        sb.append("<table style='border : 1px solid black'>");
        for (Pet pet : this.pets) {
            sb.append("<tr><td style='border : 1px solid black'>").append(pet.getName()).append("</td></tr>");
        }
        sb.append("</table>");
        return sb.toString();
    }
    **/
    private String searcheClient() {
        StringBuilder sb = new StringBuilder();
        if (searche != null) {
            clients = clinic.findClientByName(searche);
            sb.append("<p>Client Searche</p>");
            sb.append("<table style='border : 1px solid black'>");
            sb.append("<tr><td>N</td><td>Client</td><td>Pet</td><td>Vid</td></tr>");
            for (int i = 0; i < clients.size(); i++) {
                sb.append("<tr><td>" + i + "</td><td>" +
                        clients.get(i).getClientId() + "</td><td>" +
                        clients.get(i).getPetName() + "</td><td>" +
                        clients.get(i).getPetType() + "</td></tr>");
            }
            sb.append("</table>");
        }
        return sb.toString();
    }
    private String viewClientsAndPets() {
        StringBuilder sb = new StringBuilder();
        if (clinic.getSize() > 0) {
            clients = clinic.showClientAr();
            sb.append("<p>Pets</p>");
            sb.append("<table style='border : 1px solid black'>");
            sb.append("<tr><td>N</td><td>Client</td><td>Pet</td><td>Vid</td></tr>");
            for (int i = 0; i < clients.size(); i++) {
                sb.append("<tr><td>" + i + "</td><td>" +
                        clients.get(i).getClientId() + "</td><td>" +
                        clients.get(i).getPetName() + "</td><td>" +
                        clients.get(i).getPetType() + "</td></tr>");
            }
            //sb.append(clinic.showClientSt());
            sb.append("</table>");
        }
        return sb.toString();
    }
}
