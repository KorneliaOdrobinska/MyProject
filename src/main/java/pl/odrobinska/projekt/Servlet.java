package pl.odrobinska.projekt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "Remont", urlPatterns = {"/api"})
public class Servlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(Servlet.class);
    private static final String PROJECT_PARAM = "project";
    BedroomRepository bedroomRepository = new BedroomRepository();
    Bedroom defaultBedroomElement = new Bedroom("e","link","descr",null);
    HallRepository hallRepository = new HallRepository();
    Hall defaultHallElement = new Hall("e","link","descr",null, false);
    KitchenRepository kitchenRepository = new KitchenRepository();
    Kitchen defaultKitchenElement = new Kitchen("e","link","descr",null, Type.DARK);
    String index = "1";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Get request with params: " + req.getParameterMap());
       index = req.getParameter(PROJECT_PARAM);
       resp.getWriter().write("Answer is: " + kitchenRepository.findById(Integer.parseInt(Optional.ofNullable(index).orElse("1"))).orElse(defaultKitchenElement).getDescription());

    }
}
