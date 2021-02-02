package pl.odrobinska.projekt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Remont", urlPatterns = {"/*"})
public class Servlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(Servlet.class);
    private static final String PROJECT_PARAM = "project";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Get request with params: " + req.getParameterMap());
       var project = req.getParameter(PROJECT_PARAM);
       resp.getWriter().write("Answer is: " + project);
    }
}
