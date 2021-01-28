package pl.odrobinska.projekt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
        public static void main(String[] args) {
        System.out.println("Hello");
        Logger logger = LoggerFactory.getLogger(App.class);
        logger.warn("Warn");
    }
}
