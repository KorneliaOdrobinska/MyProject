package pl.odrobinska.projekt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlaceRepository<T extends Place> {
    private List<T> placeElements;
// TODO zrobic jedno globalne repozytorium z metofami findAll(String place) - ktore zwroci liste List<Kitchen||Bedroom||Hall>
   // TODO wyrzucić szczegółowe repozytoria i zamienic uzycie Servlecie
    /*
    List<T extends Place> findAll(String place) {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        List<Place> result;
        switch (place){
            case "kitchen":
                placeElements<Kitchen> = session.createQuery("from Kitchen", Kitchen.class).list();
            case "bedroom":
                result = session.createQuery("from Bedroom", Bedroom.class).list();
            case "hall":
                placeElements = session.createQuery("from Hall", Hall.class).list();

        transaction.commit();
        session.close();
        return result;
    }

     */

    /*  Optional<Bedroom> findById(Integer id){
          // TODO zastosowac wyrazenia lambda
              Bedroom tempItem = null;
              for(Bedroom item: bedroomElements){
                  if (item.getId() == id){
                      tempItem = item;
                  }
              }
              return Optional.ofNullable(tempItem);
          }

     */
    Optional<Bedroom> findById(Integer id){
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        var result = session.get(Bedroom.class, id);
        transaction.commit();
        session.close();
        return Optional.ofNullable(result);
    }

    Bedroom addBedroomElement(Bedroom newBedroomElement){
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        session.persist(newBedroomElement);
        transaction.commit();
        session.close();
        return newBedroomElement;
    }
}
