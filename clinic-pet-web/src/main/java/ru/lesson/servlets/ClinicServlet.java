package ru.lesson.servlets;

import com.sun.net.httpserver.HttpServer;
import ru.lessons.lesson_6.*;

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
    final List<Pet> pets = new CopyOnWriteArrayList<Pet>();
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
                "Name : <input type='text' name='name'>" +
                "<input type='submit' value='Submit'>" +
                "<form>" +
                this.viewPets() +
                "</body>" +
                "</html>"
        );
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.pets.add(new Dog(new Animal(req.getParameter("name"))));
        doGet(req, resp);
    }

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
}
