package pl.odrobinska.projekt;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;
import java.sql.*;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "Remont", urlPatterns = {"/api"})
public class Servlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(Servlet.class);
    private static final String PROJECT_PARAM = "place";
    private ObjectMapper mapper;

    /**
     * Servlet container needs it
     */
    @SuppressWarnings("unused")
    public Servlet() {
        this(new ObjectMapper());

    }

    Servlet(ObjectMapper mapper) {
        this.mapper = mapper;
    }
    BedroomRepository bedroomRepository = new BedroomRepository();
    Bedroom defaultBedroomElement = new Bedroom("e","link","descr",null);
    HallRepository hallRepository = new HallRepository();
    Hall defaultHallElement = new Hall("e","link","descr",null, false);
    KitchenRepository kitchenRepository = new KitchenRepository();
    Kitchen defaultKitchenElement = new Kitchen("e","link","descr",null, Type.DARK);
    String place = "1";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Get request with params: " + req.getParameterMap());
       place = req.getParameter(PROJECT_PARAM);

      // resp.getWriter().write("Answer is: " + kitchenRepository.findById(Integer.parseInt(Optional.ofNullable(place).orElse("1"))).orElse(defaultKitchenElement).getDescription());

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        out.println("<html><body>");
/*
        try
        {
            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>Element</th><th>Link</th><th>Description</th><tr>");
            for(int index = 0; index < bedroomList.size(); index++){
                out.println("<tr><td>" + bedroomList.get(index).getElement() + "</td><td>" + bedroomList.get(index).getLink() + "</td><td>" + bedroomList.get(index).getDescription() + "</td></tr>");
            }
            out.println("</table>");
            out.println("</html></body>");
        }
        catch (Exception e)
        {
            out.println("error");
        }


 */

        try
        {
            out.println("<table style=\"width:100%\" class=\"pure-table pure-table-bordered\"><thead>");
            out.println("<tr><th>Element</th><th>Link</th><th>Author</th><tr><tbody>");
            if (place.equals("bedroom")) {
                List<Bedroom> bedroomList = bedroomRepository.findAll();
                for (int index = 0; index < bedroomList.size(); index++) {
                   out.println("<tr><td>" + bedroomList.get(index).getElement() + "</td><td><a href=\"" + bedroomList.get(index).getLink() + "\" target=\"_blank\">" + Optional.ofNullable(bedroomList.get(index).getDescription()).orElse("Link") + "</a></td><td>" + bedroomList.get(index).getAuthor() + "</td></tr>");
                }

            }
            else if (place.equals("kitchen")) {
                List<Kitchen> kitchenList = kitchenRepository.findAll();
                for (int index = 0; index < kitchenList.size(); index++) {
                    out.println("<tr><td>" + kitchenList.get(index).getElement() + "</td><td><a href=\"" + kitchenList.get(index).getLink() + "\" target=\"_blank\">" + Optional.ofNullable(kitchenList.get(index).getDescription()).orElse("Link") + "</a></td><td>" + kitchenList.get(index).getAuthor() + "</td></tr>");
                }
            }
            else {
                List<Hall> hallList = hallRepository.findAll();
                for (int index = 0; index < hallList.size(); index++) {
                    out.println("<tr><td>" + hallList.get(index).getElement() + "</td><td><a href=\"" + hallList.get(index).getLink() + "\" target=\"_blank\">" + Optional.ofNullable(hallList.get(index).getDescription()).orElse("Link") + "</a></td><td>" + hallList.get(index).getAuthor() + "</td></tr>");
                }
            }
            out.println("</tbody></table>");
            out.println("</html></body>");
        }
        catch (Exception e)
        {
            out.println("error");
        }
        /*
xx
         */
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Got  POST request with parameters" + req.getParameterMap());
        String author = req.getParameter("author");
        String element = req.getParameter("element");
        String link = req.getParameter("link");
        String description = req.getParameter("description");
        Bedroom bedroomElement = new Bedroom(element, link, description,author);
        Service service = new Service(bedroomElement);
        resp.setContentType("application/json, charset=UTF-8");
        mapper.writeValue(resp.getOutputStream(), bedroomRepository.addBedroomElement((Bedroom) service.prepareData()));

    }
}
