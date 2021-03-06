package pl.odrobinska.projekt;

import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.plus.webapp.EnvConfiguration;
import org.eclipse.jetty.plus.webapp.PlusConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.webapp.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
        //comment
        public static void main(String[] args) throws Exception {
        System.out.println("Hello");
        Logger logger = LoggerFactory.getLogger(App.class);
        logger.warn("Warn");
        /*
        Service service = new Service(new Bedroom(1,"e","link","descr",null));
        logger.info(service.prepareData().getAuthor());
        Service service1 = new Service(new Kitchen(1,"e","link","descr",null, Type.BIG));
        logger.info(((Kitchen) service1.prepareData()).getType().toString());
        Service service2 = new Service(new Kitchen(1,"e","link","descr",null, null));
        logger.info(((Kitchen) service2.prepareData()).getType().toString());
         */

            var webapp = new WebAppContext();
            webapp.setResourceBase("src/main/webapp");
            webapp.setContextPath("/");
            webapp.setInitParameter("org.eclipse.jetty.servlet.Default.maxCachedFiles", "0");
            webapp.setConfigurations(new Configuration[]{
                    new AnnotationConfiguration(),
                    new WebInfConfiguration(),
                    new WebXmlConfiguration(),
                    new MetaInfConfiguration(),
                    new FragmentConfiguration(),
                    new EnvConfiguration(),
                    new PlusConfiguration(),
                    new JettyWebXmlConfiguration()
            });
            webapp.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern", ".*/classes/.*");
            var server = new Server(8080);
            server.setHandler(webapp);

            BedroomRepository bedroomRepository = new BedroomRepository();
            KitchenRepository kitchenRepository = new KitchenRepository();
            HallRepository hallRepository = new HallRepository();
            Bedroom bedroom = new Bedroom("e","link2","descr",null);
            Hall hall = new Hall("e","link","descr",null, false);
            Kitchen kitchen = new Kitchen("e","link","descr",null, Type.DARK);
            Service service = new Service(kitchen);
            logger.info("Bedroom repository 2:" + kitchenRepository.addKitchenElement((Kitchen) service.prepareData()));

            server.addLifeCycleListener(new AbstractLifeCycle.AbstractLifeCycleListener() {
                @Override
                public void lifeCycleStopped(LifeCycle event) {
                    HibernateUtil.close();
                }
            });
            server.start();
            server.join();
    }
}
